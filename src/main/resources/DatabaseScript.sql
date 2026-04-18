DROP DATABASE IF EXISTS Onskeskyprojekt;


CREATE DATABASE OnskeskyProjekt;

USE OnskeskyProjekt;

CREATE TABLE bruger(
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR (200) NOT NULL,
                       kodeord VARCHAR(200) NOT NULL
);

INSERT INTO bruger(username,kodeord) VALUES
    ('Lotto', 'Risotto');


CREATE TABLE onskeseddel(
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            bruger_id INT NOT NULL,
                            FOREIGN KEY(bruger_id) REFERENCES bruger(id),
                            navn VARCHAR(100) NOT NULL,
                            dato VARCHAR (50) NOT NULL
);

INSERT INTO onskeseddel(bruger_id,navn, dato) VALUES
    (1,'Julegaver', '24. December');


CREATE TABLE ønske (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       onskeseddel_id INT NOT NULL,
                       FOREIGN KEY (onskeseddel_id) REFERENCES onskeseddel(id),
                       navn VARCHAR(100) NOT NULL,
                       pris DOUBLE NOT NULL,
                       billed VARCHAR(255) NOT NULL,
                       link VARCHAR(255) NOT NULL,
                       antal INT NOT NULL
);

INSERT INTO onske (onskeseddel_id,navn, pris, billed, link, antal) VALUES
    (1,'Toilet børste', 2000, 'Gave.jpg', 'https://jysk.dk/badevaerelse/badevaerelsestilbehor/toiletborster/toiletboerste-gesunda-mat-glaseret',3);