import { AsyncPipe, CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { PublicacionesService } from '../_servicio/publicaciones.service';
import { PublicarComentarioService } from '../_servicio/publicar-comentario.service';
import { Publicaciones } from '../_modelo/Publicaciones';
import { Comentarios } from '../_modelo/Comentarios';
import { FormsModule } from '@angular/forms';
import { NgIconComponent, provideIcons } from '@ng-icons/core';

import {
  ionHeartCircleOutline,
  ionChatboxEllipsesOutline,
  ionShareOutline,
  ionBookmarkOutline,
} from '@ng-icons/ionicons';
import { PublicacionModalComponent } from '../publicacion-modal/publicacion-modal.component';
import { UsuarioService } from '../_servicio/usuario.service';
import { Usuario } from '../_modelo/Usuario';


@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [
    RouterModule,
    MatIconModule,
    CommonModule,
    AsyncPipe,
    FormsModule,
    NgIconComponent,
    PublicacionModalComponent
  ],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css',
  viewProviders: [
    provideIcons({
      ionHeartCircleOutline,
      ionChatboxEllipsesOutline,
      ionShareOutline,
      ionBookmarkOutline,
    }),
  ],
})

/* 
TODO: Hacer las rutas ?variant=home || ?variant=following en el url
TODO: Mostrar el perfil en :hover al ver la sugerencia
 */
export class InicioComponent implements OnInit {

  public listaPublicaciones$!: Publicaciones[];
  public listaComentarios$!: Comentarios[];
  public listaUsuarios$!: Usuario[];

  error: string = '';
  comentarioActual: string = '';
  publicacionAbierta:boolean = false;
  publicacionActual:Publicaciones | undefined;

  constructor(
    private service: PublicacionesService,
    private comentariosService: PublicarComentarioService,
    private usuarioService: UsuarioService
  ) {}

  ngOnInit(): void {
    this.service.getPublicaciones().subscribe((data) => {
      this.listaPublicaciones$ = data;      
    });
    this.comentariosService.getComentarios().subscribe((data) => {
      this.listaComentarios$ = data;
    });
    this.usuarioService.getUsuarios().subscribe((data)=> {
      this.listaUsuarios$ = data;      
    })
  }

  postComentario(): void {
    if (this.comentarioActual.length < 3) {
      this.error = 'El comentario debe ser más largo';
      console.log(this.error);
      return;
    }
    console.log(this.comentarioActual);

    console.log('Comentario posteado');
  }

  abrirPublicacion(id:number): void{
    this.publicacionAbierta = true;
    this.publicacionActual = this.listaPublicaciones$[id - 1];
  }
  cerrarPublicacion(): void{
    this.publicacionAbierta = false;
    
  }

  darLike(idPublicacion: number): void{
    console.log("Has dado like"); 
    /* SI LA PUBLI YA TIENE LIKE QUITARLO */
    /* SI LA PUBLI TIENE LIKE MOSTRARLO ROJO */
  }
  compartir(idPublicacion:number):void{
    /* TODO: Esta en standby pero debería aportar un link acortado de la publicación actual */
    console.log('Compartiendo public...');
    
  }
  guardarPublicacion(idPublicacion:number):void{
    /* TODO: Debe almacenar las publicaciones en el perfil del usuario, sin embargo estas no deben ser públicas */
    console.log("Publicación guardada");
  }
  usuario = {
    id: 0,
    nombre_usuario: 'test_23',
    nombre_completo: 'Test Ing',
    imgPerfil: 'https://picsum.photos/60/60',
  };
}
