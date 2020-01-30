'use strict'

const args = process.argv.slice(2)
const FriendsWebScrapper = require('./lib/FriendManager')

if (args.length === 0) {
  console.error('ERROR: No argument(s). Running basic address')
  process.exit(0)
}

FriendsWebScrapper.run(args)
