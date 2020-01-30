'use strict'
const { WebScrapper } = require('./WebScrapper')
const { JSDOM } = require('jsdom')
var request = require('request')

function Zekes () {
  this.Cookie = ''
  this.csrf = ''
  this.reservationUrl = ''
  this.BookingUrl = ''
}
module.exports.Zekes = Zekes
/**
 * Gets original Zekes link and gets
 * the best option
 * @param {string} link
 * @param {any[]} options
 * @example [ { status: 1,
    day: '05',
    time: '16:00',
    movie: '02',
    dayText: 'FRIDAY',
    movieTitle: 'Keep Your Seats, Please',
    zekes: [ [Object] ] }]
 */
Zekes.getBestDine = async function (link, options) {
  const zekesRequest = await this.getZekesLanding(link)
  const loginResponse = await this.postZekesLogin(zekesRequest)
  const booking = this.getOptionsBooking(loginResponse, link)
  const bookingResponse = await this.getZekesBooking(booking)
  const queryBooking = this.queryBookingURL(bookingResponse, options)
  const result = this.bestDinner(options, queryBooking)
  const finalResult = this.removeNonZekes(result)
  return finalResult
}
/**
 * Gets landing page from zekes.
 * @todo this method looks rather innecesary
 * @param {string} link
 * @returns request and headers object
 * @example
 * { headers: {
 *    'content-type': 'application/x-www-form-urlencoded'
 *    },
    url: 'http://vhost3.lnu.se:20080/dinner/login',
    form: {
      username: 'zeke',
      password: 'coys',
      submit: 'login'
    }
  }
 */
Zekes.getZekesLanding = async function (link) {
  const ZekesResponse = await WebScrapper.getUrl2Text(link)
  const body = ZekesResponse.body
  const dom = new JSDOM(body)
  const loginScrap = dom.window.document.querySelector('form').action.split('/')
  const loginurl = link + '/' + loginScrap[loginScrap.length - 1]
  const submit = dom.window.document.querySelector('input[type=submit]').value

  const request = {
    headers: { 'content-type': 'application/x-www-form-urlencoded' },
    url: loginurl,
    form: {
      username: 'zeke',
      password: 'coys',
      submit: submit
    }
  }

  return request
}

/**
 * Takes and object request and makes a post
 * request to login into Zekes
 * @param {Object} options
 * @returns Promise
 */
Zekes.postZekesLogin = function (options) {
  return new Promise((resolve, reject) => {
    request.post(options, (err, success) => err ? reject(new Error('POST Error')) : resolve(success))
  })
}

/**
 * Takes the first link and login response to¨
 * catch the cookie and re-direct url
 * @param {Object} response
 * @param {string} link
 * @returns object to request a GET from zekes
 * booking side
 * @example { url: 'http://vhost3.lnu.se:20080/dinner/login/booking',
  headers:  { Cookie: 'xxx' } }
 */
Zekes.getOptionsBooking = function (response, link) {
  Zekes.Cookie = response.headers['set-cookie'][0].split(';')[0]
  Zekes.BookingUrl = link + '/' + response.headers.location
  const optionsGET = {
    url: Zekes.BookingUrl,
    headers: {
      Cookie: Zekes.Cookie
    }
  }
  return optionsGET
}

/**
 * Takes a request object and makes a
 * GET request to the booking page from zekes
 * @param {Object} options
 * @returns Promise
 */
Zekes.getZekesBooking = function (options) {
  return new Promise((resolve, reject) => {
    request.get(options, (err, success) => err ? reject(new Error('POST Error')) : resolve(success))
  })
}

/**
 * Makes a query on the response from booking in Zekes
 * for the input radio values that fit the days
 * saved in options
 * @param {Object} response
 * @param {Object} options Possible party days
 * @returns values of free tables in zekes
 * @example const freeTables = [ { day: 'FRI',
    hourCheckIn: '14',
    hourCheckOut: '16',
    code: 'fri1416' } ]
 */

Zekes.queryBookingURL = function (response, options) {
  let searchThis = ''
  options.forEach(option => {
    searchThis += option.dayText.substring(0, 3).toUpperCase()
  })
  const body = response.body
  const dom = new JSDOM(body)
  const tables = []

  Array.from(dom.window.document.querySelectorAll('input[type=radio]'))
    .map(element => {
      const table = {
        day: element.value.substring(0, 3).toUpperCase(),
        hourCheckIn: element.value.substring(3, 5),
        hourCheckOut: element.value.substring(5),
        code: element.value
      }
      if (searchThis.includes(table.day)) {
        tables.push(table)
      }
    })

  Zekes.csrf = dom.window.document.querySelector('input[type=hidden]').value
  return tables
}

/**
 * Loops on friends open days and finds
 * if zekes has a/many free tables
 * @param {any[]} options
 * @param {any[]} dinner
 * @returns zero to many possible free tables in zekes
 * @example const results =  [ { status: 1,
    day: '05',
    time: '18:00',
    movie: '01',
    dayText: 'FRIDAY',
    movieTitle: 'The Flying Deuces' } ]
 */
Zekes.bestDinner = function (options, dinner) {
  const selectedOptions = options
  selectedOptions.forEach(option => {
    const zekes = []
    dinner.forEach(dine => {
      if (this.checkDayAndHour(option, dine)) {
        const table = {
          time: dine.hourCheckIn + '-' + dine.hourCheckOut,
          code: dine.code
        }
        zekes.push(table)
      }
    })
    if (zekes.length > 0) {
      option.zekes = zekes
    }
  })

  return selectedOptions
}

/**
 * Wapper for conditional that friends
 * option and movie hour fits with
 * zekes free tables
 * @param {Object} option
 * @param {Object} dine
 * @returns bool
 */
Zekes.checkDayAndHour = function (option, dine) {
  if (!option.dayText.includes(dine.day)) {
    return false
  }
  const optionHour = Number(option.time.slice(0, 2)) + 2
  const dineHour = Number(dine.hourCheckIn)
  return optionHour <= dineHour
}

/**
 * Gets the results of all possible
 * days for friends and zekes tables
 * and picks the only dates
 * that has a table in Zekes
 * @param { any []} result
 * @returns zero to many possible free tables in zekes
 * @example const results =  [ { status: 1,
    day: '05',
    time: '16:00',
    movie: '02',
    dayText: 'FRIDAY',
    movieTitle: 'Keep Your Seats, Please',
    zekes: [ [Object] ] } ]
 */
Zekes.removeNonZekes = function (result) {
  const finalResult = []
  result.forEach(day => {
    if (day.zekes) {
      finalResult.push(day)
    }
  })
  return finalResult
}
/**
 * Gets one option of a date and makes a request
 * to book the table in zekes
 * @returns message of success or fail
 */
Zekes.bookZekes = async function (date) {
  const request = {
    url: Zekes.BookingUrl,
    headers: {
      'content-type': 'application/x-www-form-urlencoded',
      Cookie: Zekes.Cookie
    },
    form: {
      group1: date.zekes[0].code,
      csrf_token: Zekes.csrf
    }
  }
  const response = await this.postZekesBooking(request)
  return response.statusCode
}
/**
 * Takes a request object and makes
 * a post request to Zekes
 * @param {Object} options
 * @returns Promise
 */
Zekes.postZekesBooking = function (options) {
  return new Promise((resolve, reject) => {
    request.post(options, (err, success) => err ? reject(new Error('POST Error')) : resolve(success))
  })
}
