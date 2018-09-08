CREATE TABLE person
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    age int DEFAULT 0 NOT NULL,
    nb_of_vehicles int DEFAULT 0
);
CREATE UNIQUE INDEX person_id_uindex ON person (id);
