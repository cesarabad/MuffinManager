USE `MuffinManager`;
INSERT INTO Usuario (dni, nombre, apellidos, nombreUsuario, contrasenaHash) VALUES
('123456789', 'Juan', 'Pérez', 'juanp', 'hashedpass1'),
('987654321', 'María', 'González', 'mariag', 'hashedpass2'),
('456789123', 'Carlos', 'López', 'carlosl', 'hashedpass3');

INSERT INTO Grupo (nombre) VALUES
('Administradores'),
('Usuarios'),
('Invitados');

INSERT INTO Permiso (nombre) VALUES
('Leer'),
('Escribir'),
('Eliminar');

INSERT INTO Usuario_Group (usuario, grupo) VALUES
('123456789', 'Administradores'),
('987654321', 'Usuarios'),
('987654321', 'Invitados');

INSERT INTO Permiso_Grupo (permiso, grupo) VALUES
('Leer', 'Invitados'),
('Leer', 'Usuarios'),
('Escribir', 'Usuarios'),
('Escribir', 'Administradores'),
('Eliminar', 'Administradores');

INSERT INTO Forma (id, descripcion, version, fechaCreacion, activo, responsable) VALUES
('11', 'REDONDAS', 1, NOW(), TRUE, '123456789'),
('22', 'BROWNIES', 1, NOW(), TRUE, '987654321'),
('33', 'LARGAS', 1, NOW(), TRUE, '123456789'),
('44', 'CUADRADAS', 1, NOW(), TRUE, '456789123'),
('55', 'MINI MUFFINS', 1, NOW(), TRUE, '123456789');

INSERT INTO Marca (id, nombre, version, fechaCreacion, activo, responsable) VALUES
('01', 'Hacendado', 1, NOW(), TRUE, '123456789'),
('53', 'Auchan', 1, NOW(), TRUE, '456789123'),
('02', 'Gullon', 1, NOW(), TRUE, '987654321');

INSERT INTO Articulo (referencia, marca, versionMarca, forma, versionForma, descripcionMain, peso, unidadesPorArticulo, ean13, lineaProduccion, version, fechaCreacion, activo, responsable) VALUES
('550101', '01', 1, '55', 1, 'Mini muffin limon 8 uds', 180, 8, '1234567890123', 0, 1, NOW(), TRUE, '123456789'),
('335316', '53', 1, '33', 1, 'Largas 6 uds', 175, 6, '9876543210123', 1, 1, NOW(), TRUE, '987654321');

INSERT INTO Caja (env, descripcion, baseEuropeo, baseAmericano, alturaDefecto) VALUES
('ENV-105', 'Caja cuadradas x 6', 8, 10, 10),
('ENV-107', 'Caja cuadradas x 12 WB', 8, 10, 8),
('ENV-109', 'Caja largas x 12', 8, 10, 9),
('ENV-110', 'Caja redandas x 300g', 10, 13, 7),
('ENV-120', 'Caja redondas x 8', 8, 10, 10);


INSERT INTO Producto (referencia, caja, articulo, versionArticulo, articuloPorCaja, ean14, version, fechaCreacion, activo, responsable) VALUES
('550101', 'ENV-105', '550101', 1, 14, '11111111111111', 1, NOW(), TRUE, '123456789'),
('335316', 'ENV-105', '335316', 1, 16, '22222222222222', 1, NOW(), TRUE, '987654321'),
('335316-WB', 'ENV-107', '335316', 1, 18, '22222222223333', 1, NOW(), TRUE, '987654321');

INSERT INTO Impresion_Paquete (abreviatura, descripcion) VALUES
('FR', 'Impresion que hay que utilizar cada vez que ....'),
('IT', 'Utilizar esta impresion es en caso de....');

INSERT INTO Stock_Producto (producto, versionProducto, lote, impresionPaquete, unidades) VALUES
('335316', 1, 'L1106', 'FR', 100),
('335316', 1, 'L1108', 'FR', 110),
('335316', 1, 'L1108', 'IT', 30),
('335316-WB', 1, 'L1106', 'FR', 20),
('335316-WB', 1, 'L1098', 'IT', 40),
('550101', 1, 'L1082', 'FR', 10);

INSERT INTO Movimiento_Stock (producto, versionProducto, lote, responsable, fechaYHora, observaciones) VALUES
('335316', 1, 'L1106', '123456789', NOW(), 'Salida de stock'),
('550101', 1, 'L1082', '987654321', NOW(), 'Entrada de stock');

INSERT INTO Entrada_Stock (numero, producto, versionProducto, lote, unidades) VALUES
(2, '550101', 1, 'L1082', 10);

INSERT INTO Salida_Stock (numero, producto, versionProducto, lote, unidades, destino) VALUES
(1, '335316', 1, 'L1106', 20, 'ABC-234');

