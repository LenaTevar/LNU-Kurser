'use strict'
const mongoose = require('mongoose')
const Schema = mongoose.Schema
const gistSchema = new Schema({
  title: {
    type: String,
    required: '`{PATH}` is required!',
    max: [30, '`{PATH}` ({VALUE}) exceeds the limit ({MAX}).'],
    min: [1, '`{PATH}` ({VALUE}) is beneath the limit ({MIN}).']
  },
  content: {
    type: String,
    required: '`{PATH}` is required!',
    max: [100, '`{PATH}` ({VALUE}) exceeds the limit ({MAX}).'],
    min: [1, '`{PATH}` ({VALUE}) is beneath the limit ({MIN}).']
  },
  tags: {
    type: [String]
  },
  author: {
    type: String
  },
  authorID: {
    type: Schema.Types.ObjectId
  }
})

const Gist = mongoose.model('Gist', gistSchema)
module.exports = Gist
