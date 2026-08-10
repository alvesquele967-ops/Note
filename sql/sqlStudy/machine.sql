CREATE DATABASE machine;
USE machine;
CREATE TABLE machine_room(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    room_name VARCHAR(100) NOT NULL ,
    location VARCHAR(100) NOT NULL,
    create_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP);
INSERT INTO machine_room(ROOM_NAME, LOCATION)
VALUES
       ('一号设备','湖南'),
       ('二号设备','北京');
SELECT * FROM machine_room;

CREATE TABLE network_device(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    device_name VARCHAR(100)NOT NULL ,
    ip_address VARCHAR(45),
    status VARCHAR(20) NOT NULL ,
    room_id BIGINT
);
INSERT INTO network_device(DEVICE_NAME, IP_ADDRESS, STATUS, ROOM_ID)
VALUES ('核心交换机设备','10.0.0.1','ONLINE','1'),
       ('核心路由器设备','10.0.0.2','ONLINE','1'),
       ('防火墙设备','10.0.0.3','OFFLINE','1'),
       ('数据库设备','10.0.1.1','ONLINE','2'),
       ('web设备','10.0.1.2','MAINTENANCE','2'),
       ('待分配设备','10.0.9.1','OFFLINE',NULL);

SELECT
    network_device.device_name,
    machine_room.room_name
FROM network_device
# 这里是高数MySQL我还要链接machine_room
INNER JOIN machine_room
#     连接条件
    ON network_device.room_id = machine_room.id;
# 实际项目一般这么写,会取一个别名，我这里稍微修改了下，可以查询更多字段
SELECT
    d.id,
    d.device_name,
    d.ip_address,
    d.status,
    r.room_name,
    r.location
FROM network_device d
         INNER JOIN machine_room r
                    ON d.room_id = r.id
# 同时也可以使用WHERE.AND这种
WHERE r.location = '北京'
AND d.status = 'ONLINE';

SELECT
    d.id,
    d.device_name
FROM network_device d
#     以左表为基础，去匹配右表
LEFT JOIN machine_room r
    ON d.room_id = r.id
WHERE r.id IS NULL;
# 连接类型	保留谁的全部数据	空值出现在哪里
# LEFT JOIN 左连接：左表所有数据一定留下，匹配不到右表 → 右表字段全为 null
# RIGHT JOIN 右连接：右表所有数据一定留下，匹配不到左表 → 左表字段全为 null
INSERT INTO machine_room(room_name,location) VALUES ('三号设备','广东');
SELECT
    d.id AS 设备id,
    d.device_name AS 设备名称,
    r.id AS 机房id,
    r.room_name AS 机房名称
FROM network_device d
         RIGHT JOIN machine_room r
                    ON d.room_id = r.id;

SELECT
    r.room_name,
    COUNT(d.id) AS device_count
FROM machine_room r
LEFT JOIN network_device d
    ON r.id = d.room_id
GROUP BY r.id,r.room_name ;
