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

 Date: 20/11/2022 15:06:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int NOT NULL,
  `href_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int NOT NULL,
  `count` int NULL DEFAULT NULL,
  `good_id` int NULL DEFAULT NULL,
  `is_effective` bit(1) NOT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '狗类', 'https://s1.ax1x.com/2022/11/15/zEbSzj.jpg');
INSERT INTO `category` VALUES (2, '猫类', 'https://s1.ax1x.com/2022/11/20/zMZQxK.jpg');
INSERT INTO `category` VALUES (3, '小动物', 'https://s1.ax1x.com/2022/11/20/zMZm5R.jpg');
INSERT INTO `category` VALUES (4, '宠物食品', 'https://s1.ax1x.com/2022/11/20/zMZcIs.jpg');

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `id` int NOT NULL,
  `category_id` int NOT NULL,
  `_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `discount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (1, 1, '1', '哈士奇', '5', 'https://s1.ax1x.com/2022/11/15/zEbSzj.jpg', '199', '0.8');
INSERT INTO `good` VALUES (2, 2, '1', '金渐层', '5', 'https://s1.ax1x.com/2022/11/20/zMV2jO.jpg', '999', '0.95');
INSERT INTO `good` VALUES (3, 1, '1', '泰迪', '10', 'https://s1.ax1x.com/2022/11/20/zMVjbQ.jpg', '599', '0.88');
INSERT INTO `good` VALUES (4, 1, '1', '拉布拉多', '8', 'https://s1.ax1x.com/2022/11/20/zMZC80.jpg', '799', '0.99');
INSERT INTO `good` VALUES (5, 3, '1', '垂耳兔', '22', 'https://s1.ax1x.com/2022/11/20/zMZm5R.jpg', '199', '0.75');
INSERT INTO `good` VALUES (6, 2, '1', '纯种蓝白英短', '5', 'https://s1.ax1x.com/2022/11/20/zMZQxK.jpg', '668', '0.88');
INSERT INTO `good` VALUES (7, 2, '1', '金吉拉纯种幼猫', '4', 'https://s1.ax1x.com/2022/11/20/zMZ8qe.jpg', '388', '0.85');
INSERT INTO `good` VALUES (8, 4, '1', '泰迪小型犬狗舍', '18', 'https://s1.ax1x.com/2022/11/20/zMZcIs.jpg', '155', '0.99');

-- ----------------------------
-- Table structure for good_picture
-- ----------------------------
DROP TABLE IF EXISTS `good_picture`;
CREATE TABLE `good_picture`  (
  `id` int NOT NULL,
  `good_id` int NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good_picture
-- ----------------------------
INSERT INTO `good_picture` VALUES (1, 1, 'https://s1.ax1x.com/2022/11/15/zEbSzj.jpg');
INSERT INTO `good_picture` VALUES (2, 2, 'https://s1.ax1x.com/2022/11/20/zMV2jO.jpg');
INSERT INTO `good_picture` VALUES (3, 3, 'https://s1.ax1x.com/2022/11/20/zMVjbQ.jpg');
INSERT INTO `good_picture` VALUES (4, 4, 'https://s1.ax1x.com/2022/11/20/zMZC80.jpg');
INSERT INTO `good_picture` VALUES (5, 5, 'https://s1.ax1x.com/2022/11/20/zMZm5R.jpg');
INSERT INTO `good_picture` VALUES (6, 6, 'https://s1.ax1x.com/2022/11/20/zMZQxK.jpg');
INSERT INTO `good_picture` VALUES (7, 7, 'https://s1.ax1x.com/2022/11/20/zMZ8qe.jpg');
INSERT INTO `good_picture` VALUES (8, 8, 'https://s1.ax1x.com/2022/11/20/zMZcIs.jpg');

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator`  (
  `operator_id` int NOT NULL AUTO_INCREMENT,
  `operator_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bank_account` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`operator_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES (1, 'Wendy', 'Wendy', '123', '769-2191-5449', 'Sk7EeeCaq4', NULL);
INSERT INTO `operator` VALUES (2, 'Jeremy', 'Jeremy', '123', '197-4863-4026', '5jgnQ65Ozs', NULL);

-- ----------------------------
-- Table structure for operator_pet
-- ----------------------------
DROP TABLE IF EXISTS `operator_pet`;
CREATE TABLE `operator_pet`  (
  `pet_id` int NOT NULL AUTO_INCREMENT,
  `age` int NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `health` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pet_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `specie` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `weight` double NULL DEFAULT NULL,
  PRIMARY KEY (`pet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator_pet
-- ----------------------------

-- ----------------------------
-- Table structure for operator_pet_order_sales
-- ----------------------------
DROP TABLE IF EXISTS `operator_pet_order_sales`;
CREATE TABLE `operator_pet_order_sales`  (
  `sales_order_id` int NOT NULL AUTO_INCREMENT,
  `sales_pet_id` int NOT NULL,
  `sales_pet_quantity` int NOT NULL,
  `sales_pet_price` decimal(10, 2) NOT NULL,
  `user_id` int NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_date` datetime NOT NULL,
  `sales_all_price` double NOT NULL,
  `is_confirm` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_order_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`sales_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator_pet_order_sales
-- ----------------------------

-- ----------------------------
-- Table structure for operator_products_order_sales
-- ----------------------------
DROP TABLE IF EXISTS `operator_products_order_sales`;
CREATE TABLE `operator_products_order_sales`  (
  `sales_order_id` int NOT NULL AUTO_INCREMENT,
  `sales_products_id` int NOT NULL,
  `sales_products_quantity` int NOT NULL,
  `sales_products_price` decimal(10, 2) NOT NULL,
  `user_id` int NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_date` datetime NOT NULL,
  `sales_all_price` double NULL DEFAULT NULL,
  `is_confirm` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_order_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`sales_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operator_products_order_sales
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bank_card` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, 'Rhonda', 'Rhonda', '123', '186-9149-1558', '346511105970783');
INSERT INTO `supplier` VALUES (2, 'Jason', 'Jason', '123', '760-866-9462', '5105992536246896');
INSERT INTO `supplier` VALUES (3, 'Jklolin', 'Jklolin', '123', 'sodifj', 'osdijfo;a');

-- ----------------------------
-- Table structure for supplier_pet_order_sales
-- ----------------------------
DROP TABLE IF EXISTS `supplier_pet_order_sales`;
CREATE TABLE `supplier_pet_order_sales`  (
  `sales_order_id` int NOT NULL AUTO_INCREMENT,
  `sales_pet_id` int NOT NULL,
  `sales_pet_quantity` int NOT NULL,
  `sales_pet_price` decimal(10, 2) NOT NULL,
  `petshop_id` int NOT NULL,
  `petshop_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` int NULL DEFAULT NULL,
  `user_order_id` int NULL DEFAULT NULL,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_date` datetime NOT NULL,
  `sales_all_price` decimal(10, 2) NOT NULL,
  `is_delivery` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sales_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier_pet_order_sales
-- ----------------------------

-- ----------------------------
-- Table structure for supplier_pet_stock
-- ----------------------------
DROP TABLE IF EXISTS `supplier_pet_stock`;
CREATE TABLE `supplier_pet_stock`  (
  `stock_pet_id` int NOT NULL AUTO_INCREMENT,
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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier_pet_stock
-- ----------------------------
INSERT INTO `supplier_pet_stock` VALUES (1, '1', 111, 'black', 2, 2, '1', '2022-11-20 14:53:47', 44, '武汉宠物中心', '2022-11-11 14:54:01', NULL);
INSERT INTO `supplier_pet_stock` VALUES (2, '2', 200, 'yellow', 1, 1, '1', '2022-11-30 14:56:22', 50, '武汉宠物中心', '2022-11-18 14:56:30', '1');
INSERT INTO `supplier_pet_stock` VALUES (3, '2', 300, 'brown', 3, 3, '1', '2022-11-20 14:56:39', 50, '武汉宠物中心', '2022-11-20 14:56:43', '3');
INSERT INTO `supplier_pet_stock` VALUES (4, '1', 300, 'white', 4, 3, '1', '2022-11-20 14:56:53', 50, '武汉宠物中心', '2022-11-16 14:56:57', '4');
INSERT INTO `supplier_pet_stock` VALUES (5, '3', 50, 'brown', 5, 5, '1', '2022-11-25 14:57:14', 50, '武汉宠物中心', '2022-11-23 14:57:19', '5');
INSERT INTO `supplier_pet_stock` VALUES (6, '2', 100, 'blue', 6, 5, '1', '2022-11-11 14:57:29', 50, '武汉宠物中心', '2022-11-03 14:57:35', '6');
INSERT INTO `supplier_pet_stock` VALUES (7, '2', 66, 'white', 4, 3, '1', '2022-11-20 14:57:44', 50, '武汉宠物中心', '2022-11-18 14:57:51', NULL);

-- ----------------------------
-- Table structure for supplier_products_order_sales
-- ----------------------------
DROP TABLE IF EXISTS `supplier_products_order_sales`;
CREATE TABLE `supplier_products_order_sales`  (
  `sales_order_id` int NOT NULL AUTO_INCREMENT,
  `sales_products_id` int NOT NULL,
  `sales_products_quantity` int NOT NULL,
  `sales_products_price` decimal(10, 2) NOT NULL,
  `petshop_id` int NOT NULL,
  `petshop_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `petshop_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_order_id` int NULL DEFAULT NULL,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_address` varchar(90) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_date` datetime NOT NULL,
  `sales_all_price` decimal(10, 2) NOT NULL,
  `is_delivery` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`sales_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier_products_order_sales
-- ----------------------------

-- ----------------------------
-- Table structure for supplier_products_stock
-- ----------------------------
DROP TABLE IF EXISTS `supplier_products_stock`;
CREATE TABLE `supplier_products_stock`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `stock_product_id` int NOT NULL,
  `specie` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(10, 0) NOT NULL,
  `color` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `weight` double NOT NULL,
  `quantity` int NOT NULL,
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `purchase_date` datetime NOT NULL,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier_products_stock
-- ----------------------------
INSERT INTO `supplier_products_stock` VALUES (6, 1, 'dog', 50, 'Salmon', 9.36, 14, 'Roberts\'s Inc.', '2021-03-05 22:40:39', '3Oj86qMznx');
INSERT INTO `supplier_products_stock` VALUES (7, 2, 'dog', 80, 'Lime', 6.64, 34, 'Christopher Technology Inc.', '2021-05-07 00:57:28', 'DFx8ZsTfq9');
INSERT INTO `supplier_products_stock` VALUES (8, 3, 'cat', 90, 'Beige', 10.95, 72, 'Payne Brothers Logistic LLC', '2020-08-03 08:23:16', 'SanN3e6xDB');
INSERT INTO `supplier_products_stock` VALUES (9, 4, 'cat', 170, 'Light Gray', 5.99, 89, 'Chris Food LLC', '2019-11-08 15:36:01', 'MsogvL00c1');
INSERT INTO `supplier_products_stock` VALUES (10, 5, 'snake', 173, 'Orange Red', 9.77, 95, 'Holmes Inc.', '2022-07-26 10:28:12', 'RuOOTrEjhj');

-- ----------------------------
-- Table structure for sys_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_token`;
CREATE TABLE `sys_token`  (
  `user_id` int NOT NULL,
  `expire_time` datetime NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_token
-- ----------------------------
INSERT INTO `sys_token` VALUES (1, '2022-11-19 21:32:01', 'e9b9241b20d9d84748a7d41910bbb9eb', '2022-11-19 09:32:01');
INSERT INTO `sys_token` VALUES (2, '2022-11-11 14:48:48', 's48j45srtg83fretet4tjcxjjok6', '2022-11-20 14:49:20');
INSERT INTO `sys_token` VALUES (3, '2022-11-26 14:49:33', 'ssssgg5se5gg5231a1i96chxfg5', '2022-11-18 14:49:45');
INSERT INTO `sys_token` VALUES (4, '2022-11-19 14:50:01', '245ywrhik90pf63gs2tts2', '2022-11-20 14:50:24');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `credit_card` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `e_mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `self_introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Rose', 'Rose', '123', '172-9196-9899', '377972196636695', 'fisherj@yahoo.com', '755 1st Ave', 'GpyeAMyupL');
INSERT INTO `user` VALUES (2, 'Jack', 'Jack', '123', '28-133-0036', '342421778316419', 'waynesoto@outlook.com', '550 Collier Road', 'aO0kjpTihg');
INSERT INTO `user` VALUES (3, 'Mack', 'Mack', '123', '138-3857-8477', '4753202220147535', 'gordonde@hotmail.com', '327 Alameda Street', 'j6itnh7iti');
INSERT INTO `user` VALUES (4, 'Peter', 'Peter', '123', '130-5173-7716', '6224738512182306', 'patrickwoods50@icloud.com', '527 Fifth Avenue', 'CL4hW885Ww');

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order`  (
  `user_order_id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `order_state` int NULL DEFAULT NULL,
  `pay_money` double NULL DEFAULT NULL,
  `post_fee` double NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`user_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_order
-- ----------------------------

-- ----------------------------
-- Table structure for user_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `user_order_goods`;
CREATE TABLE `user_order_goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `count` int NULL DEFAULT NULL,
  `good_id` int NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_order_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_order_goods
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
