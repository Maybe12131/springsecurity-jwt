/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 47.99.210.46:3306
 Source Schema         : security

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 04/09/2020 16:41:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for se_authority
-- ----------------------------
DROP TABLE IF EXISTS `se_authority`;
CREATE TABLE `se_authority`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of se_authority
-- ----------------------------
INSERT INTO `se_authority` VALUES ('1658de6cee614f488f2117e9acb375c2', 'bee93170375a4731a089e0033cb4feb0', 'my/**');
INSERT INTO `se_authority` VALUES ('17ec15e1f3a04561b0728f8fa62d8092', 'bee93170375a4731a089e0033cb4feb0', 'api');
INSERT INTO `se_authority` VALUES ('17ec15e1f3a04561b0728f8fa62d8093', 'bee93170375a4731a089e0033cb4feb0', 'ROLE_USER');

-- ----------------------------
-- Table structure for se_user
-- ----------------------------
DROP TABLE IF EXISTS `se_user`;
CREATE TABLE `se_user`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of se_user
-- ----------------------------
INSERT INTO `se_user` VALUES ('bee93170375a4731a089e0033cb4feb0', 'root', '123456789');

SET FOREIGN_KEY_CHECKS = 1;
