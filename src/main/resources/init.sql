/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 31/03/2019 21:45:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(255) NOT NULL COMMENT '行政区划完整名称',
    `pid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父行政区划ID',
    `level` int(2) NOT NULL COMMENT '三级联动的级别，10-第一级，20-第二级，30-第三级',
    `pinyin` varchar(255) NOT NULL COMMENT '行政区划拼音',
    `abb_name` varchar(255) NOT NULL COMMENT '行政区划简称',
    `traditional_name` varchar(255) NOT NULL COMMENT '行政区划繁体名称',
    `code` int(11) NOT NULL COMMENT '国家标准行政区划编码',
    `division_level` int(11) unsigned NOT NULL COMMENT '地区级别：2-省、自治区、直辖市 3-地级市、地区、自治州、盟，4-市辖区、县级市、县，5-乡、镇、街道行政区划级别',
    `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=650001 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of region
-- ----------------------------
BEGIN;
INSERT INTO `region` VALUES (110000, '北京', 1, 10, 'bei jing', '北京', '北京', 110000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (120000, '天津', 1, 10, 'tian jin', '天津', '天津', 120000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (130000, '河北省', 1, 10, 'he bei sheng', '河北', '河北省', 130000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (140000, '山西省', 1, 10, 'shan xi sheng', '山西', '山西省', 140000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (150000, '内蒙古自治区', 1, 10, 'nei meng gu zi zhi qu', '内蒙古', '內蒙古自治區', 150000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (210000, '辽宁省', 1, 10, 'liao ning sheng', '辽宁', '遼寧省', 210000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (220000, '吉林省', 1, 10, 'ji lin sheng', '吉林', '吉林省', 220000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (230000, '黑龙江省', 1, 10, 'hei long jiang sheng', '黑龙江', '黑龍江省', 230000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (310000, '上海', 1, 10, 'shang hai', '上海', '上海', 310000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (320000, '江苏省', 1, 10, 'jiang su sheng', '江苏', '江蘇省', 320000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (330000, '浙江省', 1, 10, 'zhe jiang sheng', '浙江', '浙江省', 330000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (340000, '安徽省', 1, 10, 'an hui sheng', '安徽', '安徽省', 340000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (350000, '福建省', 1, 10, 'fu jian sheng', '福建', '福建省', 350000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (360000, '江西省', 1, 10, 'jiang xi sheng', '江西', '江西省', 360000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (370000, '山东省', 1, 10, 'shan dong sheng', '山东', '山東省', 370000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (410000, '河南省', 1, 10, 'he nan sheng', '河南', '河南省', 410000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (420000, '湖北省', 1, 10, 'hu bei sheng', '湖北', '湖北省', 420000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (430000, '湖南省', 1, 10, 'hu nan sheng', '湖南', '湖南省', 430000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (440000, '广东省', 1, 10, 'guang dong sheng', '广东', '廣東省', 440000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (450000, '广西壮族自治区', 1, 10, 'guang xi zhuang zu zi zhi qu', '广西', '廣西壯族自治區', 450000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (460000, '海南省', 1, 10, 'hai nan sheng', '海南', '海南省', 460000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (500000, '重庆', 1, 10, 'chong qing', '重庆', '重慶', 500000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (510000, '四川省', 1, 10, 'si chuan sheng', '四川', '四川省', 510000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (520000, '贵州省', 1, 10, 'gui zhou sheng', '贵州', '貴州省', 520000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (530000, '云南省', 1, 10, 'yun nan sheng', '云南', '雲南省', 530000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (540000, '西藏自治区', 1, 10, 'xi zang zi zhi qu', '西藏', '西藏自治區', 540000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (610000, '陕西省', 1, 10, 'shan xi sheng', '陕西', '陝西省', 610000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (620000, '甘肃省', 1, 10, 'gan su sheng', '甘肃', '甘肅省', 620000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (630000, '青海省', 1, 10, 'qing hai sheng', '青海', '青海省', 630000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (640000, '宁夏回族自治区', 1, 10, 'ning xia hui zu zi zhi qu', '宁夏', '寧夏回族自治區', 640000, 2, '2019-03-04 10:21:17', NULL);
INSERT INTO `region` VALUES (650000, '新疆维吾尔自治区', 1, 10, 'xin jiang wei wu er zi zhi qu', '新疆', '新疆維吾爾自治區', 650000, 2, '2019-03-04 10:21:17', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
