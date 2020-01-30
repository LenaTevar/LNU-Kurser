## Environmental var to production
PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games"
NODE_ENV=production

## etc/nginx/sites-enabled/default

```
server {
        listen 80 default_server;
        listen [::]:80 default_server;
        server_name _;
        return 444;
}
```

## /etc/nginx/conf.d
`nano cscloudXXX.lnu.se.conf`

```
server {
  listen 80;
  listen [::]:80;
  server_name cscloud603.lnu.se;
  location / {
    proxy_pass http://localhost:3000/;
    proxy_http_version 1.1;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header COnnection 'upgrade';
  }
}
```
