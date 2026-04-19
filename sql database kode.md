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
navn VARCHAR(100) NOT NULL,
dato DATE NOT NULL
);

INSERT INTO onskeseddel(navn, dato) VALUES
('Julegaver', '2026-12-24'),
('Fødselsdag', '2026-10-18');


CREATE TABLE onske (
id INT AUTO_INCREMENT PRIMARY KEY,
onskeseddel_id INT NOT NULL,
FOREIGN KEY (onskeseddel_id) REFERENCES onskeseddel(id) ON DELETE CASCADE,
navn VARCHAR(100) NOT NULL,
pris DOUBLE NOT NULL,
billed VARCHAR(255) NOT NULL,
link VARCHAR(255) NOT NULL,
antal INT NOT NULL
);

INSERT INTO onske (onskeseddel_id,navn, pris, billed, link, antal) VALUES
(1,'Toilet børste', 2000, 'Gave.jpg', 'https://jysk.dk/badevaerelse/badevaerelsestilbehor/toiletborster/toiletboerste-gesunda-mat-glaseret',3),
(2,'AWP printstream', 2222, 'Gave.jpg', 'https://jysk.dk/badevaerelse/badevaerelsestilbehor/toiletborster/toiletboerste-gesunda-mat-glaseret',3);

INSERT INTO onske (onskeseddel_id,navn, pris, billed, link, antal) VALUES
(1,'Toilet børste', 2000, 'Gave.jpg', 'https://jysk.dk/badevaerelse/badevaerelsestilbehor/toiletborster/toiletboerste-gesunda-mat-glaseret',3);
