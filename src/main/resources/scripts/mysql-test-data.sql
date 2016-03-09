INSERT INTO `fishes` (`id`, `name`, `description`, `type`, `living_area`) VALUES
	(7, 'Carp', 'In Europe, even when not carp angling publications such as Carpolo Advanced carp fishing, Carpworld and Total Carp, and informative carp angling web sites, such as Carpfishing UK', 'CALM', 'BOTTOM'),
	(13, 'Pike', 'Effective methods for catching this teeth it is wise to take extreme remove hooks is highly recommended on safety grounds. If practicing catch and release fishing, \r\ncare for the pike should be the pike angler s utmost concern. The formerly recommended practice of grasping \r\na pike by its eye sockets (tragically interpreted as "its eyes") resulted in countless released pike that.', 'PREDATOR', 'BOTTOM');
	
INSERT INTO `baits` (`id`, `name`, `type`, `description`) VALUES
	(1, 'Worm', 'LIVEBAIT', 'For most biggest calm fish'),
	(2, 'Maggot', 'LIVEBAIT', 'For white calm fish'),
	(3, 'Bloodwarm', 'LIVEBAIT', 'For white calm fish on winter period'),
	(4, 'Corn', 'VEGETALE', 'Traditional bait for calm fish'),
	(5, 'Semolina', 'VEGETALE', 'Effective bait for calm fish'),
	(6, 'Boil', 'BOIL', 'Best for most biggest carp'),
	(7, 'Castmaster', 'SIMULATED', 'Best for pike');

INSERT INTO `bindings_baits_to_fishes` (`id`, `fish_id`, `bait_id`, `is_priority`) VALUES
	(1, 7, 1, b'0'),
	(2, 7, 2, b'0'),
	(3, 7, 4, b'0'),
	(4, 7, 6, b'1'),
	(5, 13, 7, b'0');
	
INSERT INTO `baits_colors` (`id`, `color_name`, `description`, `cloud_min`, `cloud_max`) VALUES
	(1, 'DARK', 'Use dark or soft colors', 0, 15),
	(2, 'NATURAL', 'Use natural colors wich belong to pond', 0, 25),
	(3, 'WHITE', 'Use white colors and lights', 26, 79),
	(4, 'BRIGHT', 'Use bright and lumia colors', 65, 100);

INSERT INTO `baits_mass` (`id`, `name`) VALUES
	(1, 'ULTRALIGHT'),
	(2, 'LIGHT'),
	(3, 'MEDIUM'),
	(4, 'HEAVY'),
	(5, 'ULTRAHEAVY');

INSERT INTO `baits_tastes` (`id`, `taste_name`, `description`, `temp_min`, `temp_max`) VALUES
	(1, 'MEAT', 'For cold water and cjld weather', 0, 10),
	(2, 'FISHED', 'For Otoumn and early Winter', 11, 15),
	(3, 'SPICY', 'For worm water', 16, 20),
	(4, 'FRUIT', 'For hot weather', 21, 35);	
	
INSERT INTO `bindings_baits_to_seasons` (`seasons_id`, `bait_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 4),
	(5, 6);
	
INSERT INTO `parameters_names` (`id`, `name`, `priority_level`) VALUES
	(1, 'CLOUD_LEVEL', 3),
	(2, 'RAIN_LEVEL', 2),
	(3, 'ENVIRMOMENT_TEMPERATURE', NULL),
	(4, 'WATER_TEMPERATURE', NULL),
	(5, 'PRESSURE', NULL),
	(6, 'DEEP_LEVEL', 1),
	(7, 'ALGA_LEVEL', NULL),
	(8, 'WIND_SPEED', NULL);
	
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
	
INSERT INTO `messages` (`id`, `string_key`, `mess_text`) VALUES
	(1, 'STYRO_POP_UP', 'Use the styrofoam for take up your bait under bottom'),
	(2, 'BOIL_POP_UP', 'Use the pop-up boil for take up your bait under bottom'),
	(3, 'TOP_POP_UP', 'Use some stuff for take up your bait on the top water layer');
	
INSERT INTO `pond_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `deep_id`) VALUES
	(1, 6, 0.5, 1.2, 'SHALLOW'),
	(2, 6, 1.3, 1.9, 'MIDDLE'),
	(3, 6, 2, 2.5, 'DEEPLY'),
	(4, 6, 2.5, 5, 'OVERDEEPLY'),
	(5, 7, 0, 12, 'CLEAR'),
	(6, 7, 13, 41, 'OVERGROWN'),
	(7, 7, 42, 100, 'TRASH'),
	(8, 4, 0, 12, 'COLD'),
	(9, 4, 12, 17, 'SOFT'),
	(10, 4, 18, 24, 'WARM'),
	(11, 4, 25, 30, 'HOT');

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

INSERT INTO users (email, password, first_name, last_name, role) VALUES
('mail@mail.com', '$2a$08$.Vib2ZN7L3C3kx.BRAf5xOW8wKNN/v8FFpKSMcV21lfkoSy.ILpRW', 'Bill', 'Montgomery', 'ADMIN'),
('mail1@mail.com', '$2a$08$.Vib2ZN7L3C3kx.BRAf5xOW8wKNN/v8FFpKSMcV21lfkoSy.ILpRW', 'Taller', 'Derdon', 'USER');
	
	
	