import Rest, { WinCondition } from './lib.js'
const template = document.createElement('template')
template.innerHTML = /* html */ `
<link rel="stylesheet" href="css/style.css">
  <h1>Welcome </h1>
  <p id="questionQuiz">Hello! The first question is easy. What is your name?</p>
  <form id="quiz"> 
    <div id="text-wrapper">
      <label class="textLabel">
          Answer: 
          <input type="text" id="inputText" style="display:block">            
      </label>
    </div>
    <div id="radio-wrapper" style="display:none">  
    </div>    
    
  <input type="button" value="Send" id="sendbtn" type="submit" >
  </form>
  <div id="timer-wrap"><p id="timer-element">waiting...</p></div>  
  <div id="scores"> </div>
  <button type="button" id="refresh-btn">Re-Play</button>
  `
const firstQuestion = 'http://vhost3.lnu.se:20080/question/1'

class Quiz extends window.HTMLElement {
  constructor () {
    super()
    this.shadow = this.attachShadow({ mode: 'open' })
    this.shadowRoot.appendChild(template.content.cloneNode(true))
    this._inputText = this.shadowRoot.querySelector('#inputText')
    this._h1 = this.shadowRoot.querySelector('h1')
    this._p = this.shadowRoot.querySelector('#questionQuiz')
    this._radios = this.shadowRoot.querySelector('#radio-wrapper')
    this._textBox = this.shadowRoot.querySelector('#text-wrapper')
    this._button = this.shadowRoot.getElementById('sendbtn')
    this._refreshBtn = this.shadowRoot.querySelector('#refresh-btn')

    this.restapi = new Rest()
    this.firstQuestion = true
    this.totalTime = 0

    this.serverData = {}
    this.hasRadio = false
  }
  connectedCallback () {
    this._button.addEventListener('click', this.send.bind(this))

    this._refreshBtn.style.display = 'none'
    this._refreshBtn.addEventListener('click', () => {
      document.location.reload(true)
    })
  }
}

/**
 * DOM methods
 */
Quiz.prototype.getAnswer = function () {
  return this.serverData.alternatives ? this.getRadioAnswer() : this._inputText.value
}

Quiz.prototype.getRadioAnswer = function () {
  return this._radios.querySelector('input:checked') ? this._radios.querySelector('input:checked').value : ''
}

Quiz.prototype.refreshAlternatives = function () {
  if (this.serverData.alternatives) {
    this._textBox.style.display = 'none'
    this._radios.style.display = 'block'
    this.changeRadios()
  } else {
    this._inputText.value = ''
    this._textBox.style.display = 'block'
    this._radios.style.display = 'none'
  }
}

const radioTemplate = document.createElement('template')
radioTemplate.innerHTML = /* html */ `
  <input type="radio" class="radios" id="radio1" value="alt1" >    
  <label class="radios" id="radioLabel1" ></label>
`

Quiz.prototype.changeRadios = function () {
  this.cleanRadios()
  let question = this.serverData.alternatives
  let radioIndex = 1
  for (var key in question) {
    let temp = radioTemplate.content.cloneNode(true)
    let inradio = temp.querySelector('input')
    inradio.value = 'alt' + radioIndex++
    let labelradio = temp.querySelector('label')
    labelradio.innerText = question[key]
    this._radios.appendChild(temp)
  }
}
Quiz.prototype.cleanRadios = function () {
  this._radios.innerHTML = ''
}

/**
 * @param {[Object]} scores Array of scores from localstorage
 * in format {user: xx, score: xx}
 */
Quiz.prototype.buildScoresTable = function (scores) {
  let table = document.createElement('table')
  let tr = document.createElement('tr')
  let header1 = document.createElement('th')
  header1.innerText = 'Player'
  tr.appendChild(header1)
  let header2 = document.createElement('th')
  header2.innerText = 'Score'
  tr.appendChild(header2)
  table.appendChild(tr)

  scores.forEach(object => {
    let row = document.createElement('tr')
    let player = document.createElement('td')
    player.innerText = object.user
    let score = document.createElement('td')
    score.innerText = object.score
    row.appendChild(player)
    row.appendChild(score)
    table.appendChild(row)
  })
  this.shadowRoot.querySelector('#scores').appendChild(table)
}

Quiz.prototype.endingElements = function (gameOverText) {
  this._p.innerText = gameOverText
  this.shadowRoot.querySelector('#quiz').style.display = 'none'
  this.shadowRoot.querySelector('#timer-wrap').style.display = 'none'
  this._refreshBtn.style.display = 'block'
}
// Logic Methods
Quiz.prototype.send = async function (event) {
  if (this._inputText.value === '') { return }

  if (this.firstQuestion) {
    this.username = this._inputText.value
    this._h1.innerText = `${this.username} is playing!`
    this.firstQuestion = false

    this.serverData = await this.restapi.GET(firstQuestion)
    this.startTimer()
    this.startGeneralTime()
  } else {
    this.serverData = await this.restapi.POST(this.getAnswer())
  }
  this.checkEndingConditions()
}

Quiz.prototype.checkEndingConditions = function () {
  if (this.serverData === WinCondition.WIN || this.serverData === WinCondition.LOSE) {
    this.gameOver()
  } else {
    this.refreshAlternatives()
    this._p.innerText = this.serverData.question
  }
  this.clearTimer()
  this.startTimer()
}

Quiz.prototype.gameOver = function () {
  this.clearTimer()
  this.endGeneralTime()

  let gameOverText = 'Game Over'

  switch (this.serverData) {
    case WinCondition.WIN:
      gameOverText = 'CONGRATULATIONS YOU WIN - ' + this.totalTime + 's'
      this.restapi.setScores(this.username, this.totalTime)
      this.buildScoresTable(this.restapi.getScores())
      break
    case WinCondition.LOSE:
      gameOverText += ' - WRONG ANSWER'
      break
    case WinCondition.TIMEOUT:
      gameOverText += ' - TIME IS OVER'
      break
  }
  this.endingElements(gameOverText)
}

// Timer Methods
Quiz.prototype.startGeneralTime = function () {
  this.start = new Date().getTime()
}
Quiz.prototype.endGeneralTime = function () {
  this.totalTime = new Date().getTime() - this.start
  this.totalTime /= 1000
}
Quiz.prototype.startTimer = function () {
  var start = new Date().getTime()
  var time = 0
  var elapsed = '0.0'
  var maxTime = 10
  let _timer = this.shadowRoot.querySelector('#timer-element')

  function instance () {
    if (elapsed >= maxTime) {
      this.serverData = WinCondition.TIMEOUT
      this.gameOver()
      return
    }
    if (elapsed >= maxTime) { return 0 }
    time += 100
    elapsed = Math.floor(time / 100) / 10
    if (Math.round(elapsed) === elapsed) {
      elapsed += '.0'
    }
    _timer.textContent = elapsed
    var diff = (new Date().getTime() - start) - time
    window.clearInterval(this.intervalID)
    this.intervalID = window.setTimeout(instance.bind(this), (100 - diff))
  }
  this.intervalID = window.setTimeout(instance.bind(this), 100)
}

Quiz.prototype.clearTimer = function () {
  window.clearInterval(this.intervalID)
}

window.customElements.define('game-quiz', Quiz)
