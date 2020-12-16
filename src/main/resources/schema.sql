create table if not exists Room (
    id identity not null,
    room_number number not null,
    short_description varchar(250),
    long_description varchar(5000),
    price_per_night decimal(6,2),
    created_at datetime
);

create table if not exists RoomImage (
    id identity not null,
    file_path varchar(250),
    room_id bigint not null
);

create table if not exists Reservation (
    id identity not null,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45),
    phone_num varchar(45),
    check_in_dt date,
    check_out_dt date,
    room_id bigint
);

create table if not exists Users (
    username varchar(250) primary key not null,
    password varchar(250) not null,
    full_name varchar(250) not null,
    enabled boolean not null
);

create table if not exists Authorities (
    username varchar(250) not null,
    authority varchar(250) not null
);

create unique index ix_auth_username on Authorities(username, authority);

alter table RoomImage
    add foreign key (room_id) references Room(id);

alter table Reservation
    add foreign key (room_id) references Room(id);

alter table Authorities
    add foreign key (username) references Users(username);
