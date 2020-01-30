'use strict'
import AlertsDOM from './alertsDOM.js'
const socket = io.connect('https://cscloud603.lnu.se/')
/**
 * dev: http://localhost:3000
 * prod: https://cscloud603.lnu.se/
 */
const newAlert = new AlertsDOM()
let cloudAlive = false

socket.on('connect', function () {
  console.log('Connected')
  cloudAlive = true
  newAlert.connected()
  heartbeatCheck()
})

socket.on('disconnect', function () {
  console.log('disconnected')
  cloudAlive = false
  console.log('disconnect: Cloud ' + cloudAlive)
  newAlert.disconnected()
})

socket.on('issue', function (data) {
  console.log('issue', data)
  newAlert.newAlert(data)
})
/**
 * If you try to emit and server is closed,
 * socket will know
 */
function heartbeatCheck () {
  var heartbeat = setInterval(() => {
    try {
      socket.send(JSON.stringify('<3'))
    } catch (error) {
      clearInterval(heartbeat)
      cloudAlive = false
    }
  }, 5000)
}
