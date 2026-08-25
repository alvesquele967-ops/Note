收到。我们重新开一个**企业级 Spring Boot 项目**，不在你之前的 CRUD Demo 上修修补补。

之前那个项目主要目的是让你理解：

> Spring Boot 能启动 → Controller → Service → Mapper → MySQL 能跑通

现在进入**求职作品级项目开发阶段**。

这一次我会按照你要求的方式：

- 每一步做什么
- 文件创建在哪里
- 写什么代码
- 每一行什么意思
- 为什么这样设计
- 和前面知识有什么联系
- 怎么运行验证
- 下一步做什么

不会突然蹦出一堆“高级架构魔法”。毕竟很多教程喜欢第一天就上微服务、DDD、消息队列，仿佛新人刚学会走路就应该驾驶宇宙飞船，人类教育方式有时候确实很有创造力。🌌

------

# 项目目标

我们创建：

## 设备管理后台系统

日：

> 設備管理（せつびかんり）システム

英文：

> Equipment Management System

最终功能：

### 用户端

- 用户注册
- 用户登录
- JWT认证
- 权限控制

### 设备管理

- 查询设备
- 添加设备
- 修改设备
- 删除设备
- 分页
- 条件搜索

### 系统功能

- 参数校验
- 全局异常处理
- 日志
- Redis缓存
- 文件上传
- API文档
- 测试

最后部署：

```
Spring Boot
      |
      |
MySQL
      |
Redis
      |
Docker
      |
AWS
```

这就是日本自社开发公司新卒作品比较像样的方向。

------

# 第一阶段：创建项目

## Step 1：打开 IDEA

选择：

```
New Project
```

不要选普通 Java。

选择：

```
Spring Initializr
```

------

# Step 2：填写项目信息

配置：

## Name

填写：

```
equipment-management
```

意思：

设备管理。

------

## Language

选择：

```
Java
```

------

## Type

选择：

```
Maven
```

原因：

你已经学过 Maven。

------

## Group

填写：

```
com.ryuto
```

解释：

Group 是项目组织名称。

一般：

公司：

```
com.google
com.alibaba
```

个人：

```
com.xxx
```

------

## Artifact

填写：

```
equipment-management
```

最终：

```
com.ryuto.equipment-management
```

------

## Package name

自动生成：

```
com.ryuto.equipmentmanagement
```

注意：

Java包名不能有：

```
-
```

所以：

equipment-management

变：

equipmentmanagement

------

## JDK

选择：

```
21
```

因为你现在环境：

JDK 21

------

## Spring Boot版本

选择：

```
3.2.x
```

不要追最新版。

企业项目稳定优先。

------

# Step 3：选择依赖

现在先不要贪。

添加：

------

## Spring Web

名称：

```
Spring Web
```

作用：

创建 Controller。

对应：

HTTP接口。

例如：

```
GET /device
POST /device
```

------

## MyBatis Framework

名称：

```
MyBatis Framework
```

作用：

连接数据库。

你已经学过。

------

## MySQL Driver

名称：

```
MySQL Driver
```

作用：

Java连接MySQL。

------

## Lombok

名称：

```
Lombok
```

作用：

减少实体类模板代码。

例如：

没有：

```
public String getName(){

}
```

有：

```
@Data
```

自动生成。

------

## Validation

名称：

```
Validation
```

作用：

参数校验。

以后：

```
@NotBlank
private String username;
```

------

## Spring Boot DevTools

作用：

开发自动重启。

------

现在依赖：

应该是：

```
Spring Web

MyBatis Framework

MySQL Driver

Lombok

Validation

DevTools
```

------

# Step 4：创建

点击：

```
Create
```

等待 Maven 下载。

------

# 创建完成后的目录

应该：

```
equipment-management

├── src
│
├── pom.xml
│
└── mvnw
```

进入：

```
src/main/java
```

应该：

```
com.ryuto.equipmentmanagement

└── EquipmentManagementApplication.java
```

------

# Step 5：第一次启动

打开：

```
package com.ryuto.equipmentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EquipmentManagementApplication {


    public static void main(String[] args) {

        SpringApplication.run(
            EquipmentManagementApplication.class,
            args
        );

    }

}
```

点击绿色运行。

------

正常：

控制台：

看到：

```
Tomcat started on port 8080
```

说明：

Spring Boot启动成功。

------

# 现在解释这个启动类

## @SpringBootApplication

三个东西组合：

实际上：

```
@SpringBootConfiguration

@EnableAutoConfiguration

@ComponentScan
```

------

## ComponentScan

扫描：

```
com.ryuto.equipmentmanagement
```

下面所有：

```
@Controller
@Service
@Mapper
@Component
```

------

所以以后你的目录：

必须：

```
com.ryuto.equipmentmanagement

├── controller

├── service

├── mapper

├── entity

└── vo
```

不要乱放。

否则 Spring 找不到。

------

# Step 6：创建基础目录

现在创建：

```
com.ryuto.equipmentmanagement


├── controller
│
├── service
│   ├── DeviceService.java
│   └── impl
│       └── DeviceServiceImpl.java
│
├── mapper
│
├── entity
│
├── dto
│
├── vo
│
├── common
│
└── exception
```

解释：

## entity

数据库对象。

例如：

```
NetworkDevice
```

------

## dto

接收数据。

例如：

```
DeviceCreateRequest
```

------

## vo

返回数据。

例如：

```
DeviceVO
```

------

## common

公共代码。

例如：

统一返回：

```
Result
```

------

## exception

异常处理。

例如：

```
BusinessException
```

------

# 今天先做到这里

你的检查清单：

- 

  创建 Spring Boot 项目

- 

  JDK21

- 

  Maven

- 

  添加依赖

- 

  成功启动

- 

  创建项目包结构

下一步正式开始：

# 第二步：配置 MySQL + MyBatis + application.yml

会创建：

```
database
    |
entity
    |
mapper
    |
service
    |
controller
```

然后我们把之前学过的 MyBatis 基础，升级成企业项目结构。

这一步会真正开始搭你的求职作品。