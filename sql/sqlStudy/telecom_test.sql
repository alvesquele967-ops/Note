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
#     默认值为OFFLINE
    status VARCHAR(20) NOT NULL DEFAULT 'OFFLINE',
#     日期时间类型 自动填充当前服务器时间
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

SHOW TABLES ;
# 查看表结构
DESC device ;

INSERT INTO device(device_name, ip_address, status)
VALUES('交换机C', '192.168.1.7', 'OFFLINE');
INSERT INTO device(device_name, ip_address)
VALUES('交换机', '192.168.1.2');

# 查询 所有列 从 device中
SELECT * FROM device;

# 同样的方法可以插入多条值
INSERT INTO device(device_name, ip_address,status)
VALUES('交换机A','192.168.1.3','ONLINE'),
('交换机B','192.168.1.4','OFFLINE'),
('监控服务器','192.168.1.5','ONLINE'),
('备用路由器','192.168.1.6','OFFLINE');

# 查询所有在线设备
SELECT * FROM device WHERE status = 'ONLINE';
# 同理
SELECT * FROM device WHERE id = 1;

# 但是以上两行命令，是查询了所有列的，可以只查找指定列，（这里的device.加不加都行）例如：
SELECT device.device_name FROM device WHERE status = 'ONLINE';
# 就只会输出device_name这一列
SELECT * FROM device WHERE status <> 'ONLINE';
SELECT * FROM device WHERE status != 'ONLINE';
SELECT * FROM device WHERE id >= 3;
# 可以使用OR筛选多种条件
SELECT * FROM device WHERE status = 'ONLINE' OR ip_address = '192.168.1.2';
# AND和OR可以一起使用，比如说要查找监控服务器和核心交换机中在线的设备就可以：
SELECT * FROM device WHERE status = 'ONLINE' AND (device_name = '核心交换机' OR device_name = '监控服务器');
# 另外由于AND优先级大于OR，所以这里把OR的部分圈起来了
# 顺带一提，查询时间范围的时候更推荐直接使用AND和 <,>等接比较大小而不是BETWEEN，因为BETWEEN是固定闭区间，处理时分秒容易漏数据
SELECT * FROM device WHERE id BETWEEN 4 AND 5;
# 在查询多个指定值的时候可以使用IN，而不是一直使用OR1
SELECT * FROM device WHERE id IN (1,3,5);
SELECT * FROM device WHERE id NOT IN (1,3,5);
# 排序，默认值ASC为升序，降序是DESC
SELECT * FROM device ORDER BY id DESC ;
# 先按照status升序排序，如果有相同的，再按id降序排序
SELECT * FROM device ORDER BY status ASC , id DESC ;
# 查询前三条数据
SELECT * FROM device LIMIT 3;
# 查询最新创建的三条数据，此时可以使用创建时间进行排序，再进行查询前三条数据的指令
# 两个参数的情况下，前者是起始位置，后者是查询数量
SELECT * FROM device ORDER BY created_at DESC LIMIT 2,3;
# 比如说我想在一个页面展示新到的数据，并且每页最多展示两条，当前打开第二页，并只查看在线的指定设备，且不需要无关设备
# 小结，查询在线状态下，监控服务器，交换机及AB的设备，并按照创建时间倒序排血，跳过收条数据查询后续五条数据
SELECT *
FROM device
WHERE status = 'ONLINE' AND device_name IN ('监控服务器','交换机','交换机A','交换机B')
ORDER BY created_at DESC
LIMIT 2,2;
# SET后可以修改多个列，用逗号隔开
UPDATE device SET status = 'ONLINE' WHERE device_name = '交换机B';
UPDATE device SET status = 'OFFLINE' WHERE device_name = '交换机B';
# 养成先检查范围再执行修改最后再SELECT验证结果的习惯
SELECT * FROM device WHERE status = 'OFFLINE';
UPDATE device SET status = 'MAINTENANCE' WHERE status = 'OFFLINE';
SELECT * FROM device WHERE status = 'MAINTENANCE';
UPDATE device SET status = 'OFFLINE' WHERE status = 'MAINTENANCE';
# 若其中一个数据暂且未知，可使用NULL，不过例如这里的status是无法修改为NULL的，因为在创建表的时候就写明了NOT NULL
UPDATE device SET ip_address = NULL WHERE id = 5;
# 拼接多个文本，字符串，字段
UPDATE device SET device_name = CONCAT(device_name,'备用')WHERE id = 3;

INSERT INTO device(device_name, ip_address, status)
VALUES('交换机C', '192.168.1.7', 'OFFLINE');
# 注意，DELETE不需要写*
DELETE FROM device WHERE device_name = '交换机C';
SELECT device.device_name = '交换机C' FROM device;
# 删除所有数据，但不会删除表结构，千万不要运行这个，为了不让我自己点到运行，我特意注释了，包括一些其他危险指令
# DELETE FROM device
# 快速清空整张表，通常会重置自增编号如id，不能依靠ROLLBACK撤销，会保留表结构
# TRUNCATE TABLE device;
# 删除整张表，整个表结构等所有东西都没来
# DROP TABLE device;
# 另外顺带一提，删除后也要养成再次查询的习惯
# 事务操作：如要进行一个扣款的工作，两条分开指令的情况下：如果在运行到一方扣款程序就崩溃的时候，另一方就不会增加余额了，这是非常严重的事故
# 所以就要把两条操作视为一个整体，这个整体就叫做事务Transaction,以下是三个基本命令，分别是：
# 开始事务
START TRANSACTION ;
# 提交事务，正式保存修改
COMMIT ;
# 回滚事务，撤销未提交的修改
ROLLBACK ;

SELECT * FROM device WHERE id = 1;
START TRANSACTION ;
UPDATE device SET status = 'MAINTENANCE' WHERE id = 1;
SELECT * FROM device WHERE id = 1;
# 此时还没正式提交，可以回滚
ROLLBACK ;
SELECT * FROM device WHERE id = 1;
# 正式提交之后，即使回滚也不会撤销指令了
UPDATE device SET status = 'MAINTENANCE' WHERE id = 1;
COMMIT ;
# 此指令就没用了
ROLLBACK ;
SELECT * FROM device WHERE id = 1;
# 整个 START TRANSACTION 到 COMMIT 就是一个完整的流程，其中可以包含多条修改操作，也就是我上面说的做完一个整体
START TRANSACTION ;
UPDATE device SET status = 'MAINTENANCE'WHERE id = 1;
# 中途如果发生问题可以使用ROLLBACK
UPDATE device SET status = 'ONLINE' WHERE id = 2;
COMMIT ;
# 默认MySQL是自动提交的，使用以下指令查看状态，如果返回1即自动提交已经开启了
SELECT  @@autocommit;
# 这里的SET后面可以省略两个艾特符号
SET @@autocommit = 1;
#另外事务需要使用支持事务的存储引擎，MySQL现在常用的InnoDB支持事务，可以用以下指令查看表使用的引擎
SHOW TABLE STATUS WHERE Name = 'device';
# 当一个事务执行了很多操作，只想撤销其中一部分的时候，可以设置保存点，这就叫做回滚点
START TRANSACTION ;
UPDATE device SET status = 'ONLINE' WHERE id = 1;
# 相当于设定了一个复活点
SAVEPOINT after_first_update;
UPDATE device SET status = 'OFFLINE' WHERE id = 2;
# 这样回滚到回滚点之后，第一条修改会保留，第二条修改撤销
ROLLBACK TO after_first_update;
COMMIT ;
# 小结
# 事务的ACID特性：
# 原子性：事务中的操作不可再分割，例如转账不能只扣钱不加钱
# 一致性：事务执行前后，数据库必须保持合理状态
# 隔离性：多个事务同时执行，尽量避免相互干扰
# 持久性：事务一旦提交成功，修改应当被永久保存，即使服务器重启，已提交的数据也不应当会消失
# 之后执行重要的UPDATE和DELETE操作时，应当按照下面的流程
# 先查询->开启事务->执行修改->检查结果->决定提交或者撤销