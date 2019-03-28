DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3799 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';