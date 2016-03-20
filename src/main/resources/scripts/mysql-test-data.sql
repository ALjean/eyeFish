INSERT INTO `fish_types` (`id`, `type_name`) VALUES
	(1, 'CALM'),
	(2, 'PREDATOR'),
	(3, 'OMNIVOROUS');
	
INSERT INTO `living_areas` (`id`, `area_name`) VALUES
	(1, 'TOP'),
	(2, 'MIDDLE'),
	(4, 'BOTTOM'),
	(5, 'EVERPRESENT');
	
INSERT INTO `fishes` (`id`, `name`, `description`, `type_id`, `area_id`) VALUES	
	(7, 'Carp', 'In Europe, even when not fished for food, they are eagerly sought by anglers, being considered highly prized coarse fish', 1, 4),
	(13, 'Pike', 'Effective methods for catching this hard-fighting fish include dead baits', 2, 4);
	
INSERT INTO `parameters_names` (`id`, `parameters_name`, `priority_level`) VALUES
	(1, 'CLOUD_LEVEL', 3),
	(2, 'RAIN_LEVEL', 2),
	(3, 'ENVIRMOMENT_TEMPERATURE', NULL),
	(4, 'WATER_TEMPERATURE', NULL),
	(5, 'PRESSURE', NULL),
	(6, 'DEEP_LEVEL', 1),
	(7, 'ALGA_LEVEL', NULL),
	(8, 'WIND_SPEED', NULL);
	
INSERT INTO `fishe_settings` (`id`, `fish_id`, `parameter_id`, `min_value`, `max_value`, `nibble_level`) VALUES
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

INSERT INTO `bait_types` (`id`, `type_name`) VALUES
	(1, 'LIVEBAIT'),
	(2, 'VEGETALE'),
	(3, 'BOIL'),
	(4, 'SIMULATED'),
	(5, 'SPOONBAIT');
	
INSERT INTO `baits` (`id`, `bait_name`, `type_id`, `description`, `is_color`, `is_taste`, `is_mass`, `is_speed`, `is_deep`) VALUES
	(1, 'Worm', 1, 'For most biggest calm fish', b'0', b'0', b'0', b'0', b'0'),
	(2, 'Maggot', 1, 'For white calm fish', b'1', b'0', b'0', b'0', b'0'),
	(3, 'Bloodwarm', 1, 'For white calm fish on winter period', b'0', b'0', b'0', b'0', b'0'),
	(4, 'Corn', 2, 'Traditional bait for calm fish', b'0', b'1', b'0', b'0', b'0'),
	(5, 'Semolina', 2, 'Effective bait for calm fish', b'1', b'1', b'0', b'0', b'0'),
	(6, 'Boil', 3, 'Best for most biggest carp', b'1', b'1', b'0', b'0', b'0'),
	(7, 'Castmaster', 5, 'Best for pike', b'1', b'0', b'1', b'1', b'0');
	
INSERT INTO `baits_mass` (`id`, `mass_name`, `description`) VALUES
	(1, 'ULTRALIGHT', NULL),
	(2, 'LIGHT', NULL),
	(3, 'MEDIUM', NULL),
	(4, 'HEAVY', NULL),
	(5, 'ULTRAHEAVY', NULL);

INSERT INTO `bait_colors` (`id`, `color_name`, `description`) VALUES
	(1, 'DARK', NULL),
	(2, 'NATURAL', NULL),
	(3, 'WHITE', NULL),
	(4, 'BRIGHT', NULL);
	
INSERT INTO `bait_tastes` (`id`, `taste_name`, `description`) VALUES
	(1, 'MEAT', NULL),
	(2, 'FRUIT', NULL),
	(3, 'SPICY', NULL),
	(4, 'FISH', NULL);
	
INSERT INTO `bait_tastes_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `taste_id`) VALUES
	(1, 3, -50, 10, 1),
	(2, 3, 11, 15, 4),
	(3, 3, 16, 20, 3),
	(4, 3, 21, 35, 2),
	(5, 4, 0, 10, 1),
	(6, 4, 11, 15, 4),
	(7, 4, 16, 20, 3),
	(8, 4, 21, 26, 2);
	
INSERT INTO `bait_colors_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `color_id`) VALUES
	(1, 1, 0, 15, 1),
	(2, 1, 16, 25, 2),
	(3, 1, 26, 79, 3),
	(4, 1, 65, 100, 4),
	(5, 6, 0, 1.2, 1),
	(6, 6, 1.3, 2, 2),
	(7, 6, 2.1, 3.5, 3),
	(8, 6, 3.6, 15, 4),
	(9, 7, 30, 60, 3),
	(10, 7, 61, 100, 4);
	
INSERT INTO `baits_to_fishes` (`id`, `fish_id`, `bait_id`, `is_priority`) VALUES
	(1, 7, 1, b'0'),
	(2, 7, 2, b'0'),
	(3, 7, 4, b'0'),
	(4, 7, 6, b'1'),
	(5, 13, 7, b'0');
	
INSERT INTO `baits_to_seasons` (`id`, `bait_id`, `start_period`, `end_period`) VALUES
	(1, 1, '2016-09-01', '2016-10-31'),
	(2, 1, '2016-04-15', '2016-05-15'),
	(3, 4, '2016-06-01', '2016-08-31'),
	(5, 6, '2016-06-01', '2016-08-31');
	
INSERT INTO `messages` (`id`, `string_key`, `mess_text`) VALUES
	(1, 'STYRO_POP_UP', 'Use the styrofoam for take up your bait under bottom'),
	(2, 'BOIL_POP_UP', 'Use the pop-up boil for take up your bait under bottom'),
	(3, 'TOP_POP_UP', 'Use some stuff for take up your bait on the top water layer');
	
INSERT INTO `pond` (`id`, `parameter_id`, `min_value`, `max_value`, `deep_id`) VALUES
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
	
INSERT INTO `rain_volume` (`id`, `min_mm_level`, `max_mm_level`, `description`) VALUES
	(1, 0.3, 0.5, 'Slight rain'),
	(2, 0.6, 4, 'Moderate rain'),
	(3, 4.1, 8, 'Heavy rain'),
	(4, 8, 100, 'Very heavy rain');
	

	