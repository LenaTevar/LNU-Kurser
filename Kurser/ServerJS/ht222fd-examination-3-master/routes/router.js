'use strict'
const router = require('express').Router()
module.exports = router
const controller = require('../controllers/controller')
router.route('/')
  .get(controller.index)
  .post(controller.checkPost, controller.post)
