/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : gc

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-04-09 15:13:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commoditylist
-- ----------------------------
DROP TABLE IF EXISTS `commoditylist`;
CREATE TABLE `commoditylist` (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `commodity` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `orderItemListId` varchar(36) CHARACTER SET utf8 NOT NULL,
  `gPrice` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of commoditylist
-- ----------------------------
INSERT INTO `commoditylist` VALUES ('0bcdcd27-b2c7-42f9-8d83-70100d8aa3a8', '铁', '2', '3942b371-c665-466f-93b7-7fc149c683b9', '12');
INSERT INTO `commoditylist` VALUES ('0f43ad5b-9fcb-4f32-9fd1-e09fbda99b83', '塑料餐具', '4', '0744e4dd-3b5b-4a8e-8d4b-52d64ef4f2ef', '3');
INSERT INTO `commoditylist` VALUES ('1a7338d1-5b8c-4248-90e4-fe6e857a751c', '玻璃瓶', '3', '874b1a35-77e4-4cd6-9cae-7ea57cda0453', '3');
INSERT INTO `commoditylist` VALUES ('21153a5f-8d3c-4479-85a0-d10ae317735f', '纸', '2', '401457df-b44a-4761-aeea-c315c8fe3c48', '10');
INSERT INTO `commoditylist` VALUES ('27c7a8bb-d8bd-4298-9a6e-e7498d1f5036', '塑料瓶', '2', 'f1c07230-c124-4a39-8353-075470ad667b', '2');
INSERT INTO `commoditylist` VALUES ('2ee50b76-c7c7-45bf-b081-129aefbe32de', '电瓶车', '-1', '8e207183-f1cd-4dbe-91c1-74627d5793f8', '3');
INSERT INTO `commoditylist` VALUES ('43f76064-8417-48ea-9149-b7e20e55b1d4', '玻璃瓶', '3', '05072bab-7a4e-4c64-8826-42b878dd2c3c', '3');
INSERT INTO `commoditylist` VALUES ('442ab190-e56e-42ea-aaa2-f8e521e3ab86', '泡沫', '2', '29e1651e-f26c-43d1-9051-9ebabc2a3c7f', '2');
INSERT INTO `commoditylist` VALUES ('4716c1fe-b03a-4551-ac91-d240bd50d317', '纸', '1', '3942b371-c665-466f-93b7-7fc149c683b9', '10');
INSERT INTO `commoditylist` VALUES ('4d05be28-9c9e-49ed-841f-851b24ecd554', '铁', '4', 'c7865252-5867-4ed2-9f7b-d9c5094a3ff6', '12');
INSERT INTO `commoditylist` VALUES ('597cb07a-b70d-4942-8793-a2f004d848bf', '玻璃瓶', '-5', '29e1651e-f26c-43d1-9051-9ebabc2a3c7f', '3');
INSERT INTO `commoditylist` VALUES ('61c918cf-27ee-49db-8924-eea53748597a', '纸', '3', 'c7865252-5867-4ed2-9f7b-d9c5094a3ff6', '10');
INSERT INTO `commoditylist` VALUES ('65ca3b45-cd08-4578-8f8e-8b2232197089', '泡沫', '2', '874b1a35-77e4-4cd6-9cae-7ea57cda0453', '2');
INSERT INTO `commoditylist` VALUES ('70c8965a-3d39-4439-9106-62d495a039d5', '纸', '-3', '4735ca06-1106-4108-a46d-a7f95b9bc524', '10');
INSERT INTO `commoditylist` VALUES ('7f32cf7e-e080-4c90-8710-b472b226391e', '废旧钢铁', '2', '05072bab-7a4e-4c64-8826-42b878dd2c3c', '2');
INSERT INTO `commoditylist` VALUES ('7f9cc33f-73cb-415f-ace9-4938f3020757', '废旧钢铁', '2', '2b8b53e7-a65b-41f8-9555-25631e292c28', '2');
INSERT INTO `commoditylist` VALUES ('8a1e5041-d851-4d5f-ad4e-37e9595eb7a6', '纸', '3', 'ff52697b-9916-46de-a270-4802d6b5ab96', '10');
INSERT INTO `commoditylist` VALUES ('92e7a9fe-d9df-4291-8850-8687fcb566ec', '电池', '2', '82db3fc2-3372-4887-a6a8-7fa843557f15', '0');
INSERT INTO `commoditylist` VALUES ('98697dfa-59f9-4c99-9c98-755c23b2db03', '纸', '3', '3b9c0754-3838-4ae7-9e47-dfe7134a370d', '10');
INSERT INTO `commoditylist` VALUES ('99c8197e-275b-48de-a122-7b57ca0feec9', '铜', '3', '3942b371-c665-466f-93b7-7fc149c683b9', '58');
INSERT INTO `commoditylist` VALUES ('9f06a02e-ac76-4053-979b-05ea62f31f05', '铁', '5', '401457df-b44a-4761-aeea-c315c8fe3c48', '12');
INSERT INTO `commoditylist` VALUES ('a70147c4-75a7-4872-ada2-f3fbe3143644', '塑料餐具', '3', 'f1c07230-c124-4a39-8353-075470ad667b', '3');
INSERT INTO `commoditylist` VALUES ('b70da264-dedd-4da1-9aab-a1a594c7cb9b', '铁', '2', '701f5f12-e788-4249-8565-b08f13099479', '12');
INSERT INTO `commoditylist` VALUES ('c5830acd-d6f7-4101-a973-f2a5506703d5', '电瓶车', '5', '701f5f12-e788-4249-8565-b08f13099479', '3');
INSERT INTO `commoditylist` VALUES ('cab8dd7e-4cc2-4491-8c78-8bcc5ec1687c', '废旧钢铁', '2', '0744e4dd-3b5b-4a8e-8d4b-52d64ef4f2ef', '2');
INSERT INTO `commoditylist` VALUES ('cfdbdfd9-240b-453c-adf3-2668035b767d', '玻璃瓶', '-3', '2b8b53e7-a65b-41f8-9555-25631e292c28', '3');
INSERT INTO `commoditylist` VALUES ('d1f682b8-1c78-4bc7-86e3-0d26016eeabe', '手机', '2', '3b9c0754-3838-4ae7-9e47-dfe7134a370d', '1');
INSERT INTO `commoditylist` VALUES ('d618c0b9-1475-4afa-8601-4b1ec98d9680', '塑料餐具', '1', 'f0b5fb99-59e5-4e44-97dc-fc68f2e75055', '3');
INSERT INTO `commoditylist` VALUES ('e24cc948-2bee-4c12-912f-436124597d95', '泡沫', '-2', '4dccf382-e910-4625-96e7-198112610054', '2');
INSERT INTO `commoditylist` VALUES ('e41073d3-d37b-4c10-bed8-1a5dd1ddcd9e', '泡沫', '2', '8c7dff70-2ff3-4608-bc8f-d12a338c6f52', '2');
INSERT INTO `commoditylist` VALUES ('e904e607-472f-4eed-8328-3c27e4cd1d0f', '手机', '2', 'ff52697b-9916-46de-a270-4802d6b5ab96', '1');
INSERT INTO `commoditylist` VALUES ('f0181904-26f4-4204-bde2-c06bd2e40f3c', '玻璃瓶', '3', '8c7dff70-2ff3-4608-bc8f-d12a338c6f52', '3');
INSERT INTO `commoditylist` VALUES ('f78cda12-3f27-41f1-864e-10ba39308069', '铜', '3', '701f5f12-e788-4249-8565-b08f13099479', '58');

-- ----------------------------
-- Table structure for garbage
-- ----------------------------
DROP TABLE IF EXISTS `garbage`;
CREATE TABLE `garbage` (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gName` varchar(30) DEFAULT NULL,
  `gType` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `gPrice` float DEFAULT NULL,
  `gDesc` tinytext,
  `isCycle` bit(1) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of garbage
-- ----------------------------
INSERT INTO `garbage` VALUES ('1', '塑料瓶', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/plastic.jpg');
INSERT INTO `garbage` VALUES ('10', '塑料餐具', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/plastic2.jpg');
INSERT INTO `garbage` VALUES ('11', '泡沫', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/foam.jpg');
INSERT INTO `garbage` VALUES ('12', '玻璃瓶', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/glass.jpg');
INSERT INTO `garbage` VALUES ('13', '废旧钢铁', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/iron.jpg');
INSERT INTO `garbage` VALUES ('14', '不锈钢物品', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('15', '水壶', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('16', '金属刀具', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('17', '金属元件', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('18', '废旧电线', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('19', '铁钉', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('2', '食品罐头', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('20', '金属衣架', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('21', '废衣服', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('22', '废布料', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('23', '废毛巾', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('24', '毛绒玩具', '可回收物', '1', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('25', '废旧电器', '可回收物', '1', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('26', '菜叶', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/vegetable.jpg');
INSERT INTO `garbage` VALUES ('27', '橙皮', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/orange.jpg');
INSERT INTO `garbage` VALUES ('28', '葱', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/scallion.jpg');
INSERT INTO `garbage` VALUES ('29', '饼干', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/cookies.jpg');
INSERT INTO `garbage` VALUES ('3', '玻璃瓶', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('30', '番茄酱', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/tomato.jpg');
INSERT INTO `garbage` VALUES ('31', '蛋壳', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('32', '西瓜皮', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('33', '马铃薯', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('34', '鱼骨', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('35', '甘蔗', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('36', '玉米', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('37', '骨头', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('38', '虾壳', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('39', '蛋糕', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('4', '易拉罐', '可回收物', '4', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('40', '面包', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('41', '草莓', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('42', '西红柿', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('43', '梨', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('44', '果皮', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('45', '树叶', '湿垃圾', '0', '湿垃圾需要放到湿垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('46', '盆子', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/pot.jpg');
INSERT INTO `garbage` VALUES ('47', '贝壳', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/shell.jpg');
INSERT INTO `garbage` VALUES ('48', '化妆梳', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/comb.jpg');
INSERT INTO `garbage` VALUES ('49', '坛子', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/bombonne.jpg');
INSERT INTO `garbage` VALUES ('5', '废报纸', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('50', '海绵', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/sponge.jpg');
INSERT INTO `garbage` VALUES ('51', '卫生纸', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('52', '陶瓷', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('53', '筷子', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('54', '花盆', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('55', '烟蒂', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('56', '湿垃圾袋', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('57', '脏污衣服', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('58', '扫把', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('59', '瓦片', '干垃圾', '0', '干垃圾需要放到干垃圾桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('6', '旧书本', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('60', '电池', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/battery.jpg');
INSERT INTO `garbage` VALUES ('61', '油漆', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/youqi.jpg');
INSERT INTO `garbage` VALUES ('62', '过期的胶囊药物', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/capsule.jpg');
INSERT INTO `garbage` VALUES ('63', '温度计', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/thermometer.jpg');
INSERT INTO `garbage` VALUES ('64', '过期药片', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/medicine.jpg');
INSERT INTO `garbage` VALUES ('65', '荧光灯', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('66', '蓄电池', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('67', '杀虫剂', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('68', '农药瓶', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('69', '废弃灯泡', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('7', '纸箱', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('70', '荧光棒', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('71', '纽扣电池', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('72', '废弃水银', '有害垃圾', '0', '有害垃圾在丢弃时一定要注意扔到有害垃圾回收桶中', '\0', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('8', '图书', '可回收物', '3', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');
INSERT INTO `garbage` VALUES ('9', '奶瓶', '可回收物', '2', '具有回收价值', '', 'http://127.0.0.1:9090/noPicture.jpg');

-- ----------------------------
-- Table structure for gcsystemrouter
-- ----------------------------
DROP TABLE IF EXISTS `gcsystemrouter`;
CREATE TABLE `gcsystemrouter` (
  `gcPermission` int(1) NOT NULL,
  `gcRouter` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`gcPermission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gcsystemrouter
-- ----------------------------
INSERT INTO `gcsystemrouter` VALUES ('0', '[{\"path\":\"/\",\"redirect\":\"/login\",\"hidden\":true},{\"path\":\"/login\",\"component\":\"Login\",\"hidden\":true},{\"path\":\"/register\",\"component\":\"Register\",\"hidden\":true},{\"path\":\"/home\",\"name\":\"\",\"component\":\"Home\",\"hidden\":true},{\"path\":\"/home\",\"name\":\"垃圾展示\",\"component\":\"Home\",\"iconCls\":\"el-icon-s-grid\",\"children\":[{\"path\":\"/wet\",\"name\":\"湿垃圾\",\"component\":\"Wet\",\"meta\":{\"keepAlive\":true}},{\"path\":\"/dry\",\"name\":\"干垃圾\",\"component\":\"Dry\",\"meta\":{\"keepAlive\":false}},{\"path\":\"/harmful\",\"name\":\"有害垃圾\",\"component\":\"Harmful\",\"meta\":{\"keepAlive\":false}},{\"path\":\"/recycle\",\"name\":\"可回收垃圾\",\"component\":\"Recycle\",\"meta\":{\"keepAlive\":false}}]},{\"path\":\"/home\",\"name\":\"用户功能\",\"component\":\"Home\",\"iconCls\":\"el-icon-menu\",\"children\":[{\"path\":\"/search\",\"name\":\"垃圾搜索\",\"component\":\"Search\"},{\"path\":\"/Cart\",\"name\":\"回收车\",\"component\":\"Cart\"},{\"path\":\"/watchOrder\",\"name\":\"订单查看\",\"component\":\"WatchOrder\"},{\"path\":\"/map\",\"name\":\"地图\",\"component\":\"MapGeo\"},{\"path\":\"/mapSearch\",\"name\":\"回收点搜索\",\"component\":\"MapSearch\"},{\"path\":\"/imageIdentify\",\"name\":\"图片识别\",\"component\":\"ImageIdentify\"},{\"path\":\"/chat\",\"name\":\"聊天\",\"component\":\"Chat\"}]},{\"path\":\"/userPage\",\"name\":\"用户主页\",\"component\":\"UserPage\",\"hidden\":true}]');
INSERT INTO `gcsystemrouter` VALUES ('1', '[{\"path\":\"/\",\"redirect\":\"/login\",\"hidden\":true},{\"path\":\"/login\",\"component\":\"Login\",\"hidden\":true},{\"path\":\"/register\",\"component\":\"Register\",\"hidden\":true},{\"path\":\"/home\",\"name\":\"\",\"component\":\"Home\",\"hidden\":true},{\"path\":\"/home\",\"name\":\"垃圾展示\",\"component\":\"Home\",\"iconCls\":\"el-icon-s-grid\",\"children\":[{\"path\":\"/wet\",\"name\":\"湿垃圾\",\"component\":\"Wet\",\"meta\":{\"keepAlive\":true}},{\"path\":\"/dry\",\"name\":\"干垃圾\",\"component\":\"Dry\",\"meta\":{\"keepAlive\":false}},{\"path\":\"/harmful\",\"name\":\"有害垃圾\",\"component\":\"Harmful\",\"meta\":{\"keepAlive\":false}},{\"path\":\"/recycle\",\"name\":\"可回收垃圾\",\"component\":\"Recycle\",\"meta\":{\"keepAlive\":false}}]},{\"path\":\"/home\",\"name\":\"用户功能\",\"component\":\"Home\",\"iconCls\":\"el-icon-menu\",\"children\":[{\"path\":\"/search\",\"name\":\"垃圾搜索\",\"component\":\"Search\"},{\"path\":\"/Cart\",\"name\":\"回收车\",\"component\":\"Cart\"},{\"path\":\"/watchOrder\",\"name\":\"订单查看\",\"component\":\"WatchOrder\"},{\"path\":\"/map\",\"name\":\"地图\",\"component\":\"MapGeo\"},{\"path\":\"/mapSearch\",\"name\":\"回收点搜索\",\"component\":\"MapSearch\"},{\"path\":\"/imageIdentify\",\"name\":\"图片识别\",\"component\":\"ImageIdentify\"},{\"path\":\"/chat\",\"name\":\"聊天\",\"component\":\"Chat\"}]},{\"path\":\"/home\",\"name\":\"管理员功能\",\"component\":\"Home\",\"iconCls\":\"el-icon-s-order\",\"children\":[{\"path\":\"/userManage\",\"name\":\"用户管理\",\"component\":\"UserManage\"},{\"path\":\"/addGarbage\",\"name\":\"添加垃圾\",\"component\":\"AddGarbage\"},{\"path\":\"/alter\",\"name\":\"回收价格修改\",\"component\":\"AlterPrice\"},{\"path\":\"/manage\",\"name\":\"管理订单\",\"component\":\"Manage\"},{\"path\":\"/uploadImage\",\"name\":\"上传图片\",\"component\":\"UploadImage\"}]},{\"path\":\"/home\",\"name\":\"回收人员功能\",\"component\":\"Home\",\"iconCls\":\"el-icon-s-data\",\"children\":[{\"path\":\"/browseOrder\",\"name\":\"接收订单\",\"component\":\"BrowseOrder\"},{\"path\":\"/manageOrder\",\"name\":\"订单查看\",\"component\":\"ManageOrder\"}]},{\"path\":\"/userPage\",\"name\":\"用户主页\",\"component\":\"UserPage\",\"hidden\":true}]');
INSERT INTO `gcsystemrouter` VALUES ('2', '[{\"path\":\"/\",\"redirect\":\"/login\",\"hidden\":true},{\"path\":\"/login\",\"component\":\"Login\",\"hidden\":true},{\"path\":\"/register\",\"component\":\"Register\",\"hidden\":true},{\"path\":\"/home\",\"name\":\"\",\"component\":\"Home\",\"hidden\":true},{\"path\":\"/home\",\"name\":\"垃圾展示\",\"component\":\"Home\",\"iconCls\":\"el-icon-s-grid\",\"children\":[{\"path\":\"/wet\",\"name\":\"湿垃圾\",\"component\":\"Wet\",\"meta\":{\"keepAlive\":true}},{\"path\":\"/dry\",\"name\":\"干垃圾\",\"component\":\"Dry\",\"meta\":{\"keepAlive\":false}},{\"path\":\"/harmful\",\"name\":\"有害垃圾\",\"component\":\"Harmful\",\"meta\":{\"keepAlive\":false}},{\"path\":\"/recycle\",\"name\":\"可回收垃圾\",\"component\":\"Recycle\",\"meta\":{\"keepAlive\":false}}]},{\"path\":\"/home\",\"name\":\"用户功能\",\"component\":\"Home\",\"iconCls\":\"el-icon-menu\",\"children\":[{\"path\":\"/search\",\"name\":\"垃圾搜索\",\"component\":\"Search\"},{\"path\":\"/map\",\"name\":\"地图\",\"component\":\"MapGeo\"},{\"path\":\"/mapSearch\",\"name\":\"回收点搜索\",\"component\":\"MapSearch\"},{\"path\":\"/imageIdentify\",\"name\":\"图片识别\",\"component\":\"ImageIdentify\"},{\"path\":\"/chat\",\"name\":\"聊天\",\"component\":\"Chat\"}]},{\"path\":\"/home\",\"name\":\"回收人员功能\",\"component\":\"Home\",\"iconCls\":\"el-icon-s-data\",\"children\":[{\"path\":\"/browseOrder\",\"name\":\"接收订单\",\"component\":\"BrowseOrder\"},{\"path\":\"/manageOrder\",\"name\":\"订单查看\",\"component\":\"ManageOrder\"}]},{\"path\":\"/userPage\",\"name\":\"用户主页\",\"component\":\"UserPage\",\"hidden\":true}]');

-- ----------------------------
-- Table structure for orderlist
-- ----------------------------
DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE `orderlist` (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `payment` float DEFAULT NULL,
  `address` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `creationTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `endTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `userid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cycleid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `orderStatus` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user-order` (`userid`) USING BTREE,
  KEY `cycle-order` (`cycleid`) USING BTREE,
  KEY `orderItemList` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of orderlist
-- ----------------------------
INSERT INTO `orderlist` VALUES ('05072bab-7a4e-4c64-8826-42b878dd2c3c', '13', '湖北安陆', '2020-04-02 22:20:41', null, '8ff80ac2-ca77-4814-8369-911a2c5fef3c', null, '0');
INSERT INTO `orderlist` VALUES ('0744e4dd-3b5b-4a8e-8d4b-52d64ef4f2ef', '16', '湖北安陆', '2020-04-02 15:28:55', null, '8ff80ac2-ca77-4814-8369-911a2c5fef3c', null, '0');
INSERT INTO `orderlist` VALUES ('29e1651e-f26c-43d1-9051-9ebabc2a3c7f', '-11', '湖北安陆', '2020-04-02 14:41:13', null, '8ff80ac2-ca77-4814-8369-911a2c5fef3c', null, '0');
INSERT INTO `orderlist` VALUES ('2b8b53e7-a65b-41f8-9555-25631e292c28', '-5', '湖北安陆', '2020-04-02 22:25:51', null, '8ff80ac2-ca77-4814-8369-911a2c5fef3c', null, '0');
INSERT INTO `orderlist` VALUES ('3942b371-c665-466f-93b7-7fc149c683b9', '208', '湖北安陆', '2020-03-20 21:12:42', '2020-03-25 14:03:36', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');
INSERT INTO `orderlist` VALUES ('3b9c0754-3838-4ae7-9e47-dfe7134a370d', '32', '湖北安陆', '2020-03-20 21:13:49', '2020-03-31 21:33:04', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');
INSERT INTO `orderlist` VALUES ('401457df-b44a-4761-aeea-c315c8fe3c48', '80', '湖北孝感', '2020-03-25 14:37:24', null, '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');
INSERT INTO `orderlist` VALUES ('4735ca06-1106-4108-a46d-a7f95b9bc524', '-30', '湖北安陆', '2020-03-29 16:50:41', '2020-03-31 21:33:03', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');
INSERT INTO `orderlist` VALUES ('4dccf382-e910-4625-96e7-198112610054', '-4', '湖北安陆', '2020-04-02 23:10:14', '2020-04-05 18:00:29', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');
INSERT INTO `orderlist` VALUES ('701f5f12-e788-4249-8565-b08f13099479', '213', '湖北孝感', '2020-03-24 14:30:38', '2020-03-25 14:01:01', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1', '1');
INSERT INTO `orderlist` VALUES ('82db3fc2-3372-4887-a6a8-7fa843557f15', '0', '湖北孝感', '2020-03-25 20:30:16', '2020-03-31 21:33:01', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');
INSERT INTO `orderlist` VALUES ('874b1a35-77e4-4cd6-9cae-7ea57cda0453', '13', '湖北孝感', '2020-04-02 15:59:31', '2020-04-05 17:38:02', '1495f4fd-84fd-4e99-8811-1076e99905e4', '3', '1');
INSERT INTO `orderlist` VALUES ('8c7dff70-2ff3-4608-bc8f-d12a338c6f52', '13', '湖北安陆', '2020-04-02 15:59:05', '2020-04-05 17:37:56', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '3', '1');
INSERT INTO `orderlist` VALUES ('8e207183-f1cd-4dbe-91c1-74627d5793f8', '-3', '湖北安陆', '2020-03-29 16:45:07', '2020-03-31 21:32:57', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');
INSERT INTO `orderlist` VALUES ('c7865252-5867-4ed2-9f7b-d9c5094a3ff6', '78', '湖北孝感', '2020-03-28 23:10:46', '2020-03-28 23:12:01', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');
INSERT INTO `orderlist` VALUES ('f0b5fb99-59e5-4e44-97dc-fc68f2e75055', '3', '湖北安陆', '2020-04-02 23:10:54', '2020-04-05 17:37:50', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '3', '1');
INSERT INTO `orderlist` VALUES ('f1c07230-c124-4a39-8353-075470ad667b', '13', '湖北安陆', '2020-04-02 14:40:45', '2020-04-02 16:26:11', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '3', '1');
INSERT INTO `orderlist` VALUES ('ff52697b-9916-46de-a270-4802d6b5ab96', '32', '湖北孝感', '2020-03-24 14:31:00', '2020-03-25 20:30:59', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '8ff80ac2-ca77-4814-8369-911a2c5fef3c', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uname` varchar(20) NOT NULL,
  `upassword` varchar(30) NOT NULL,
  `role` tinyint(4) DEFAULT NULL,
  `telphone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `userStatus` tinyint(4) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `registerTime` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `money` float NOT NULL,
  PRIMARY KEY (`id`,`money`),
  UNIQUE KEY `uname` (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1495f4fd-84fd-4e99-8811-1076e99905e4', 'hyy', '123456', '0', '', '1', '', '2020-03-31 19:57:14', '湖北孝感', '13');
INSERT INTO `user` VALUES ('155e76bf-a90a-47d2-bc5e-5ad774e01d89', '成永毕', '123456', '0', null, '1', null, '2020-04-02 14:15:23', null, '0');
INSERT INTO `user` VALUES ('2a6078ec-b90f-444c-91f4-e1819a23a996', 'np123', '123456', '0', null, '1', null, '2020-03-22 23:53:34', null, '0');
INSERT INTO `user` VALUES ('3', 'fyk', '123456', '2', '1111111111', '1', null, '2020-03-08 12:09:54', '湖北安陆', '0');
INSERT INTO `user` VALUES ('45b8499e-5294-4c9a-a161-93f5846eb084', 'zjc', '123456', '0', '134124', '1', '12341', '2020-03-15 14:46:49', '湖北赤壁', '0');
INSERT INTO `user` VALUES ('45f0974e-377c-46f0-a4d6-48b602608100', '毕玄', '123456', '0', null, '1', null, '2020-03-22 23:02:19', null, '0');
INSERT INTO `user` VALUES ('499e5f33-935d-4b8e-b555-2a6ff99913b2', '孙悟空', '123456', '0', null, '1', null, '2020-03-08 12:09:54', '湖北安陆', '0');
INSERT INTO `user` VALUES ('53052075-8931-4934-a93e-29f7a4f217fc', '1', '123', '0', null, '1', null, '2020-03-22 15:08:32', null, '0');
INSERT INTO `user` VALUES ('64c7baf6-3faa-4238-ba53-ee78829a186b', 'pdd', '123456', '0', null, '1', null, '2020-04-02 15:00:43', null, '0');
INSERT INTO `user` VALUES ('67382e19-4c6c-48a2-9333-054e6b05ca47', 'wxx', '123456', '0', null, '1', null, '2020-04-05 17:36:58', null, '0');
INSERT INTO `user` VALUES ('82ff992f-b657-46b0-a1d3-3421bee05957', 'yyy', '123456', '0', '134124', '1', null, '2020-03-08 12:09:54', '湖北安陆', '0');
INSERT INTO `user` VALUES ('8ff80ac2-ca77-4814-8369-911a2c5fef3c', 'byc', '123456', '1', '15971192885', '1', '2743584911@qq.com', '2020-03-08 12:09:54', '湖北安陆', '12591.2');
INSERT INTO `user` VALUES ('935d4ec2-453a-4809-987c-29b1d1d3b110', '徐明伍', '123456', '0', null, '1', null, '2020-03-09 19:26:31', null, '0');
INSERT INTO `user` VALUES ('b15e5a2a-d778-4833-90d2-79e910ba6b4f', 'ooo', '123456', '0', '415414', '1', null, '2020-03-08 12:09:54', '湖北安陆', '0');
INSERT INTO `user` VALUES ('c81da33d-a042-422c-bfa9-377fdc0c71a2', '曾瑶', '123456', '0', null, '0', null, '2020-03-08 12:09:54', '湖北安陆', '0');
INSERT INTO `user` VALUES ('d3d0f39b-8753-4d08-9e29-415bc7d05743', '毕永成', '123456', '0', '41241', '0', null, '2020-03-08 12:09:54', '湖北安陆', '0');
INSERT INTO `user` VALUES ('d70b848e-0a6c-4e1c-a481-45b6dff369a2', '张三', '123456', '0', null, '1', null, '2020-03-09 17:30:57', '湖北安陆', '280');
INSERT INTO `user` VALUES ('d9ab2f3e-f886-48c5-aa97-d0395c82bb47', 'ypp', '123456', '0', '1', '1', '1', '2020-03-08 12:09:54', '1', '0');
INSERT INTO `user` VALUES ('e67a364c-953d-49b5-a14f-67f5ac6788ea', 'kfasga', '123456', '0', '454513253', '1', null, '2020-03-08 12:09:54', '湖北安陆', '12.01');
INSERT INTO `user` VALUES ('f52c9c7c-7323-4c7e-8c7c-090586e03655', '123', '', '0', null, '1', null, '2020-03-22 15:07:47', null, '0');
