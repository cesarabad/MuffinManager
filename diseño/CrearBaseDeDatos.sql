CREATE DATABASE `MuffinManager`;
USE `MuffinManager`;

CREATE TABLE `Usuario` (
    `dni` CHAR(9) NOT NULL,
    `nombre` VARCHAR(80) NOT NULL,
    `apellidos` VARCHAR(80),
    `nombreUsuario` VARCHAR(20) NOT NULL,
    `contrasenaHash` VARCHAR(80) NOT NULL,
    PRIMARY KEY (`dni`)
);

CREATE TABLE `Grupo` (
    `nombre` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`nombre`)
);

CREATE TABLE `Usuario_Group` (
    `usuario` CHAR(9) NOT NULL,
    `grupo` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`usuario`, `grupo`),
    FOREIGN KEY (`usuario`) REFERENCES `usuario`(`dni`),
    FOREIGN KEY (`grupo`) REFERENCES `grupo`(`nombre`)
);

CREATE TABLE `Permiso` (
    `nombre` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`nombre`)
);

CREATE TABLE `Permiso_Grupo` (
    `permiso` VARCHAR(20) NOT NULL,
    `grupo` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`permiso`, `grupo`),
    FOREIGN KEY (`permiso`) REFERENCES `permiso`(`nombre`),
    FOREIGN KEY (`grupo`) REFERENCES `grupo`(`nombre`)
);

CREATE TABLE `Forma` (
    `id` VARCHAR(5) NOT NULL,
    `descripcion` varchar(80) NOT NULL,
    `version` INT,
    `fechaCreacion` TIMESTAMP,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Marca` (
    `id` VARCHAR(5) NOT NULL,
    `nombre` varchar(80) NOT NULL,
    `logo` BLOB,
    `version` INT,
    `fechaCreacion` TIMESTAMP,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Articulo` (
    `referencia` VARCHAR(16) NOT NULL,
    `marca` varchar(5) NOT NULL,
    `versionMarca` INT,
    `forma` varchar(5) NOT NULL,
    `versionForma` INT,
    `descripcionMain` varchar(80) NOT NULL,
    `peso` FLOAT,
    `unidadesPorArticulo` INT,
    `ean13` CHAR(13),
    `lineaProduccion` INT,
    `version` INT,
    `fechaCreacion` TIMESTAMP,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN,
    `responsable` CHAR(9),
    PRIMARY KEY (`referencia`, `version`),
    FOREIGN KEY (`marca`, `versionMarca`) REFERENCES `marca`(`id`, `version`),
    FOREIGN KEY (`forma`, `versionForma`) REFERENCES `forma`(`id`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Caja` (
    `env` VARCHAR(16) NOT NULL,
    `descripcion` varchar(80) NOT NULL,
    `baseEuropeo` INT,
    `baseAmericano` INT,
    `alturaDefecto` INT,
    PRIMARY KEY (`env`)
);

CREATE TABLE `Producto` (
    `referencia` VARCHAR(16) NOT NULL,
    `caja` VARCHAR(16) NOT NULL,
    `articulo` VARCHAR(16) NOT NULL,
    `versionArticulo` INT,
    `articuloPorCaja` INT,
    `ean14` CHAR(14),
    `version` INT,
    `fechaCreacion` TIMESTAMP,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN,
    `responsable` CHAR(9),
    PRIMARY KEY (`referencia`, `version`),
    FOREIGN KEY (`caja`) REFERENCES `caja`(`env`),
    FOREIGN KEY (`articulo`, `versionArticulo`) REFERENCES `articulo`(`referencia`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Impresion_Paquete` (
    `abreviatura` VARCHAR(12) NOT NULL,
    `descripcion` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`abreviatura`)
);

CREATE TABLE `Stock_Producto` (
    `producto` VARCHAR(16) NOT NULL,
    `versionProducto` INT,
    `lote` CHAR(5) NOT NULL,
    `impresionPaquete` VARCHAR(12),
    `unidades` INT,
    PRIMARY KEY (`producto`, `versionProducto`, `lote`),
    FOREIGN KEY (`producto`, `versionProducto`) REFERENCES `producto`(`referencia`, `version`),
    FOREIGN KEY (`impresionPaquete`) REFERENCES `Impresion_Paquete`(`abreviatura`)
);

CREATE TABLE `Movimiento_Stock` (
    `numero` INT AUTO_INCREMENT NOT NULL,
    `producto` VARCHAR(16) NOT NULL,
    `versionProducto` INT,
    `lote` CHAR(5) NOT NULL,
    `responsable` CHAR(9),
    `fechaYHora` TIMESTAMP,
    `observaciones` VARCHAR(255),
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`),
    FOREIGN KEY (`producto`, `versionProducto`, `lote`) REFERENCES `Stock_Producto`(`producto`, `versionProducto`, `lote`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Entrada_Stock` (
    `numero` INT NOT NULL,
    `producto` VARCHAR(16) NOT NULL,
    `versionProducto` INT,
    `lote` CHAR(5) NOT NULL,
    `unidades` INT,
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`),
    FOREIGN KEY (`numero`, `producto`, `versionProducto`, `lote`) REFERENCES `Movimiento_Stock`(`numero`, `producto`, `versionProducto`, `lote`)
);

CREATE TABLE `Salida_Stock` (
    `numero` INT NOT NULL,
    `producto` VARCHAR(16) NOT NULL,
    `versionProducto` INT,
    `lote` CHAR(5) NOT NULL,
    `unidades` INT,
    `destino` VARCHAR(80),
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`),
    FOREIGN KEY (`numero`, `producto`, `versionProducto`, `lote`) REFERENCES `Movimiento_Stock`(`numero`, `producto`, `versionProducto`, `lote`)
);

CREATE TABLE `Ajuste_Stock` (
    `numero` INT NOT NULL,
    `producto` VARCHAR(16) NOT NULL,
    `versionProducto` INT,
    `lote` CHAR(5) NOT NULL,
    `unidades` INT,
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`),
    FOREIGN KEY (`numero`, `producto`, `versionProducto`, `lote`) REFERENCES `Movimiento_Stock`(`numero`, `producto`, `versionProducto`, `lote`)
);

CREATE TABLE `Reserva_Stock` (
    `numero` INT NOT NULL,
    `producto` VARCHAR(16) NOT NULL,
    `versionProducto` INT,
    `lote` CHAR(5) NOT NULL,
    `unidades` INT,
    `destino` VARCHAR(80),
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`),
    FOREIGN KEY (`numero`, `producto`, `versionProducto`, `lote`) REFERENCES `Movimiento_Stock`(`numero`, `producto`, `versionProducto`, `lote`)
);

CREATE TABLE `Descripcion_Articulo` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `articulo` VARCHAR(16) NOT NULL,
    `versionArticulo` INT,
    `descripcion` VARCHAR(80) NOT NULL,
    `fechaCreacion` TIMESTAMP,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`articulo`, `versionArticulo`) REFERENCES `articulo`(`referencia`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Idioma` (
    `id` VARCHAR(20) NOT NULL,
    `loteTexto` VARCHAR(50) NOT NULL,
    `caducidadTexto` VARCHAR(50) NOT NULL,
    `mensaje` TEXT NOT NULL,
    `unidadesTexto` VARCHAR(50) NOT NULL,
    `version` INT,
    `fechaCreacion` TIMESTAMP,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Auxiliar_Idioma` (
    `idioma` VARCHAR(20) NOT NULL,
    `versionIdioma` INT,
    `datoAuxiliar` VARCHAR(50) NOT NULL,
    `fechaCreacion` TIMESTAMP,
    `responsable` CHAR(9),
    PRIMARY KEY (`idioma`, `versionIdioma`, `datoAuxiliar`),
    FOREIGN KEY (`idioma`, `versionIdioma`) REFERENCES `idioma`(`id`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Variante_Idioma` (
    `variante` VARCHAR(20) NOT NULL,
    `idioma` VARCHAR(20) NOT NULL,
    `versionIdioma` INT,
    `fechaCreacion` TIMESTAMP,
    `responsable` CHAR(9),
    PRIMARY KEY (`variante`),
    FOREIGN KEY (`idioma`, `versionIdioma`) REFERENCES `idioma`(`id`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Auxiliar_Variante` (
    `variante` VARCHAR(20) NOT NULL,
    `datoAuxiliar` VARCHAR(50) NOT NULL,
    `fechaCreacion` TIMESTAMP,
    `responsable` CHAR(9),
    PRIMARY KEY (`variante`, `datoAuxiliar`),
    FOREIGN KEY (`variante`) REFERENCES `Variante_Idioma`(`variante`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Cambio_En_Variante` (
    `cambio` INT AUTO_INCREMENT NOT NULL,
    `nombreCampo` VARCHAR(30) NOT NULL,
    `valorNuevo` VARCHAR(50),
    `fechaCreacion` TIMESTAMP,
    `responsable` CHAR(9),
    PRIMARY KEY (`cambio`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);

CREATE TABLE `Cambios_Variante` (
    `cambio` INT NOT NULL,
    `variante` VARCHAR(20) NOT NULL,
    `fechaAnadido` TIMESTAMP,
    `responsable` CHAR(9),
    PRIMARY KEY (`cambio`, `variante`),
    FOREIGN KEY (`variante`) REFERENCES `Variante_Idioma`(`variante`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`)
);