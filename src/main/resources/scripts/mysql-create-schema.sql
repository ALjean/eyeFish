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
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bait_settings`
--

LOCK TABLES `bait_settings` WRITE;
/*!40000 ALTER TABLE `bait_settings` DISABLE KEYS */;
INSERT INTO `bait_settings` VALUES (80,1,'Sweet','Taste','For sprng'),(81,1,'Bright','Color','For deepest and darknes places'),(82,1,'Fruit','Taste','For hot weather'),(84,1,'Light','Color','For middle deep '),(85,1,'Dark','Color','For top'),(86,3,'White','Color','For middle deep and deepest'),(87,3,'Natural','Color','For all places'),(88,2,'Natural','Color','For all places');
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
  `bait_type` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  `bait_name` varchar(50) COLLATE utf16_bin DEFAULT NULL,
  `description` varchar(8000) COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`bait_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baits`
--

LOCK TABLES `baits` WRITE;
/*!40000 ALTER TABLE `baits` DISABLE KEYS */;
INSERT INTO `baits` VALUES (1,'Vegitable','Corn','The best bait for fishing carp'),(2,'Protein','Worm','Bait wich prefer almost to all fishes'),(3,'Protein','Maggot','The best bait for white fishes');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baits_to_fishes`
--

LOCK TABLES `baits_to_fishes` WRITE;
/*!40000 ALTER TABLE `baits_to_fishes` DISABLE KEYS */;
INSERT INTO `baits_to_fishes` VALUES (1,7,1,''),(2,7,2,'\0'),(3,30,2,'\0'),(4,30,3,''),(5,7,3,'\0');
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
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baits_to_seasons`
--

LOCK TABLES `baits_to_seasons` WRITE;
/*!40000 ALTER TABLE `baits_to_seasons` DISABLE KEYS */;
INSERT INTO `baits_to_seasons` VALUES (99,1,'2016-05-01','2016-08-22'),(100,2,'2016-06-23','2016-11-21'),(101,3,'2016-03-01','2016-09-30');
/*!40000 ALTER TABLE `baits_to_seasons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day_weathers`
--

DROP TABLE IF EXISTS `day_weathers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day_weathers` (
  `day_weather_id` int(11) NOT NULL AUTO_INCREMENT,
  `gen_weather_id` int(11) NOT NULL,
  `current_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `temp_day` double NOT NULL,
  `temp_night` double NOT NULL,
  `temp_even` double NOT NULL,
  `temp_morn` double NOT NULL,
  `pressure` double NOT NULL,
  `wind_speed` double NOT NULL,
  `wind_deg` double NOT NULL,
  `humidity` double NOT NULL,
  `clouds` double NOT NULL,
  `rain_volume` double NOT NULL,
  `sun_rise` varchar(10) COLLATE utf16_bin NOT NULL,
  `sun_down` varchar(10) COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`day_weather_id`),
  KEY `FK_day_weathers_general_weather` (`gen_weather_id`),
  CONSTRAINT `FK_day_weathers_general_weather` FOREIGN KEY (`gen_weather_id`) REFERENCES `general_weather` (`gen_weather_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day_weathers`
--

LOCK TABLES `day_weathers` WRITE;
/*!40000 ALTER TABLE `day_weathers` DISABLE KEYS */;
/*!40000 ALTER TABLE `day_weathers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `days_activity`
--

DROP TABLE IF EXISTS `days_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `days_activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `fish_id` int(11) NOT NULL,
  `activity_name` varchar(30) COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `FK_days_activity_fishes` (`fish_id`),
  CONSTRAINT `FK_days_activity_fishes` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`fish_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `days_activity`
--

LOCK TABLES `days_activity` WRITE;
/*!40000 ALTER TABLE `days_activity` DISABLE KEYS */;
INSERT INTO `days_activity` VALUES (8,7,'MORNING'),(9,7,'NIGHT'),(10,13,'MORNING'),(49,30,'MORNING'),(51,30,'DAY'),(70,40,'MORNING'),(71,40,'MORNING'),(76,43,'MORNING'),(77,43,'MORNING'),(78,7,'EVENING');
/*!40000 ALTER TABLE `days_activity` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fish_settings`
--

LOCK TABLES `fish_settings` WRITE;
/*!40000 ALTER TABLE `fish_settings` DISABLE KEYS */;
INSERT INTO `fish_settings` VALUES (38,7,'ENVIRMOMENT_TEMPERATURE',-50,-5,-3),(39,7,'ENVIRMOMENT_TEMPERATURE',-5,12,-2),(40,7,'ENVIRMOMENT_TEMPERATURE',12,16,-1),(41,7,'ENVIRMOMENT_TEMPERATURE',16,20,0),(42,7,'ENVIRMOMENT_TEMPERATURE',20,26,1),(44,7,'ENVIRMOMENT_TEMPERATURE',26,31,0),(45,7,'ENVIRMOMENT_TEMPERATURE',31,36,-2),(46,7,'ENVIRMOMENT_TEMPERATURE',36,48,-3),(53,7,'PRESSURE',710,725,5.2),(54,7,'PRESSURE',725,740,38.9),(55,7,'PRESSURE',740,752,86.3),(56,7,'PRESSURE',752,765,26.3),(70,13,'ENVIRMOMENT_TEMPERATURE',-50,-4,0),(71,13,'ENVIRMOMENT_TEMPERATURE',-4,12,45.3),(72,13,'ENVIRMOMENT_TEMPERATURE',13,16,80.2),(73,13,'ENVIRMOMENT_TEMPERATURE',17,20,89.23),(74,13,'ENVIRMOMENT_TEMPERATURE',21,26,75.3),(76,13,'ENVIRMOMENT_TEMPERATURE',27,31,33.3),(77,13,'ENVIRMOMENT_TEMPERATURE',32,36,15.8),(78,13,'ENVIRMOMENT_TEMPERATURE',37,48,5.4),(85,13,'PRESSURE',710,725,5.2),(86,13,'PRESSURE',726,740,23.87),(87,13,'PRESSURE',741,752,26.3),(88,13,'PRESSURE',753,765,96.3),(137,30,'ENVIRMOMENT_TEMPERATURE',0,7,23.5),(138,30,'ENVIRMOMENT_TEMPERATURE',8,12,57.23),(139,30,'ENVIRMOMENT_TEMPERATURE',13.8,19,77.23),(167,40,'ENVIRMOMENT_TEMPERATURE',0,7,100),(168,40,'ENVIRMOMENT_TEMPERATURE',8,12,57.23),(169,40,'ENVIRMOMENT_TEMPERATURE',13.8,19,77.23),(176,43,'ENVIRMOMENT_TEMPERATURE',0,7,100),(177,43,'ENVIRMOMENT_TEMPERATURE',8,12,57.23),(178,43,'ENVIRMOMENT_TEMPERATURE',13.8,19,77.23),(185,46,'ENVIRMOMENT_TEMPERATURE',0,7,23.5),(186,46,'ENVIRMOMENT_TEMPERATURE',8,12,57.23),(187,46,'ENVIRMOMENT_TEMPERATURE',13.8,19,77.23);
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
  `is_stability` double DEFAULT NULL,
  `is_high` double DEFAULT NULL,
  `is_low` double DEFAULT NULL,
  `is_rise` double DEFAULT NULL,
  `is_down` double DEFAULT NULL,
  PRIMARY KEY (`fish_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fishes`
--

LOCK TABLES `fishes` WRITE;
/*!40000 ALTER TABLE `fishes` DISABLE KEYS */;
INSERT INTO `fishes` VALUES (7,'Carp','In Europe, even when not fished for food, they are eagerly sought by anglers, being considered highly prized coarse fish that are difficult to hook.[29] The UK has a thriving carp angling market. It is the fastest growing angling market in the UK, and has spawned a number of specialised carp angling publications such as Carpology,[30] Advanced carp fishing, Carpworld and Total Carp, and informative carp angling web sites, such as Carpfishing UK','CALM',1,-1,2,-3,2),(13,'Pike','Effective methods for catching this hard-fighting fish include dead baits, live baits, and lure fishing. \r\nPike can easily be damaged when handled since they are not as robust as their reputation would suggest. \r\nColour of lure can be influenced by water clarity and weather conditions. Since pike have numerous sharp \r\nteeth it is wise to take extreme care when unhooking them. The use of a wet leather gauntlet and surgical \r\nforceps to remove hooks is highly recommended on safety grounds. If practicing catch and release fishing, \r\ncare for the pike should be the pike angler s utmost concern. The formerly recommended practice of grasping \r\na pike by its eye sockets (tragically interpreted as \"its eyes\") resulted in countless released pike that \r\nquickly died from inability to see prey any longer.','PREDATOR',NULL,NULL,NULL,NULL,NULL),(30,'Roach','Europian Roach','CALM',NULL,NULL,NULL,NULL,NULL),(40,'Yaz','Europian Roach','CALM',NULL,NULL,NULL,NULL,NULL),(43,'Yaz','Europian Roach','CALM',NULL,NULL,NULL,NULL,NULL),(46,'Roach','Europian Roach','CALM',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `fishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_weather`
--

DROP TABLE IF EXISTS `general_weather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_weather` (
  `gen_weather_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `city_name` varchar(50) COLLATE utf16_bin NOT NULL,
  `coord_lon` double NOT NULL,
  `coord_lat` double NOT NULL,
  `country` varchar(20) COLLATE utf16_bin NOT NULL,
  `message_count` double NOT NULL,
  PRIMARY KEY (`gen_weather_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_weather`
--

LOCK TABLES `general_weather` WRITE;
/*!40000 ALTER TABLE `general_weather` DISABLE KEYS */;
INSERT INTO `general_weather` VALUES (1,12345,'Piza',123.3,321.1,'GU',801);
/*!40000 ALTER TABLE `general_weather` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hour_weathers`
--

DROP TABLE IF EXISTS `hour_weathers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hour_weathers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gen_weather_id` int(11) NOT NULL,
  `date_text` varchar(30) COLLATE utf16_bin NOT NULL,
  `clouds` double NOT NULL,
  `humadity` double NOT NULL,
  `pressure` double NOT NULL,
  `sea_level` double NOT NULL,
  `temp_day` double NOT NULL,
  `temp_min` double NOT NULL,
  `temp_max` double NOT NULL,
  `wind_deg` double NOT NULL,
  `wind_speed` double NOT NULL,
  `rain_volume` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hours_weather_general_weather` (`gen_weather_id`),
  CONSTRAINT `FK_hours_weather_general_weather` FOREIGN KEY (`gen_weather_id`) REFERENCES `general_weather` (`gen_weather_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hour_weathers`
--

LOCK TABLES `hour_weathers` WRITE;
/*!40000 ALTER TABLE `hour_weathers` DISABLE KEYS */;
/*!40000 ALTER TABLE `hour_weathers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `living_areas`
--

DROP TABLE IF EXISTS `living_areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `living_areas` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `fish_id` int(11) NOT NULL,
  `area_name` varchar(30) COLLATE utf16_bin NOT NULL,
  PRIMARY KEY (`area_id`),
  KEY `FK_living_areas_fishes` (`fish_id`),
  CONSTRAINT `FK_living_areas_fishes` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`fish_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `living_areas`
--

LOCK TABLES `living_areas` WRITE;
/*!40000 ALTER TABLE `living_areas` DISABLE KEYS */;
INSERT INTO `living_areas` VALUES (3,7,'BOTTOM'),(30,30,'MIDDLE'),(31,30,'TOP'),(52,40,'MIDDLE'),(53,40,'TOP'),(58,43,'MIDDLE'),(59,43,'TOP');
/*!40000 ALTER TABLE `living_areas` ENABLE KEYS */;
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
  `period_id` int(11) NOT NULL AUTO_INCREMENT,
  `fish_id` int(11) NOT NULL,
  `start_period` date NOT NULL,
  `end_period` date NOT NULL,
  `nibble_level` double DEFAULT NULL,
  PRIMARY KEY (`period_id`),
  KEY `fish_id` (`fish_id`),
  CONSTRAINT `nibble_periods_ibfk_1` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`fish_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nibble_periods`
--

LOCK TABLES `nibble_periods` WRITE;
/*!40000 ALTER TABLE `nibble_periods` DISABLE KEYS */;
INSERT INTO `nibble_periods` VALUES (13,7,'2016-03-04','2016-05-04',-10),(14,7,'2016-05-05','2016-07-27',-1),(15,7,'2016-07-02','2016-10-30',0),(16,7,'2016-11-01','2016-12-31',-10),(53,30,'2016-05-23','2016-06-01',0),(54,30,'2016-06-02','2016-09-01',53.45),(55,30,'2016-09-02','2016-12-31',89.32),(83,40,'2016-05-23','2016-06-01',0),(84,40,'2016-06-02','2016-09-01',53.45),(85,40,'2016-09-02','2016-12-31',89.32);
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
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf16 COLLATE=utf16_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualifiers`
--

LOCK TABLES `qualifiers` WRITE;
/*!40000 ALTER TABLE `qualifiers` DISABLE KEYS */;
INSERT INTO `qualifiers` VALUES (147,80,'ENVIRMOMENT_TEMPERATURE',18,30),(148,81,'CLOUD_LEVEL',0,100),(149,81,'DEEP_LEVEL',3.5,100),(150,82,'ENVIRMOMENT_TEMPERATURE',25,32),(151,84,'CLOUD_LEVEL',0,65),(152,85,'CLOUD_LEVEL',0,35),(153,84,'DEEP_LEVEL',1.5,3.5),(154,85,'DEEP_LEVEL',0,1.5),(155,86,'CLOUD_LEVEL',65,100),(156,86,'DEEP_LEVEL',2.5,100),(157,88,'ENVIRMOMENT_TEMPERATURE',18,28),(158,86,'ALGA_LEVEL',40,78);
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

-- Dump completed on 2016-07-23 14:07:57
