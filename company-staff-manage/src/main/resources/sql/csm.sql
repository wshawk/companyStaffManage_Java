/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : csm

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 21/07/2021 09:01:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- csm.`staff` definition

CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自动生成',
  `staff_no` bigint(20) DEFAULT NULL COMMENT '员工账号',
  `name` bigint(20) DEFAULT NULL COMMENT '姓名',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别，0-男，1-女',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `role_id` tinyint(4) DEFAULT '1' COMMENT '0-管理员，1-普通用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` varchar(64) DEFAULT NULL COMMENT '修改人',
  `state` tinyint(4) NOT NULL COMMENT '用户状态（0：正常，1：已锁定，2：已禁用）',
  `enabled_flag` tinyint(4) DEFAULT NULL COMMENT '0：有效，1：无效',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
