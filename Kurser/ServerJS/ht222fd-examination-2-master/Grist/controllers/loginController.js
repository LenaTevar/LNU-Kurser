'user strict'
const LoginController = {}
module.exports = LoginController
const UserGrist = require('../models/user')

LoginController.register = async (request, response) => {
  const newUser = {
    username: undefined,
    email: undefined,
    password: undefined
  }
  response.render('grist/public/register', { newUser })
}

LoginController.login = async (request, response) => {
  console.log('login: ', request.body)
  const newUser = {
    inputUsername: undefined,
    inputEmail: undefined,
    inputPassword: undefined
  }
  response.render('grist/public/login', { newUser })
}

LoginController.registerPOST = async (request, response) => {
  try {
    const userPost = new UserGrist({
      username: request.body.username,
      email: request.body.email,
      password: request.body.password
    })
    // ...save the number to the database...
    await userPost.save()
    await regenerateSession(request, userPost)

    // ...and redirect and show a message.
    response.redirect('/')
  } catch (error) {
    // If an error, or validation error, occurred, view the form and an error message.
    return response.render('grist/public/register', {
      validationErrors: [error.message] || [error.errors.value.message],
      value: request.body
    })
  }
}

LoginController.loginPOST = async (request, response) => {
  try {
    const userFound = await UserGrist.authenticate(request.body.username, request.body.password)

    await regenerateSession(request, userFound)
    response.redirect('/')
  } catch (error) {
    return response.render('grist/public/login', {
      validationErrors: ['Username or Password incorrect'],
      value: request.body
    })
  }
}
LoginController.logout = async (request, response) => {
  delete request.session.authGuard
  request.session.flash = { type: 'info', text: 'User logged out' }
  response.redirect('/')
}

function regenerateSession (request, user) {
  return new Promise(function (resolve, reject) {
    request.session.regenerate(function (err, result) {
      if (err) return reject(err)
      request.session.authGuard = user
      request.session.flash = { type: 'success', text: 'success' }
      resolve(result)
    })
  })
}
