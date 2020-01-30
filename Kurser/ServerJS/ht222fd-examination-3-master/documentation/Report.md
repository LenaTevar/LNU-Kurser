# Assignment Report
## Url
https://cscloud603.lnu.se

## Security
The server runs with a reversed proxy that creates a fasade that hides the original node server. The proxy is HTTPS and then works in HTTP localhost with the node server. The proxy listen to different ports: When trying to access the application through HTTP - port 80, the proxy re-route it to the HTTPS web.
Inside the application code, the route that allows a post request makes a check on the x-hub-signature or the request. If the post request comes from github, then is accepted and the data is broadcasted through the web socket. The presentation of issues is managed by the server, not client side, so XSS scripting is not easily possible, because I used handlebars text nodes and the possible options to reach html elements are only accesed by github. For instance, the link to the issue github page looks like `<a href="{{html_url}}" class="btn btn-outline-info">Go to Github</a>` if someone could reach the parameter `html_url`, it could be a vulnerability, but because the direction of the information is from the server to github, there is no third party access to our server, we are save that the information is real and safe.
In case the server had some problem and crashed for some reason, the process manager PM2 would reset the connection and the traffic could keep working. Moreover, PM2 handles the execution in production. Something that otherwise we should manage by changing the environmental variable NODE_ENV. For instance, during development I have used NODE_ENV set in development, so node would install all the dependencies from the package that are used during development and used some extra code to test the application. At the end of the assigment, the development and testing branches were cleaned to deploy.
An addition to PM2 bein able to reload the server by itself when it is down, and because the client socket has a heartbeat and the application has only one page with all the issues loaded when you get the page, if the server is down, a visual key (a literal heart beat) will show the  user when the server has had a problem. Anyways PM2 will take care of that and reset it. 

The main difference of the application running in development with the online application runing in production is that the development application includes packages like nodemon and a logger (morgan), the websocket is configured to localhost and the app is HTTP, because Nginx is the one handling the HTTPS and the TLS certificates.

The extra modules used during this assignmnet were: 
- Octonode: This package was used to reach and download the github API
- Crypto: This package was used to check the x-hub-signature from the webhook
I used those modules because they are well maitained. That was the reason of not using any other package to manage the webhook, for instance. If the package was not update often, then I discarded it. 



    
