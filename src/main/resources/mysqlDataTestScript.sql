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



