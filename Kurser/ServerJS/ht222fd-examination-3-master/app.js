'use strict'
const express = require('express')
const app = express()
const hbs = require('express-hbs')
const { resolve } = require('path')

const server = app.listen(3000, () => {
  console.log('\n>> Expres started in ' + app.get('env') + 'mode in http://localhost:3000')
})
const io = require('socket.io')(server)

app.engine('hbs', hbs.express4({
  defaultLayout: resolve('views', 'layouts', 'default'),
  partialsDir: resolve('views', 'partials')
}))
app.set('view engine', 'hbs')
app.set('views', resolve('views'))
app.use(express.static(resolve('public')))
app.use(express.urlencoded({ extended: false }))
/** SOCKET */
io.on('connection', (socket) => {
  console.log('User connected')

  socket.on('disconnect', () => {
    console.log('user ' + socket.id + ' disconnected!')
  })
  socket.on('message', (data) => {
    console.log('user ' + socket.id + ' sent ' + data)
  })
})

app.use(function (req, res, next) {
  req.io = io
  next()
})
/** BODY PARSER */
const bodyParser = require('body-parser')
app.use(bodyParser.json())

/** ROUTES */
app.use('/', require('./routes/router'))

app.use((err, req, res, next) => {
  if (err.statusCode === 404) {
    return res.send('404')
  }
  if (req.app.get('env') !== 'development') {
    return res.send('Server Error')
  }
  res.send('500 Server Error')
})
