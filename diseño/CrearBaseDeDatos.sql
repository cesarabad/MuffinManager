CREATE DATABASE `MuffinManager`;
USE `MuffinManager`;

CREATE TABLE `Usuario` (
    `dni` CHAR(9) NOT NULL,
    `nombre` VARCHAR(80) NOT NULL,
    `apellidos` VARCHAR(80),
    `nombreUsuario` VARCHAR(20) NOT NULL UNIQUE,
    `contrasenaHash` VARCHAR(64) NOT NULL,
    PRIMARY KEY (`dni`)
);

CREATE TABLE `Grupo_Permisos` (
    `nombre` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`nombre`)
);

CREATE TABLE `Usuario_Grupo` (
    `usuario` CHAR(9) NOT NULL,
    `grupo` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`usuario`, `grupo`),
    FOREIGN KEY (`usuario`) REFERENCES `usuario`(`dni`) ON DELETE CASCADE,
    FOREIGN KEY (`grupo`) REFERENCES `grupo_permisos`(`nombre`) ON DELETE CASCADE
);

CREATE TABLE `Permiso` (
    `nombre` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`nombre`)
);

CREATE TABLE `Permiso_Grupo` (
    `grupo` VARCHAR(20) NOT NULL,
    `permiso` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`permiso`, `grupo`),
    FOREIGN KEY (`permiso`) REFERENCES `permiso`(`nombre`) ON DELETE CASCADE,
    FOREIGN KEY (`grupo`) REFERENCES `grupo_permisos`(`nombre`) ON DELETE CASCADE
);

CREATE TABLE `Permiso_Usuario` (
    `usuario` CHAR(9) NOT NULL,
    `permiso` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`permiso`, `usuario`),
    FOREIGN KEY (`permiso`) REFERENCES `permiso`(`nombre`) ON DELETE CASCADE,
    FOREIGN KEY (`usuario`) REFERENCES `usuario`(`dni`) ON DELETE CASCADE
);

CREATE TABLE `Forma` (
    `id` VARCHAR(10) NOT NULL,
    `descripcion` varchar(80) NOT NULL,
    `version` INT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Marca` (
    `id` VARCHAR(10) NOT NULL,
    `nombre` varchar(80) NOT NULL,
    `logo` BLOB,
    `version` INT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`, `version`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Articulo` (
    `referencia` VARCHAR(20) NOT NULL,
    `marca` varchar(10) NOT NULL,
    `versionMarca` INT NOT NULL,
    `forma` varchar(10) NOT NULL,
    `versionForma` INT NOT NULL,
    `descripcionMain` varchar(80) NOT NULL,
    `peso` FLOAT,
    `unidadesPorArticulo` INT,
    `ean13` CHAR(13) UNIQUE,
    `lineaProduccion` INT,
    `version` INT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`referencia`, `version`),
    FOREIGN KEY (`marca`, `versionMarca`) REFERENCES `marca`(`id`, `version`) ON DELETE CASCADE,
    FOREIGN KEY (`forma`, `versionForma`) REFERENCES `forma`(`id`, `version`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Caja` (
    `env` VARCHAR(20) NOT NULL,
    `descripcion` varchar(80) NOT NULL,
    `baseEuropeo` INT,
    `baseAmericano` INT,
    `alturaDefecto` INT,
    PRIMARY KEY (`env`)
);

CREATE TABLE `Producto` (
    `referencia` VARCHAR(20) NOT NULL,
    `caja` VARCHAR(20),
    `articulo` VARCHAR(20) NOT NULL,
    `versionArticulo` INT NOT NULL,
    `articuloPorCaja` INT,
    `ean14` CHAR(14) UNIQUE,
    `version` INT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`referencia`, `version`),
    FOREIGN KEY (`caja`) REFERENCES `caja`(`env`) ON DELETE SET NULL,
    FOREIGN KEY (`articulo`, `versionArticulo`) REFERENCES `articulo`(`referencia`, `version`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Impresion_Paquete` (
    `abreviatura` VARCHAR(12) NOT NULL,
    `descripcion` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`abreviatura`)
);

CREATE TABLE `Stock_Producto` (
    `producto` VARCHAR(20) NOT NULL,
    `versionProducto` INT NOT NULL,
    `lote` CHAR(5) NOT NULL,
    `impresionPaquete` VARCHAR(12),
    `unidades` INT NOT NULL,
    PRIMARY KEY (`producto`, `versionProducto`, `lote`, `impresionPaquete`),
    FOREIGN KEY (`producto`, `versionProducto`) REFERENCES `producto`(`referencia`, `version`) ON DELETE CASCADE,
    FOREIGN KEY (`impresionPaquete`) REFERENCES `Impresion_Paquete`(`abreviatura`) ON DELETE CASCADE
);

CREATE TABLE `Movimiento_Stock` (
    `numero` INT AUTO_INCREMENT NOT NULL,
    `producto` VARCHAR(20) NOT NULL,
    `versionProducto` INT NOT NULL,
    `lote` CHAR(5) NOT NULL,
    `impresionPaquete` VARCHAR(12),
    `responsable` CHAR(9),
    `unidades` INT NOT NULL,
    `fechaYHora` TIMESTAMP NOT NULL,
    `observaciones` VARCHAR(255),
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`, `impresionPaquete`),
    FOREIGN KEY (`producto`, `versionProducto`, `lote`) REFERENCES `Stock_Producto`(`producto`, `versionProducto`, `lote`) ON DELETE CASCADE,
    FOREIGN KEY (`impresionPaquete`) REFERENCES `Stock_Producto`(`impresionPaquete`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE CASCADE
);

CREATE TABLE `Entrada_Stock` (
    `numero` INT NOT NULL,
    `producto` VARCHAR(20) NOT NULL,
    `versionProducto` INT NOT NULL,
    `lote` CHAR(5) NOT NULL,
    `impresionPaquete` VARCHAR(12),
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`, `impresionPaquete`),
    FOREIGN KEY (`numero`, `producto`, `versionProducto`, `lote`) REFERENCES `Movimiento_Stock`(`numero`, `producto`, `versionProducto`, `lote`) ON DELETE CASCADE,
    FOREIGN KEY (`impresionPaquete`) REFERENCES `Movimiento_Stock`(`impresionPaquete`) ON DELETE CASCADE
);

CREATE TABLE `Salida_Stock` (
    `numero` INT NOT NULL,
    `producto` VARCHAR(20) NOT NULL,
    `versionProducto` INT NOT NULL,
    `lote` CHAR(5) NOT NULL,
    `impresionPaquete` VARCHAR(12),
    `destino` VARCHAR(80) NOT NULL,
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`, `impresionPaquete`),
    FOREIGN KEY (`numero`, `producto`, `versionProducto`, `lote`) REFERENCES `Movimiento_Stock`(`numero`, `producto`, `versionProducto`, `lote`) ON DELETE CASCADE,
    FOREIGN KEY (`impresionPaquete`) REFERENCES `Movimiento_Stock`(`impresionPaquete`) ON DELETE CASCADE
);

CREATE TABLE `Ajuste_Stock` (
    `numero` INT NOT NULL,
    `producto` VARCHAR(20) NOT NULL,
    `versionProducto` INT NOT NULL,
    `lote` CHAR(5) NOT NULL,
    `impresionPaquete` VARCHAR(12),
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`, `impresionPaquete`),
    FOREIGN KEY (`numero`, `producto`, `versionProducto`, `lote`) REFERENCES `Movimiento_Stock`(`numero`, `producto`, `versionProducto`, `lote`) ON DELETE CASCADE,
    FOREIGN KEY (`impresionPaquete`) REFERENCES `Movimiento_Stock`(`impresionPaquete`) ON DELETE CASCADE
);

CREATE TABLE `Reserva_Stock` (
    `numero` INT NOT NULL,
    `producto` VARCHAR(20) NOT NULL,
    `versionProducto` INT NOT NULL,
    `lote` CHAR(5) NOT NULL,
    `impresionPaquete` VARCHAR(12),
    `destino` VARCHAR(80),
    PRIMARY KEY (`numero`, `producto`, `versionProducto`, `lote`, `impresionPaquete`),
    FOREIGN KEY (`numero`, `producto`, `versionProducto`, `lote`) REFERENCES `Movimiento_Stock`(`numero`, `producto`, `versionProducto`, `lote`) ON DELETE CASCADE,
    FOREIGN KEY (`impresionPaquete`) REFERENCES `Movimiento_Stock`(`impresionPaquete`) ON DELETE CASCADE
);

CREATE TABLE `Descripcion_Articulo` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `articulo` VARCHAR(20) NOT NULL,
    `versionArticulo` INT NOT NULL,
    `descripcion` VARCHAR(80) NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`articulo`, `versionArticulo`) REFERENCES `articulo`(`referencia`, `version`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Mensaje` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `texto` TEXT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Idioma` (
    `id` VARCHAR(20) NOT NULL,
    `loteTexto` VARCHAR(50),
    `caducidadTexto` VARCHAR(50),
    `mensaje` INT,
    `unidadesTexto` VARCHAR(50),
    `plantilla` VARCHAR(20) NOT NULL,
    `version` INT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `fechaFin` TIMESTAMP,
    `activo` BOOLEAN NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`id`, `version`),
    FOREIGN KEY (`mensaje`) REFERENCES `mensaje`(`id`) ON DELETE SET NULL,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Auxiliar_Idioma` (
    `idioma` VARCHAR(20) NOT NULL,
    `versionIdioma` INT NOT NULL,
    `datoAuxiliar` VARCHAR(50) NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`idioma`, `versionIdioma`, `datoAuxiliar`),
    FOREIGN KEY (`idioma`, `versionIdioma`) REFERENCES `idioma`(`id`, `version`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Variante_Idioma` (
    `variante` VARCHAR(20) NOT NULL,
    `idioma` VARCHAR(20) NOT NULL,
    `versionIdioma` INT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`variante`),
    FOREIGN KEY (`idioma`, `versionIdioma`) REFERENCES `idioma`(`id`, `version`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Auxiliar_Variante` (
    `variante` VARCHAR(20) NOT NULL,
    `datoAuxiliar` VARCHAR(50) NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`variante`, `datoAuxiliar`),
    FOREIGN KEY (`variante`) REFERENCES `Variante_Idioma`(`variante`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Cambio_En_Variante` (
    `cambio` INT AUTO_INCREMENT NOT NULL,
    `nombreCampo` VARCHAR(30) NOT NULL,
    `valorNuevo` VARCHAR(50),
    `fechaCreacion` TIMESTAMP NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`cambio`),
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Cambios_Variante` (
    `cambio` INT NOT NULL,
    `variante` VARCHAR(20) NOT NULL,
    `fechaAnadido` TIMESTAMP NOT NULL,
    `responsable` CHAR(9),
    PRIMARY KEY (`cambio`, `variante`),
    FOREIGN KEY (`variante`) REFERENCES `Variante_Idioma`(`variante`) ON DELETE CASCADE,
    FOREIGN KEY (`cambio`) REFERENCES `Cambio_En_Variante`(`cambio`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);

CREATE TABLE `Etiqueta` (
    `codigo` VARCHAR(20) NOT NULL,
    `varianteIdioma` VARCHAR(20) NOT NULL,
    `producto` VARCHAR(20) NOT NULL,
    `versionProducto` INT NOT NULL,
    `version` INT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `fechaFin` TIMESTAMP,
    `responsable` CHAR(9),
    PRIMARY KEY (`codigo`, `version`),
    FOREIGN KEY (`varianteIdioma`) REFERENCES `Variante_Idioma`(`variante`) ON DELETE CASCADE,
    FOREIGN KEY (`producto`, `versionProducto`) REFERENCES `producto`(`referencia`, `version`) ON DELETE CASCADE,
    FOREIGN KEY (`responsable`) REFERENCES `usuario`(`dni`) ON DELETE SET NULL
);