/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : pk

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2015-05-28 13:15:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for maillist
-- ----------------------------
DROP TABLE IF EXISTS `maillist`;
CREATE TABLE `maillist` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maillist
-- ----------------------------
INSERT INTO `maillist` VALUES ('2', 'Jim', '18463100356', 'Jim@hotmail.com');
INSERT INTO `maillist` VALUES ('3', 'Allen', '18463101255', 'Allen@126.com');
