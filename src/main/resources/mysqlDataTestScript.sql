
INSERT INTO fish (id, name, description, fish_type) VALUES (
7,
'Carp',
'In Europe, even when not fished for food, they are eagerly sought by anglers, 
being considered highly prized coarse fish that are difficult to hook. The UK has a thriving 
carp angling market. It is the fastest growing angling market in the UK, and has spawned a number 
of specialised carp angling publications such as Carpology,[30] Advanced carp fishing, Carpworld and 
Total Carp, and informative carp angling web sites, such as Carpfishing UK', 
'calmfish'
);
INSERT INTO fish (id, name, description, fish_type) VALUES (
13,
'Pike',
'Effective methods for catching this hard-fighting fish include dead baits, live baits, and lure fishing. 
Pike can easily be damaged when handled since they are not as robust as their reputation would suggest. 
Colour of lure can be influenced by water clarity and weather conditions. Since pike have numerous sharp 
teeth it is wise to take extreme care when unhooking them. The use of a wet leather gauntlet and surgical 
forceps to remove hooks is highly recommended on safety grounds. If practicing catch and release fishing, 
care for the pike should be the pike angler s utmost concern. The formerly recommended practice of grasping 
a pike by its eye sockets (tragically interpreted as "its eyes") resulted in countless released pike that 
quickly died from inability to see prey any longer.', 
'predatorfish'
);

INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', -50, -4, 0);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', -4, 12, 15.5);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', 12, 16, 21.2);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', 16, 20, 38.23);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', 20, 26, 88.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', 20, 26, 88.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', 26, 31, 52.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', 31, 36, 21.8);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'ENVIROMENT_TEMPERATURE', 36, 48, 5.4);

INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'WATER_TEMPERATURE', -4, 10, 5.4);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'WATER_TEMPERATURE', 10, 16, 32.8);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'WATER_TEMPERATURE', 16, 22, 76.2);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'WATER_TEMPERATURE', 22, 26, 88.9);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'WATER_TEMPERATURE', 26, 32, 23.5);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'WATER_TEMPERATURE', 32, 48, 0);

INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'PRESSURE', 710, 725, 5.2);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'PRESSURE', 725, 740, 38.9);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'PRESSURE', 745, 752, 86.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(7, 'PRESSURE', 752, 765, 26.3);

INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', -50, -4, 0);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', -4, 12, 45.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', 12, 16, 80.2);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', 16, 20, 89.23);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', 20, 26, 75.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', 20, 26, 65.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', 26, 31, 33.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', 31, 36, 15.8);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'ENVIROMENT_TEMPERATURE', 36, 48, 5.4);

INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'WATER_TEMPERATURE', -4, 10, 5.4);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'WATER_TEMPERATURE', 10, 16, 58.36);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'WATER_TEMPERATURE', 16, 22, 89.2);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'WATER_TEMPERATURE', 22, 26, 62.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'WATER_TEMPERATURE', 26, 32, 12.8);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'WATER_TEMPERATURE', 32, 48, 0);

INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'PRESSURE', 710, 725, 5.2);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'PRESSURE', 725, 740, 23.87);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'PRESSURE', 745, 752, 26.3);
INSERT INTO fish_parameters (fish_id, state_data_type, min_range_value, max_range_value, result_nibble_value)VALUES(13, 'PRESSURE', 752, 765, 96.3);


INSERT INTO bait (bait_type, name, description)VALUES
( 'livebait', 'warm', 'For most biggest calm fish'),
( 'vegetale', 'maggot', 'For white calm fish'),
( 'vegetale', 'bloodwarm', 'For white calm fish on winter period'),
( 'vegetale', 'corn', 'Traditional bait for calm fish'),
( 'vegetale', 'semolina', 'Effective bait for calm fish'),
( 'vegetale', 'boil', 'Best for most biggest carp');

INSERT INTO bait_color (name)VALUES
('white_colors'),
('bright_colors'),
('dark_colors'),
('natural_colors');

INSERT INTO bait_taste (name)VALUES
('sweet'),
('sold'),
('spicy'),
('meat'),
('vanilla');

INSERT INTO bait_weight (name)VALUES
('heavy'),
('medium'),
('light'),
('ultralight');

INSERT INTO weather_feed_prefer (bait_id, taste, min_temp, max_temp)VALUES
(null, null, -40.00, 6.00),
(1, null, 7.00, 16.00),
(6, 'MEAT', 7.00, 16.00),
(2, null, 7.00, 16.00),
(3, null, 7.00, 16.00),
(6, 'MEAT', 17.00, 22.00),
(6, 'SPICY', 17.00, 22.00),
(4, 'SWEET', 17.00, 22.00),
(6, 'SWEET', 23.00, 28.00),
(4, 'SPICY', 23.00, 28.00),
(6, 'VANILLA', 23.00, 28.00),
(6, 'SWEET', 29.00, 35.00),
(null, null, 36.00, 45.00);

INSERT INTO season_feed_prefer (bait_id, taste, start_period, end_period)VALUES
(null, null, '2016-01-01', '2016-04-30'),
(1, null, '2016-05-01', '2016-06-01'),
(6, 'MEAT', '2016-05-01', '2016-06-01'),
(2, null, '2016-05-01', '2016-06-01'),
(3, null, '2016-05-01', '2016-06-01'),
(6, 'SPICY', '2016-05-01', '2016-06-01'),
(4, 'SWEET', '2016-06-01', '2016-07-31'),
(4, 'VANILLA', '2016-06-01', '2016-07-31'),
(6, 'SWEET', '2016-06-01', '2016-07-31'),
(6, 'VANILLA', '2016-06-01', '2016-07-31'),
(6, 'MEAT', '2016-07-01', '2016-08-15'),
(2, null, '2016-07-01', '2016-08-15'),
(3, null, '2016-07-01', '2016-08-15'),
(4, 'SPICY', '2016-07-01', '2016-08-15'),
(4, 'SPICY', '2016-07-01', '2016-08-15'),
(6, 'MEAT', '2016-08-16', '2016-10-30'),
(1, null, '2016-08-16', '2016-10-30'),
(null, null, '2016-11-01', '2016-12-31');

INSERT INTO bait_binding (fish_id, bait_id)VALUES 
(7,1),
(7,2),
(7,3),
(7,4),
(7,5),
(7,6);
