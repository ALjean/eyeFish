-- MySQL dump 10.16  Distrib 10.1.13-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: eye_fish_project
-- ------------------------------------------------------
-- Server version	10.1.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bait_settings`
--

DROP TABLE IF EXISTS `bait_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bait_settings` (
  `setting_id` int(11) NOT NULL AUTO_INCREMENT,
  `bait_id` int(11) NOT NULL DEFAULT '0',
  `setting_name` varchar(30) COLLATE utf16_bin NOT NULL,
  `setting_type` varchar(30) COLLATE utf16_bin NOT NULL,
  `description` varchar(1000) COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `FK_bait_settings_baits` (`bait_id`),
  CONSTRAINT `FK_bait_settings_baits` FOREIGN KEY (`bait_id`) REFERENCES `baits` (`bait_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bait_settings`
--

LOCK TABLES `bait_settings` WRITE;
/*!40000 ALTER TABLE `bait_settings` DISABLE KEYS */;
INSERT INTO `bait_settings` VALUES (3,60,'Natural','Color','Use natural colors for the best result'),(8,4,'Sweet','Taste','If you have hot weather'),(11,67,'Meat','Taste','Use meat for the best result'),(32,88,'Red','Color','Use for the best result');
/*!40000 ALTER TABLE `bait_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baits`
--

DROP TABLE IF EXISTS `baits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baits` (
  `bait_id` int(11) NOT NULL AUTO_INCREMENT,
  `bait_name` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  `description` varchar(8000) COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`bait_id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baits`
--

LOCK TABLES `baits` WRITE;
/*!40000 ALTER TABLE `baits` DISABLE KEYS */;
INSERT INTO `baits` VALUES (4,'CORNS','Traditional bait for calm fish'),(60,'Slizzard','For superlative fish? for example Yazzz!'),(67,'Fat WORM','For superlative fish? for example Yazzz!'),(88,'Castmaster','For real predator!');
/*!40000 ALTER TABLE `baits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baits_to_fishes`
--

DROP TABLE IF EXISTS `baits_to_fishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baits_to_fishes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fish_id` int(11) DEFAULT NULL,
  `bait_id` int(11) DEFAULT NULL,
  `is_priority` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `FK_bindings_baits_to_fishes_fish` (`fish_id`),
  KEY `FK_bindings_baits_to_fishes_bait` (`bait_id`),
  CONSTRAINT `FK_bindings_baits_to_fishes_bait` FOREIGN KEY (`bait_id`) REFERENCES `baits` (`bait_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_bindings_baits_to_fishes_fish` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`fish_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baits_to_fishes`
--

LOCK TABLES `baits_to_fishes` WRITE;
/*!40000 ALTER TABLE `baits_to_fishes` DISABLE KEYS */;
INSERT INTO `baits_to_fishes` VALUES (3,7,4,'\0'),(10,7,67,'\0'),(15,7,60,'\0'),(32,13,88,'\0');
/*!40000 ALTER TABLE `baits_to_fishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baits_to_seasons`
--

DROP TABLE IF EXISTS `baits_to_seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baits_to_seasons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bait_id` int(11) NOT NULL,
  `start_period` date NOT NULL,
  `end_period` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `baits_to_seasons_ibfk_1` (`bait_id`),
  CONSTRAINT `baits_to_seasons_ibfk_1` FOREIGN KEY (`bait_id`) REFERENCES `baits` (`bait_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baits_to_seasons`
--

LOCK TABLES `baits_to_seasons` WRITE;
/*!40000 ALTER TABLE `baits_to_seasons` DISABLE KEYS */;
INSERT INTO `baits_to_seasons` VALUES (3,4,'2016-06-22','2016-08-31'),(10,67,'2016-01-01','2016-03-30'),(11,67,'2016-09-01','2016-12-30'),(20,60,'2016-04-25','2016-06-25'),(53,88,'2016-04-01','2016-07-30'),(54,88,'2016-02-01','2016-03-25');
/*!40000 ALTER TABLE `baits_to_seasons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily_forecast_weathers`
--

DROP TABLE IF EXISTS `daily_forecast_weathers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_forecast_weathers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(30) COLLATE utf16_bin NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `temp_day` float NOT NULL,
  `temp_night` float NOT NULL,
  `temp_even` float NOT NULL,
  `temp_morn` float NOT NULL,
  `pressure` float NOT NULL,
  `wind_speed` float NOT NULL,
  `wind_deg` int(11) NOT NULL,
  `humidity` int(11) NOT NULL,
  `clouds` int(11) NOT NULL,
  `rain_volume` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_forecast_weathers`
--

LOCK TABLES `daily_forecast_weathers` WRITE;
/*!40000 ALTER TABLE `daily_forecast_weathers` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_forecast_weathers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fish_settings`
--

DROP TABLE IF EXISTS `fish_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fish_settings` (
  `setting_id` int(11) NOT NULL AUTO_INCREMENT,
  `fish_id` int(11) NOT NULL,
  `param_name` varchar(50) COLLATE utf16_bin NOT NULL,
  `min_range` double NOT NULL,
  `max_range` double NOT NULL,
  `nibble_level` double NOT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `fish_id` (`fish_id`),
  KEY `FK_fish_settings_parameters_names` (`param_name`),
  CONSTRAINT `FK_fish_settings_parameters_names` FOREIGN KEY (`param_name`) REFERENCES `parameters_names` (`parameters_name`),
  CONSTRAINT `fish_settings_ibfk_1` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`fish_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fish_settings`
--

LOCK TABLES `fish_settings` WRITE;
/*!40000 ALTER TABLE `fish_settings` DISABLE KEYS */;
INSERT INTO `fish_settings` VALUES (38,7,'ENVIRMOMENT_TEMPERATURE',-50,-4,0),(39,7,'ENVIRMOMENT_TEMPERATURE',-5,12,15.5),(40,7,'ENVIRMOMENT_TEMPERATURE',12,16,21.2),(41,7,'ENVIRMOMENT_TEMPERATURE',17,20,38.23),(42,7,'ENVIRMOMENT_TEMPERATURE',21,26,88.3),(43,7,'ENVIRMOMENT_TEMPERATURE',20,26,88.3),(44,7,'ENVIRMOMENT_TEMPERATURE',27,31,52.3),(45,7,'ENVIRMOMENT_TEMPERATURE',32,36,21.8),(46,7,'ENVIRMOMENT_TEMPERATURE',37,48,5.4),(53,7,'PRESSURE',710,725,5.2),(54,7,'PRESSURE',726,740,38.9),(55,7,'PRESSURE',741,752,86.3),(56,7,'PRESSURE',753,765,26.3),(70,13,'ENVIRMOMENT_TEMPERATURE',-50,-4,0),(71,13,'ENVIRMOMENT_TEMPERATURE',-4,12,45.3),(72,13,'ENVIRMOMENT_TEMPERATURE',13,16,80.2),(73,13,'ENVIRMOMENT_TEMPERATURE',17,20,89.23),(74,13,'ENVIRMOMENT_TEMPERATURE',21,26,75.3),(76,13,'ENVIRMOMENT_TEMPERATURE',27,31,33.3),(77,13,'ENVIRMOMENT_TEMPERATURE',32,36,15.8),(78,13,'ENVIRMOMENT_TEMPERATURE',37,48,5.4),(85,13,'PRESSURE',710,725,5.2),(86,13,'PRESSURE',726,740,23.87),(87,13,'PRESSURE',741,752,26.3),(88,13,'PRESSURE',753,765,96.3);
/*!40000 ALTER TABLE `fish_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fishes`
--

DROP TABLE IF EXISTS `fishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fishes` (
  `fish_id` int(11) NOT NULL AUTO_INCREMENT,
  `fish_name` varchar(50) COLLATE utf16_bin NOT NULL,
  `description` varchar(8000) COLLATE utf16_bin DEFAULT NULL,
  `fish_type` varchar(30) COLLATE utf16_bin DEFAULT NULL,
  `area` varchar(30) COLLATE utf16_bin DEFAULT NULL,
  `activity` varchar(30) COLLATE utf16_bin DEFAULT NULL,
  PRIMARY KEY (`fish_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fishes`
--

LOCK TABLES `fishes` WRITE;
/*!40000 ALTER TABLE `fishes` DISABLE KEYS */;
INSERT INTO `fishes` VALUES (7,'Carp','In Europe, even when not fished for food, they are eagerly sought by anglers, being considered highly prized coarse fish that are difficult to hook.[29] The UK has a thriving carp angling market. It is the fastest growing angling market in the UK, and has spawned a number of specialised carp angling publications such as Carpology,[30] Advanced carp fishing, Carpworld and Total Carp, and informative carp angling web sites, such as Carpfishing UK','CALM','BOTTOM','MORNING'),(13,'Pike','Effective methods for catching this hard-fighting fish include dead baits, live baits, and lure fishing. \r\nPike can easily be damaged when handled since they are not as robust as their reputation would suggest. \r\nColour of lure can be influenced by water clarity and weather conditions. Since pike have numerous sharp \r\nteeth it is wise to take extreme care when unhooking them. The use of a wet leather gauntlet and surgical \r\nforceps to remove hooks is highly recommended on safety grounds. If practicing catch and release fishing, \r\ncare for the pike should be the pike angler s utmost concern. The formerly recommended practice of grasping \r\na pike by its eye sockets (tragically interpreted as \"its eyes\") resulted in countless released pike that \r\nquickly died from inability to see prey any longer.','PREDATOR','BOTTOM','MORNING');
/*!40000 ALTER TABLE `fishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `mess_id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(30) COLLATE utf16_bin NOT NULL,
  `mess_text` varchar(8000) COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`mess_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'STYRO_POP_UP','Use the styrofoam for take up your bait under bottom'),(2,'BOIL_POP_UP','Use the pop-up boil for take up your bait under bottom'),(3,'TOP_POP_UP','Use some stuff for take up your bait on the top water layer');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nibble_periods`
--

DROP TABLE IF EXISTS `nibble_periods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nibble_periods` (
  `nibble_id` int(11) NOT NULL AUTO_INCREMENT,
  `fish_id` int(11) NOT NULL,
  `start_period` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_period` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `nibble_level` double DEFAULT NULL,
  PRIMARY KEY (`nibble_id`),
  KEY `fish_id` (`fish_id`),
  CONSTRAINT `nibble_periods_ibfk_1` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`fish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nibble_periods`
--

LOCK TABLES `nibble_periods` WRITE;
/*!40000 ALTER TABLE `nibble_periods` DISABLE KEYS */;
/*!40000 ALTER TABLE `nibble_periods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameters_names`
--

DROP TABLE IF EXISTS `parameters_names`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameters_names` (
  `param_name_id` int(11) NOT NULL AUTO_INCREMENT,
  `parameters_name` varchar(50) COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`param_name_id`),
  UNIQUE KEY `parameters_name` (`parameters_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameters_names`
--

LOCK TABLES `parameters_names` WRITE;
/*!40000 ALTER TABLE `parameters_names` DISABLE KEYS */;
INSERT INTO `parameters_names` VALUES (7,'ALGA_LEVEL'),(1,'CLOUD_LEVEL'),(6,'DEEP_LEVEL'),(3,'ENVIRMOMENT_TEMPERATURE'),(5,'PRESSURE'),(2,'RAIN_LEVEL'),(4,'WATER_TEMPERATURE'),(8,'WIND_SPEED');
/*!40000 ALTER TABLE `parameters_names` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pond_properties`
--

DROP TABLE IF EXISTS `pond_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pond_properties` (
  `pond_id` int(11) NOT NULL AUTO_INCREMENT,
  `param_name_id` int(11) NOT NULL,
  `min_range` double NOT NULL,
  `max_range` double NOT NULL,
  `deep_level` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  PRIMARY KEY (`pond_id`),
  KEY `FK_baits_weights_properties_parameters_names` (`param_name_id`),
  CONSTRAINT `FK_baits_weights_properties_parameters_names` FOREIGN KEY (`param_name_id`) REFERENCES `parameters_names` (`param_name_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pond_properties`
--

LOCK TABLES `pond_properties` WRITE;
/*!40000 ALTER TABLE `pond_properties` DISABLE KEYS */;
INSERT INTO `pond_properties` VALUES (1,6,0.5,1.2,'SHALLOW'),(2,6,1.3,1.9,'MIDDLE'),(3,6,2,2.5,'DEEPLY'),(4,6,2.5,5,'OVERDEEPLY'),(5,7,0,12,'CLEAR'),(6,7,13,41,'OVERGROWN'),(7,7,42,100,'TRASH'),(8,4,0,12,'COLD'),(9,4,12,17,'SOFT'),(10,4,18,24,'WARM'),(11,4,25,30,'HOT');
/*!40000 ALTER TABLE `pond_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qualifiers`
--

DROP TABLE IF EXISTS `qualifiers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qualifiers` (
  `qual_id` int(11) NOT NULL AUTO_INCREMENT,
  `setting_id` int(11) NOT NULL DEFAULT '0',
  `param_name` varchar(50) COLLATE utf16_bin NOT NULL,
  `min_level` double NOT NULL,
  `max_level` double NOT NULL,
  PRIMARY KEY (`qual_id`),
  KEY `FK_qualifiers_bait_settings` (`setting_id`),
  KEY `FK_qualifiers_parameters_names` (`param_name`),
  CONSTRAINT `FK_qualifiers_bait_settings` FOREIGN KEY (`setting_id`) REFERENCES `bait_settings` (`setting_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_qualifiers_parameters_names` FOREIGN KEY (`param_name`) REFERENCES `parameters_names` (`parameters_name`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualifiers`
--

LOCK TABLES `qualifiers` WRITE;
/*!40000 ALTER TABLE `qualifiers` DISABLE KEYS */;
INSERT INTO `qualifiers` VALUES (3,3,'CLOUD_LEVEL',23,50),(4,3,'DEEP_LEVEL',1.2,2),(13,8,'ENVIRMOMENT_TEMPERATURE',25,35),(15,11,'ENVIRMOMENT_TEMPERATURE',0,12),(52,32,'ENVIRMOMENT_TEMPERATURE',0,12),(53,32,'CLOUD_LEVEL',30,65);
/*!40000 ALTER TABLE `qualifiers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rain_volume`
--

DROP TABLE IF EXISTS `rain_volume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rain_volume` (
  `rain_volume_id` int(11) NOT NULL AUTO_INCREMENT,
  `min_mm_level` double DEFAULT NULL,
  `max_mm_level` double DEFAULT NULL,
  `description` varchar(500) COLLATE utf16_bin DEFAULT NULL,
  PRIMARY KEY (`rain_volume_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rain_volume`
--

LOCK TABLES `rain_volume` WRITE;
/*!40000 ALTER TABLE `rain_volume` DISABLE KEYS */;
INSERT INTO `rain_volume` VALUES (1,0.3,0.5,'Slight rain'),(2,0.6,4,'Moderate rain'),(3,4.1,8,'Heavy rain'),(4,8,100,'Very heavy rain');
/*!40000 ALTER TABLE `rain_volume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seasons`
--

DROP TABLE IF EXISTS `seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seasons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text COLLATE utf16_bin,
  `start_period` date NOT NULL,
  `end_period` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seasons`
--

LOCK TABLES `seasons` WRITE;
/*!40000 ALTER TABLE `seasons` DISABLE KEYS */;
INSERT INTO `seasons` VALUES (1,'WINTER_MIDDLE','2016-01-01','2016-01-30'),(2,'WINTER_END','2016-02-01','2016-02-29'),(3,'SPRING_EARLY','2016-03-01','2016-03-31'),(4,'SPRING_MIDDLE','2016-04-01','2016-04-30'),(5,'SPRING_END','2016-05-01','2016-05-31'),(6,'SUMMER_EARLY','2016-06-01','2016-06-30'),(7,'SUMMER_MIDDLE','2016-07-01','2016-07-30'),(8,'SUMMER_END','2016-08-01','2016-08-31'),(9,'OTOUMN_EARLY','2016-09-01','2016-09-30'),(10,'OTOUMN_MIDDLE','2016-10-01','2016-10-31'),(11,'OTOUMN_END','2016-11-01','2016-11-30'),(12,'WINTER_EARLY','2016-12-01','2016-12-31');
/*!40000 ALTER TABLE `seasons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) COLLATE utf16_bin NOT NULL,
  `password` varchar(100) COLLATE utf16_bin DEFAULT NULL,
  `first_name` varchar(20) COLLATE utf16_bin DEFAULT NULL,
  `last_name` varchar(20) COLLATE utf16_bin DEFAULT NULL,
  `role` varchar(20) COLLATE utf16_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'mail@mail.com','$2a$08$.Vib2ZN7L3C3kx.BRAf5xOW8wKNN/v8FFpKSMcV21lfkoSy.ILpRW','Bill','Montgomery','ADMIN'),(2,'mail1@mail.com','$2a$08$.Vib2ZN7L3C3kx.BRAf5xOW8wKNN/v8FFpKSMcV21lfkoSy.ILpRW','Taller','Derdon','USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-28 15:53:10
