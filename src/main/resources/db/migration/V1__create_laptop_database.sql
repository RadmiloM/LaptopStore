create table laptop(
id SERIAL ,
name varchar not null,
processor varchar not null,
screen varchar not null,
graphic_card varchar not null,
memory varchar not null,
image varchar,
created_at timestamptz,
color varchar not null,
keyboard varchar not null,
camera boolean not null,
battery varchar not null
);