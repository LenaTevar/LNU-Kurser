
# Exam Assignment 2

Senast ändrad 2019-10-29 09:23 av Johan Leitet

In this assignment, you will create a web application for persistent handling of programming code snippets using an application framework and an object data modeling library for MongoDB.

## Requirements

The application in Node.js will use Express as the application framework and Mongoose as the object modeling library. The application must have full CRUD functionality regarding snippets, whereby a user must be able to create, read, update and delete snippets.

Users must be able to register and login to the application after entering a username and a password. A user cannot register an already existing username because the username must be unique to the application. A logged in user must be able to log out of the application.

Anonymous users should only be able to view snippets. Authenticated users, in addition to view snippets, must also be able to create, edit and delete their snippets. No one but the authenticated user should be able to create, edit and delete their snippets. Because of this, the application must support some basic authentication and authorization. On the server-side you may only use plain session storage, using the express-session package, to implement authentication and authorization. You must not use any packages such as Passport, etc., to authenticate or authorize.

When writing and presenting snippets, the application must support multiline text, enabling the user to write real code snippets, not just a one-line text string. The application should be easy to understand, meaning that the users should get clear notifications on what is going on in the application (eg. using flash messages).

If a user tries to access a resource that requires the user to be logged in, the application must return the status code 403 (Forbidden). Of course, when necessary, the application must also return the status code 404 (Not Found) as well as 500 (Internal Server Error).

As far as possible, the application must be protected from vulnerable attacks. Be prepared to explain and defend your solution at the oral hearing.

As always, we have the following requirements:

- The application should be written as a JavaScript application following the JavaScript Standard Style code standard, using the Express API, running on the Node.js platform.
- The only command that the examiner will need to execute to run your application after cloning it from GitHub is npm install and npm start.
- You must use GitHub, and make several commits, to show how your completed assignment has evolved from the start to the end.
- To announce that you have completed the assignment, you must create a release of your examination repository on GitHub. If a release is missing the examinators will not grade your assignment.

## Setup

You are free to set up your development environment. You will need a database connection. You are free to use Docker or a connection-string to mLab (see the database connection text for more information)
Extra features [optional]

For those who want to expand functionality in the application and get an extra plus on the assignment, feel free to do that. Some examples of this could be:

    Add support for tagging each snippet by one or more tags.
    Add support for just showing snippets that's belongs to one tag or/and one user.


## Icons
https://thenounproject.com/search/?q=pig&i=549917

## Tipical problems
Tipical problems I found

### bcript not working in windows
```javascript
npm install -g node-gyp
npm install --g --production windows-build-tools
npm install bcrypt
```

### MongoError Connection closed 
Using different IP (ie: laptop to desktop) in Mongo Atlas
- Network Access
- Add IP Adress
- Add current IP 

<!--
<body>
    {{>navbar}}
    <main role="main" class="container">
        {{{body}}}
    </main>
   {{>footer}}
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.7.1/js/all.js"
        integrity="sha384-eVEQC9zshBn0rFj4+TU78eNA19HMNigMviK/PU/FFjLXqa/GKPgX58rvt5Z8PLs7"
        crossorigin="anonymous"></script>
</body>

</html>
-->