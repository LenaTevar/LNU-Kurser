'use strict'
const { WebScrapper } = require('./WebScrapper')
const { JSDOM } = require('jsdom')

function Cinema () {}
module.exports.Cinema = Cinema

/**
 * Wrapper method, takes Cinema link and optional days
 * and checks the movies that are available for the
 * friends options
 * @param {string} link
 * @param {boolean[]} options available days
 * @returns {any[]}
 * @example const films = [ { status: 1,
    day: '06',
    time: '18:00',
    movie: '02',
    dayText: 'SATURDAY',
    movieTitle: 'Keep Your Seats, Please' } ]
 */
Cinema.getBestMovies = async function (link, options) {
  const scrapCinema = await WebScrapper.getUrl2Text(link)
  const movies = await this.getMoviesInfo(scrapCinema.body)
  const days = await this.getMoviesDays(scrapCinema.body, options)
  let movieOptions = await this.moviesMatchDays(link, movies, days)
  movieOptions = this.getVerboseData(movies, days, movieOptions)
  return movieOptions
}

/**
 * Takes the result of best day and movies and add
 * more information to the object for future use
 * @param {any[]} movies
 * @param {any[]} days
 * @param {any[]} movieOptions
 * @returns {any[]}
 * @example const films = [ { status: 1,
    day: '06',
    time: '18:00',
    movie: '02',
    dayText: 'SATURDAY',
    movieTitle: 'Keep Your Seats, Please' }]
 */
Cinema.getVerboseData = function (movies, days, movieOptions) {
  const result = []
  movieOptions.forEach(session => {
    const verboseSession = session
    days.forEach(day => {
      if (verboseSession.day === day.value) {
        verboseSession.dayText = day.day.toUpperCase()
      }
    })
    movies.forEach(movie => {
      if (verboseSession.movie === movie.value) {
        verboseSession.movieTitle = movie.title
      }
    })
    result.push(verboseSession)
  })
  return result
}

/**
 * Takes params and finds the best matched sessions
 * @param {string} link cinema url
 * @param {any[]} movies scrapped movies from url
 * @param {any[]} days scrapped days
 * @returns {any[]}
 * @example const returns = {
 *  status: 1,
 * day: '05',
 * time: '18:00',
 * movie: '03'
 *}
 */
Cinema.moviesMatchDays = async function (link, movies, days) {
  const links = this.getMoviesLinks(movies, days, link)

  const bodies = await this.requestGETMoviesQuery(links)
  const result = await this.getBestMoviesMatch(bodies)

  return result
}

/**
 * Searches for available sessions from all
 * sessions and returns all available sessions
 * @param {string[]} bodies result from get request from
 * the available days
 * @returns {any[]}
 * @example const session = {
 *  status: 1,
 * day: '05',
 * time: '18:00',
 * movie: '03'
 * }
 */
Cinema.getBestMoviesMatch = async function (bodies) {
  const result = []
  const parsePromises = bodies.map(body => JSON.parse(body))
  const allSessions = await Promise.all(parsePromises)
  allSessions.forEach(movieSessions => {
    movieSessions.map(session => {
      if (session.status === 1) {
        result.push(session)
      }
    })
  })
  return result
}

/**
 * Request GET for each movie and day
 * @param {string[]} links
 * @returns string[] with body content from url
 */
Cinema.requestGETMoviesQuery = async function (links) {
  const promises = links.map(link => WebScrapper.getUrl2Text(link))
  const responses = await Promise.all(promises)
  const bodies = []
  responses.forEach(response => {
    bodies.push(response.body)
  })
  return bodies
}

/**
 * Creates array of links to request
 * @param {any[]} movies
 * @param {any[]} days
 * @param {string} link
 * @see getMoviesDays
 * @returns array string resulted links
 */
Cinema.getMoviesLinks = function (movies, days, link) {
  const links = []
  movies.forEach(movie => {
    days.forEach(day => {
      if (!day.selected) { return }
      const url = link + '/check?day=' + day.value + '&movie=' + movie.value
      links.push(url)
    })
  })
  return links
}

/**
 * Gets the data from the cinema url body
 * and query in relation with available days
 * @param {string} body
 * @param {boolean[]} options
 * @returns Object day
 * @example const day = {
        day: element.innerHTML,
        value: element.value,
        selected: true
      }
 */
Cinema.getMoviesDays = function (body, options) {
  const dom = new JSDOM(body)
  const days = []
  Array.from(dom.window.document.querySelector('#day').children)
    .map(element => {
      if (element.value === '') { return }
      const day = {
        day: element.innerHTML,
        value: element.value,
        selected: true
      }
      days.push(day)
    })

  for (let index = 0; index < options.length; index++) {
    if (options[index] === false) {
      days[index].selected = false
    }
  }
  return days
}

/**
 * Scrapping function
 * Gets the movies title and value
 * to use when request get query movie
 * availability
 * @param {string} body
 * @returns movies in url data
 * @example const film = {
        value: element.value,
        title: element.innerHTML
      }
 */
Cinema.getMoviesInfo = function (body) {
  const dom = new JSDOM(body)
  const films = []
  Array.from(dom.window.document.querySelector('#movie').children)
    .map(element => {
      if (element.hasAttribute('selected')) { return }
      const film = {
        value: element.value,
        title: element.innerHTML
      }
      films.push(film)
    })
  return films
}
