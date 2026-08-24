全栈开发学习顺序

第一阶段：计算机与开发基础

学习内容：

* 计算机程序基本概念
* 客户端、服务器、前端、后端
* HTTP、HTTPS、IP、端口、域名
* JSON 数据格式
* REST API 基本概念
* IntelliJ IDEA、VS Code 的基本操作
* 命令行与 PowerShell 基础

目标：理解浏览器、前端、后端和数据库之间如何通信。

⸻

第二阶段：Git 与 GitHub

学习内容：

* Git 仓库
* 工作区、暂存区、版本库
* add、commit、push、pull
* .gitignore
* 分支与合并
* 冲突解决
* GitHub 仓库管理
* Conventional Commits

目标：能够独立管理项目版本并上传 GitHub。

⸻

第三阶段：Java 基础

学习内容：

* 变量与数据类型
* 条件判断与循环
* 方法
* 数组
* 类与对象
* 构造方法
* 封装、继承、多态
* 接口与抽象类
* 异常处理
* 枚举
* 注解
* record
* 日期时间 API

目标：能够独立编写普通 Java 程序，并看懂后端业务代码。

⸻

第四阶段：Java 进阶

学习内容：

* List、Set、Map
* 泛型
* Lambda 表达式
* Stream API
* Optional
* 文件输入输出
* 常用工具类
* 反射基础
* 多线程基础
* JVM 基础概念
* 代码规范与常见设计原则

目标：能够处理集合数据、编写较完整的业务逻辑。

⸻

第五阶段：Maven

学习内容：

* Maven 项目结构
* pom.xml
* groupId、artifactId、version
* Dependency
* Plugin
* Scope
* Maven 生命周期
* clean、test、package、install
* Maven Wrapper
* 多环境配置基础

目标：能够管理依赖、运行测试并打包 Java 项目。

⸻

第六阶段：Spring Framework 基础

学习内容：

* IoC
* DI
* Spring 容器
* Bean
* 组件扫描
* @Component
* @Service
* @Repository
* 构造器注入
* Bean 生命周期基础
* AOP 基础

目标：理解 Spring 为什么能自动创建和管理对象。

⸻

第七阶段：Spring Boot 与 Spring MVC

学习内容：

* Spring Boot 项目结构
* 自动配置
* application.yml
* Profile 多环境配置
* Controller、Service、Repository 分层
* @RestController
* @RequestMapping
* @GetMapping
* @PostMapping
* @PutMapping
* @DeleteMapping
* @RequestBody
* @RequestParam
* @PathVariable
* ResponseEntity
* DTO
* JSON 与 Java 对象转换
* REST API 设计规范

目标：能够开发完整的增删改查接口。

⸻

第八阶段：后端公共基础设施

学习内容：

* 统一 API 返回结构
* 全局异常处理
* 自定义业务异常
* HTTP 状态码
* 参数校验
* @Valid
* @NotBlank
* @Size
* @Pattern
* 日志 SLF4J、Logback
* 跨域 CORS
* 分页请求设计
* 统一错误代码

目标：让接口具备正式企业项目的基础规范。

⸻

第九阶段：JUnit 与自动化测试

学习内容：

* JUnit 5
* @Test
* 常用断言
* 异常测试
* 参数化测试
* Mockito
* Mock 对象
* given、willReturn、willThrow
* verify
* MockMvc
* @WebMvcTest
* @SpringBootTest
* 测试正常流程与异常流程
* 测试覆盖率基础

目标：能够测试 Service、Controller 和完整应用。

⸻

第十阶段：SQL 与 MySQL

学习内容：

* 数据库、表、行、列
* 数据类型
* 主键
* 外键
* 唯一约束
* 非空约束
* SELECT
* INSERT
* UPDATE
* DELETE
* WHERE
* ORDER BY
* LIMIT
* 聚合函数
* GROUP BY
* HAVING
* 内连接、左连接
* 子查询
* 索引
* 事务
* ACID
* 事务隔离级别
* 数据库范式
* ER 图
* 一对一、一对多、多对多

目标：能够独立设计数据库并编写常用 SQL。

⸻

第十一阶段：Spring Data JPA 与 Hibernate

学习内容：

* ORM
* JPA 与 Hibernate 的关系
* Entity
* @Entity
* @Table
* @Id
* @GeneratedValue
* @Column
* JpaRepository
* 派生查询
* JPQL
* @Query
* 分页与排序
* 一对一、一对多、多对多映射
* 懒加载与立即加载
* N+1 问题
* Entity 与 DTO 转换
* @Transactional
* 乐观锁
* 审计字段
* Flyway 数据库版本管理
* @DataJpaTest

目标：能够通过 JPA 完成真实数据库业务。

⸻

第十二阶段：Spring Security

学习内容：

* 认证与授权
* Spring Security 过滤器链
* SecurityFilterChain
* BCrypt 密码加密
* UserDetails
* UserDetailsService
* 登录认证流程
* 401 与 403
* CORS 与 CSRF
* 方法级权限
* @PreAuthorize
* 安全异常处理

目标：能够保护接口并实现用户登录认证。

⸻

第十三阶段：JWT 与 RBAC

学习内容：

* JWT 结构
* Header、Payload、Signature
* Access Token
* Token 过期
* JWT 生成与验证
* JWT 过滤器
* 当前登录用户
* RBAC 权限模型
* 用户、角色、权限关系
* 动态权限控制
* 登录、退出登录
* Token 黑名单或刷新机制
* 前后端权限协作

目标：能够实现管理员、普通用户等多级权限系统。

⸻

第十四阶段：Redis

学习内容：

* Redis 基础数据类型
* String、Hash、List、Set、ZSet
* TTL
* RedisTemplate
* JSON 序列化
* Spring Cache
* @Cacheable
* @CacheEvict
* 缓存更新策略
* 缓存穿透
* 缓存击穿
* 缓存雪崩
* 登录状态与 Token 黑名单
* 分布式锁基础

目标：能够正确使用缓存，而不是机械地把所有数据塞进 Redis。

⸻

第十五阶段：后端高级业务功能

学习内容：

* 文件上传与下载
* 文件类型和大小校验
* Excel 导入导出
* Apache POI 或 EasyExcel
* AOP 操作日志
* 自定义注解
* 定时任务
* 邮件通知基础
* 业务状态机
* 并发更新
* 幂等性
* 软删除
* 批量操作
* 动态查询
* 数据权限

目标：具备开发企业后台管理系统的完整能力。

⸻

第十六阶段：Swagger 与 OpenAPI

学习内容：

* OpenAPI 3
* Swagger UI
* springdoc-openapi
* 接口说明
* 参数说明
* DTO 字段说明
* 响应状态说明
* JWT Bearer 配置
* 接口分组
* API 文档维护规范

目标：能够生成可供前端和测试人员使用的接口文档。

⸻

第十七阶段：HTML、CSS 与 JavaScript

学习内容：

* HTML 常用标签
* 表单
* CSS 盒模型
* Flex
* Grid
* 响应式布局
* JavaScript 变量与函数
* 对象和数组
* 解构
* 模块化
* DOM 基础
* Promise
* async/await
* Fetch
* 事件机制
* 数组的 map、filter、reduce

目标：为 Vue 和 TypeScript 打好前端基础。

⸻

第十八阶段：TypeScript

学习内容：

* 基础类型
* 数组与对象类型
* Interface
* Type
* 联合类型
* 泛型
* 枚举
* 类型断言
* 可选字段
* 函数类型
* 工具类型
* API 响应类型
* TypeScript 模块化

目标：能够为前端数据、接口和组件提供类型约束。

⸻

第十九阶段：Vue 3

学习内容：

* Vite
* 单文件组件
* Composition API
* <script setup>
* ref
* reactive
* computed
* watch
* 生命周期
* 组件拆分
* Props
* Emits
* Slot
* 表单绑定
* 条件渲染
* 列表渲染
* 自定义组合函数

目标：能够独立编写组件化 Vue 页面。

⸻

第二十阶段：Vue 工程化

学习内容：

* Vue Router
* 路由参数
* 嵌套路由
* 路由守卫
* 动态路由
* Pinia
* Axios
* 请求与响应拦截器
* Token 自动携带
* API 模块拆分
* 环境变量
* Element Plus
* 表单校验
* 表格与分页
* 弹窗组件
* ESLint
* Prettier

目标：能够搭建标准的后台管理前端架构。

⸻

第二十一阶段：前端权限与数据可视化

学习内容：

* 登录状态管理
* 页面权限
* 按钮权限
* 动态菜单
* 401 自动跳转
* 403 页面
* Token 过期处理
* ECharts
* 折线图
* 柱状图
* 饼图
* 仪表盘
* 数据刷新
* 文件上传
* Excel 下载

目标：能够实现具备权限和数据大屏的后台管理系统。

⸻

第二十二阶段：Linux

学习内容：

* Linux 文件系统
* 常用命令
* 文件权限
* 用户与用户组
* 进程管理
* 端口查看
* 服务管理
* systemd
* 日志查看
* 环境变量
* 防火墙
* SSH
* SCP
* 软件安装
* Java、MySQL、Redis、Nginx 环境管理

目标：能够在 Linux 服务器上部署和排查应用。

⸻

第二十三阶段：Docker

学习内容：

* 镜像与容器
* Dockerfile
* 镜像构建
* 容器启动
* 端口映射
* 环境变量
* Volume
* Network
* 多阶段构建
* 容器日志
* exec
* inspect
* Healthcheck
* Java 项目容器化
* Vue 项目容器化
* MySQL 和 Redis 容器

目标：能够将前端、后端和数据库分别容器化。

⸻

第二十四阶段：Docker Compose

学习内容：

* Compose 文件结构
* Service
* Network
* Volume
* 环境变量
* 服务依赖
* Healthcheck
* 一键启动多个容器
* MySQL 初始化
* Redis 配置
* 后端连接数据库
* 前后端联合编排
* 开发与生产 Compose 区分

目标：能够一条命令启动整个系统。

⸻

第二十五阶段：Nginx 与生产部署

学习内容：

* Nginx 基础
* 静态资源部署
* 反向代理
* /api 请求转发
* Vue Router History 模式
* Gzip
* 缓存配置
* HTTPS
* 域名解析
* 阿里云 ECS
* 安全组
* 防火墙
* 日志排查
* 生产环境变量
* 数据备份

目标：能够把完整系统部署到公网访问。

⸻

第二十六阶段：CI/CD

学习内容：

* CI/CD 基础
* GitHub Actions
* Maven 自动测试
* 前端自动构建
* Docker 镜像自动构建
* 自动部署基础
* Secrets
* 构建失败通知
* 分支保护
* Pull Request 检查
* Release 与版本号

目标：实现提交代码后自动测试和构建。

⸻

第二十七阶段：项目整理与求职准备

学习内容：

* 日语 README
* 架构图
* ER 图
* API 文档
* 部署文档
* 测试报告
* 项目截图
* 演示视频
* 技术难点总结
* Git 提交记录整理
* Qiita 技术文章
* 日语项目介绍
* 面试问题准备
* 项目复盘

目标：将代码项目整理成可以用于日本求职的完整作品集。

⸻

推荐的大阶段划分

如果觉得 27 个阶段太碎，可以记成下面 8 个大阶段：

1. 基础阶段：计算机基础、Git、Java、Maven
2. 后端入门阶段：Spring、Spring Boot、MVC、REST、测试
3. 数据库阶段：SQL、MySQL、JPA、事务
4. 权限与中间件阶段：Security、JWT、RBAC、Redis
5. 后端业务阶段：日志、文件、Excel、Swagger、复杂业务
6. 前端阶段：HTML、CSS、JavaScript、TypeScript、Vue
7. 部署阶段：Linux、Docker、Compose、Nginx、云服务器
8. 求职包装阶段：CI/CD、README、Qiita、面试与演示视频
