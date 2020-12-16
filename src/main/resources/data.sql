delete from RoomImage;
delete from Reservation;
delete from Room;
delete from Users;

insert into Room(id, room_number, short_description, long_description, price_per_night, created_at)
values ( 1, 101, 'Logement pour les amoureux', 'Logement très aéré avec ouverture la vallée...', 49, '2020-10-29 14:56:59' );
insert into Room(id, room_number, short_description, long_description, price_per_night, created_at)
values ( 2, 102, 'Suite présidentielle pour amoureux', 'Logement très aéré avec ouverture la vallée...', 45, '2020-10-29 14:56:59' );
insert into Room(id, room_number, short_description, long_description, price_per_night, created_at)
values ( 3, 103, 'Suite très calme', 'Logement très aéré avec ouverture la vallée...', 49, '2020-10-29 14:56:59' );
insert into Room(id, room_number, short_description, long_description, price_per_night, created_at)
values ( 4, 104, 'Chambre idéale pour un séjour très court', 'Logement très aéré avec ouverture la vallée...', 33, '2020-10-29 14:56:59' );
insert into Room(id, room_number, short_description, long_description, price_per_night, created_at)
values ( 5, 105, 'Chambre avec lit très grand', 'Idéale pour deux personnes sur une longue durée', 89, '2020-10-29 14:56:59' );
insert into Room(id, room_number, short_description, long_description, price_per_night, created_at)
values ( 6, 106, 'Chambre très belle et très lumineuse', 'Logement très aéré avec ouverture la vallée...', 69, '2020-10-29 14:56:59' );



insert into RoomImage (id, file_path, room_id)
values (1, 'IMG_ROOM_001/IMG_001.jpg', 1);
insert into RoomImage (id, file_path, room_id)
values (2, 'IMG_ROOM_001/IMG_002.jpg', 1);
insert into RoomImage (id, file_path, room_id)
values (3, 'IMG_ROOM_001/IMG_003.jpg', 1);
insert into RoomImage (id, file_path, room_id)
values (4, 'IMG_ROOM_001/IMG_004.jpg', 1);
insert into RoomImage (id, file_path, room_id)
values (5, 'IMG_ROOM_001/IMG_005.jpg', 1);

insert into RoomImage (id, file_path, room_id)
values (6, 'IMG_ROOM_002/IMG_001.jpg', 2);
insert into RoomImage (id, file_path, room_id)
values (7, 'IMG_ROOM_002/IMG_002.jpg', 2);
insert into RoomImage (id, file_path, room_id)
values (8, 'IMG_ROOM_002/IMG_003.jpg', 2);
insert into RoomImage (id, file_path, room_id)
values (9, 'IMG_ROOM_002/IMG_004.jpg', 2);
insert into RoomImage (id, file_path, room_id)
values (10, 'IMG_ROOM_002/IMG_005.jpg', 2);


insert into RoomImage (id, file_path, room_id)
values (11, 'IMG_ROOM_003/IMG_001.jpg', 3);
insert into RoomImage (id, file_path, room_id)
values (12, 'IMG_ROOM_003/IMG_002.jpg', 3);
insert into RoomImage (id, file_path, room_id)
values (13, 'IMG_ROOM_003/IMG_003.jpg', 3);
insert into RoomImage (id, file_path, room_id)
values (14, 'IMG_ROOM_003/IMG_004.jpg', 3);
insert into RoomImage (id, file_path, room_id)
values (15, 'IMG_ROOM_003/IMG_005.jpg', 3);

insert into RoomImage (id, file_path, room_id)
values (16, 'IMG_ROOM_004/IMG_001.jpg', 4);
insert into RoomImage (id, file_path, room_id)
values (17, 'IMG_ROOM_004/IMG_002.jpg', 4);
insert into RoomImage (id, file_path, room_id)
values (18, 'IMG_ROOM_004/IMG_003.jpg', 4);
insert into RoomImage (id, file_path, room_id)
values (19, 'IMG_ROOM_004/IMG_004.jpg', 4);
insert into RoomImage (id, file_path, room_id)
values (20, 'IMG_ROOM_004/IMG_005.jpg', 4);

insert into RoomImage (id, file_path, room_id)
values (21, 'IMG_ROOM_005/IMG_001.jpg', 5);
insert into RoomImage (id, file_path, room_id)
values (22, 'IMG_ROOM_005/IMG_002.jpg', 5);
insert into RoomImage (id, file_path, room_id)
values (23, 'IMG_ROOM_005/IMG_003.jpg', 5);
insert into RoomImage (id, file_path, room_id)
values (24, 'IMG_ROOM_005/IMG_004.jpg', 5);
insert into RoomImage (id, file_path, room_id)
values (25, 'IMG_ROOM_005/IMG_005.jpg', 5);

insert into RoomImage (id, file_path, room_id)
values (26, 'IMG_ROOM_006/IMG_001.jpg', 6);
insert into RoomImage (id, file_path, room_id)
values (27, 'IMG_ROOM_006/IMG_002.jpg', 6);
insert into RoomImage (id, file_path, room_id)
values (28, 'IMG_ROOM_006/IMG_003.jpg', 6);
insert into RoomImage (id, file_path, room_id)
values (29, 'IMG_ROOM_006/IMG_004.jpg', 6);
insert into RoomImage (id, file_path, room_id)
values (30, 'IMG_ROOM_006/IMG_005.jpg', 6);

insert into Users (username, password, full_name, enabled)
values ('wang', '$2y$10$RecpQawvdfW6xgMOJjHMWeUa8iSto4bNdJKcM2Jk1LuIARbNZDUJ.', 'Wangari Matai', true);
insert into Users (username, password, full_name, enabled)
values ('okel', '$2y$10$xmmViU82UL2h5SeXa/i6lunIsvGeHvCe8X5B7ba2v9Wl.r4KVJhUy', 'Okelo Matao', true);

insert into Authorities (username, authority)
values ('wang', 'ROLE_ADMIN');

insert into Authorities (username, authority)
values ('okel', 'ROLE_ADMIN');