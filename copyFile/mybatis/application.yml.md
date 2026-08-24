```# ================================================
# ================================================
# 一、服务基础配置
# ================================================
server:
  port: 9090
  servlet:
    context-path: /api
    encoding:
      charset: UTF-8
      enabled: true
      force: true
  tomcat:
    uri-encoding: UTF-8
    # 线程池配置
    threads:
      max: 200          # 最大工作线程数
      min-spare: 10     # 最小空闲线程数
    accept-count: 100   # 等待队列长度
    max-connections: 10000 # 最大连接数
    connection-timeout: 10000 # 连接超时ms
    max-http-form-post-size: 2MB

# ================================================
# 二、Spring 应用全局配置
# ================================================
spring:
  application:
    name: crud-demo     # 应用名称
  profiles:
    active: dev         # 默认激活环境 dev/test/prod
  main:
    banner-mode: console
    allow-bean-definition-overriding: true # 允许Bean覆盖

  # ==============================================
  # 2.1 Jackson JSON 全局序列化配置
  # ==============================================
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
    default-property-inclusion: non_null # 空值不序列化
    serialization:
      write-dates-as-timestamps: false
      fail-on-empty-beans: false
    deserialization:
      fail-on-unknown-properties: false # 未知字段不报错

  # ==============================================
  # 2.2 数据源 & HikariCP 连接池
  # ==============================================
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/day?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true
    username: root
    password: 123456
    type: com.zaxxer.hikari.HikariDataSource
    hikari:
      pool-name: HikariPool
      minimum-idle: 5
      maximum-pool-size: 20
      auto-commit: true
      idle-timeout: 30000       # 空闲连接超时ms
      max-lifetime: 1800000    # 连接最大生命周期ms
      connection-timeout: 30000 # 获取连接超时ms
      connection-test-query: SELECT 1

  # ==============================================
  # 2.3 文件上传配置
  # ==============================================
  servlet:
    multipart:
      enabled: true
      max-file-size: 10MB      # 单文件最大
      max-request-size: 50MB   # 请求总大小最大

  # ==============================================
  # 2.4 静态资源 & 跨域配置
  # ==============================================
  web:
    resources:
      static-locations: classpath:/static/,file:${user.dir}/upload/
      add-mappings: true
    cors:
      mappings:
        '/**':
          allowed-origins: '*'
          allowed-methods: GET,POST,PUT,DELETE,OPTIONS
          allowed-headers: '*'
          allow-credentials: true
          max-age: 3600

  # ==============================================
  # 2.5 Redis 配置（按需启用，需引入spring-boot-starter-data-redis）
  # ==============================================
  #  data:
  #    redis:
  #      host: 127.0.0.1
  #      port: 6379
  #      password:
  #      database: 0
  #      timeout: 3000
  #      lettuce:
  #        pool:
  #          max-active: 8
  #          max-idle: 8
  #          min-idle: 0
  #          max-wait: -1ms

  # ==============================================
  # 2.6 AOP & 事务
  # ==============================================
  aop:
    auto: true
    proxy-target-class: true
  transaction:
    rollback-on-commit-failure: true

# ================================================
# 三、MyBatis 配置
# ================================================
mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: chiku.liu.pojo
  configuration:
    map-underscore-to-camel-case: true  # 驼峰下划线自动映射
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl # 控制台打印SQL
    cache-enabled: false                # 关闭二级缓存
    lazy-loading-enabled: false
    default-statement-timeout: 3000     # SQL超时ms

# ================================================
# 四、日志配置
# ================================================
logging:
  level:
    root: info
    chiku.liu.mapper: debug    # mapper层打印SQL参数
    org.springframework.web: info
  pattern:
    console: '%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n'
    file: '%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n'
  file:
    name: logs/app.log
    max-size: 10MB
    max-history: 30

# ================================================
# 五、Actuator 监控端点（按需引入spring-boot-starter-actuator）
# ================================================
#management:
#  endpoints:
#    web:
#      exposure:
#        include: health,info,metrics,beans,mappings
#      base-path: /actuator
#  endpoint:
#    health:
#      show-details: always
```