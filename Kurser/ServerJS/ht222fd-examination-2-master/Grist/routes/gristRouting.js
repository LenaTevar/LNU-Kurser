'use strict'
const router = require('express').Router()
module.exports = router
const controller = require('../controllers/mainController')
const LoginController = require('../controllers/loginController')
const authGuard = require('../controllers/authGuard')

router.get('/throw', controller.throwme)
router.route('/register').get(LoginController.register).post(LoginController.registerPOST)
router.route('/login').get(LoginController.login).post(LoginController.loginPOST)
router.route('/logout').get(authGuard.guardRoute, LoginController.logout)
router.get('/', controller.index)
router.get('/gist/:id', controller.oneCard)
router.get('/tag/:tag', controller.indexByTag)
