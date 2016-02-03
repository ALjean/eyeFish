#Insert test dates into eyeFish

INSERT INTO fish (name, description, type) VALUES (
'Carp',
'In Europe, even when not fished for food, they are eagerly sought by anglers, 
being considered highly prized coarse fish that are difficult to hook. The UK has a thriving 
carp angling market. It is the fastest growing angling market in the UK, and has spawned a number 
of specialised carp angling publications such as Carpology,[30] Advanced carp fishing, Carpworld and 
Total Carp, and informative carp angling web sites, such as Carpfishing UK', 
'calmfish'
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

INSERT INTO bait (fish_id, bait_type, name, description)VALUES
(7, 'livebait', 'warm', 'For most biggest calm fish'),
(7, 'vegetale', 'maggot', 'For white calm fish'),
(7, 'vegetale', 'bloodwarm', 'For white calm fish on winter period'),
(7, 'vegetale', 'corn', 'Traditional bait for calm fish'),
(7, 'vegetale', 'semolina', 'Effective bait for calm fish')
(7, 'vegetale', 'boil', 'Best for most biggest carp');

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

INSERT INTO weather_feed_prefer (bait_id, fish_id, taste, min_temp, max_temp)VALUES
(null, 7, null, -40.00, 6.00),
(1, 7, null, 7.00, 16.00),
(6, 7, 'MEAT', 7.00, 16.00),
(2, 7, null, 7.00, 16.00),
(3, 7, null, 7.00, 16.00),
(6, 7, 'MEAT', 17.00, 22.00),
(6, 7, 'SPICY', 17.00, 22.00),
(4, 7, 'SWEET', 17.00, 22.00),
(6, 7, 'SWEET', 23.00, 28.00),
(4, 7, 'SPICY', 23.00, 28.00),
(6, 7, 'VANILLA', 23.00, 28.00),
(6, 7, 'SWEET', 29.00, 35.00),
(null, 7, null, 36.00, 45.00);

INSERT INTO season_feed_prefer (bait_id, fish_id, taste, start_period, end_period)VALUES
(null, 7, null, '2016-01-01', '2016-04-30'),
(1, 7, null, '2016-05-01', '2016-06-01'),
(6, 7, 'MEAT', '2016-05-01', '2016-06-01'),
(2, 7, null, '2016-05-01', '2016-06-01'),
(3, 7, null, '2016-05-01', '2016-06-01'),
(6, 7, 'SPICY', '2016-05-01', '2016-06-01'),
(4, 7, 'SWEET', '2016-06-01', '2016-07-31'),
(4, 7, 'VANILLA', '2016-06-01', '2016-07-31'),
(6, 7, 'SWEET', '2016-06-01', '2016-07-31'),
(6, 7, 'VANILLA', '2016-06-01', '2016-07-31'),
(6, 7, 'MEAT', '2016-07-01', '2016-08-15'),
(2, 7, null, '2016-07-01', '2016-08-15'),
(3, 7, null, '2016-07-01', '2016-08-15'),
(4, 7, 'SPICY', '2016-07-01', '2016-08-15'),
(4, 7, 'SPICY', '2016-07-01', '2016-08-15'),
(6, 7, 'MEAT', '2016-08-16', '2016-10-30'),
(1, 7, null, '2016-08-16', '2016-10-30'),
(null, 7, null, '2016-11-01', '2016-12-31');





