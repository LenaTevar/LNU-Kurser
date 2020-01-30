'use strict'

const Gist = require('../models/gist')
const UserController = {}
module.exports = UserController

UserController.logout = async (request, response) => {
  delete request.session.authGuard
  request.session.flash = { type: 'info', text: 'User logged out' }
  response.redirect('/')
}

UserController.myPage = async (request, response) => {
  const data = {
    myGists: (await Gist.find({ author: request.session.authGuard.username }))
      .map(aGist => ({
        id: aGist._id,
        title: aGist.title,
        content: aGist.content,
        contentShort: aGist.content.substring(0, 60),
        author: aGist.author,
        tags: aGist.tags
      }))
  }
  response.render('grist/member/mypage', { data })
}
