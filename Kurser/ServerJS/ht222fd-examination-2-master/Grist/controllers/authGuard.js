const authGuard = {}
module.exports = authGuard

authGuard.guardRoute = function (request, response, next) {
  if (!request.session.authGuard) {
    request.session.flash = this.flash
    response.status(403).redirect('/')
  } else {
    next()
  }
}
authGuard.authorCheck = function (gist, request) {
  try {
    const authorID = gist.authorID.toString()
    const sessionID = request.session.authGuard._id.toString()
    const check = authorID.localeCompare(sessionID)

    if (check === 0) {
      return true
    }
    return false
  } catch (error) {
    return false
  }
}

authGuard.flash = {
  type: 'danger',
  text: 'Unauthorized'
}
