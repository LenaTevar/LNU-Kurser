'use strict'
const controller = {}
module.exports = controller
const credentials = require('../config/credentials')
const github = require('octonode')
const crypto = require('crypto')
var client = github.client(credentials.github.ghtoken)
const repo = '1dv523/ht222fd-examination-3'
var ghrepo = client.repo(repo)

controller.index = async (request, response) => {
  const result = await ghrepo.issuesAsync({ per_page: 100 })
  const issues = result[0]
  const promises = issues.map(async i => {
    const rawIssue = await client.issue(repo, i.number)
    const rawComments = await rawIssue.commentsAsync()
    i.comments_content = rawComments[0]
    return i
  })

  const resolved = await Promise.all(promises)
  console.log(resolved[0].labels)
  const data = { issues: resolved }
  response.render('layouts/main', { data })
}
/*
OBS!!! Use application/json to not to have nightmares with the x-hub-signature and crypto
*/
controller.post = async (request, response) => {
  console.log(request.body.action)
  const data = {
    event: request.headers['x-github-event'],
    number: request.body.issue.number,
    action: request.body.action
  }
  console.log('Hook: ', data)
  request.io.emit('issue', data)
  response.status(200)
  response.send()
}
controller.checkPost = async (request, response, next) => {
  const signature = request.header('x-hub-signature').split('=')
  const checksum = crypto.createHmac('sha1', 'macarroni').update(JSON.stringify(request.body)).digest('hex')
  console.log(checksum)
  console.log(signature[1])
  console.log(request.header('content-type'))
  if (signature[1] === checksum) {
    console.log('Validated')
    next()
  } else {
    console.log('Not validated')
    response.send(400).send('Invalid signature')
  }
}
