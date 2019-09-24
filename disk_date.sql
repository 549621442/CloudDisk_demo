/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : disk_date

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-06-19 09:16:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminID` char(20) NOT NULL,
  `adminPWD` char(20) NOT NULL,
  `adminName` char(20) NOT NULL,
  `adminPM` char(4) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `download`
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download` (
  `downloadID` char(20) NOT NULL,
  `downloadFile` char(20) DEFAULT NULL,
  `downloadUser` int(20) DEFAULT NULL,
  `downloadNum` char(20) DEFAULT NULL,
  `downloadDate` char(20) DEFAULT NULL,
  PRIMARY KEY (`downloadID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of download
-- ----------------------------

-- ----------------------------
-- Table structure for `filemsg`
-- ----------------------------
DROP TABLE IF EXISTS `filemsg`;
CREATE TABLE `filemsg` (
  `fileID` char(20) NOT NULL,
  `fileName` char(20) NOT NULL,
  `fileURL` char(30) NOT NULL,
  `fileType` char(5) NOT NULL,
  PRIMARY KEY (`fileID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filemsg
-- ----------------------------

-- ----------------------------
-- Table structure for `upload`
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `uploadID` char(20) NOT NULL,
  `uploadDate` char(20) NOT NULL,
  `uploadUser` char(20) NOT NULL,
  `uploadFile` char(20) NOT NULL,
  PRIMARY KEY (`uploadID`),
  KEY `1` (`uploadUser`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` char(20) NOT NULL,
  `userName` char(20) NOT NULL,
  `userPM` char(4) NOT NULL,
  `userPWD` char(20) NOT NULL,
  `userPhone` char(20) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
