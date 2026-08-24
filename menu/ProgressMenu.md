# 日本新卒 Java Backend 学习路线

## 当前状态

目标：

- 日本新卒 Java Backend Engineer
- 游戏公司 Backend Engineer
- Web 自社开发 Engineer

当前已完成：

- [x] Java基础
- [x] Maven
- [x] MySQL / SQL基础
- [x] MyBatis
- [x] Spring Boot基础
- [x] REST API
- [x] Controller → Service → Mapper 分层


当前阶段：

> 基础阶段完成，进入企业项目开发阶段


---

# 阶段1：Spring Boot 企业化开发

预计时间：

> 3～5周

目标：

> 从“能写接口”提升到“能写企业项目代码”

求职价值：

★★★★★


## DTO / VO / Request / Response

- [ ] DTO / VO设计

重要度：

★★★★★

难度：

★★★☆☆

预计时间：

3～5天

学习：

- Entity与DTO区别
- Request对象
- Response对象
- VO对象

完成标准：

- 不直接返回数据库Entity
- 理解接口数据设计


---

## Validation 参数校验

- [ ] Validation

重要度：

★★★★☆

难度：

★★☆☆☆

预计时间：

2～3天

学习：

- @Valid
- @NotNull
- @NotBlank
- @Size


完成标准：

- 用户输入错误时返回合理提示


---

## 全局异常处理

- [ ] Global Exception Handler

重要度：

★★★★★

难度：

★★★☆☆

预计时间：

3～5天

学习：

- 自定义异常
- @RestControllerAdvice
- @ExceptionHandler


完成标准：

- Controller不大量使用try-catch


---

## 统一返回结构

- [ ] API统一响应格式

重要度：

★★★★☆

难度：

★★☆☆☆

预计时间：

1～2天


学习：

- code
- message
- data


---

## 日志系统

- [ ] SLF4J / Logback

重要度：

★★★★☆

难度：

★★☆☆☆

预计时间：

2～3天


学习：

- INFO
- WARN
- ERROR


---

## 配置管理

- [ ] Spring Profile

重要度：

★★★★☆

难度：

★★☆☆☆

预计时间：

2～3天


学习：

- application.yml
- dev环境
- prod环境
- 环境变量


---

# 阶段2：用户系统与安全认证

预计时间：

> 4～6周


目标：

> 完成真正后台系统核心


求职价值：

★★★★★


---

## Spring Security

- [ ] Spring Security

重要度：

★★★★★

难度：

★★★★☆

预计时间：

1～2周


学习：

- Authentication
- Authorization
- Filter Chain
- SecurityContext


---

## JWT

- [ ] JWT认证

重要度：

★★★★★

难度：

★★★☆☆

预计时间：

1周


学习：

- 登录
- Token生成
- Token验证
- 请求携带Token


---

## BCrypt

- [ ] BCrypt密码加密

重要度：

★★★★★

难度：

★★☆☆☆

预计时间：

1天


目标：

- 密码不能明文保存


---

## CORS

- [ ] CORS跨域

重要度：

★★★★☆

难度：

★★☆☆☆

预计时间：

1～2天


---

阶段2完成：

具备：

- 用户注册
- 登录
- 权限控制
- Token认证


水平：

普通Java新卒：

★★★★☆


---

# 阶段3：数据库进阶

预计时间：

> 3～4周


目标：

> 从会使用数据库到理解数据库


---

## MySQL索引

- [ ] MySQL Index

重要度：

★★★★★

难度：

★★★★☆

预计时间：

1周


学习：

- B+Tree
- 普通索引
- 联合索引
- 最左匹配


---

## EXPLAIN

- [ ] SQL执行计划

重要度：

★★★★☆

难度：

★★★☆☆

预计时间：

2～3天


学习：

- 查询优化
- 索引使用情况


---

## MySQL事务

- [ ] Transaction

重要度：

★★★★★

难度：

★★★★☆

预计时间：

1周


学习：

- ACID
- Commit
- Rollback
- @Transactional


---

## 隔离级别

- [ ] Isolation Level

重要度：

★★★★☆

难度：

★★★★☆


学习：

- 脏读
- 不可重复读
- 幻读


---

## MVCC

- [ ] MVCC基础

重要度：

★★★☆☆

难度：

★★★★☆


目标：

- 理解思想即可


---

# 阶段4：项目增强

预计时间：

> 1～2个月


目标：

> 让项目达到优秀新卒作品水平


---

## Redis

- [ ] Redis基础

重要度：

★★★★☆

难度：

★★★☆☆


学习：

- String
- Hash
- List
- TTL


---

## Redis缓存设计

- [ ] Cache设计

重要度：

★★★★☆

难度：

★★★☆☆


学习：

- Cache Aside
- 缓存穿透
- 缓存击穿
- 缓存雪崩


---

## 分页与复杂查询

- [ ] 分页功能

重要度：

★★★★★


学习：

- 分页查询
- 条件搜索
- 动态SQL


---

## 测试

- [ ] JUnit

重要度：

★★★★☆

难度：

★★★☆☆


学习：

- 单元测试
- Service测试


---

- [ ] Mockito

重要度：

★★★☆☆


学习：

- Mock对象


---

# 阶段5：完整Spring Boot项目

预计时间：

> 2～3个月（与前面同步）


目标：

完成第一个求职作品。


---

项目要求：

## 后端

- [ ] Spring Boot

- [ ] MyBatis

- [ ] MySQL

- [ ] Redis

- [ ] Spring Security

- [ ] JWT


## 功能

- [ ] 用户系统

- [ ] 登录注册

- [ ] 权限管理

- [ ] CRUD

- [ ] 分页

- [ ] 搜索

- [ ] 文件上传

- [ ] 数据统计

- [ ] API文档

- [ ] 测试


完成后：

达到：

> 日本普通新卒 Java Backend 可投水平


---

# 阶段6：工程化与部署能力

预计时间：

> 1～2个月


目标：

> 从“本地能运行”到“真实上线”


---

## Git深入

- [ ] Git

重要度：

★★★★★


学习：

- branch
- merge
- conflict
- Pull Request


---

## Linux

- [ ] Linux基础

重要度：

★★★★★


预计时间：

1～2周


学习：

- SSH
- 文件操作
- 权限
- 进程
- 日志


---

## Docker

- [ ] Docker

重要度：

★★★★★


预计时间：

1～2周


学习：

- Image
- Container
- Dockerfile
- Docker Compose


---

## Nginx

- [ ] Nginx

重要度：

★★★★☆


学习：

- Reverse Proxy
- 基础配置


---

# AWS基础

预计时间：

> 1个月


目标：

部署自己的项目。


---

## AWS IAM

- [ ] IAM


重要度：

★★★★★


---

## AWS EC2

- [ ] EC2


重要度：

★★★★★


学习：

- 云服务器
- SSH部署


---

## AWS RDS

- [ ] RDS


重要度：

★★★★★


学习：

- 云数据库


---

## AWS S3

- [ ] S3


重要度：

★★★★☆


学习：

- 文件存储


---

## Security Group

- [ ] Security Group


重要度：

★★★★★


---

## CloudWatch

- [ ] CloudWatch


重要度：

★★★★☆


学习：

- 日志
- 监控


---

完成阶段6：

水平：

> 优秀新卒 Backend


---

# 阶段7：COVER / 游戏大厂专项

说明：

> 非普通新卒必须内容

目标：

> 提升竞争热门Backend岗位能力


---

## Go

- [ ] Go基础


重要度：

普通Java岗位：

★★☆☆☆


COVER：

★★★★★


预计时间：

3～4周


学习：

- struct
- interface
- goroutine
- HTTP API


---

## Go Backend

- [ ] Go Web项目


预计时间：

1～2个月


内容：

- Go REST API
- MySQL
- Redis
- Docker


---

## AWS ECS / Fargate

- [ ] ECS/Fargate


重要度：

★★★★☆


---

## OpenAPI

- [ ] OpenAPI


重要度：

★★★★☆


---

## PostgreSQL

- [ ] PostgreSQL


重要度：

★★★☆☆


---

## DynamoDB

- [ ] DynamoDB


重要度：

★★★☆☆


---

完成阶段7：

目标：

> 可以挑战COVER Server-side Engineer等热门岗位


---

# 阶段8：入社后成长路线

说明：

> 不属于新卒求职必须学习内容


目标：

> 从Junior Engineer成长为中高级工程师


---

## Kubernetes

- [ ] Kubernetes


难度：

★★★★★


学习：

- Pod
- Service
- Deployment


---

## Terraform

- [ ] Terraform


学习：

- Infrastructure as Code


---

## Kafka / RabbitMQ

- [ ] Message Queue


---

## 微服务

- [ ] Microservices


---

## 分布式系统

- [ ] Distributed System


---

## 高并发系统设计

- [ ] High Performance System Design


---

## SRE

- [ ] SRE基础


---

# 最终目标阶段

## 日本普通新卒Backend

需要：

✅ 阶段1

✅ 阶段2

✅ 阶段3基础

✅ 阶段5项目


---

## 优秀新卒Backend

需要：

✅ 上述全部

+

✅ Docker

✅ Linux

✅ AWS基础


---

## COVER / 大型游戏公司Backend

需要：

✅ 优秀新卒水平

+

✅ Go

+

✅ Cloud

+

✅ 系统设计基础


---

## 入社后成长

学习：

Kubernetes

Terraform

微服务

分布式

高并发


---

# 当前下一步

- [ ] DTO / VO / Request / Response

- [ ] Validation

- [ ] 全局异常处理

- [ ] 统一响应结构

- [ ] 日志系统

- [ ] Profile配置管理

然后：

- [ ] Spring Security

- [ ] JWT

- [ ] BCrypt

- [ ] CORS

开始第一个完整Spring Boot项目