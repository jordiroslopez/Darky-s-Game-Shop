DROP DATABASE IF EXISTS DarkysGamesShop;
CREATE DATABASE DarkysGamesShop;
USE DarkysGamesShop;

-- ELIMINACION DE TABLAS
DROP TABLE IF EXISTS Videojuego_Categoria;
DROP TABLE IF EXISTS Usuario_Videojuego;
DROP TABLE IF EXISTS Categoria;
DROP TABLE IF EXISTS Videojuego;
DROP TABLE IF EXISTS Usuario;
-- FIN ELIMINACION DE TABLAS

-- CREACION DE TABLAS
CREATE TABLE Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) UNIQUE
);

CREATE TABLE Videojuego (
    id_videojuego INT AUTO_INCREMENT PRIMARY KEY,
    nombre_videojuego VARCHAR(50),
    precio FLOAT
);

CREATE TABLE Videojuego_Categoria (
    id_videojuego INT,
    id_categoria INT,
    CONSTRAINT PK_Videojuego_Categoria PRIMARY KEY (id_videojuego, id_categoria),
    CONSTRAINT FK1_Videojuego FOREIGN KEY(id_videojuego) REFERENCES Videojuego(id_videojuego),
    CONSTRAINT FK2_Categoria FOREIGN KEY(id_categoria) REFERENCES Categoria(id_categoria)
);

CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50),
    contrasena VARCHAR(50),
    email VARCHAR(50),
    esAdmin BOOLEAN DEFAULT FALSE
);

CREATE TABLE Usuario_Videojuego (
    id_usuario INT,
    id_videojuego INT,
    CONSTRAINT PK_Usuario_Videojuego PRIMARY KEY (id_usuario, id_videojuego),
    CONSTRAINT FK1_Usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    CONSTRAINT FK2_Videojuego FOREIGN KEY (id_videojuego) REFERENCES Videojuego(id_videojuego)
);
-- FIN CREACION DE TABLAS

-- INSERTS DE PRUEBA
INSERT INTO Usuario (nombre_usuario, contrasena, email, esAdmin) VALUES
    ("admin", "admin", "admin@gmail.com", TRUE);

INSERT INTO videojuego (nombre_videojuego, precio) VALUES
    ("EA SPORTS FC™ 25 Standard Edition", 69.99),
    ("Grand Theft Auto V: Premium Edition", 29.99),
    ("God of War Ragnarök", 59.99),
    ("Dead by Daylight", 19.99),
    ("Warhammer 40,000: Space Marine 2", 59.99),
    ("Black Myth: Wukong", 59.99),
    ("Alan Wake 2", 49.99),
    ("Borderlands 3", 5.99),
    ("Star Wars Outlaws", 69.99),
    ("Mafia: Trilogy", 14.99),
    ("Tiny Tina's Wonderlands", 11.99),
    ("SnowRunner", 29.99),
    ("Crosshair X", 7.19),
    ("FINAL FANTASY XVI", 49.99),
    ("Sid Meier’s Civilization VI", 5.99),
    ("HITMAN World of Assassination", 27.99),
    ("Frostpunk 2", 44.99),
    ("Satisfactory", 38.99),
    ("EA SPORTS Madden NFL 25", 69.99),
    ("It Takes Two", 13.99),
    ("Football Manager 2024", 59.99),
    ("Ghost of Tsushima DIRECTOR'S CUT", 59.99),
    ("Cyberpunk 2077", 59.99),
    ("Remnant II", 24.99),
    ("BeamNG.drive", 22.39),
    ("Battlefield 2042", 8.99),
    ("Pizza Tower", 13.39),
    ("Prince of Persia: The Lost Crown", 20.00),
    ("Ratchet & Clank: Rift Apart", 30.00),
    ("Red Dead Redemption", 30.00),
    ("Red Dead Redemption 2", 15.00),
    ("Resident Evil 4", 20.00),
    ("The Rise of the Golden Idol", 18.00),
    ("Shin Megami Tensei V Vengeance", 36.00),
    ("Silent Hill 2", 49.00),
    ("Slay the Princess: The Pristine Cut", 13.49),
    ("The Stanley Parable: Ultra Deluxe", 12.49),
    ("Stardew Valley", 9.00),
    ("Street Fighter 6", 30.00),
    ("Sumerian Six", 20.00),
    ("Tactical Breach Wizards", 15.00),
    ("Thank Goodness You're Here", 14.00),
    ("UFO 50", 20.00),
    ("Viewfinder", 12.49);
