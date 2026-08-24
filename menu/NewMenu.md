# 日本新卒 Java Backend / COVER Backend 学习路线

> 当前定位：
> 已完成 Java → Maven → MySQL/SQL → MyBatis → Spring Boot → REST API → Controller/Service/Mapper 分层。
>
> 当前阶段：
> 【基础知识学习后期 → 完整后端项目阶段】
>
> 评分说明：
> 重要度：★★★★★ = 求职前基本必须
> 难度：★★★★★ = 对新卒学习阶段而言较难
>
> 主线：
> Java Backend基础
> → 完整Spring Boot项目
> → 工程化
> → Linux / Docker
> → AWS云部署
> → CI/CD
> → 求职强化
> → Go / COVER专项


- [x] **01. Java 基础**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：基本语法、类、方法、OOP、集合、异常等
  - 后续：不用重新系统学，在项目和面试复习中巩固
  - 就职阶段：Java Backend最基础门槛

- [x] **02. Maven**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 包括：pom.xml、依赖、生命周期、打包
  - 可一起学：整个Spring Boot项目过程中持续使用
  - 就职阶段：企业Java项目基本工具

- [x] **03. MySQL / SQL 基础**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：CRUD、WHERE、LIKE、函数、子查询、JOIN、多表查询
  - 后续：以后继续补索引、事务、EXPLAIN
  - 就职阶段：Backend基础数据库能力

- [x] **04. MyBatis 基础**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：Mapper接口、Mapper XML、实体映射、CRUD
  - 可一起学：MySQL + Spring Boot
  - 就职阶段：已经具备Java访问数据库基础

- [x] **05. Spring Boot 基础**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：项目启动、配置、依赖注入、Bean等
  - 后续：不再单独继续“学Spring Boot”，而是用项目深化
  - 就职阶段：开始进入真正Backend开发

- [x] **06. REST API**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：GET / POST / PUT / DELETE、JSON、请求与响应
  - 可一起学：Spring MVC、HTTP
  - 就职阶段：已经能设计基础后端接口

- [x] **07. Controller → Service → Mapper 分层**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：Controller负责接口、Service负责业务、Mapper负责数据访问
  - 后续：在真实项目中持续巩固
  - 就职阶段：
    **你现在就在这里**
    从“Spring Boot教程阶段”正式进入“企业项目结构阶段”


- [ ] **08. DTO / VO / Request / Response 对象**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 核心：不要把Entity直接到处传
  - 可一起学：
    DTO
    + Validation
    + 统一响应
    + 全局异常
  - 建议：下一步就学
  - 就职意义：代码结构开始真正像企业项目

- [ ] **09. Validation 参数校验**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 包括：@Valid、@NotNull、@NotBlank、@Size等
  - 可一起学：DTO
  - 目标：用户输入非法数据时能够正确返回错误

- [ ] **10. 全局异常处理**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：
    自定义异常
    @RestControllerAdvice
    @ExceptionHandler
  - 可一起学：统一响应结构
  - 目标：Controller中不出现大量try/catch

- [ ] **11. 统一API响应结构**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 例如：
    code
    message
    data
  - 可一起学：DTO + Exception
  - 目标：接口返回格式统一

- [ ] **12. 日志 SLF4J / Logback**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 包括：
    INFO
    WARN
    ERROR
  - 可一起学：异常处理
  - 目标：知道什么情况下应该写日志，而不是System.out.println

- [ ] **13. Spring Profile / 配置管理**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 包括：
    application-dev
    application-prod
    环境变量
  - 可一起学：项目部署
  - 目标：开发环境和生产环境配置分离


- [ ] **14. Spring Security**
  - 重要度：★★★★★
  - 难度：★★★★☆
  - 包括：
    Authentication
    Authorization
    Security Filter基本概念
  - 可一起学：
    JWT
    BCrypt
    CORS
  - 这是下一阶段的核心Boss

- [ ] **15. JWT 登录认证**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：
    登录
    Token生成
    Token验证
    请求携带Token
  - 可一起学：Spring Security

- [ ] **16. BCrypt / 密码安全**
  - 重要度：★★★★★
  - 难度：★★☆☆☆
  - 目标：
    密码绝不能明文存数据库
  - 可一起学：Security登录

- [ ] **17. CORS**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 目标：理解跨域为什么发生、怎么解决
  - 可一起学：前后端分离 + Security


- [ ] **18. MyBatis 动态 SQL**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 包括：
    if
    choose
    foreach
  - 可一起学：复杂查询、分页
  - 目标：处理实际后台搜索条件

- [ ] **19. 分页 / 条件查询**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 可一起学：MyBatis / MyBatis-Plus
  - 目标：真正后台系统必须有

- [ ] **20. MyBatis-Plus**
  - 重要度：★★★☆☆
  - 难度：★★☆☆☆
  - 注意：
    学会使用即可
    不要用它替代MyBatis/SQL基本功
  - 可一起学：项目CRUD


- [ ] **21. MySQL 索引**
  - 重要度：★★★★★
  - 难度：★★★★☆
  - 包括：
    普通索引
    联合索引
    最左匹配
    B+Tree基本思想
  - 可一起学：
    EXPLAIN
    SQL优化
  - 就职意义：进入真正Backend技术面高频区域

- [ ] **22. EXPLAIN**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 目标：能看基础执行计划
  - 可一起学：索引

- [ ] **23. MySQL 事务**
  - 重要度：★★★★★
  - 难度：★★★★☆
  - 包括：
    ACID
    Commit / Rollback
    @Transactional
  - 可一起学：Spring事务

- [ ] **24. 事务隔离级别**
  - 重要度：★★★★☆
  - 难度：★★★★☆
  - 包括：
    脏读
    不可重复读
    幻读
  - 可一起学：事务

- [ ] **25. MVCC 基础**
  - 重要度：★★★☆☆
  - 难度：★★★★☆
  - 目标：理解思想即可
  - 不要求：MySQL源码级理解


- [ ] **26. Redis 基础**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 包括：
    String
    Hash
    List
    Set
    TTL
  - 可一起学：Spring Boot项目

- [ ] **27. Redis 缓存**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 包括：Cache Aside
  - 目标：实际把缓存加进项目

- [ ] **28. 缓存穿透 / 击穿 / 雪崩**
  - 重要度：★★★☆☆
  - 难度：★★★★☆
  - 可一起学：Redis缓存
  - 就职意义：技术面加分


- [ ] **29. JUnit 5**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 目标：能够测试Service主要业务
  - 可一起学：Spring Boot Test

- [ ] **30. Spring Boot Test**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 目标：能够测试API / Repository等

- [ ] **31. Mockito**
  - 重要度：★★★☆☆
  - 难度：★★★☆☆
  - 目标：理解Mock并能写简单测试
  - 不要求：成为测试专家


- [ ] **32. Git 系统补全**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：
    branch
    merge
    conflict
    Pull Request
    .gitignore
  - 学习方式：
    从现在开始直接在项目开发过程中使用
  - 不建议：单独看几十小时Git教程

- [ ] **33. Swagger / OpenAPI**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 目标：自动生成API文档
  - 可一起学：REST API项目


- [ ] **34. 完成第一个完整 Spring Boot Backend 项目**
  - 重要度：★★★★★
  - 难度：★★★★☆
  - 至少包括：
    登录
    JWT
    权限
    CRUD
    多表关系
    分页
    搜索
    参数校验
    全局异常
    日志
    MySQL
    Redis
    测试
    API文档
  - 求职阶段：
    ★★★【普通日本新卒Java Backend开始具备正式投递能力】
  - 从这里开始：
    可以边继续学下面的内容，边正式投普通新卒Backend岗位


- [ ] **35. HTTP 深入**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 包括：
    Header
    Cookie
    Session
    Status Code
    HTTPS基本原理
  - 可一起学：Security

- [ ] **36. TCP/IP / DNS 基础**
  - 重要度：★★★★☆
  - 难度：★★★★☆
  - 目标：
    能回答“浏览器输入URL后发生了什么”
  - 不需要：网络工程师级深度


- [ ] **37. Linux 基础**
  - 重要度：★★★★★
  - 难度：★★☆☆☆
  - 包括：
    ls
    cd
    cp
    mv
    rm
    cat
    grep
    tail
    ps
    top
    kill
    chmod
    环境变量
  - 可一起学：
    SSH
    Docker
    AWS EC2
  - 学习方式：边部署边学

- [ ] **38. SSH**
  - 重要度：★★★★★
  - 难度：★★☆☆☆
  - 可一起学：Linux / AWS EC2

- [ ] **39. Linux日志与进程管理**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 可一起学：部署


- [ ] **40. Docker 基础**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 包括：
    Image
    Container
    Dockerfile
    Port
    Volume
  - 可一起学：Linux

- [ ] **41. Docker Compose**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 目标：
    Spring Boot
    + MySQL
    + Redis
    一条命令启动
  - 求职意义：作品集工程化程度明显提升

- [ ] **42. Nginx**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 包括：
    Reverse Proxy
    基础配置
  - 可一起学：Linux + Docker + 部署


- [ ] **43. AWS IAM**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 可一起学：EC2
  - 核心：权限和Role

- [ ] **44. AWS EC2**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 可一起学：
    Linux
    SSH
    Docker
  - 目标：把Spring Boot服务真正部署到云服务器

- [ ] **45. AWS RDS**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 目标：MySQL数据库迁移到AWS

- [ ] **46. AWS Security Group**
  - 重要度：★★★★★
  - 难度：★★★☆☆
  - 可一起学：EC2 + RDS

- [ ] **47. AWS VPC 基础**
  - 重要度：★★★★☆
  - 难度：★★★★☆
  - 包括：
    Public Subnet
    Private Subnet
    Route
    网络基础
  - 不需要：一开始设计大型企业网络

- [ ] **48. AWS S3**
  - 重要度：★★★★☆
  - 难度：★★☆☆☆
  - 目标：图片/文件上传

- [ ] **49. AWS CloudWatch**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 目标：日志、监控


- [ ] **50. 将完整项目部署到 AWS**
  - 重要度：★★★★★
  - 难度：★★★★☆
  - 最终结构示例：
    Client
    ↓
    EC2 / Docker
    ↓
    Spring Boot
    ↓
    RDS MySQL
    ↓
    Redis
    ↓
    S3
    ↓
    CloudWatch
  - 求职阶段：
    ★★★★【普通日本新卒Backend中已经属于明显有准备的候选人】
  - 从这里开始：
    不再只是“会Spring Boot”
    而是能够说明开发 → 部署 → 运维的完整流程


- [ ] **51. CI/CD 基础**
  - 重要度：★★★★☆
  - 难度：★★★☆☆

- [ ] **52. GitHub Actions**
  - 重要度：★★★★☆
  - 难度：★★★☆☆
  - 可一起学：
    JUnit
    Docker
    AWS
  - 目标：
    git push
    → 自动测试
    → 自动build

- [ ] **53. 自动部署**
  - 重要度：★★★☆☆
  - 难度：★★★★☆
  - 目标：
    GitHub Actions
    → Docker build
    → AWS部署


- [ ] **54. AWS ECR**
  - 重要度：★★★☆☆
  - 难度：★★★☆☆
  - 可一起学：Docker / ECS

- [ ] **55. AWS ECS / Fargate**
  - 重要度：★★★★☆
  - 难度：★★★★☆
  - 可一起学：
    Docker
    ECR
    AWS
  - 就职意义：
    开始进入现代Cloud Backend环境
    也开始贴近COVER的技术方向


- [ ] **56. 数据结构与算法基础**
  - 重要度：★★★★☆
  - 难度：★★★★☆
  - 建议：不要最后集中学，每周慢慢练
  - 包括：
    Array
    List
    Stack
    Queue
    HashMap
    Tree
    二分
    DFS
    BFS
    Big-O
  - 目标：
    Easy稳定
    常见Medium能够理解
  - 不要求：刷500道LeetCode


- [ ] **57. 系统设计基础**
  - 重要度：★★★★☆
  - 难度：★★★★☆
  - 建议：AWS + Redis + DB学完后开始
  - 包括：
    Load Balancer
    Cache
    DB
    横向扩展
    高可用
    Session
  - 求职阶段：
    ★★★★☆【热门Web / 游戏Backend技术面强化阶段】


- [ ] **58. Vue 3**
  - 重要度：★★★☆☆
  - 难度：★★★☆☆
  - 定位：Full Stack加分，不是Backend当前第一优先级

- [ ] **59. TypeScript**
  - 重要度：★★★☆☆
  - 难度：★★★☆☆
  - 可一起学：Vue

- [ ] **60. Axios / Router / Pinia**
  - 重要度：★★★☆☆
  - 难度：★★☆☆☆
  - 目标：
    给自己的Backend项目做一个真正可用的管理后台
  - 求职意义：
    日本Full Stack岗位加分


- [ ] **61. Go 基础**
  - 重要度：
    普通Java求职：★★☆☆☆
    COVER专项：★★★★★
  - 难度：★★★☆☆
  - 开始时机：
    完整Java Backend项目完成以后
  - 注意：
    不要放弃Java重学Go
    Go是第二Backend语言

- [ ] **62. Go REST API**
  - COVER重要度：★★★★★
  - 难度：★★★☆☆
  - 目标：
    用Go重新做一个小型Backend服务

- [ ] **63. Go + MySQL**
  - COVER重要度：★★★★☆
  - 难度：★★★☆☆

- [ ] **64. Go + Redis**
  - COVER重要度：★★★★☆
  - 难度：★★★☆☆

- [ ] **65. Go + Docker**
  - COVER重要度：★★★★★
  - 难度：★★★☆☆

- [ ] **66. Go服务部署到AWS**
  - COVER重要度：★★★★★
  - 难度：★★★★☆
  - 求职阶段：
    ★★★★★【COVER等热门Backend岗位开始真正具备技术匹配度】


- [ ] **67. PostgreSQL 基础**
  - 重要度：★★★☆☆
  - 难度：★★☆☆☆
  - MySQL学好后非常容易补

- [ ] **68. DynamoDB 基础**
  - COVER重要度：★★★☆☆
  - 难度：★★★☆☆
  - 建议：AWS基础完成后

- [ ] **69. OpenAPI 深入**
  - COVER重要度：★★★★☆
  - 难度：★★★☆☆
  - 可一起学：Go API


- [ ] **70. 高并发 / 性能基础**
  - 重要度：★★★★☆
  - 难度：★★★★★
  - 包括：
    Cache
    DB瓶颈
    Connection Pool
    Scale Out
    Rate Limit
  - 学习阶段：求职强化
  - 不需要：达到高级架构师程度


- [ ] **71. Terraform**
  - 普通新卒重要度：★★☆☆☆
  - COVER / Cloud重要度：★★★☆☆
  - 难度：★★★★☆
  - 开始时机：AWS已经熟悉之后

- [ ] **72. Kubernetes 基础**
  - 普通新卒重要度：★★☆☆☆
  - 难度：★★★★★
  - 当前状态：
    【完全不用急】
  - 前置：
    Docker
    AWS
    ECS
  - 目标：以后理解Pod / Deployment / Service即可

- [ ] **73. EKS**
  - 重要度：★★☆☆☆
  - 难度：★★★★★
  - 前置：Kubernetes
  - 当前：后期再说

- [ ] **74. Kafka / RabbitMQ**
  - 重要度：★★★☆☆
  - 难度：★★★★☆
  - 开始时机：系统设计阶段
  - 当前：不是求职前必须

- [ ] **75. Prometheus / Grafana**
  - 重要度：★★★☆☆
  - 难度：★★★★☆
  - 定位：监控 / SRE方向加分
  - 当前：后期


---

# 就职里程碑

- [x] **里程碑 0：Java Backend基础建立**
  - Java
  - Maven
  - SQL
  - MyBatis
  - Spring Boot
  - REST API
  - Controller / Service / Mapper
  - 状态：✅ 已完成


- [ ] **里程碑 1：完整Backend项目**
  - 推荐完成范围：08 ～ 34
  - 完成后定位：
    **可以正式投普通日本新卒Java Backend**
  - 面试时已经能够围绕一个完整项目回答问题


- [ ] **里程碑 2：工程化Backend**
  - Linux
  - Docker
  - Nginx
  - Git
  - Test
  - 状态：
    **不只是“会开发”，开始懂实际运行环境**


- [ ] **里程碑 3：Cloud Backend**
  - AWS
  - EC2
  - RDS
  - S3
  - VPC
  - CloudWatch
  - Docker部署
  - 完成后定位：
    **日本新卒Backend里属于明显认真准备过的一档**


- [ ] **里程碑 4：工程能力强化**
  - CI/CD
  - ECS/Fargate
  - 系统设计
  - 算法
  - DB性能
  - Redis深入
  - 完成后定位：
    **热门Web公司 / 游戏公司Backend进入有竞争力阶段**


- [ ] **里程碑 5：COVER专项**
  - Go
  - Go REST API
  - MySQL
  - Redis
  - Docker
  - AWS
  - ECS/Fargate
  - OpenAPI
  - 系统设计
  - 完成后定位：
    **可以真正认真挑战COVER Server-side Engineer**


# 当前下一步

- [ ] DTO / VO / Request / Response
- [ ] Validation
- [ ] 全局异常处理
- [ ] 统一API返回
- [ ] 日志
- [ ] Profile / 配置管理

> 上面6项不要拆成6门课程。
> 直接在一个Spring Boot项目中一起完成。

完成后：

- [ ] Spring Security
- [ ] JWT
- [ ] BCrypt
- [ ] CORS

然后：

- [ ] MySQL索引
- [ ] 事务
- [ ] EXPLAIN
- [ ] Redis
- [ ] Test

最终：

- [ ] 完成完整Spring Boot Backend项目