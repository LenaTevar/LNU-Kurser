'use strict'
export default function alertsDOM () {}
alertsDOM.prototype.newAlert = function (data) {
  this.navbarAlert(data)
  this.dotManager(data.number)
}
alertsDOM.prototype.navbarAlert = function (data) {
  let updateElement = document.querySelector('#updateElement')

  if (updateElement.className.includes('animated')) { // reset the animation if was already triggered
    updateElement = this.resetAlert()
  }
  const innerText = (data.event === 'issues') ? this.isIssue(data) : this.isComment(data)
  updateElement.innerText = innerText
  updateElement.classList.add('animated')
}
alertsDOM.prototype.isIssue = function (data) {
  return 'Issue ' + data.number + ' was ' + data.action + '!'
}

alertsDOM.prototype.isComment = function (data) {
  return 'A comment in issue ' + data.number + ' was ' + data.action + '!'
}
alertsDOM.prototype.resetAlert = function () {
  const navbarnav = document.querySelector('.navbarAnchor')
  document.querySelector('#updateElement').remove()
  const p = document.createElement('p')
  p.classList.add('nav-item', 'nav-link', 'active', 'updateElement', 'animated')
  p.id = 'updateElement'
  navbarnav.append(p)
  return p
}

alertsDOM.prototype.dotManager = function (number) {
  const issueID = 'issue' + number
  const issueCard = document.getElementById(issueID)
  const checkdot = issueCard.querySelector('.dot')
  if (checkdot) {
    checkdot.remove()
  }
  const dotPlace = document.getElementById(number)
  this.dot(dotPlace)
}
alertsDOM.prototype.dot = (card) => {
  const span = document.createElement('span')
  span.classList.add('dot')
  // card.appendChild(span)
  card.insertBefore(span, card.firstChild)
}
/**
 * X-GitHub-Event: issue_comment
 * X-GitHub-Event: issues
 */
alertsDOM.prototype.connected = function () {
  const heart = document.querySelector('.heartdead')
  heart.classList.remove('heartdead')
  heart.classList.add('heart')
}

alertsDOM.prototype.disconnected = function () {
  const heart = document.querySelector('.heart')
  heart.classList.remove('heart')
  heart.classList.add('heartdead')
}
