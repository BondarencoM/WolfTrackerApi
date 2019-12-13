insert into packs(id, name, is_deleted) values
(1, 'New age wolves', false),
(2, 'Grey wolves', false);

insert into wolves(id, birth_date, first_name, gender, last_name, pack_id, longitude, latitude, is_deleted ) values
(1, '2000-03-18', 'Mihail', 'Male', 'Bondarenco',1, 20.34, 35, 0),
(2, '2000-03-08', 'Niklaus', 'Male', 'Colins',1, 67.32, 10.11, 0),
(3, '1800-01-01', 'Ada', 'Female', 'King', 2, null, null, 0),
(4, '1800-01-01', 'Janna', 'Female', 'Arc', null, null, null, 0);

