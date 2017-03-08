/*
Navicat MySQL Data Transfer

Source Server         : ding
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : vuelogin

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2017-03-08 15:33:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(50) NOT NULL,
  `idCard` varchar(18) DEFAULT NULL,
  `password` varchar(18) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('002', 'zhang', '123456', '4421.5');
INSERT INTO `t_user` VALUES ('003', 'tao', '123456', '999999900');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('zhang', '123456');
INSERT INTO `user` VALUES ('tao', '123456');
INSERT INTO `user` VALUES ('ke', '123456');
INSERT INTO `user` VALUES ('wang', '123456');
SET FOREIGN_KEY_CHECKS=1;
