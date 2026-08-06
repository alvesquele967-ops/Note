-- DDL


mysql -u root -p ;


-- 查询所有数据库
show databases ;

-- 创建数据库
create database logpw;

-- 删除数据库
drop database db02;

-- 使用数据库
use logpw;

-- 创建表
create table userlist(
    userid int primary key auto_increment comment '用户ID 唯一标识',
    username varchar(20) not null unique comment '用户名称',
    userage int comment  '用户年龄',
    usergender char(1) default '男' comment '用户性别',
    userjob varchar(10) default 'user' comment  '用户权利',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
                      -- 这里不要用逗号结尾
)comment  '用户列表'



-- 删除表
drop table if exists userlist;

-- 查看数据库下的表
show tables;

-- 查询指定表结构
desc userlist;

-- 查询建表语句
show create table userlist;

-- 添加字段
alter table userlist add usersqltset varchar(10) comment '测试用字段';

-- 修改字段类型
alter table userlist modify usersqltset varchar(20);

-- 修改字段名
alter table userlist change usersqltset usersqltest2 varchar(10);
alter table userlist change usersqltest2 usersqltest varchar(20);

-- 删除字段
alter table userlist drop column usersqltest;

-- 修改表名
rename table userlist to userlist2;
rename table userlist2 to userlist;

-- DML

-- 在指定字段中插入数据
insert into userlist(username,userjob,create_time,update_time) values ('chikuA','master',now(),now());

-- 为所有字段插入值
insert into userlist(userid, username, userage,usergender,userjob,create_time,update_time)
values (null,'chikuC',19,'男','master',now(),now());

-- 在字段中批量插入指
insert into userlist(username,userjob,create_time,update_time)
values ('chikuA','master',now(),now()),('chikuB','master',now(),now());

-- 修改数据
update userlist set userjob = 'user',username = 'tseruser',update_time = now() where userid = 1;

-- 修改所有数据
update userlist set update_time = now();

-- 删除指定数据
delete from userlist where userid = 1;

-- 删除所有数据
delete from userlist;

-- DQL

-- 查询指定多个字段
select userid,username,userjob from userlist;

-- 查询所有字段
select userid, username, userage, usergender, userjob, create_time, update_time from userlist;
    -- 在输入完select之后直接输入from表格在到前面输入某一个字段通过联想功能一次性全部补全
select  * from userlist;
    -- 简单，但是不直观、性能低

-- 查询并在返回结果中更改别名
select userid,username as '名 字',userjob 权限 from userlist;

-- 去除重复值查询
select distinct userjob from userlist;

-- 更多条件查询
select * from userlist where userjob = 'master';
select * from userlist where userid >= 1;
    -- 根据值具体范围查询
select * from userlist where userage is null;
select * from userlist where userjob is not null;
    -- 通过数据是否为空为条件查询
select * from userlist where username != 'chikuA';
select * from userlist where username <> 'chikuB';
    -- 查询不是指定值的其他数据
select * from userlist where update_time >= '2023-01-01' and update_time <= '2026-01-01';
select * from userlist where update_time between '2023-01-01' and '2026-01-01';
    -- 根据范围查询(and可以叠加)
select * from userlist where userjob = 'master' or username = 'chikuA';
select * from userlist where username in ('chikuA','chikuB');
    -- 查询满足多个条件中满足其中某些条件的数据
select * from userlist where username like '______';
    -- 根据字符数进行模糊查询，查询目标为多少个字符就输入多少个下划线
select * from userlist where username like 'chiku%';
    -- 根据指定字符进行查询，查询满足匹配百分号%之前的字符的所有数据

-- 聚合函数
select count(userid) from userlist;
    -- 统计数量，不对null值进行运算
select count(1) from userlist;
select count(*) from userlist;
    -- 任意不为null常量
select min(update_time) from userlist;
    -- 查找最小指
select max(update_time) from userlist;
    -- 查找最大值
select avg(userid) from userlist;
    -- 统计平均值
select sum(userid) from userlist;
    -- 计算总和

-- 分组查询
select usergender,count(*) from userlist group by usergender;
    -- 分组查询数量
select userjob,count(*) from userlist where update_time <= '2025-01-01' group by userjob;
    -- 根据值的范围分组查询
select userjob,count(*) from userlist where update_time <= '2025-01-01' group by userjob having count(*) >= 2;
    -- 分组后过滤条件

-- 排序查询
select * from userlist order by update_time;
select * from userlist order by update_time asc;
select * from userlist order by update_time desc;
    -- 默认ASC升序，DESC降序
select * from userlist order by  update_time asc , create_time desc ;
    -- 当第一个字段相同的时候，第二个排序字段才会生效

-- 分页查询
select * from userlist limit 0,1;
    -- 从索引0开始，每页展示一条数据
select * from userlist limit 2,2;
    -- 从第三项(第二页)开始，展示两条数据
    -- 起始索引 = （页码-1）*每页展示记录数
select * from userlist limit 2;
    -- 查询第一页的数据，每页展示两条记录

select *
from userlist
where username like 'chi%'
  and usergender = '男'
  and update_time between '2023-01-01' and '2025-01-01'
order by create_time desc
limit 5;
    -- Ctrl+Alt+L可快速将长句格式化，没变就是热键冲突

select if(update_time >= '2024-11-19' and update_time <= '2025-01-01', 'True', 'False') 判断结果, count(*)
from userlist
group by update_time;
    -- 根据条件判断语句分组查询，如此处为在这个时间区间的则输出True，否则输出False。并在此基础上进行分组计数
select case userjob when 'master' then '管理员' when 'user' then '普通用户' else '未知权限' end, count(*)
from userlist
group by userjob;
    -- 同样是条件判断，结尾处要加end，否则会报错
select (case userjob when 'master' then '管理员' when 'user' then '普通用户' else '未知权限' end) 权限判断, count(*)
from userlist
group by userjob;
    -- 括起来在外面起别名