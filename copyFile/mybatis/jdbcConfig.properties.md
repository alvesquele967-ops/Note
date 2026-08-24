```
jdbc.drive=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql:///数据库名字?characterEncoding=utf8
jdbc.username=root
jdbc.password=密码
#3306(///)
```

OR(SpringBoot)

```
server.port=8080
#指定mybatis的mapper文件
mybatis.mapper-locations=classpath:mappers/*xml
#指定mybatis实体目录
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/数据库名?serverTimezone=GMT%2B8&useUnicode=true
spring.datasource.username=root
spring.datasource.password=密码
```
