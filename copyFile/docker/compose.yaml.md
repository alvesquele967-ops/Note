```
services:
  mysql:
    image: mysql:8.4
#    compose先读取.env，再把值传给MySQL
    environment:
      MYSQL_DATABASE: ${MYSQL_DATABASE}
      MYSQL_USER: ${MYSQL_USER}
      MYSQL_PASSWORD: ${MYSQL_PASSWORD}
      MYSQL_ROOT_PASSWORD: ${MYSQL_ROOT_PASSWORD}
    ports:
      - "127.0.0.1:3307:3306"
    volumes:
      - mysql-data:/var/lib/mysql
    healthcheck:
      test: [ "CMD", "mysqladmin", "ping", "-h", "localhost", "--silent" ]
      interval: 5s
      timeout: 3s
      retries: 20
      start_period: 20s
#宿主机地址:宿主机端口:容器端口
volumes:
  mysql-data:
```