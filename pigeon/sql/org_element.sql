/*
 Navicat Premium Data Transfer

 Source Server         : T480
 Source Server Type    : MySQL
 Source Server Version : 50513
 Source Host           : localhost:3306
 Source Schema         : pigeon

 Target Server Type    : MySQL
 Target Server Version : 50513
 File Encoding         : 65001

 Date: 26/09/2019 18:48:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for org_element
-- ----------------------------
DROP TABLE IF EXISTS `org_element`;
CREATE TABLE `org_element`  (
  `pd_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pd_type` int(11) NULL DEFAULT 0,
  `pd_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pd_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pd_is_available` bit(1) NULL DEFAULT b'0',
  `pd_is_abandon` bit(1) NOT NULL DEFAULT b'0',
  `pd_desc` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `pd_create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pd_alter_time` datetime NULL DEFAULT NULL,
  `pd_order` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`pd_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of org_element
-- ----------------------------
INSERT INTO `org_element` VALUES ('16d6c4435a6cb49f481b8eb41c0bafdc', 0, 'hermite', '14123901000', b'0', b'0', '这是个和平boy1', NULL, NULL, NULL);
INSERT INTO `org_element` VALUES ('16d6c467854fe19dfc82fd241078ef7c', 0, 'hermite', '14123901000', b'0', b'0', '这是个和平boy1', NULL, NULL, NULL);
INSERT INTO `org_element` VALUES ('16d6c774ee3c90c9a567a4142db9cb75', 2, 'hermite', '14123901000', b'1', b'0', '这是个和平boy1', '2019-09-26 07:27:01', '2019-09-26 07:27:01', 1205);
INSERT INTO `org_element` VALUES ('16d6cb6445445b8afaeca3a49c1a08ec', 2, 'hermite', '14123901000', b'1', b'0', '这是个和平boy1', '2019-09-26 08:35:47', '2019-09-26 08:35:47', 1205);
INSERT INTO `org_element` VALUES ('16d6cdf2868ae97d94a07a34f94822da', 2, 'hermite', '14123901000', b'1', b'0', '这是个和平boy1', '2019-09-26 09:20:27', '2019-09-26 09:20:27', 1205);
INSERT INTO `org_element` VALUES ('16d6ce9947b170a88d46e9942e88dd2f', 2, 'hermite', '14123901000', b'1', b'0', '这是个和平boy1', '2019-09-26 09:31:50', '2019-09-26 09:31:50', 1205);

SET FOREIGN_KEY_CHECKS = 1;
