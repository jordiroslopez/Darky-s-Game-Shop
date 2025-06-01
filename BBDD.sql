-- CREACION DE BASE DE DATOS
DROP DATABASE IF EXISTS DarkysGamesShop;
CREATE DATABASE DarkysGamesShop;
USE DarkysGamesShop;

-- ELIMINACION DE TABLAS
DROP TABLE IF EXISTS Videojuego_Categoria;
DROP TABLE IF EXISTS Usuario_Videojuego;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Videojuego;
DROP TABLE IF EXISTS Categoria;

-- CREACION DE TABLAS
CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50),
    contrasena VARCHAR(50),
    email VARCHAR(50),
    esAdmin BOOLEAN DEFAULT FALSE
);

CREATE TABLE Videojuego (
    id_videojuego INT AUTO_INCREMENT PRIMARY KEY,
    nombre_videojuego VARCHAR(50),
    precio FLOAT
);

CREATE TABLE Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) UNIQUE
);

CREATE TABLE Videojuego_Categoria (
    id_videojuego INT,
    id_categoria INT,
    CONSTRAINT PK_Videojuego_Categoria PRIMARY KEY (id_videojuego, id_categoria),
    CONSTRAINT FK1_Videojuego FOREIGN KEY(id_videojuego) REFERENCES Videojuego(id_videojuego),
    CONSTRAINT FK2_Categoria FOREIGN KEY(id_categoria) REFERENCES Categoria(id_categoria)
);

CREATE TABLE Usuario_Videojuego (
    id_usuario INT,
    id_videojuego INT,
    CONSTRAINT PK_Usuario_Videojuego PRIMARY KEY (id_usuario, id_videojuego),
    CONSTRAINT FK1_Usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    CONSTRAINT FK2_Videojuego FOREIGN KEY (id_videojuego) REFERENCES Videojuego(id_videojuego)
);

-- INSERTAR USUARIO ADMIN
INSERT INTO Usuario (nombre_usuario, contrasena, email, esAdmin) VALUES
    ("admin", "admin", "admin@gmail.com", TRUE);

-- INSERTAR LISTA DE VIDEOJUEGOS
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

-- INSERTAR LISTA DE CATEGORIAS
INSERT INTO Categoria (nombre_categoria) VALUES
    ("Acción"),
    ("Aventura"),
    ("Plataforma"),
    ("RPG"),
    ("Shooter"),
    ("Mundo Abierto"),
    ("Estrategia"),
    ("Simulación"),
    ("Multijugador"),
    ("Cooperativo"),
    ("Deportes"),
    ("Carreras"),
    ("Terror"),
    ("Survival Horror"),
    ("Puzzle"),
    ("Ciencia Ficción"),
    ("Fantasía"),
    ("Indie"),
    ("Narrativo"),
    ("Stealth"),
    ("Beat 'em up"),
    ("Metroidvania");

-- RELACIONAR VIDEOJUEGO CON CATEGORIA
INSERT INTO Videojuego_Categoria VALUES
-- ACCION
(3, 1),  -- GOW
(19, 1), -- R&C
(2, 1),  -- GTA V

-- RPG
(23, 4), -- CP2077
(14, 4), -- FF XVI
(34, 4), -- SMT V

-- SHOOTER
(6, 5), -- BF 2042
(24, 5), -- R II
(5, 5), -- SM 2

-- MULTIJUGADOR / COOPERATIVO
(4, 9), -- DBD
(4, 10), -- DBD
(20, 9), -- ITT
(20, 10), -- ITT

-- TERROR / SURVIVAL HORROR
(32, 13), -- RE 4
(32, 14), -- RE 4
(35, 13), -- SH 2
(35, 14), -- SH 2
(7, 13), -- AW 2
(7, 14), -- AW 2

-- PUZZLE / NARRATIVO
(37, 15), -- TSP
(37, 19), -- TSP
(44, 15), -- VF
(44, 19), -- VF

-- ESTRATEGIA / SIMULACION
(15, 7), -- C VI
(15, 8), -- C VI
(18, 7), -- Sat
(18, 8), -- Sat
(21, 7), -- FM 2024
(21, 8); -- FM 2024
