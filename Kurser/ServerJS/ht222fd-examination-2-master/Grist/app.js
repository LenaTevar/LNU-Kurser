'use strict'
// ;(async function () { .... ALL THE SHIT
// rembmer async mongoose....})
; (async function () {
  const express = require('express')
  const app = express()
  const session = require('express-session')
  const https = require('https')

  const mongooseDB = require('./config/mongoose.js')
  const mongoose = require('mongoose')
  const MongoSession = require('connect-mongo')(session)

  const hbs = require('express-hbs')
  const logger = require('morgan')
  const { resolve } = require('path')

  const cookieParser = require('cookie-parser')
  const credentials = require('./config/credentials')
  const createError = require('http-errors')
  const fs = require('fs')

  /**
                 * Set up DB - MongoAtlas + Mongoose
                 */
  await mongooseDB.connect().catch(error => {
    console.error(error)
    process.exit(1)
  })

  /**
                 * Set up view engine middleware
                 */
  app.engine('hbs', hbs.express4({
    defaultLayout: resolve('views', 'layouts', 'default'),
    partialsDir: resolve('views', 'partials')
  }))
  app.set('view engine', 'hbs')
  app.set('views', resolve('views'))

  // points the address of static files for hbs
  app.use(express.static(resolve('public')))

  /**
    * Other middleware
    */

  // Parse request bodies with application/x-www-form-urlencoded, like AJAX requests.
  app.use(express.urlencoded({ extended: false }))

  // Cookie secret encrypting string
  app.use(cookieParser(credentials.cookieSettings.cookieSecret))

  // Session settings
  const sessionSettings = {
    resave: false,
    saveUninitialized: false,
    secret: credentials.cookieSettings.cookieSecret,
    name: credentials.cookieSettings.cookieName,
    cookie: {
      httpOnly: true,
      secure: true,
      maxAge: 1000 * 60 * 60 * 24, // 1 day
      sameSite: 'Strict'
    },
    store: new MongoSession({ mongooseConnection: mongoose.connection })
  }
  if (app.get('env') === 'production') {
    app.set('trust proxy', 1) // trust first proxy
    sessionSettings.cookie.secure = true // serve secure cookies
  }
  app.use(session(sessionSettings))

  /**
                 * Session storage
                 */
  app.use((req, res, next) => {
    if (req.session.authGuard) {
      res.locals.authGuard = req.session.authGuard
    }
    if (req.session.flash) {
      res.locals.flash = req.session.flash
      delete req.session.flash
    }
    next()
  })
  /**
                 * Cross-Site Request Forgery has to be after cookie parser
                 * and session configuration.
                 * Add hidden input in AJAX forms to make it work
                 */

  app.use(require('csurf')())
  app.use(function (request, response, next) {
    response.locals._csrfToken = request.csrfToken()
    next()
  })
  /**
                 * Logger
                 */

  app.use(logger('dev'))

  /**
                 * Routing
                 */
  app.use('/mypage', require('./routes/mypageRouting'))
  app.use('/', require('./routes/gristRouting'))
  /**
                 * Error Handling
                 */

  app.use('*', (req, res, next) => next(createError(404)))
  app.use((err, req, res, next) => {
    // 404 Not Found.
    if (err.statusCode === 404) {
      return res.status(404).sendFile(resolve('public', '404.html'))
    }

    // 500 Internal Server Error (in production, all other errors send this response).
    if (req.app.get('env') !== 'development') {
      return res.status(500).sendFile(resolve('public', '500.html'))
    }

    // Development only!
    // Set locals, only providing error in development.
    res.locals.error = err

    // Render the error page.
    res.status(err.status || 500).render('error/error')
  })

  /**
                 * Listening!
                 */
  const options = {
    key: fs.readFileSync(resolve('config/ssl/localhost.pem')),
    cert: fs.readFileSync(resolve('config/ssl/localhost.crt'))
  }

  https.createServer(options, app).listen(credentials.port, function () {
    console.log('\n>> Express started in ' + app.get('env') + ' mode on port ' + credentials.port + ' using HTTPS.')
    console.log('>> Server started on https://localhost:3000')
    console.log('>> Press Ctrl-C to terminate...\n')
  })
}())
