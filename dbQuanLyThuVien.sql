CREATE DATABASE  IF NOT EXISTS `quanlythuvien` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanlythuvien`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlythuvien
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'phong123','1@$@@2@$@@@@$@@','DG'),(2,'ducdeptrai','1@$@@2@$@@@@$@@','DG'),(3,'ducduc','1@$@@2@$@@@@$@@','DG'),(4,'truongan','11111111','NV'),(5,'truongan2','11111111','NV'),(6,'truongan123','!!&*#2!&*#3!&*#4!&*#5!&*#6!&*#7!&*#8!&*#','DG'),(7,'TruongAnVC','!!&*#2!&*#3!&*#4!&*#5!&*#6!&*#','DG'),(8,'anbaove','!!&*#2!&*#3!&*#4!&*#5!&*#6!&*#','DG'),(9,'kyanbaove','!!&*#2!&*#3!&*#4!&*#5!&*#6!&*#','DG'),(10,'duc1234444','!!&*#2!&*#3!&*#4!&*#5!&*#6!&*#7!&*#8!&*#','DG'),(11,'admin1','1@$@@2@$@@@@$@@','NV'),(12,'kimduyen','!!&*#2!&*#3!&*#4!&*#5!&*#6!&*#','DG'),(13,'huuducbaove','1@$@@2@$@@@@$@@','NV');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `book_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `book_category` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `book_description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `publish` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `publish_year` int NOT NULL,
  `entry_date` date NOT NULL,
  `book_position` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `instock` int NOT NULL,
  `author` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Đắc nhân tâm','Tâm lý - Kỹ năng sống','Sách hướng dẫn tâm lý và kỹ năng sống','NXB Trẻ',2010,'2022-03-25','A01',0,' Dale Carnegie'),(2,'Cuốn theo chiều gió','Văn học','Cuốn theo chiều gió là tác phẩm tiểu thuyết nổi tiếng của nữ nhà văn Mỹ Margaret Mitchell, xuất bản lần đầu năm 1936.','NXB Văn học',1936,'2022-03-25','A02',1,'Margaret Mitchell'),(3,'Tôi tài giỏi, bạn cũng thế','Phát triển bản thân','Vượt qua khó khăn và phát triển bản thân.','NXB Trẻ',2020,'2022-03-24','A03',12,'Adam Khoo'),(4,'Đắc nhân tâm','Phát triển bản thân','Cuốn sách chuyên về phát triển bản thân này đã được viết bởi Dale Carnegie từ năm 1936, cho đến nay vẫn được nhiều người đọc và áp dụng trong cuộc sống.','NXB Thanh niên',1936,'2022-03-23','A03',45,'George S. Clason'),(5,'Người giàu có nhất thành Babylon','Tài chính - Kinh doanh','Cuốn sách kinh điển này giúp bạn học cách quản lý tài chính thông minh và cải thiện đời sống tài chính của mình.','NXB Hồng Đức',1926,'2022-03-22','B01',7,'Charles Dickens'),(6,'Hai số phận','Văn học','Hai số phận là tác phẩm tiểu thuyết của nhà văn nổi tiếng Alexandre Dumas, phát hành lần đầu vào năm 1844.','NXB Văn học',1844,'2022-03-21','B02',8,'Colleen McCullough'),(7,'Tiếng chim hót trong bụi mận gai','Văn học','Tác phẩm đạt giải Quả cầu vàng cho bộ phim truyền hình xuất sắc nhất năm 1983','NXB Văn học',1977,'2022-03-20','B03',9,'Colleen McCulloughColleen McCullough'),(8,'Nhà giả kim','Văn học','Cuốn sách nổi tiếng của Paulo Coelho, kể về câu chuyện của một người đàn ông tìm kiếm nghĩa vụ của mình trong cuộc đời.','NXB Thế giới',1988,'2022-03-19','B04',1,'Paulo Coelho');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `call_card`
--

DROP TABLE IF EXISTS `call_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `call_card` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_get_book` datetime(6) NOT NULL,
  `return_date` datetime(6) NOT NULL,
  `employee_id` bigint DEFAULT NULL,
  `reader_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `call_card_employee_id_e788156b_fk_employee_id` (`employee_id`),
  KEY `call_card_reader_id_67ea0b54_fk_reader_id` (`reader_id`),
  CONSTRAINT `call_card_employee_id_e788156b_fk_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `call_card_reader_id_67ea0b54_fk_reader_id` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `call_card`
--

LOCK TABLES `call_card` WRITE;
/*!40000 ALTER TABLE `call_card` DISABLE KEYS */;
INSERT INTO `call_card` VALUES (1,'2023-04-20 00:00:00.000000','2023-05-18 00:00:00.000000',NULL,1);
/*!40000 ALTER TABLE `call_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `call_card_detail`
--

DROP TABLE IF EXISTS `call_card_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `call_card_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `book_id` bigint NOT NULL,
  `call_card_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `call_card_detail_book_id_bb8a9885_fk_book_id` (`book_id`),
  KEY `call_card_detail_call_card_id_29dc3321_fk_call_card_id` (`call_card_id`),
  CONSTRAINT `call_card_detail_book_id_bb8a9885_fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `call_card_detail_call_card_id_29dc3321_fk_call_card_id` FOREIGN KEY (`call_card_id`) REFERENCES `call_card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `call_card_detail`
--

LOCK TABLES `call_card_detail` WRITE;
/*!40000 ALTER TABLE `call_card_detail` DISABLE KEYS */;
INSERT INTO `call_card_detail` VALUES (1,2,3,1);
/*!40000 ALTER TABLE `call_card_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cmnd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_account_id_9bc3db3a_fk_account_id` (`account_id`),
  CONSTRAINT `employee_account_id_9bc3db3a_fk_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Doan Trung Phong','123123','123123',11),(2,'Hữu Đức','123123','123123',13);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader`
--

DROP TABLE IF EXISTS `reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reader` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `reader_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `reader_role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `position` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date_of_call_card` date DEFAULT NULL,
  `email` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `borrowing_availability` int DEFAULT NULL,
  `account_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `reader_account_id_163db319_fk_account_id` (`account_id`),
  CONSTRAINT `reader_account_id_163db319_fk_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader`
--

LOCK TABLES `reader` WRITE;
/*!40000 ALTER TABLE `reader` DISABLE KEYS */;
INSERT INTO `reader` VALUES (1,'Doan TrungP Phong','Male','2002-10-04','Student','IT03','2022-03-25','phong1@gmail.com','ABC Street, HCMC','0987654321',5,1),(2,'duc','Nam',NULL,NULL,NULL,NULL,NULL,'quan non','123123123',0,3),(3,'Trường An','Nam',NULL,NULL,NULL,NULL,NULL,'Nguyễn Văn Dung','3121311',0,6),(4,'Trường An','Nam',NULL,'Nam','Khoa CNTT',NULL,NULL,'Gia Nghĩa','123123123',0,7),(5,'KyAn','Nam',NULL,'Nam','Bảo Vệ','2023-05-17','anky123@gmail.com','GoVap','123123',5,9),(6,'Pham Huu duc','Nam',NULL,'Nam','aaa','2023-10-17','duc@dsds','quang nam','0777590717',5,10),(7,'KimDinn','Nữ',NULL,'Viên Chức','Khoa CNTT','2023-10-18','din123@gmail.com','TaNi','123123123',5,12);
/*!40000 ALTER TABLE `reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_book`
--

DROP TABLE IF EXISTS `return_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `return_book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_return_book` datetime(6) NOT NULL,
  `fine` int NOT NULL,
  `call_card_id` bigint NOT NULL,
  `employee_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `return_book_call_card_id_fb332010_fk_call_card_id` (`call_card_id`),
  KEY `return_book_employee_id_83e6c4ae_fk_employee_id` (`employee_id`),
  CONSTRAINT `return_book_call_card_id_fb332010_fk_call_card_id` FOREIGN KEY (`call_card_id`) REFERENCES `call_card` (`id`),
  CONSTRAINT `return_book_employee_id_83e6c4ae_fk_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_book`
--

LOCK TABLES `return_book` WRITE;
/*!40000 ALTER TABLE `return_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-18 18:52:57
