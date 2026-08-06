select 1+1;

show databases ;

CREATE DATABASE telecom_ops;

USE telecom_ops;

CREATE TABLE device (
#     超长整数 主键约束 自增
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
#     可变长度字符串 非空约束
    device_name VARCHAR(100) NOT NULL ,
#     唯一约束
    ip_address VARCHAR(45) UNIQUE,
#     默认值为OFFILINE
    status VARCHAR(20) NOT NULL DEFAULT 'OFFLINE',
#     日期时间类型 自动填充当前服务器时间
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

SHOW TABLES ;
DESC device ;

INSERT INTO device(device_name, ip_address, status)
VALUES('交换机', '192.168.1.1', 'ONLINE');
INSERT INTO device(device_name, ip_address)
VALUES('交换机', '192.168.1.2');

# 查询 所有列 从 device中
SELECT * FROM device;