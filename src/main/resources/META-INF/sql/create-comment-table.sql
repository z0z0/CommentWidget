--drop table comment;
create table comment (
id SERIAL PRIMARY KEY,
name CHAR(50),
text CHAR(500),
posted timestamp without time zone)