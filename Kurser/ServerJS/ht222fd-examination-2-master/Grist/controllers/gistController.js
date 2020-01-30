'use strict'
const Gist = require('../models/gist')
const GistController = {}
module.exports = GistController

/**
 * Render create url
 * with form action 'create
 */
GistController.add = async (request, response) => {
  const data = {
    action: 'create'
  }
  response.render('grist/member/create', { data })
}

/**
 * Create a Gist and save in DB
 * Catch errors with views/error/error
 */
GistController.addPOST = async (request, response) => {
  const myPlainTags = request.body.tags.split(',')
  try {
    const myPlainGist = new Gist({
      title: request.body.title,
      content: request.body.content,
      tags: myPlainTags,
      author: request.session.authGuard.username,
      authorID: request.session.authGuard._id
    })

    await myPlainGist.save()

    request.session.flash = { type: 'success', text: 'success' }
    response.redirect('/mypage')
  } catch (error) {
    return response.render('', {
      validationErrors: [error.message] || [error.errors.value.message],
      value: request.body
    })
  }
}

/**
 * Select gist from request params id
 * and delete from database
 */
GistController.delete = async (request, response) => {
  const gist = await Gist.findById(request.params.id).exec()
  if (authGuard.authorCheck(gist, request)) {
    await Gist.findByIdAndRemove(request.params.id).exec()
  }
  response.redirect('/')
}

const authGuard = require('../controllers/authGuard')
/**
 * Show form with with form action edit and gist id
 */
GistController.edit = async (request, response) => {
  const gist = await Gist.findById(request.params.id).exec()

  if (!authGuard.authorCheck(gist, request)) {
    request.session.flash = { type: 'danger', text: 'You shouldn\'t be here' }

    response.redirect('/')
  } else {
    const actionURL = 'edit/' + gist._id
    const data = {
      gist: gist,
      action: actionURL
    }
    response.render('grist/member/create', { data })
  }
}

/**
 * Post request for edit and gist id
 */
GistController.editPOST = async (request, response) => {
  try {
    const myPlainTags = request.body.tags.split(',')
    const myPlainGist = {
      title: request.body.title,
      content: request.body.content,
      tags: myPlainTags
    }

    await Gist.findByIdAndUpdate(request.params.id, myPlainGist)

    request.session.flash = { type: 'success', text: 'success' }
    response.redirect('/mypage')
  } catch (error) {
    return response.render('', {
      validationErrors: [error.message] || [error.errors.value.message],
      value: request.body
    })
  }
}
