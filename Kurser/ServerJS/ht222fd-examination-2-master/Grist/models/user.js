'use strict'
const bcrypt = require('bcrypt')
const mongoose = require('mongoose')
const Schema = mongoose.Schema
const userSchema = new Schema({
  username: {
    type: String,
    required: '`{PATH}` is required!',
    unique: true
  },
  email: {
    type: String,
    required: '`{PATH}` is required!',
    unique: true
  },
  password: {
    type: String,
    required: '`{PATH}` is required!',
    unique: false
  }
})
// Salts and hashes password before save.
userSchema.pre('save', async function (next) {
  try {
    const salt = await bcrypt.genSalt(10)
    this.password = await bcrypt.hash(this.password, salt)
    next()
  } catch (error) {
    next(error)
  }
})
userSchema.statics.authenticate = async function (username, password) {
  const user = await this.findOne({ username })

  if (!user || !(await bcrypt.compare(password, user.password))) {
    throw new Error('Invalid login attempt.')
  }

  return user
}

const UserGrist = mongoose.model('User', userSchema)
module.exports = UserGrist
/**
 * Recall that every object in a MongoDB has its own unique ID stored in its _id property.
 * At this point we can also define methods on our schema before we create our model.
 * // In the User model

 */
