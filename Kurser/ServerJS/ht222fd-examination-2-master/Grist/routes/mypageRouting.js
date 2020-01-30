
const authGuard = require('../controllers/authGuard')
const UserController = require('../controllers/userController')
const GistController = require('../controllers/gistController')

const myPageRouting = require('express').Router()
module.exports = myPageRouting

myPageRouting.all('*', authGuard.guardRoute)

myPageRouting.route('/create')
  .get(GistController.add)
  .post(GistController.addPOST)

myPageRouting.route('/delete/:id')
  .get(GistController.delete)

myPageRouting.route('/edit/:id')
  .get(GistController.edit)
  .post(GistController.editPOST)

myPageRouting.route('/')
  .get(UserController.myPage)
