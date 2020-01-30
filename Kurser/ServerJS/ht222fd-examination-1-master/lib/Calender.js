'use strict'
const { WebScrapper } = require('./WebScrapper')
const { JSDOM } = require('jsdom')

function Calender () {}
module.exports.Calender = Calender

/**
 * Gets the best days for the friends to meet
 * in a boolean array for [friday, saturday, sunday]
 * @param {string} calenderLink
 * @returns {boolean[]}
 * @example const FriSatSun = [true, true, true]
 */
Calender.getBestDay = async function (calenderLink) {
  const friendsLinks = await this.getFriendsCalenderLinks(calenderLink)
  const bestDays = await this.getCalenderMatchDays(friendsLinks)
  return bestDays
}

/**
   * Fetches the links for the friends calenders
   * and appends them to the main URL
   * @param {string} link
   * @returns {string[]}
   */
Calender.getFriendsCalenderLinks = async function (link) {
  const response = await WebScrapper.getUrl2Text(link)
  const links = await WebScrapper.getLinks(response.body)
  this.fixCalenderLinks(links, link)
  return links
}

/**
   * Add the original calender url to the friends url.
   * @param {string[]} array
   */
Calender.fixCalenderLinks = function (array, originalURL) {
  array.forEach(function (part, index) {
    this[index] = originalURL + part
  }, array)
}

/**
   * Method wrapper that takes links array and
   * results in a boolean array with friends
   * disponibility
   * @param {string[]} friendsLinks
   * @returns {boolean[]}
   */
Calender.getCalenderMatchDays = async function (friendsLinks) {
  const responses = await this.getAllResponses(friendsLinks)
  const queryResults = await this.scrappCalenders(responses)
  const bestDays = this.getBestMatch(queryResults)
  return bestDays
}

/**
   * Takes an array of links, gets the url's
   * responses
   * @param {string[]} friendsLinks
   */
Calender.getAllResponses = async function (friendsLinks) {
  const promises = friendsLinks.map(url => WebScrapper.getUrl2Text(url))
  const responses = await Promise.all(promises)
  return responses
}

/**
   * Get an array of strings, each one a friend
   * response body. Query for title and td.
   * @param {string[]} responses
   * @return {any[]}
   */
Calender.scrappCalenders = async function (responses) {
  const queryResults = []
  const query = 'h2, td'

  responses.forEach(async (friend) => {
    const results = this.body2Query(friend.body, query)
    queryResults.push(results)
  })
  const scrappedCalender = await Promise.all(queryResults)
  return Array.of(scrappedCalender)
}

/**
   * Searches for free days from the friends
   * @param {string[]} queryResults
   * @returns {boolean[]}
   */
Calender.getBestMatch = function (queryResults) {
  const persons = queryResults[0]
  const matches = [true, true, true]
  persons.forEach(person => {
    if (person[1].includes('-')) { matches[0] = false }
    if (person[2].includes('-')) { matches[1] = false }
    if (person[3].includes('-')) { matches[2] = false }
  })
  return matches
}
/**
 * Makes a query in a response body and returns the result
 * @param {string} body
 * @param {string} query
 * @returns {any[]}
 */
Calender.body2Query = function (body, query) {
  const result = []
  const dom = new JSDOM(body)
  Array.from(dom.window.document.querySelectorAll(query))
    .map(element => {
      result.push(element.innerHTML)
    })
  return result
}
