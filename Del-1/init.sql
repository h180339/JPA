

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;


CREATE TABLE ansatt
(
	aId	serial primary key,
	Brukernavn VARCHAR(4),
	Fornavn VARCHAR(100),
	Etternavn VARCHAR(100),
	DatoAns DATE,
	Stilling VARCHAR(100),
	Maanedslonn INTEGER,
	avdelingId INTEGER NOT NULL
--	Prosjekter VARCHAR(100)

);

CREATE TABLE Avdeling
(
	avdelingId serial primary key,
	navn VARCHAR(100),
	aId INTEGER NOT NULL,
	CONSTRAINT ansattFK FOREIGN KEY (aId) REFERENCES ansatt(aId)

);

INSERT INTO ansatt(Brukernavn, Fornavn, Etternavn, DatoAns, Stilling, Maanedslonn, avdelingId)
VALUES
	('EA', 'Eirik', 'Eirik', '2017-08-14', 'being best', 12345, 1),
	('OE', 'Orjan', 'Orjan', '2029-08-14', 'best programmer', 21, 1),
	('JA', 'Joakim', 'Joakim', '2028-08-14', 'ok programmer', 22, 1),
	('KA', 'Knut', 'Knut', '2028-08-14', 'Vaskehjelp', 26, 2),
	('JS', 'Jarle', 'Jarle', '2028-08-14', 'Vaskehjelp', 25, 2),
	('HT', 'Harald', 'Harald', '2028-08-14', 'Vaskesjef', 22, 2),
	('SA', 'Sindre', 'Sindre', '2028-08-14', 'IT hjelp', 22, 3),
	('JS', 'Josef', 'Josef', '2028-08-14', 'IT hjelp', 22, 3),
	('FI', 'Fredrik', 'Fredrik', '2028-08-14', 'IT sjef', 22, 3);

INSERT INTO Avdeling (navn, aId)
VALUES
	('Programering', 1),
	('Vasking', 6),
	('IT hjelp', 9);

ALTER TABLE oblig3.ansatt
ADD CONSTRAINT avdelingFK FOREIGN KEY (avdelingId) REFERENCES avdeling(avdelingId);



