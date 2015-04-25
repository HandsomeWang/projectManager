/*
Navicat MySQL Data Transfer

Source Server         : wang
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : projectmanager

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2015-04-18 13:42:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `disres`
-- ----------------------------
DROP TABLE IF EXISTS `disres`;
CREATE TABLE `disres` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  PRIMARY KEY (`did`),
  KEY `d_t` (`tid`),
  KEY `d_r` (`rid`),
  CONSTRAINT `d_r` FOREIGN KEY (`rid`) REFERENCES `res` (`rid`),
  CONSTRAINT `d_t` FOREIGN KEY (`tid`) REFERENCES `task` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disres
-- ----------------------------
INSERT INTO `disres` VALUES ('1', '2', '1');
INSERT INTO `disres` VALUES ('2', '3', '1');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pdate` varchar(255) NOT NULL,
  `pname` varchar(255) NOT NULL,
  `pspend` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `p_u` (`uid`),
  CONSTRAINT `p_u` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '2014年5月1日', '我的第一个项目', '9', '1');
INSERT INTO `project` VALUES ('2', '2015年4月3日', '软件设计项目', '2', '1');
INSERT INTO `project` VALUES ('3', '2015年2月1日', '测试的项目', '3', '1');

-- ----------------------------
-- Table structure for `res`
-- ----------------------------
DROP TABLE IF EXISTS `res`;
CREATE TABLE `res` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rmoney` int(11) NOT NULL,
  `rname` varchar(255) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `r_u` (`uid`),
  CONSTRAINT `r_u` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res
-- ----------------------------
INSERT INTO `res` VALUES ('2', '90', '李四', '1');
INSERT INTO `res` VALUES ('3', '80', '王五', '1');
INSERT INTO `res` VALUES ('4', '100', '赵六', '1');

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `tafter` int(11) DEFAULT NULL,
  `tday` int(11) NOT NULL,
  `tmonth` int(11) NOT NULL,
  `tname` varchar(255) NOT NULL,
  `tnumber` int(11) NOT NULL,
  `tspend` int(11) NOT NULL,
  `ttype` varchar(255) DEFAULT NULL,
  `tyear` int(11) NOT NULL,
  PRIMARY KEY (`tid`),
  KEY `t_p` (`pid`),
  CONSTRAINT `t_p` FOREIGN KEY (`pid`) REFERENCES `project` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '1', '0', '8', '1', '需求分析', '1', '1', 'null', '2015');
INSERT INTO `task` VALUES ('3', '1', '1', '9', '1', '系统设计', '2', '2', 'sf', '2015');
INSERT INTO `task` VALUES ('4', '1', '2', '11', '1', '编码实现', '3', '2', 'sf', '2015');
INSERT INTO `task` VALUES ('5', '2', '1', '4', '2', '分析设计', '0', '5', 'ff', '333');
INSERT INTO `task` VALUES ('6', '3', '1', '0', '0', '33333333', '0', '0', '33', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) NOT NULL,
  `upwd` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '1');
