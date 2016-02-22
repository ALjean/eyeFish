
INSERT INTO `activity_levels` (`id`, `name`, `min_value`, `max_value`) VALUES
	(1, 'LOW', 0, 23.6),
	(2, 'MIDDLE', 23.7, 52.9),
	(3, 'NORMAL', 53, 72.5),
	(4, 'HEIGHT', 72.6, 100);

INSERT INTO `baits` (`id`, `name`, `bait_type`, `description`, `is_color`, `is_taste`, `is_deep`, `is_weight`, `is_speed`) VALUES
	(1, 'worm', 1, 'For most biggest calm fish', b'0', b'0', b'0', b'0', b'0'),
	(2, 'maggot', 1, 'For white calm fish', b'0', b'0', b'0', b'0', b'0'),
	(3, 'bloodwarm', 1, 'For white calm fish on winter period', b'0', b'0', b'0', b'0', b'0'),
	(4, 'corn', 2, 'Traditional bait for calm fish', b'1', b'1', b'0', b'0', b'0'),
	(5, 'semolina', 2, 'Effective bait for calm fish', b'0', b'1', b'0', b'0', b'0'),
	(6, 'boil', 2, 'Best for most biggest carp', b'1', b'1', b'1', b'0', b'0'),
	(7, 'castmaster', 3, 'Best for pike', b'1', b'0', b'0', b'1', b'1');

INSERT INTO `baits_colors` (`id`, `color_name`) VALUES
	(1, 'WHITE'),
	(2, 'BRIGHT'),
	(3, 'DARK'),
	(4, 'NATURAL');

INSERT INTO `baits_colors_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `color_id`) VALUES
	(5, 1, 0, 23.2, 3),
	(6, 1, 23.3, 41.5, 4),
	(7, 1, 41.6, 73.5, 1),
	(8, 1, 73.6, 100, 2);

INSERT INTO `baits_deeps` (`id`, `deep_level`) VALUES
	(1, 'SHALLOW'),
	(2, 'MIDDLE'),
	(3, 'DEEPLY'),
	(4, 'OVERDEEPLY');

INSERT INTO `baits_deeps_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `deep_id`) VALUES
	(1, 6, 0.5, 1.2, 1),
	(2, 6, 1.3, 1.9, 2),
	(3, 6, 2, 2.5, 3),
	(4, 6, 2.5, 5, 4);

INSERT INTO `baits_mass` (`id`, `name`) VALUES
	(1, 'ULTRALIGHT'),
	(2, 'LIGHT'),
	(3, 'MEDIUM'),
	(4, 'HEAVY'),
	(5, 'ULTRAHEAVY'),
	(6, 'POP-UP');

INSERT INTO `baits_mass_properties` (`id`, `parameter_id`, `boffort_min`, `boffort_max`, `mass_id`) VALUES
	(1, 8, 0, 2, 1),
	(2, 8, 3, 4, 2),
	(3, 8, 5, 6, 3),
	(4, 8, 7, 8, 4),
	(5, 8, 9, 11, 5);

INSERT INTO `baits_speeds` (`id`, `speed`) VALUES
	(1, 'ULTRAFAST'),
	(2, 'FAST'),
	(3, 'MIDDLESLOW'),
	(4, 'SLOW');

INSERT INTO `baits_tastes` (`id`, `taste_name`, `description`) VALUES
	(1, 'MEAT', NULL),
	(2, 'FISHED', NULL),
	(3, 'SPICY', NULL),
	(4, 'FRUIT', NULL),
	(5, 'SWEET', NULL);

INSERT INTO `baits_tastes_properties` (`id`, `parameter_id`, `min_value`, `max_value`, `taste_id`) VALUES
	(1, 3, -40, 12, 1),
	(2, 3, 13, 16, 2),
	(3, 3, 12, 16, 3),
	(4, 3, 17, 22, 5),
	(5, 3, 23, 28, 3),
	(6, 3, 29, 36, 4),
	(7, 3, 36, 50, NULL);

INSERT INTO `baits_types` (`id`, `type_names`) VALUES
	(1, 'LIVEBAIT'),
	(2, 'VEGETALE'),
	(3, 'SPOONBAIT'),
	(4, 'SIMULATED');

INSERT INTO `bindings_baits_to_fishes` (`id`, `fish_id`, `bait_id`, `activity_id`) VALUES
	(1, 7, 1, 4),
	(2, 7, 2, 3),
	(3, 7, 4, 2),
	(4, 7, 6, 1),
	(5, 13, 7, 2);

INSERT INTO `binding_mass_to_baits` (`id`, `bait_id`, `min_weight`, `max_weight`, `mass_id`) VALUES
	(1, 7, 2, 5, 1),
	(2, 7, 6, 12, 2),
	(3, 7, 13, 18, 3),
	(4, 7, 19, 25, 4),
	(5, 7, 26, 35, 5);

INSERT INTO `fishes` (`id`, `name`, `description`, `fish_type`, `living_area`) VALUES
	(7, 'Carp', 'In Europe, even when not fished for food, they are eagerly sought by anglers, being considered highly prized coarse fish that are difficult to hook.[29] The UK has a thriving carp angling market. It is the fastest growing angling market in the UK, and has spawned a number of specialised carp angling publications such as Carpology,[30] Advanced carp fishing, Carpworld and Total Carp, and informative carp angling web sites, such as Carpfishing UK', 1, 3),
	(13, 'Pike', 'Effective methods for catching this hard-fighting fish include dead baits, live baits, and lure fishing. \r\nPike can easily be damaged when handled since they are not as robust as their reputation would suggest. \r\nColour of lure can be influenced by water clarity and weather conditions. Since pike have numerous sharp \r\nteeth it is wise to take extreme care when unhooking them. The use of a wet leather gauntlet and surgical \r\nforceps to remove hooks is highly recommended on safety grounds. If practicing catch and release fishing, \r\ncare for the pike should be the pike angler s utmost concern. The formerly recommended practice of grasping \r\na pike by its eye sockets (tragically interpreted as "its eyes") resulted in countless released pike that \r\nquickly died from inability to see prey any longer.', 2, 3);
;
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

INSERT INTO `fish_types` (`id`, `type_name`) VALUES
	(1, 'CALM'),
	(2, 'PREDATOR'),
	(3, 'SHUFFLE');

INSERT INTO `living_areas` (`id`, `area_name`) VALUES
	(1, 'TOP'),
	(2, 'MIDDLE'),
	(3, 'BOTTOM'),
	(4, 'EVERPRESENT');

INSERT INTO `parameters_names` (`id`, `parameters_name`, `priority_level`) VALUES
	(1, 'CLOUD_LEVEL', 3),
	(2, 'RAIN_LEVEL', 2),
	(3, 'ENVIRMOMENT_TEMPERATURE', NULL),
	(4, 'WATER_TEMPERATURE', NULL),
	(5, 'PRESSURE', NULL),
	(6, 'DEEP_LEVEL', 1),
	(7, 'ALGA_LEVEL', NULL),
	(8, 'WIND_SPEED', NULL);

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

