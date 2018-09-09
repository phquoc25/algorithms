CREATE TABLE vehicle
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ownerId int(11) NOT NULL,
    make varchar(100) NOT NULL,
    model varchar(100) NOT NULL,
    CONSTRAINT vehicle_person_id_fk FOREIGN KEY (ownerId) REFERENCES person (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX vehicle_id_uindex ON vehicle (id);