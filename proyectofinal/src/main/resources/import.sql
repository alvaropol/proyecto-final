INSERT INTO CATEGORIA (id,imagen,nombre) VALUES (1,'https://static.vecteezy.com/system/resources/previews/020/274/791/non_2x/fashion-category-online-store-in-outline-icon-t-shirt-short-pant-clothing-apparel-online-shopping-free-vector.jpg','Ropa');
INSERT INTO CATEGORIA (id,imagen,nombre) VALUES (2,'https://img.freepik.com/iconos-gratis/pelota-futbol_318-1526.jpg','Objeto deportivo');
INSERT INTO CATEGORIA (id,imagen,nombre) VALUES (3,'https://img.freepik.com/vector-premium/conjunto-icono-accesorios-moda_1453-28.jpg','Accesorio');
INSERT INTO CATEGORIA (id,imagen,nombre) VALUES (4,'https://cdn-icons-png.flaticon.com/512/497/497145.png','Juego de mesa');
INSERT INTO CATEGORIA (id,imagen,nombre) VALUES (5,'https://cdn-icons-png.flaticon.com/512/1794/1794635.png','Informática');



INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (1,9,'Gorra de color negro, con el escudo del Sevilla FC bordado en la parte frontal de la gorra','https://cdn.grupoelcorteingles.es/SGFM/dctm/MEDIA03/202107/29/00125238606690____3__640x640.jpg','Gorra NIKE negra del Sevilla FC',14.99,1);
INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (2,8,'Taza de cerámica con los colores del Sevilla FC y su escudo','https://tienda.lacolinadenervion.com/wp-content/uploads/2021/06/white-ceramic-mug-with-color-inside-red-11oz-right-60ba06c6493fa.jpg','Taza del Sevilla FC',9.99,3);
INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (3,7,'Balón con materiales de calidad, y con escudo del Sevilla FC','https://cdn.grupoelcorteingles.es/SGFM/dctm/MEDIA03/202206/07/00108418315126____1__640x640.jpg','Balón NIKE del Sevilla FC',25.5,2);
INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (4,10,'Equipación oficial visitante del Sevilla FC color rojo, temporada 2022/2023','https://cdn.shopify.com/s/files/1/0469/2774/1079/products/TM1131camisetaoficialsevillafcvisitante20222023roja_300x300.png?v=1675963843','Camiseta 2º Sevilla FC visitante adulto',75.99,1);
INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (5,6,'Reloj del Sevilla FC con escudo implementado en la parte interior del reloj, materiales de calidad y robustos, correa de color rojo, y bordeado del centro de color negro','https://paez.es/media/catalog/product/cache/c5eebc7207563108d218ef18c35d9285/7/6/762015-01hHW.jpg','Reloj del Sevilla FC',25.99,3);
INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (6,9, 'Puzle en 3D del estadio Ramón Sanchéz Pizjuan, incluye dos pilas AA (no incluidas), incluyendo un sistema de luces fiel al estilo real, piezas duras y compactas. Recomendado a partir de 3 años. Medidas: 35cm de largo','https://storage.googleapis.com/catalog-pictures-carrefour-es/catalog/pictures/hd_510x_/8436573613675_1.jpg','Puzle 3D Ramón Sánchez Pizjuan',49.99,4);
INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (7,8,'Pendrive de 16 GB, Forma y Colores del Escudo del Sevilla FC - Incluye Pequeño Colgante - Acabado Engomado y de Ligero Peso - Producto Oficial del Equipo','https://cdn.phonehouse.es/res/viewone450/resource_2163773.jpg?&w=380&h=380&trim=auto&auto=format','Pendrive 16 GB Sevilla FC',9.99,5);
INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (8,9,'Medidas: 33x45x22 cm. | Peso: 1,88 kg. | Capacidad: 33 L. | Caracteristicas: Mochila EXTRAIBLE para poder LAVARLA. Departamento principal de gran capacidad. Bolsillo frontal de gran formato, y Bolsillo lateral portabotella. Doble tirador en cremallera principal para facilitar su apertura. Hombreras y espalda acolchada, Asa de mano acolchada en la parte superior. Tarjeta de identificación personal. Bandeja interior de PVC. Base reforzada, y Asa extraible. Fabricado en España.','https://www.regalizdistribuciones.com/productos/imagenes/img_188271_e16a17775cfb8fa51fb97547be634e03_20.jpg','Mochila Sevilla FC Roja',20.99,3);
INSERT INTO PRODUCTO (id,calificacion,descripcion,imagen,nombre,precio,categoria_id) VALUES (9,10,'Silicona 100% natural y acero inoxidable, Anticorrosiva, antibacteriana, hipoalergénica y resistente al calor, Grabado láser de alta calidad y durabilidad, Seguro para niños (+3 años), Ajustable para hombres, mujeres y niños','https://cdn.shopify.com/s/files/1/0371/0117/4923/products/SFC-fashion-01-JR-pack_480x.jpg?v=1634302786','Pulsera Sevilla FC Braceless',12.99,3);


ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;