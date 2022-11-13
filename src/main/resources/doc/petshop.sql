/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : petshop

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 13/11/2022 16:16:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator`  (
  `operator_id` int NOT NULL,
  `operator_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `level` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bank_account` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`operator_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES (1, 'Mack', '1234', '123', '123', '123', '123');

-- ----------------------------
-- Table structure for operator_order_purchase
-- ----------------------------
DROP TABLE IF EXISTS `operator_order_purchase`;
CREATE TABLE `operator_order_purchase`  (
  `purchase_order_id` int NOT NULL,
  `pet_id` int NOT NULL,
  `pet_quantity` int NOT NULL,
  `purchase_pet_price` decimal(10, 2) NOT NULL,
  `purchase_all_price` decimal(10, 2) UNSIGNED NOT NULL,
  `purchase_time` datetime NOT NULL,
  `supplier_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `supplier_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `supplier_company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `supplier_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`purchase_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator_order_purchase
-- ----------------------------

-- ----------------------------
-- Table structure for operator_order_sales
-- ----------------------------
DROP TABLE IF EXISTS `operator_order_sales`;
CREATE TABLE `operator_order_sales`  (
  `sales_order_id` int NOT NULL,
  `sales_pet_id` int NOT NULL,
  `sales_pet_quantity` int NOT NULL,
  `sales_pet_price` decimal(10, 2) NOT NULL,
  `salse_all_price` decimal(10, 2) NOT NULL,
  `user_id` int NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_date` datetime NOT NULL,
  PRIMARY KEY (`sales_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator_order_sales
-- ----------------------------

-- ----------------------------
-- Table structure for operator_pet
-- ----------------------------
DROP TABLE IF EXISTS `operator_pet`;
CREATE TABLE `operator_pet`  (
  `pet_id` int NOT NULL,
  `pet_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `specie` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `color` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birthday` datetime NULL DEFAULT NULL,
  `age` int NOT NULL,
  `weight` double NOT NULL,
  `health` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`pet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator_pet
-- ----------------------------

-- ----------------------------
-- Table structure for supplier_order_sales
-- ----------------------------
DROP TABLE IF EXISTS `supplier_order_sales`;
CREATE TABLE `supplier_order_sales`  (
  `sales_order_id` int NOT NULL,
  `sales_pet_id` int NOT NULL,
  `sales_pet_quantity` int NOT NULL,
  `sales_pet_price` decimal(10, 2) NOT NULL,
  `petshop_id` int NOT NULL,
  `petshop_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_date` datetime NOT NULL,
  `sales_all_price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`sales_order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier_order_sales
-- ----------------------------

-- ----------------------------
-- Table structure for supplier_stock
-- ----------------------------
DROP TABLE IF EXISTS `supplier_stock`;
CREATE TABLE `supplier_stock`  (
  `stock_pet_id` int NOT NULL,
  `specie` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(10, 0) NOT NULL,
  `color` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `weight` double NOT NULL,
  `health` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birthday` datetime NOT NULL,
  `quantity` int NOT NULL,
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `purchase_date` datetime NOT NULL,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stock_pet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier_stock
-- ----------------------------

-- ----------------------------
-- Table structure for suppllier
-- ----------------------------
DROP TABLE IF EXISTS `suppllier`;
CREATE TABLE `suppllier`  (
  `supplier_id` int NOT NULL,
  `supplier_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bank_card` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suppllier
-- ----------------------------

-- ----------------------------
-- Table structure for sys_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_token`;
CREATE TABLE `sys_token`  (
  `user_id` int NOT NULL,
  `expire_time` datetime NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `userid` int NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_token
-- ----------------------------
INSERT INTO `sys_token` VALUES (1, '2022-11-12 23:32:27', '533081da5746d503f522ee0aa820897e', '2022-11-12 11:32:27', 0);
INSERT INTO `sys_token` VALUES (2, '2022-11-12 23:30:17', 'cb85edec0dc14bdc1fd066c1296a323c', '2022-11-12 11:30:17', 0);
INSERT INTO `sys_token` VALUES (3, '2020-04-21 21:49:41', '60350a6d830edbe911944d81f95c2e0b', '2020-04-21 09:49:41', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `credit_card` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `e_mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `self_introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Rose', '12344', '123', '123', '123', '123', '123', '123');

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order`  (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userID` int NOT NULL,
  `petID` int NOT NULL,
  `petPrice` decimal(10, 2) NOT NULL,
  `petQuantity` int NOT NULL,
  `userPhone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userAddress` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `orderTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `expressCarrier` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `curierNumber` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deliveryTime` datetime NOT NULL,
  `evaluation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `orderPrice` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`orderID`) USING BTREE,
  INDEX `userId`(`userID` ASC) USING BTREE,
  INDEX `petId`(`petID` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_order
-- ----------------------------

-- ----------------------------
-- Table structure for user_shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `user_shoppingcart`;
CREATE TABLE `user_shoppingcart`  (
  `user_shoppingcart_id` int NOT NULL,
  `petID` int NOT NULL,
  `petName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `specie` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `color` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birthday` datetime NOT NULL,
  `age` int NOT NULL,
  `weight` double NOT NULL,
  `health` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_shoppingcart
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
