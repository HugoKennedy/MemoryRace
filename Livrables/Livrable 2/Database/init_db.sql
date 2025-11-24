CREATE TABLE Utilisateurs (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nom VARCHAR(100),
	prenom VARCHAR(100),
	date_naissance DATE,
	email VARCHAR(255),
	password VARCHAR(255),
	permission_level INT
);	

CREATE TABLE Inscriptions (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_course INT NOT NULL,
	id_dossard INT NOT NULL,
	date_inscription DATE
);

CREATE TABLE Detections (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_photo INT NOT NULL,
	id_dossard INT NOT NULL
);

CREATE TABLE Photos (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	date DATE,
	id_course INT NOT NULL,
	latitude FLOAT,
	longitude FLOAT,
	file_path VARCHAR(255)
);

CREATE TABLE Courses (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	date DATE,
	lieu VARCHAR(255),
	nom VARCHAR(255)
);
