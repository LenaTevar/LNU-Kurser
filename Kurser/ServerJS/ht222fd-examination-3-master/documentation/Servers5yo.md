# Explain me servers like I was 5
How to make a server step like step. 

## Setting up Node
1. Install Node `npm init` and answer the questions
2. Add gitignore for VS and ignore node_modules
3. Add the typical packages we have used in other assignments and exercises (add the version you are using rn, this versions are from 2019/2020)
```json
"scripts": {
    "lint": "standard | snazzy",
    "lint:fix": "standard --fix",
    "start": "node app.js",
    "devstart": "nodemon --inspect ./app.js"
  },
"dependencies": {
    "bcrypt": "^3.0.7",
    "body-parser": "^1.19.0",
    "cookie-parser": "^1.4.4",
    "csurf": "^1.10.0",
    "express": "^4.17.1",
    "express-hbs": "^2.3.0",
    "express-session": "^1.17.0",
    "http-errors": "^1.7.3",
    "moment": "^2.24.0",
    "morgan": "^1.9.1",
    "node-gyp": "^6.0.1"
  },
  "devDependencies": {
    "nodemon": "*",
    "snazzy": "*",
    "standard": "*"
  },
```
do a `npm install` to install all the dependencies
4. Create `app.js` write a simple test `console.log('Hello World')` and run `npm run devstart` to start nodemon
```console
[nodemon] 2.0.1
[nodemon] to restart at any time, enter `rs`
[nodemon] watching dir(s): *.*
[nodemon] watching extensions: js,json,hbs,html,css
[nodemon] starting `node --inspect ./app.js`
Debugger listening on ws://127.0.0.1:9229/c0b26633-830b-406b-aa51-1f1728a84ff7
For help see https://nodejs.org/en/docs/inspector
Hello World
[nodemon] clean exit - waiting for changes before restart
```
## Creating the server in app.js

1. Create express constants
```javascript
const express = require('express')
const app = express()
```
2. Plan how and where are going to be your folders for the front-end and the back-end. Remember to add config to gitignore.

```
|_config 
|_controllers
|_public
| |_css
| |_images
|_routes
|_views
  |_error
  |_layouts
  |_partials
```

3. Set up view engine - handlebars

```javascript
/** Handlebars View Engine */
const { resolve } = require('path')
const hbs = require('express-hbs')
app.engine('hbs', hbs.express4({
  defaultLayout: resolve('views', 'layouts', 'default'),
  partialsDir: resolve('views', 'partials')
}))
app.set('view engine', 'hbs')
app.set('views', resolve('views'))
```
4. Set up address of static files (like css or images)
```javascript
app.use(express.static(resolve('public')))
```

5. Set up express to be able to parse AJAX forms
```javascript
app.use(express.urlencoded({ extended: false }))
```

4. Create a basic scaffolding for the server. 
  - A default layout in handlebars
    - Add `{{{body}}}` wherever you want your main content to be shown
  - An index layout in handlebars
  - A main routing file 
  ```javascript
  router.get('/', controller.index)
  ```

  - A main controller file 
  ```javascript
  controller.index = async (request, response) => {
       response.render('layouts/index')
    })
 ```
  - Basic routing in app.js 
  ```javascript 
  app.use('/', require('./routes/MainRouting'))
  ```
  - Basic handling errors
  ```javascript
  app.use((error, request, response, next) => {
  if (error.statusCode === 404) {
    return response.status(404)
  }

  if (request.app.get('env') !== 'development') {
    return response.status(5000)
  }
  response.status(error.status || 500)
})
```

  - Listening to port 

  ```javascript 
  app.listen(PORT, () => {console.log('\n Server started on http://localhost:3000')})
  ```
  - Run the app, test everything is ok at this point

  ## Make the server https
  - Install OpenSSL in your computer
    - If you use windows... don't use windows.
  - Run command 
  ```console
  openssl req -x509 -days 365 -newkey rsa:2048 -keyout YOUR_APP_NAME_HERE.pem -out YOUR_APP_NAME_HERE.crt
  ```
  - Move the certificate and the key to the cofig folder so is not indexed by git. Add the passphrase if you have one, to a file called credentials (or whatever) in config so no one can access it in github.
  - Actually, you could move all the hardcoded data to the credentials...
  - Add https options to the app.js

```javascript
const fs = require('fs')
const httpsOptions = {
  key: fs.readFileSync(resolve('config', 'ssl', 'githook.pem')),
  cert: fs.readFileSync(resolve('config', 'ssl', 'githook.crt')),
  passphrase: credentials.ssl_passphrase
}
https.createServer(httpsOptions, app).listen(credentials.PORT, function () {
  console.log('\n>> Server started on https://localhost:3000')
})
```
 - Run and test it works

 ## Adding sessions
 - Use a package that can encrypt cookies
   - create a string to encrypt the cookie and add it to the credentials
   - Good place for secure strings: https://xkpasswd.net/s/
`app.use(cookieParser(credentials.cookie.cookie_secret))`


 - Create session settings
   - You will need a cookie secret string
   - Pick a good name for your cookie
   - Write down that info in credentials

```javascript
const cookieParser = require('cookie-parser')
const session = require('express-session')
app.use(cookieParser(credentials.cookie.cookie_secret))

const sessionOptions = {
  resave: false,
  saveUninitialized: false,
  secret: credentials.cookie.cookie_secret,
  name: credentials.cookie.cookie_name,
  cookie: {
    httpOnly: true,
    maxAge: 1000 * 60 * 60 * 24
  }
}

if (app.get('env') === 'production') {
  app.set('trust proxy', 1)
  sessionOptions.cookie.secure = true
}

app.use(session(sessionOptions))
```

## Adding CSRF
If you want to use typical AJAX forms, then add a hidden input with the csrf to avoid cross site request forgery (taking data from other sites and use it in yours).
```javascript
const csurf = require('csurf')
app.use(csurf())
app.use(function (request, response, next) {
  response.locals._csrfToken = request.csrfToken()
  next()
})
```

## Logger
If you want to check the requests in console, add a logger. 
`app.use(require('morgan')('dev'))`

## DONE
With this you should be able to run a basic express https-csrf-sessions server