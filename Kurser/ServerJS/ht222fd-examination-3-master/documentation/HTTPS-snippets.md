# Server side scripts for https
```bash
#!/bin/bash
echo "Generating self-signed certificate..."
mkdir -p ./config/sslcerts
openssl genrsa -out ./config/sslcerts/key.pem 4096
openssl req -new -key ./config/sslcerts/key.pem -out ./config/sslcerts/csr.pem
openssl x509 -req -days 365 -in ./config/sslcerts/csr.pem -signkey ./config/sslcerts/key.pem -out ./config/sslcerts/cert.pem
rm ./config/sslcerts/csr.pem
chmod 600 ./config/sslcerts/key.pem ./config/sslcerts/cert.pem
```

Tip: Use winscp to manage files and folders
Redirect all http to https, from port 80 to 443. 
Change port to https port and some ssl stuff in nginx config.

```
server { 
        listen 80;
        server_name cscloud603.lnu.se;
        return 301 https://$server_name$request_uri;
}

server {
	listen 443;
	listen [::]:443;
	ssl on;
	ssl_certificate /var/www/githook/config/sslcerts/cert.pem;
	ssl_certificate_key /var/www/githook/config/sslcerts/key.pem;
	ssl_ciphers EECDH+AESGCM:EDH+AESGCM:AES256+EECDH:AES256+EDH;
	ssl_prefer_server_ciphers on;
	ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
	server_name cscloud603.lnu.se;
	location / {
		proxy_pass http://localhost:3000/;
		proxy_http_version 1.1;
		proxy_set_header Upgrade $http_upgrade;
		proxy_set_header Connection 'upgrade';
  	}
}
```
Exam assignment 3  1DV523      

Server-based Web Programming
Describe what you have done to make your application secure, both in code and when configuring your application server.
- Server side fetch from octonode
- Socket only alerts, not DOM changes
- Proxy
- TLS

Describe the following parts, how you are using them, and what their purpose is in your solution:
    Reversed proxy
		- From https to hppt
    Process manager
		- reload when server crashes
    TLS certificates
	- TLS security layer
	- https proxy witn self signed certificate
    Environment variables
	- change from development to environmental
    What differs in your application when running it in development from running it in production?
	- I added extra modules to test the application

    Which extra modules did you use in the assignment? Motivate the use of them, and how you have to make sure that they are secure enough for production.
    - octonode
	- crypto

	Have you implemented any extra features (see below) that could motivate a higher grade of this assignment? If so, describe them.
	- Hopes and dreams

