
export default function Rest () {
  this.serverData = {}
  this.localStorageKey = 'players'
  this.scores = []
}

Rest.prototype.GET = async function (url) {
  let data = await window.fetch(url)
  this.serverData = await data.json()
  return this.serverData
}

Rest.prototype.POST = async function (userAnswer) {
  let answer = { answer: userAnswer }
  let answerToJson = JSON.stringify(answer)
  let request = {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: answerToJson
  }
  return this.postRequest(request)
}

Rest.prototype.postRequest = async function (request) {
  try {
    let postRqst = await window.fetch(this.serverData.nextURL, request)
    this.serverData = await postRqst.json()
    if (isWrongAnwer(this.serverData.message)) {
      this.ending = WinCondition.LOSE
      return WinCondition.LOSE
    } else {
      this.serverData = await this.GET(this.serverData.nextURL)
      return this.serverData
    }
  } catch (error) {
    return WinCondition.WIN
  }
}
function isWrongAnwer (message) {
  return message.includes(':(')
}

Rest.prototype.setScores = function (user, score) {
  if (this.getScores()) {
    this.scores = this.getScores()
  }

  let player = { user: user, score: score }
  this.scores.push(player)
  window.localStorage.setItem(this.localStorageKey, JSON.stringify(this.scores))
}

Rest.prototype.getScores = function () {
  let players = JSON.parse(window.localStorage.getItem(this.localStorageKey))
  return players
}

export const WinCondition = {
  WIN: 'win',
  LOSE: 'lose',
  TIMEOUT: 'lose timeout'
}
