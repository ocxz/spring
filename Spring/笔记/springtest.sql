/*
Navicat MySQL Data Transfer

Source Server         : spring
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : springtest

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-12-09 10:06:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bookinfo`
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('100', '西游记', '吴承恩', '153.6', '100', '20');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` varchar(255) NOT NULL,
  `departmentName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'p-001', '.NET实习一组');
INSERT INTO `department` VALUES ('4', 'p-002', '.NET开发二组');
INSERT INTO `department` VALUES ('5', 'p-003', 'JAVA开发一组');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) NOT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `did` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('27', 'u-931', '张媛媛123', '1998-04-21', 'zhang@qq.com', '1', 'p-001');
INSERT INTO `employee` VALUES ('28', 'u-767', '啦啦啦5656', '1998-04-21', 'zhang@qq.com', '0', 'p-001');
INSERT INTO `employee` VALUES ('29', 'u-014', '啦啦啦5656', '1998-04-21', 'zhang@qq.com', '1', 'p-001');
