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
VALUES('交换机', '192.168.1.1', 'ONLINE');
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
UPDATE device SET device_name = '交换机B' WHERE id = 5;
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