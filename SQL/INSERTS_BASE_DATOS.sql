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
-- INSERT PERFILES
INSERT INTO perfil (id_perfil,descripcion,nombre,apellido,foto_perfil,num_publicaciones,num_seguidores,num_siguiendo,id_usuario)
VALUES(1,'','jhon','Cena','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,1),
(2,'','pablito','clavo un clavito','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,2),
(3,'','Elrica','tula','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,3),
(4,'','ALL CAPS','MA BOYS','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,4),
(5,'','ROSA','MELANO','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,5);
-- INSERT PUBLICACIONES
INSERT INTO publicaciones (id_publicacion,f_creacion, h_creacion, id_usuario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(1, CURRENT_DATE, CURRENT_TIME, 1, 'De viaje en paris :D', 'https://picsum.photos/id/237/200/300', '', 0);

INSERT INTO publicaciones (id_publicacion,f_creacion, h_creacion, id_usuario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(2, CURRENT_DATE, CURRENT_TIME, 2, 'Comienda pizza!', 'https://picsum.photos/id/237/200/400', '', 0);

INSERT INTO publicaciones (id_publicacion, f_creacion, h_creacion, id_usuario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(3, CURRENT_DATE, CURRENT_TIME, 3, 'Explorando Nueva York', 'https://picsum.photos/id/238/300/200', '', 0);

-- Publicación 4 con dimensión y ID distinto
INSERT INTO publicaciones (id_publicacion, f_creacion, h_creacion, id_usuario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(4, CURRENT_DATE, CURRENT_TIME, 4, 'Caminando por Roma', 'https://picsum.photos/id/239/400/200', '', 0);

-- Publicación 5 con dimensión y ID distinto
INSERT INTO publicaciones (id_publicacion, f_creacion, h_creacion, id_usuario, descripcion, ruta_contenido, url_compartir, cantidad_likes)
VALUES(5, CURRENT_DATE, CURRENT_TIME, 5, 'Relajándome en la playa', 'https://picsum.photos/id/240/400/300', '', 0);

-- INSERT COMENTARIOS
INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios,id_usuario,id_publicacion)
VALUES (1, CURRENT_DATE, CURRENT_TIME, 0, '¡Qué increíble foto!', '',1,1);

INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios,id_usuario,id_publicacion)
VALUES (2, CURRENT_DATE, CURRENT_TIME, 0, 'Hermoso lugar :)', '',2,2);

INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios,id_usuario,id_publicacion)
VALUES (3, CURRENT_DATE, CURRENT_TIME, 0, '¡Me encanta este paisaje!', '',3,3);

-- Comentario 4
INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios,id_usuario,id_publicacion)
VALUES (4, CURRENT_DATE, CURRENT_TIME, 0, 'Increíble vista desde allí.', '',4,4);

-- Comentario 5
INSERT INTO comentarios (id_comentario, f_creacion, h_creacion, likes, mensajes, respuestas_usuarios,id_usuario,id_publicacion)
VALUES (5, CURRENT_DATE, CURRENT_TIME, 0, '¿En qué parte del mundo es esto?', '',5,5);

-- INSERT FOLLOWERS
INSERT INTO seguidores (id_usuario_seguido,id_usuario_seguidor)
VALUES (1,2),(1,3),(1,4),(1,5),(2,1);

--INSERT HISTORIAS PUBLICAS
INSERT INTO historias
VALUES(1,true,'https://cdn.eldeforma.com/wp-content/uploads/2020/03/hacker-meme-e1604368158422.png',CURRENT_DATE, CURRENT_TIME,true,1),
(2,true,'https://media.gettyimages.com/id/963210214/photo/real-madrid-celebrate-after-victory-in-the-champions-league-final.jpg?b=1&s=594x594&w=0&k=20&c=Qt_iArsxlXvck0KZreVz8A8xN77YvmpRrFQRS9bqyI8=',CURRENT_DATE, CURRENT_TIME,true,2),
(3,true,'https://cdn.eldeforma.com/wp-content/uploads/2020/03/hacker-meme-e1604368158422.png',CURRENT_DATE, CURRENT_TIME,true,3),
(4,true,'texto',CURRENT_DATE, CURRENT_TIME,true,4),
(5,true,'Ola mundo',CURRENT_DATE, CURRENT_TIME,true,5),
-- PRIVADAS
(6,true,'PRIV',CURRENT_DATE, CURRENT_TIME,false,1),
(7,true,'Siuu',CURRENT_DATE, CURRENT_TIME,false,2);
