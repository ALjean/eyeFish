-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.5-10.0.16-MariaDB - mariadb.org binary distribution
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Дамп данных таблицы eyefish.activity_levels: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `activity_levels` DISABLE KEYS */;
INSERT INTO `activity_levels` (`id`, `name`, `min_value`, `max_value`) VALUES
	(1, 'LOW', 0, 23.6),
	(2, 'MIDDLE', 23.7, 52.9),
	(3, 'NORMAL', 53, 72.5),
	(4, 'HEIGHT', 72.6, 100);
/*!40000 ALTER TABLE `activity_levels` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `baits` DISABLE KEYS */;
INSERT INTO `baits` (`id`, `name`, `bait_type`, `description`, `is_color`, `is_taste`, `is_deep`, `is_weight`, `is_speed`) VALUES
	(1, 'worm', 'livebait', 'For most biggest calm fish', b'0', b'0', b'0', b'0', b'0'),
	(2, 'maggot', 'livebait', 'For white calm fish', b'0', b'0', b'0', b'0', b'0'),
	(3, 'bloodwarm', 'livebait', 'For white calm fish on winter period', b'0', b'0', b'0', b'0', b'0'),
	(4, 'corn', 'vegetale', 'Traditional bait for calm fish', b'1', b'1', b'0', b'0', b'0'),
	(5, 'semolina', 'vegetale', 'Effective bait for calm fish', b'0', b'1', b'0', b'0', b'0'),
	(6, 'boil', 'vegetale', 'Best for most biggest carp', b'1', b'1', b'1', b'0', b'0');
/*!40000 ALTER TABLE `baits` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_colors: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `baits_colors` DISABLE KEYS */;
INSERT INTO `baits_colors` (`id`, `color_name`) VALUES
	(1, 'WHITE'),
	(2, 'BRIGHT'),
	(3, 'DARK'),
	(4, 'NATURAL');
/*!40000 ALTER TABLE `baits_colors` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_colors_properties: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `baits_colors_properties` DISABLE KEYS */;
INSERT INTO `baits_colors_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `color_id`) VALUES
	(5, 1, 0, 23.2, 3),
	(6, 1, 23.3, 41.5, 4),
	(7, 1, 41.6, 73.5, 1),
	(8, 1, 73.6, 100, 2),
	(9, 2, 50, 100, 2),
	(11, 6, 3, 5, 2),
	(14, 2, 32, 49, 1);
/*!40000 ALTER TABLE `baits_colors_properties` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_deeps: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `baits_deeps` DISABLE KEYS */;
INSERT INTO `baits_deeps` (`id`, `deep_level`) VALUES
	(1, 'POP_UP'),
	(2, 'TOP'),
	(3, 'MIDDLE'),
	(4, 'BOTTOM');
/*!40000 ALTER TABLE `baits_deeps` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_deep_properties: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `baits_deep_properties` DISABLE KEYS */;
INSERT INTO `baits_deep_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `deep_id`) VALUES
	(1, 7, 0, 25, 3),
	(2, 7, 25, 50, 1),
	(3, 7, 50, 100, 2),
	(4, 6, 0.5, 1, 2),
	(5, 6, 1.1, 2.5, 3),
	(6, 6, 2.6, 10, 4);
/*!40000 ALTER TABLE `baits_deep_properties` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_speeds: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `baits_speeds` DISABLE KEYS */;
INSERT INTO `baits_speeds` (`id`, `speed`) VALUES
	(1, 'slow'),
	(2, 'middle-slow'),
	(3, 'middle-speed'),
	(4, 'speed'),
	(5, 'middle-seed'),
	(6, 'high-speed');
/*!40000 ALTER TABLE `baits_speeds` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_speeds_properties: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `baits_speeds_properties` DISABLE KEYS */;
/*!40000 ALTER TABLE `baits_speeds_properties` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_tastes: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `baits_tastes` DISABLE KEYS */;
INSERT INTO `baits_tastes` (`id`, `taste_name`, `description`, `min_temp_value`, `max_temp_value`) VALUES
	(1, 'MEAT', NULL, 15.5, 19.2),
	(2, 'FISHED', NULL, 15.5, 21.3),
	(3, 'SPICY', NULL, 16.2, 24.6),
	(4, 'FRUIT', NULL, 27.2, 34.5),
	(5, 'SWEET', NULL, 24.1, 27.5);
/*!40000 ALTER TABLE `baits_tastes` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_tastes_properties: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `baits_tastes_properties` DISABLE KEYS */;
INSERT INTO `baits_tastes_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `taste_id`) VALUES
	(1, 3, -40, 12, 1),
	(2, 3, 13, 16, 2),
	(3, 3, 12, 16, 3),
	(4, 3, 17, 22, 5),
	(5, 3, 23, 28, 3),
	(6, 3, 29, 36, 4),
	(7, 3, 36, 50, NULL);
/*!40000 ALTER TABLE `baits_tastes_properties` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.baits_weights: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `baits_weights` DISABLE KEYS */;
INSERT INTO `baits_weights` (`id`, `name`) VALUES
	(1, 'heavy'),
	(2, 'medium'),
	(3, 'light'),
	(4, 'ultralight');
/*!40000 ALTER TABLE `baits_weights` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.bindings_baits_to_fishes: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `bindings_baits_to_fishes` DISABLE KEYS */;
INSERT INTO `bindings_baits_to_fishes` (`id`, `fish_id`, `bait_id`, `activity_id`) VALUES
	(1, 7, 1, 4),
	(2, 7, 2, 3),
	(3, 7, 4, 2),
	(4, 7, 6, 1);
/*!40000 ALTER TABLE `bindings_baits_to_fishes` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.daily_forecast_weathers: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `daily_forecast_weathers` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_forecast_weathers` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.day_phases: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `day_phases` DISABLE KEYS */;
/*!40000 ALTER TABLE `day_phases` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.fishes: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `fishes` DISABLE KEYS */;
INSERT INTO `fishes` (`id`, `name`, `description`, `fish_type`, `living_area`) VALUES
	(7, 'Carp', 'In Europe, even when not fished for food, they are eagerly sought by anglers, being considered highly prized coarse fish that are difficult to hook.[29] The UK has a thriving carp angling market. It is the fastest growing angling market in the UK, and has spawned a number of specialised carp angling publications such as Carpology,[30] Advanced carp fishing, Carpworld and Total Carp, and informative carp angling web sites, such as Carpfishing UK', NULL, NULL),
	(13, 'Pike', 'Effective methods for catching this hard-fighting fish include dead baits, live baits, and lure fishing. \r\nPike can easily be damaged when handled since they are not as robust as their reputation would suggest. \r\nColour of lure can be influenced by water clarity and weather conditions. Since pike have numerous sharp \r\nteeth it is wise to take extreme care when unhooking them. The use of a wet leather gauntlet and surgical \r\nforceps to remove hooks is highly recommended on safety grounds. If practicing catch and release fishing, \r\ncare for the pike should be the pike angler s utmost concern. The formerly recommended practice of grasping \r\na pike by its eye sockets (tragically interpreted as "its eyes") resulted in countless released pike that \r\nquickly died from inability to see prey any longer.', NULL, NULL);
/*!40000 ALTER TABLE `fishes` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.fishes_nibble_properties: ~25 rows (приблизительно)
/*!40000 ALTER TABLE `fishes_nibble_properties` DISABLE KEYS */;
INSERT INTO `fishes_nibble_properties` (`id`, `fish_id`, `parameter_id`, `min_value`, `max_value`, `nibble_level`) VALUES
	(38, 7, 3, -50, -4, 0),
	(39, 7, 3, -5, 12, 15.5),
	(40, 7, 3, 12, 16, 21.2),
	(41, 7, 3, 17, 20, 38.23),
	(42, 7, 3, 21, 26, 88.3),
	(43, 7, 3, 20, 26, 88.3),
	(44, 7, 3, 27, 31, 52.3),
	(45, 7, 3, 32, 36, 21.8),
	(46, 7, 3, 37, 48, 5.4),
	(53, 7, 5, 710, 725, 5.2),
	(54, 7, 5, 726, 740, 38.9),
	(55, 7, 5, 741, 752, 86.3),
	(56, 7, 5, 753, 765, 26.3),
	(70, 13, 3, -50, -4, 0),
	(71, 13, 3, -4, 12, 45.3),
	(72, 13, 3, 13, 16, 80.2),
	(73, 13, 3, 17, 20, 89.23),
	(74, 13, 3, 21, 26, 75.3),
	(76, 13, 3, 27, 31, 33.3),
	(77, 13, 3, 32, 36, 15.8),
	(78, 13, 3, 37, 48, 5.4),
	(85, 13, 5, 710, 725, 5.2),
	(86, 13, 5, 726, 740, 23.87),
	(87, 13, 5, 741, 752, 26.3),
	(88, 13, 5, 753, 765, 96.3);
/*!40000 ALTER TABLE `fishes_nibble_properties` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.parameters_names: ~8 rows (приблизительно)
/*!40000 ALTER TABLE `parameters_names` DISABLE KEYS */;
INSERT INTO `parameters_names` (`id`, `parameters_name`, `priority_level`) VALUES
	(1, 'CLOUD_LEVEL', 3),
	(2, 'RAIN_LEVEL', 2),
	(3, 'ENVIRMOMENT_TEMPERATURE', NULL),
	(4, 'WATER_TEMPERATURE', NULL),
	(5, 'PRESSURE', NULL),
	(6, 'DEEP_LEVEL', 1),
	(7, 'ALGA_LEVEL', NULL),
	(8, 'WIND_SPEED', NULL);
/*!40000 ALTER TABLE `parameters_names` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.seasons: ~11 rows (приблизительно)
/*!40000 ALTER TABLE `seasons` DISABLE KEYS */;
INSERT INTO `seasons` (`id`, `description`, `start_period`, `end_period`) VALUES
	(1, 'WINTER_MIDDLE', '2016-01-01', '2016-01-30'),
	(2, 'WINTER_END', '2016-02-01', '2016-02-29'),
	(3, 'SPRING_EARLY', '2016-03-01', '2016-03-31'),
	(4, 'SPRING_MIDDLE', '2016-04-01', '2016-04-30'),
	(5, 'SPRING_END', '2016-05-01', '2016-05-31'),
	(6, 'SUMMER_EARLY', '2016-06-01', '2016-06-30'),
	(7, 'SUMMER_MIDDLE', '2016-07-01', '2016-07-30'),
	(8, 'SUMMER_END', '2016-08-01', '2016-08-31'),
	(9, 'OTOUMN_EARLY', '2016-09-01', '2016-09-30'),
	(10, 'OTOUMN_MIDDLE', '2016-10-01', '2016-10-31'),
	(11, 'OTOUMN_END', '2016-11-01', '2016-11-30'),
	(12, 'WINTER_EARLY', '2016-12-01', '2016-12-31');
/*!40000 ALTER TABLE `seasons` ENABLE KEYS */;

-- Дамп данных таблицы eyefish.year_periods: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `year_periods` DISABLE KEYS */;
/*!40000 ALTER TABLE `year_periods` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
