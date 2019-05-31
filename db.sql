DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar (32) CHARACTER SET utf8 DEFAULT NULL COMMENT '编码',
  `username` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '登录账号',
  `name` varchar(40) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '名称',
  `password` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `salt` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码盐',
  `phone_number` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号码',
  `status` char(3) CHARACTER SET utf8 DEFAULT '1' COMMENT '状态: 1-可用，0-禁用，-1-锁定',
  `sex` char(1) CHARACTER SET utf8 DEFAULT NULL COMMENT 'F-女；M-男',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
	`create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  KEY `t_user_sex` (`sex`)

) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';


delimiter ;;
drop procedure if exists idata;
create procedure idata()
begin
  declare i int;
  set i=0;
  while i<10000 do
    insert into t_user(username,name,password,status,sex,create_time,create_by)
values(substring(MD5(RAND()),1,10),concat('RAND',substring(MD5(RAND()),1,10)),123456,1,'F',CURRENT_TIME,0);
    set i=i+1;
  end while;
  while i<20000 do
    insert into t_user(username,name,password,status,sex,create_time,create_by)
values(substring(MD5(RAND()),1,10),concat('RAND',substring(MD5(RAND()),1,10)),123456,1,'M',CURRENT_TIME,0);
    set i=i+1;
  end while;
end;;
delimiter ;

call idata();

DROP TABLE IF EXISTS `t_auto_code`;
CREATE TABLE `t_auto_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `init_value` int(11) DEFAULT 1 COMMENT '初始值',
  `current_value` int(11) DEFAULT NULL COMMENT '当前值',
  `num_length` int(11) DEFAULT NULL COMMENT '长度',
  `prefix` varchar(20) DEFAULT NULL COMMENT '前缀',
  `cache_frequency` int(11) DEFAULT NULL COMMENT '更新缓存频率',
  `step` int(11) DEFAULT 1 COMMENT '步长',
  `strategy` varchar (255) DEFAULT NULL COMMENT '策略',
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_auto_code_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='code表';

insert into `t_auto_code` (code,init_value,current_value,num_length,prefix,cache_frequency,step,strategy)
value ('USER',1,1,6,'u',5,'1','PREFIX_DATE_ZERO_INCREMENT');