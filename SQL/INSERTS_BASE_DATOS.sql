-- INSERT USUARIOS
INSERT INTO usuarios (id_usuario, nombre_usuario, contrasena, salt, correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (1, 'jhon_cenaa', 'contrasena1', 'salt1', 'usuario1@example.com', 'Pregunta1', '2024-02-05', '12:30:00');

INSERT INTO usuarios (id_usuario, nombre_usuario, contrasena, salt, correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (2, 'pablito123', 'contrasena2', 'salt2', 'usuario2@example.com', 'Pregunta2', '2024-02-05', '14:45:00');

INSERT INTO usuarios (id_usuario, nombre_usuario, contrasena, salt, correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (3, 'Elrica_Tula', 'contrasena3', 'salt3', 'usuario3@example.com', 'Pregunta3', '2024-02-05', '10:15:00');

INSERT INTO usuarios (id_usuario, nombre_usuario, contrasena, salt, correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (4, 'ALL_CAPS_MA_BOYS', 'contrasena4', 'salt4', 'usuario4@example.com', 'Pregunta4', '2024-02-05', '08:00:00');

INSERT INTO usuarios (id_usuario, nombre_usuario, contrasena, salt, correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (5, 'ROSA_MELANO', 'contrasena5', 'salt5', 'usuario5@example.com', 'Pregunta5', '2024-02-05', '16:30:00');


-- INSERT COMENTARIOS
INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios)
VALUES (1, CURRENT_DATE, CURRENT_TIME, 0, '¡Qué increíble foto!', '');

INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios)
VALUES (2, CURRENT_DATE, CURRENT_TIME, 0, 'Hermoso lugar :)', '');

INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios)
VALUES (3, CURRENT_DATE, CURRENT_TIME, 0, '¡Me encanta este paisaje!', '');

-- Comentario 4
INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios)
VALUES (4, CURRENT_DATE, CURRENT_TIME, 0, 'Increíble vista desde allí.', '');

-- Comentario 5
INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios)
VALUES (5, CURRENT_DATE, CURRENT_TIME, 0, '¿En qué parte del mundo es esto?', '');

-- INSERT PUBLICACIONES
INSERT INTO publicaciones (f_creacion, h_creacion, id_usuario, id_comentario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(CURRENT_DATE, CURRENT_TIME, 1, 2, 'De viaje en paris :D', 'https://picsum.photos/id/237/200/300', '', 0);

INSERT INTO publicaciones (f_creacion, h_creacion, id_usuario, id_comentario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(CURRENT_DATE, CURRENT_TIME, 2, 3, 'Comienda pizza!', 'https://picsum.photos/id/237/200/400', '', 0);

INSERT INTO publicaciones (f_creacion, h_creacion, id_usuario, id_comentario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(CURRENT_DATE, CURRENT_TIME, 3, 2, 'Explorando Nueva York', 'https://picsum.photos/id/238/300/200', '', 0);

-- Publicación 4 con dimensión y ID distinto
INSERT INTO publicaciones (f_creacion, h_creacion, id_usuario, id_comentario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(CURRENT_DATE, CURRENT_TIME, 4, 4, 'Caminando por Roma', 'https://picsum.photos/id/239/400/200', '', 0);

-- Publicación 5 con dimensión y ID distinto
INSERT INTO publicaciones (f_creacion, h_creacion, id_usuario, id_comentario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(CURRENT_DATE, CURRENT_TIME, 5, 5, 'Relajándome en la playa', 'https://picsum.photos/id/240/400/300', '', 0);
