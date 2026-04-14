DROP DATABASE IF EXISTS ønskeskyprojekt;


CREATE DATABASE ØnskeskyProjekt;

USE ØnskeskyProjekt;

CREATE TABLE ønske (
id INT AUTO_INCREMENT PRIMARY KEY,
ønskeseddel_id INT NOT NULL,
FOREIGN KEY (ønskeseddel_id) REFERENCES ønskeseddel(id),
navn VARCHAR(100) NOT NULL,
pris DOUBLE NOT NULL,
billed VARCHAR(255) NOT NULL,
link VARCHAR(255) NOT NULL,
antal INT NOT NULL
);

INSERT INTO ønske (navn, pris, billed, link, antal) VALUES
('Toilet børste', 2000, 'Gave.jpg', 'https://jysk.dk/badevaerelse/badevaerelsestilbehor/toiletborster/toiletboerste-gesunda-mat-glaseret',3);

CREATE TABLE ønskeseddel(
id INT AUTO_INCREMENT PRIMARY KEY,
bruger_id INT NOT NULL,
FOREIGN KEY(bruger_id) REFERENCES bruger(id),
navn VARCHAR(100) NOT NULL,
dato VARCHAR (50) NOT NULL
);

INSERT INTO ønskeseddel(navn, dato) VALUES
('Julegaver', '24. December');

CREATE TABLE bruger(
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR (200) NOT NULL,
kodeord VARCHAR(200) NOT NULL
);

INSERT INTO bruger(username,kodeord) VALUES
('Lotto', 'Risotto');
