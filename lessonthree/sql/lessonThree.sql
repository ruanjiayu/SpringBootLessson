/**
* @Description:   系统数据表详情.建库统一描述【数据库名称： test】、【字符集： utf8mb4 -- UTF-8 Unicode】、【排序规则： utf8mb4_general_ci】
* @Author:         Xian
* @CreateDate:     2019/9/5 18:25
* @Version:        0.0.1-SHAPSHOT
*/

-- ---------------------------
-- table structure for t_user
-- ---------------------------
DROP TABLE IF EXISTS t_user;
create table t_user (
    t_id int(11) not null  AUTO_INCREMENT comment 'id',
    t_name varchar(32) not null comment '用户名',
    t_age int(4) default null comment '年龄',
    t_address varchar(256) default null comment '地址',
    primary key(t_id) using BTREE
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------
-- records of t_user
-- -----------------------

insert into t_user(t_id, t_name, t_age, t_address) values ('1', 'ruanjiayu', 24, '浙江省杭州市');
insert into t_user(t_id, t_name, t_age, t_address) values ('2', 'xufan', 23, '浙江省杭州市');
insert into t_user(t_id, t_name, t_age, t_address) values ('3', 'lifang', 23, '浙江省杭州市')