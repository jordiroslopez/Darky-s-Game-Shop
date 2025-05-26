CREATE DATABASE DarkysGamesShop;
USE DarkysGamesShop;

DROP TABLE IF EXISTS Categoria;
CREATE TABLE Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

DROP TABLE IF EXISTS Videojuego;
CREATE TABLE Videojuego (
    id_videojuego INT AUTO_INCREMENT PRIMARY KEY,
    nombre_videojuego VARCHAR(50),
    precio FLOAT
);

DROP TABLE IF EXISTS Videojuego_Categoria;
CREATE TABLE Videojuego_Categoria (
    id_videojuego INT,
    id_categoria INT,
    CONSTRAINT PK_Videojuego_Categoria PRIMARY KEY (id_videojuego, id_categoria),
    CONSTRAINT FK1_Videojuego FOREIGN KEY(id_videojuego) REFERENCES Videojuego(id_videojuego),
    CONSTRAINT FK2_Categoria FOREIGN KEY(id_categoria) REFERENCES Categoria(id_categoria)
);
