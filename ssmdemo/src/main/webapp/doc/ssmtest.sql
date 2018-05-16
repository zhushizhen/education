/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : ssmtest

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-16 17:25:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_authority
-- ----------------------------
DROP TABLE IF EXISTS `tb_authority`;
CREATE TABLE `tb_authority` (
  `id` int(20) NOT NULL,
  `authorityname` varchar(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_authority
-- ----------------------------
INSERT INTO `tb_authority` VALUES ('1', '个人信息', null);
INSERT INTO `tb_authority` VALUES ('2', '主任信息', null);
INSERT INTO `tb_authority` VALUES ('3', '教师信息', null);
INSERT INTO `tb_authority` VALUES ('4', '学生信息', null);

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `id` int(5) NOT NULL,
  `coursename` varchar(50) DEFAULT NULL,
  `courseinfo` varchar(2000) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES ('1', 'java', 'Java 是由Sun Microsystems公司于1995年5月推出的高级程序设计语言。\r\n\r\nJava可运行于多个平台，如Windows, Mac OS，及其他多种UNIX版本的系统。', null);
INSERT INTO `tb_course` VALUES ('2', 'php', 'PHP 是一种创建动态交互性站点的强有力的服务器端脚本语言。\r\n\r\nPHP 是免费的，并且使用非常广泛。同时，对于像微软 ASP 这样的竞争者来说，PHP 无疑是另一种高效率的选项', null);
INSERT INTO `tb_course` VALUES ('3', 'android', 'Android是一个开源的，基于Linux的移动设备操作系统，主要使用于移动设备，如智能手机和平板电脑。Android是由谷歌及其他公司带领的开放手机联盟开发的。', null);
INSERT INTO `tb_course` VALUES ('4', 'ios', 'iOS是由苹果公司开发的移动操作系统 [1]  。苹果公司最早于2007年1月9日的Macworld大会上公布这个系统，最初是设计给iPhone使用的，后来陆续套用到iPod touch、iPad以及Apple TV等产品上。iOS与苹果的Mac OS X操作系统一样，属于类Unix的商业操作系统。原本这个系统名为iPhone OS，因为iPad，iPhone，iPod touch都使用iPhone OS，所以2010WWDC大会上宣布改名为iOS', null);
INSERT INTO `tb_course` VALUES ('5', 'c++', 'C++ 是一种中级语言，它是由 Bjarne Stroustrup 于 1979 年在贝尔实验室开始设计开发的。C++ 进一步扩充和完善了 C 语言，是一种面向对象的程序设计语言。C++ 可运行于多种平台上，如 Windows、MAC 操作系统以及 UNIX 的各种版本。', null);
INSERT INTO `tb_course` VALUES ('6', 'python', 'Python具有丰富和强大的库。它常被昵称为胶水语言，能够把用其他语言制作的各种模块（尤其是C/C++）很轻松地联结在一起。常见的一种应用情形是，使用Python快速生成程序的原型（有时甚至是程序的最终界面），然后对其中有特别要求的部分，用更合适的语言改写，比如3D游戏中的图形渲染模块，性能要求特别高，就可以用C/C++重写，而后封装为Python可以调用的扩展类库。需要注意的是在您使用扩展类库时可能需要考虑平台问题，某些可能不提供跨平台的实现', null);

-- ----------------------------
-- Table structure for tb_register
-- ----------------------------
DROP TABLE IF EXISTS `tb_register`;
CREATE TABLE `tb_register` (
  `id` varchar(64) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `roleid` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_register
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(20) NOT NULL,
  `rolename` varchar(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '主任', null);
INSERT INTO `tb_role` VALUES ('2', '教师', null);
INSERT INTO `tb_role` VALUES ('3', '学生', null);

-- ----------------------------
-- Table structure for tb_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_auth`;
CREATE TABLE `tb_role_auth` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `roleid` int(20) DEFAULT NULL,
  `authid` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role_auth
-- ----------------------------
INSERT INTO `tb_role_auth` VALUES ('1', '1', '1');
INSERT INTO `tb_role_auth` VALUES ('2', '1', '2');
INSERT INTO `tb_role_auth` VALUES ('3', '1', '3');
INSERT INTO `tb_role_auth` VALUES ('4', '1', '4');
INSERT INTO `tb_role_auth` VALUES ('5', '2', '1');
INSERT INTO `tb_role_auth` VALUES ('6', '2', '3');
INSERT INTO `tb_role_auth` VALUES ('7', '2', '4');
INSERT INTO `tb_role_auth` VALUES ('8', '3', '1');
INSERT INTO `tb_role_auth` VALUES ('9', '3', '4');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` varchar(64) NOT NULL,
  `restuid` varchar(64) DEFAULT NULL,
  `workid` varchar(64) DEFAULT NULL,
  `money` varchar(20) DEFAULT NULL,
  `courseid` int(5) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `retid` varchar(64) DEFAULT NULL,
  `opinion` varchar(255) DEFAULT NULL COMMENT '对老师的意见',
  `teaassess` varchar(255) DEFAULT NULL COMMENT '老师对学生的评价',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_student
-- ----------------------------

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `id` varchar(64) NOT NULL,
  `reatid` varchar(64) DEFAULT NULL,
  `workid` int(3) DEFAULT NULL,
  `opinion` varchar(255) DEFAULT NULL COMMENT '学生反馈',
  `managerassess` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(64) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `parentname` varchar(50) DEFAULT NULL,
  `relation` varchar(20) DEFAULT NULL,
  `parenttel` varchar(20) DEFAULT NULL,
  `regid` varchar(64) DEFAULT NULL,
  `selfintroduce` varchar(2000) DEFAULT NULL,
  `courseid` int(5) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL COMMENT '在校状态',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------

-- ----------------------------
-- Table structure for tb_work
-- ----------------------------
DROP TABLE IF EXISTS `tb_work`;
CREATE TABLE `tb_work` (
  `id` int(5) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_work
-- ----------------------------
INSERT INTO `tb_work` VALUES ('1', '正常', null);
INSERT INTO `tb_work` VALUES ('2', '迟到', null);
INSERT INTO `tb_work` VALUES ('3', '请假', null);
INSERT INTO `tb_work` VALUES ('4', '旷课', null);

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO `user_t` VALUES ('1', '测试', 'sfasgfaf', '24');
