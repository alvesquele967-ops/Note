-- 1. 删除有问题的表（如果存在）
DROP TABLE IF EXISTS passwordlist;

-- 2. 创建表
CREATE TABLE passwordlist (
                              id INT PRIMARY KEY AUTO_INCREMENT COMMENT '账号编号',
                              name VARCHAR(20) NOT NULL UNIQUE COMMENT '软件名称',
                              job VARCHAR(10) DEFAULT 'master' COMMENT '是否为主号',
                              username VARCHAR(50) COMMENT '账号', -- 长度建议加大
                              `password` VARCHAR(255) COMMENT '密码', -- 非常重要：密码字段应预留足够长度以存储加密后的密文
                              create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', -- 设置默认值
                              update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' -- 自动更新
) COMMENT '密码数据库';

-- 3. 插入示例数据（注意：密码字段暂时为空或测试值，后续需加密）
INSERT INTO passwordlist (name, job, username, `password`)
VALUES ('QQ', 'master', 'your_qq_number', 'encrypted_password_here'); -- 正式使用时密码必须加密

-- 4. 查询测试
SELECT * FROM passwordlist;

use cipherkeep_local ;