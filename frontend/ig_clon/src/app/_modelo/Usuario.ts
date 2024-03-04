export interface Usuario {
  contrasena:string,
  correo:string,
  fcreacion: Date,
  hcreacion: Date,
  idUsuario: 1,
  nombreUsuario:string,
  preguntaSecreta:string,
  /*TODO: Remove this later */
  salt:string,
}
