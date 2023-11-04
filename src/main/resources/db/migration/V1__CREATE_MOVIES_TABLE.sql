CREATE SEQUENCE movies_table_id_seq;

CREATE TABLE movies(
    id BIGINT primary key DEFAULT nextval('movies_table_id_seq'),
    title varchar(255),
    description varchar(255),
    release_date timestamp,
    director_name varchar(255),
    version INTEGER
);
