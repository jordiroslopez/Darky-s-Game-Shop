/*
CREATE DATABASE DarkysGamesShop;
USE DarkysGamesShop;
*/

DROP TABLE IF EXISTS Videojuego_Categoria;
DROP TABLE IF EXISTS Usuario_Videojuego;
DROP TABLE IF EXISTS Categoria;
DROP TABLE IF EXISTS Videojuego;
DROP TABLE IF EXISTS Usuario;

CREATE TABLE Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
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
    nombre VARCHAR(50),
    contrasenya VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE Usuario_Videojuego (
    id_usuario INT,
    id_videojuego INT,
    CONSTRAINT PK_Usuario_Videojuego PRIMARY KEY (id_usuario, id_videojuego),
    CONSTRAINT FK1_Usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
    CONSTRAINT FK2_Videojuego FOREIGN KEY (id_videojuego) REFERENCES Videojuego(id_videojuego)
);
