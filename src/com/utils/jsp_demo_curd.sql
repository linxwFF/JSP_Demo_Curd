/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50711
Source Host           : 127.0.0.1:3306
Source Database       : jsp_demo_curd

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-11-22 22:48:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ts` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `date_of_manufacture` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `shelf_life` int(11) DEFAULT NULL,
  `vendor` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '10001', '眼镜', '一副100°', '10', '2017-11-22 14:53:26', '0', '宝岛眼镜', '台湾宝岛眼镜');
INSERT INTO `products` VALUES ('26', '10002', '商品名称', '型号规格', '100', '2017-11-22 22:03:30', '18', '生产厂家', '供货商');
INSERT INTO `products` VALUES ('20', '10002', '商品名称', '型号规格', '100', '2017-11-22 18:55:32', '18', '生产厂家', '供货商');
INSERT INTO `products` VALUES ('23', '222222', '商品名称2343', '型号规格', '100', '2017-11-22 22:03:37', '18', '生产厂家', '供货商');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1', 'admin', 'admin', 'admin', '1', '874226876@qq.com', '13774545206');
INSERT INTO `users` VALUES ('2', '1', 'admin', 'admin124', 'admin', '1', '874226876@qq.com', '13774545206');
INSERT INTO `users` VALUES ('3', '1', 'admin', 'admin22', 'admin', '1', '874226876@qq.com', '13774545206');
INSERT INTO `users` VALUES ('4', '1', 'admin', 'admin12314', 'admin', '1', '874226876@qq.com', '13774545206');
