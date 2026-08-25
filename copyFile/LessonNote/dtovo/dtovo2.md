明白。你现在的项目结构已经调整成：

```
chiku.liu.equipmentmanagement

├── common
│
├── controller
│
├── dto
│
├── entity
│
├── exception
│
├── mapper
│
├── service
│   ├── impl
│   │   └── DeviceServiceImpl.java
│   │
│   └── DeviceService.java
│
├── vo
│
└── EquipmentManagementApplication.java
```

后续课程我全部按照这个结构讲，不再用之前的抽象目录。毕竟目录结构这种东西如果一直变，学习体验会像追一部换编剧的电视剧，人还没学会角色名字，角色已经全换了。😅

------

# 第二阶段：MySQL + MyBatis 企业项目搭建

## 当前目标

我们先完成一个完整设备查询功能：

请求：

```
GET /device/list
```

返回：

```
[
    {
        "id":1,
        "deviceName":"核心交换机",
        "ipAddress":"10.0.0.1",
        "status":"ONLINE"
    }
]
```

完整流程：

```
Controller
    ↓
Service
    ↓
Mapper
    ↓
MySQL
```

------

# 一、创建数据库

## 1. 创建数据库

MySQL执行：

```
CREATE DATABASE equipment_management
DEFAULT CHARACTER SET utf8mb4;
```

创建完成：

```
equipment_management
```

进入：

```
USE equipment_management;
```

------

# 二、创建数据表

位置：

数据库：

```
equipment_management
```

创建：

```
network_device
```

SQL：

```
CREATE TABLE network_device(

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    device_name VARCHAR(100) NOT NULL,

    ip_address VARCHAR(50),

    status VARCHAR(20),

    create_time DATETIME DEFAULT CURRENT_TIMESTAMP

);
```

------

## 对应Java结构

数据库：

```
network_device
```

对应：

```
entity

└── NetworkDevice.java
```

------

字段对应：

| 数据库      | Java                     |
| ----------- | ------------------------ |
| id          | Long id                  |
| device_name | String deviceName        |
| ip_address  | String ipAddress         |
| status      | String status            |
| create_time | LocalDateTime createTime |

------

# 三、插入测试数据

执行：

```
INSERT INTO network_device
(device_name, ip_address, status)
VALUES
('核心交换机','10.0.0.1','ONLINE');


INSERT INTO network_device
(device_name, ip_address, status)
VALUES
('防火墙','10.0.0.2','ONLINE');
```

检查：

```
SELECT * FROM network_device;
```

应该：

```
1  核心交换机  10.0.0.1  ONLINE

2  防火墙      10.0.0.2  ONLINE
```

------

# 四、配置 application.yml

位置：

你的：

```
src/main/resources/application.yml
```

现在：

```
server:
  port: 8080


spring:

  datasource:

    driver-class-name: com.mysql.cj.jdbc.Driver

    url: jdbc:mysql://localhost:3306/equipment_management?serverTimezone=Asia/Shanghai&characterEncoding=UTF-8

    username: root

    password: 你的密码


mybatis:

  mapper-locations: classpath:mapper/*.xml

  type-aliases-package: chiku.liu.equipmentmanagement.entity
```

------

这里注意：

你的包名现在不是：

```
com.ryuto
```

而是：

```
chiku.liu
```

所以：

之前：

```
com.ryuto.equipmentmanagement.entity
```

必须改成：

你的：

```
chiku.liu.equipmentmanagement.entity
```

否则 MyBatis 找不到实体。

------

# 五、创建 entity 层

目录：

你的：

```
entity
```

里面创建：

```
NetworkDevice.java
```

------

代码：

```
package chiku.liu.equipmentmanagement.entity;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class NetworkDevice {


    private Long id;


    private String deviceName;


    private String ipAddress;


    private String status;


    private LocalDateTime createTime;

}
```

------

## 为什么放 entity？

因为：

entity = 数据库实体。

数据库：

```
network_device
```

Java：

```
NetworkDevice
```

它们是一一对应。

------

# 六、创建 mapper 层

目录：

你的：

```
mapper
```

创建：

```
NetworkDeviceMapper.java
```

------

代码：

```
package chiku.liu.equipmentmanagement.mapper;


import chiku.liu.equipmentmanagement.entity.NetworkDevice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface NetworkDeviceMapper {


    List<NetworkDevice> selectAll();


}
```

------

解释：

## @Mapper

告诉Spring：

> 这个接口交给MyBatis管理。

否则：

Spring启动：

```
我不知道这个接口是什么
```

------

## selectAll()

对应SQL：

```
SELECT * FROM network_device
```

------

# 七、创建 Mapper XML

注意：

这个不是java目录。

位置：

```
src/main/resources

└── mapper

    └── NetworkDeviceMapper.xml
```

如果没有mapper文件夹：

自己创建。

------

代码：

```
<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">


<mapper namespace="chiku.liu.equipmentmanagement.mapper.NetworkDeviceMapper">


    <select id="selectAll"
            resultType="chiku.liu.equipmentmanagement.entity.NetworkDevice">


        SELECT

            id,
            device_name,
            ip_address,
            status,
            create_time

        FROM network_device


    </select>


</mapper>
```

------

重点：

这里：

```
namespace
```

必须：

等于Mapper接口完整路径：

```
chiku.liu.equipmentmanagement.mapper.NetworkDeviceMapper
```

------

# 八、创建 service 层

你的结构：

```
service

├── DeviceService.java

└── impl

    └── DeviceServiceImpl.java
```

------

## 1. Service接口

文件：

```
service/DeviceService.java
```

代码：

```
package chiku.liu.equipmentmanagement.service;


import chiku.liu.equipmentmanagement.entity.NetworkDevice;

import java.util.List;


public interface DeviceService {


    List<NetworkDevice> list();


}
```

------

作用：

定义业务。

例如：

以后：

```
查询设备
新增设备
删除设备
修改设备
```

全部写这里。

------

## 2. Service实现

文件：

```
service/impl/DeviceServiceImpl.java
```

代码：

```
package chiku.liu.equipmentmanagement.service.impl;


import chiku.liu.equipmentmanagement.entity.NetworkDevice;
import chiku.liu.equipmentmanagement.mapper.NetworkDeviceMapper;
import chiku.liu.equipmentmanagement.service.DeviceService;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceServiceImpl implements DeviceService {


    private final NetworkDeviceMapper mapper;


    public DeviceServiceImpl(NetworkDeviceMapper mapper){

        this.mapper = mapper;

    }


    @Override
    public List<NetworkDevice> list(){

        return mapper.selectAll();

    }

}
```

------

这里：

```
@Service
```

表示：

注册到Spring容器。

------

这里：

```
private final NetworkDeviceMapper mapper;
```

表示：

Service需要Mapper查询数据库。

------

# 九、创建 controller 层

目录：

```
controller
```

创建：

```
NetworkDeviceController.java
```

------

代码：

```
package chiku.liu.equipmentmanagement.controller;


import chiku.liu.equipmentmanagement.entity.NetworkDevice;
import chiku.liu.equipmentmanagement.service.DeviceService;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/device")
public class NetworkDeviceController {


    private final DeviceService service;


    public NetworkDeviceController(DeviceService service){

        this.service = service;

    }


    @GetMapping("/list")
    public List<NetworkDevice> list(){

        return service.list();

    }

}
```

------

# 十、启动测试

启动：

```
EquipmentManagementApplication
```

访问：

```
http://localhost:8080/device/list
```

成功结果：

```
[
  {
    "id":1,
    "deviceName":"核心交换机",
    "ipAddress":"10.0.0.1",
    "status":"ONLINE",
    "createTime":"2026-08-25T..."
  }
]
```

------

# 完成后的项目结构

最终：

```
chiku.liu.equipmentmanagement

├── common
│
├── controller
│   └── NetworkDeviceController.java
│
├── dto
│
├── entity
│   └── NetworkDevice.java
│
├── exception
│
├── mapper
│   └── NetworkDeviceMapper.java
│
├── service
│   ├── DeviceService.java
│   │
│   └── impl
│       └── DeviceServiceImpl.java
│
├── vo
│
└── EquipmentManagementApplication.java
```

------

完成这一节后，你的项目就真正拥有：

✅ Spring Boot
✅ MyBatis
✅ MySQL
✅ 三层架构
✅ 企业项目目录结构  

下一节开始进入你原计划里的：

# 第三阶段：DTO / VO / Request / Response 企业化改造

也就是把现在：

```
Controller
 ↓
Entity
```

改成：

```
Controller
 ↓
VO

Service

 ↓

Entity
```

正式进入企业代码风格。