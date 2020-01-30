'use strict'
const { JSDOM } = require('jsdom')
var request = require('request')

async function WebScrapper () {}
module.exports.WebScrapper = WebScrapper

/**
 * Scraps url for all the inside links
 * @param {string} url
 * @returns string[] links scrapped
 */
WebScrapper.scrapForLinks = async function (url) {
  const firstResponse = await this.firstUrl(url)
  const allLinks = await this.body2Link(firstResponse.body)
  return allLinks
}
/**
 * Takes the arguments from console and makes a GET request
 * @param {string[]} args
 * @todo accept multiple urls
 */
WebScrapper.firstUrl = async function (args) {
  const firstUrl = args[0]
  const firstResponse = await this.getUrl2Text(firstUrl)
  return firstResponse
}

/**
 * Accepts a body response string and queries the links href
 * @param {string} body
 * @param {string} query
 * @returns string Array links
 */
WebScrapper.body2Link = async function (body) {
  const query = 'a'
  const result = []
  const dom = new JSDOM(body)
  Array.from(dom.window.document.querySelectorAll(query))
    .map(element => {
      result.push(element.href)
    })
  return result
}

/**
 * Sends GET request to the url parameter
 * @example let response = await getUrl2Text(url)
 * let body = respose.body
 * @param {string} url to scrap
 * @returns Promise of request response or error
 */
WebScrapper.getUrl2Text = function (url) {
  return new Promise((resolve, reject) => {
    request.get(url, (err, success) => err ? reject(new Error('GET Error')) : resolve(success))
  })
}

/**
 * Takes the body of a scrapped web
 * and searches for the links
 * @param {string} body
 * @returns string array with links
 * @method Calender.getFriendsCalenderLinks
 */
WebScrapper.getLinks = async function (body) {
  const query = 'a'
  return this.body2Link(body, query)
}
