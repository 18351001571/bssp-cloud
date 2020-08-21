DROP TABLE
IF
	EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
	`token_id` VARCHAR ( 255 ) DEFAULT NULL COMMENT '加密的access_token的值',
	`token` LONGBLOB COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
	`authentication_id` VARCHAR ( 255 ) DEFAULT NULL COMMENT '加密过的username,client_id,scope',
	`user_name` VARCHAR ( 255 ) DEFAULT NULL COMMENT '登录的用户名',
	`client_id` VARCHAR ( 255 ) DEFAULT NULL COMMENT '客户端ID',
	`authentication` LONGBLOB COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据',
	`refresh_token` VARCHAR ( 255 ) DEFAULT NULL COMMENT '加密的refresh_token的值'
) ENGINE = INNODB DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
	`userId` VARCHAR ( 255 ) DEFAULT NULL COMMENT '登录的用户名',
	`clientId` VARCHAR ( 255 ) DEFAULT NULL COMMENT '客户端ID',
	`scope` VARCHAR ( 255 ) DEFAULT NULL COMMENT '申请的权限范围',
	`status` VARCHAR ( 10 ) DEFAULT NULL COMMENT '状态（Approve或Deny）',
	`expiresAt` datetime DEFAULT NULL COMMENT '过期时间',
	`lastModifiedAt` datetime DEFAULT NULL COMMENT '最终修改时间'
) ENGINE = INNODB DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
	`client_id` VARCHAR ( 255 ) NOT NULL COMMENT '客户端ID',
	`resource_ids` VARCHAR ( 255 ) DEFAULT NULL COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
	`client_secret` VARCHAR ( 255 ) DEFAULT NULL COMMENT '客户端密匙',
	`scope` VARCHAR ( 255 ) DEFAULT NULL COMMENT '客户端申请的权限范围',
	`authorized_grant_types` VARCHAR ( 255 ) DEFAULT NULL COMMENT '客户端支持的grant_type',
	`web_server_redirect_uri` VARCHAR ( 255 ) DEFAULT NULL COMMENT '重定向URI',
	`authorities` VARCHAR ( 255 ) DEFAULT NULL COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
	`access_token_validity` INT ( 11 ) DEFAULT NULL COMMENT '访问令牌有效时间值(单位:秒)',
	`refresh_token_validity` INT ( 11 ) DEFAULT NULL COMMENT '更新令牌有效时间值(单位:秒)',
	`additional_information` VARCHAR ( 255 ) DEFAULT NULL COMMENT '预留字段',
	`autoapprove` VARCHAR ( 255 ) DEFAULT NULL COMMENT '用户是否自动Approval操作'
) ENGINE = INNODB DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
	`token_id` VARCHAR ( 255 ) DEFAULT NULL COMMENT '加密的access_token值',
	`token` LONGBLOB COMMENT 'OAuth2AccessToken.java对象序列化后的二进制数据',
	`authentication_id` VARCHAR ( 255 ) DEFAULT NULL COMMENT '加密过的username,client_id,scope',
	`user_name` VARCHAR ( 255 ) DEFAULT NULL COMMENT '登录的用户名',
	`client_id` VARCHAR ( 255 ) DEFAULT NULL COMMENT '客户端ID'
) ENGINE = INNODB DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `oauth_code`;
CREATE TABLE `oauth_code` ( `code` VARCHAR ( 255 ) DEFAULT NULL COMMENT '授权码(未加密)', `authentication` VARBINARY ( 255 ) DEFAULT NULL COMMENT 'AuthorizationRequestHolder.java对象序列化后的二进制数据' ) ENGINE = INNODB DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` ( `token_id` VARCHAR ( 255 ) DEFAULT NULL COMMENT '加密过的refresh_token的值', `token` LONGBLOB COMMENT 'OAuth2RefreshToken.java对象序列化后的二进制数据 ', `authentication` LONGBLOB COMMENT 'OAuth2Authentication.java对象序列化后的二进制数据' ) ENGINE = INNODB DEFAULT CHARSET = utf8;
DROP TABLE
IF
	EXISTS `sys_user`;
CREATE TABLE `sys_user` (
	`id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR ( 50 ) DEFAULT NULL COMMENT '用户名',
`password` VARCHAR ( 50 ) DEFAULT NULL COMMENT '密码',
PRIMARY KEY ( `id` )) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '用户信息表';

--
DROP TABLE IF EXISTS `authority`;CREATE TABLE `authority` (  `id` bigint(11) NOT NULL COMMENT '权限id',  `authority` varchar(255) DEFAULT NULL COMMENT '权限',  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `credentials`;CREATE TABLE `credentials` (  `id` bigint(11) NOT NULL COMMENT '凭证id',  `enabled` tinyint(1) NOT NULL COMMENT '是否可用',  `name` varchar(255) NOT NULL COMMENT '用户名',  `password` varchar(255) NOT NULL COMMENT '密码',  `version` int(11) DEFAULT NULL COMMENT '版本号',  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `credentials_authorities`;CREATE TABLE `credentials_authorities` (  `credentials_id` bigint(20) NOT NULL COMMENT '凭证id',  `authorities_id` bigint(20) NOT NULL COMMENT '权限id') ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
INSERT INTO authority  VALUES(1,'ROLE_OAUTH_ADMIN');
INSERT INTO authority VALUES(2,'ROLE_RESOURCE_ADMIN');
INSERT INTO authority VALUES(3,'ROLE_PROJECT_ADMIN');
INSERT INTO credentials VALUES(1,b'1','oauth_admin','$2a$10$BurTWIy5NTF9GJJH4magz.9Bd4bBurWYG8tmXxeQh1vs7r/wnCFG2','0');
INSERT INTO credentials VALUES(2,b'1','resource_admin','$2a$10$BurTWIy5NTF9GJJH4magz.9Bd4bBurWYG8tmXxeQh1vs7r/wnCFG2','0');
INSERT INTO credentials  VALUES(3,b'1','project_admin','$2a$10$BurTWIy5NTF9GJJH4magz.9Bd4bBurWYG8tmXxeQh1vs7r/wnCFG2','0');
INSERT INTO credentials_authorities VALUE (1,1);
INSERT INTO credentials_authorities VALUE (2,2);
INSERT INTO credentials_authorities VALUE (3,3);


INSERT INTO oauth_client_details VALUES('user_client','project_api', '$2a$10$BurTWIy5NTF9GJJH4magz.9Bd4bBurWYG8tmXxeQh1vs7r/wnCFG2', 'read,write', 'password,refresh_token', 'http://127.0.0.1', 'ROLE_PROJECT_ADMIN', 7200, 1800, NULL, 'true');