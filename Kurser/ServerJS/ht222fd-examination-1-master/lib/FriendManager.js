'use strict'
const { WebScrapper } = require('./WebScrapper')
const { Calender } = require('./Calender')
const { Cinema } = require('./Cinema')
const { Zekes } = require('./Zekes')

/**
 * Takes the arguments from console
 * noder start and runs the scrapping classes
 * @param {string} firstUrl
 * @returns Console print of party options and booking
 */
exports.run = async function (firstUrl) {
  console.log('============== FRIEND MANAGER ==============')
  console.log('> Scrapping for pages in: ', firstUrl)
  const allLinks = await WebScrapper.scrapForLinks(firstUrl)
  console.log('> Calculating Best Day')
  const getBestDays = await Calender.getBestDay(allLinks[0])
  console.log('> Calculating Best Movie')
  const getBestMovies = await Cinema.getBestMovies(allLinks[1], getBestDays)
  console.log('> Calculating Zekes Tables')
  const getBestTables = await Zekes.getBestDine(allLinks[2], getBestMovies)
  console.log('============== BOOKING ==============')
  const party = await BookParty(getBestTables)
  prettyPrint(party)
}

async function BookParty (getBestTables) {
  if (getBestTables.length > 0) {
    prettyPrintAll(getBestTables)

    /*
    for (let index = 0; index < getBestTables.length; index++) {
      const code = await makeReservation(getBestTables[index])
      if (code === 200) {
        return getBestTables[index]
      }
    } */

    const code = await makeReservation(getBestTables[0])
    if (code === 200) {
      return getBestTables[0]
    }
  } else {
    console.log('Sorry, we found no available partay')
  }
  return null
}

async function makeReservation (date) {
  const reservation = await Zekes.bookZekes(date)
  return reservation
}
/**
 * Pretty Print one result
 * @param {any[]} options
 */
function prettyPrint (option) {
  if (option === null) { console.log('Sorry, could not found party available') } else {
    console.log('\tDay: ', option.dayText)
    console.log('\tMovie: %s, time: %s', option.movieTitle, option.time)
    option.zekes.forEach(booking => {
      console.log('\tZekes Free Table: ', booking.time)
    })
  }
}
/**
 * Pretty Print results
 * @param {any[]} results
 */
function prettyPrintAll (results) {
  if (!results || results === null) {
    console.log('This week everybody is busy or everything is booked, maybe next week :-(')
  } else {
    console.log('============== OPTIONS ==============')
  }
  results.forEach(option => {
    console.log('>> Option')
    prettyPrint(option)
  })
}
