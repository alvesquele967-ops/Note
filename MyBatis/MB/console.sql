use machine;

INSERT INTO company (company_name, contact_person, address) VALUES
                                                                ('星辰网络科技有限公司', '张经理', '长沙市岳麓区麓谷产业园A栋'),
                                                                ('锐捷系统集成公司', '李总', '娄底市娄星区创业大厦8层'),
                                                                ('云海通信技术有限公司', '王主管', '武汉市东湖高新区软件园'),
                                                                ('恒信安防设备公司', '刘负责人', '广州市天河区智慧产业园');

-- 用户数据
INSERT INTO tb_user(username,password,birthday) VALUES
                                                    ('zhangsan','123456','2000‑01‑10'),
                                                    ('lisi','654321','1999‑05‑22'),
                                                    ('wangwu','789000','2001‑08‑15');

-- 订单数据 user_id关联上面用户id
INSERT INTO tb_order(order_time,total,user_id) VALUES
                                                  ('2026-08-01 10:20:30', 299.50, 1),
                                                  ('2026-08-03 14:10:10', 88.00, 1),
                                                  ('2026-08-05 09:05:22', 1250.00, 2),
                                                  ('2026-08-07 16:40:00', 368.75, 3);
