import { Component, OnInit } from '@angular/core';


import {
  ionHeartCircleOutline,
  ionChatboxEllipsesOutline,
  ionShareOutline,
  ionBookmarkOutline,
} from '@ng-icons/ionicons';
import { Usuario } from '../_modelo/Usuario';
import { RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { AsyncPipe, CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { Publicaciones } from '../_modelo/Publicaciones';
import { PublicacionesService } from '../_servicio/publicaciones.service';
import { UsuarioService } from '../_servicio/usuario.service';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [RouterModule,
    MatIconModule,
    CommonModule,
    AsyncPipe,
    FormsModule,
    NgIconComponent
    ],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css',
  viewProviders: [
    provideIcons({
      ionHeartCircleOutline,
      ionChatboxEllipsesOutline,
      ionShareOutline,
      ionBookmarkOutline,
    }),
  ],
})

export class PerfilComponent implements OnInit {

  listaPublicaciones$!: Publicaciones[];
  mostrarUsuario$!: Usuario[];
  publicacionActual: Publicaciones | undefined;
  publicacionesGuardadas: Publicaciones[] = [];


  publicacionAbierta: boolean = false;

  

  constructor(
    private service: PublicacionesService,
    private usuarioService: UsuarioService
  ) {}

  ngOnInit(): void {
    this.service.getPublicaciones().subscribe((data) => {
      this.listaPublicaciones$ = data;      
    });
    this.usuarioService.getUsuarios().subscribe((data)=> {
      this.mostrarUsuario$ = data;      
    })
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
  perfilGuardado(idUsuario:number):void{
  /* TODO: Debe almacenar las publicaciones en el perfil del usuario, sin embargo estas no deben ser públicas */
  console.log("Perfil guardado");
  }
  usuario = {
  id: 1,
  nombre_usuario: 'test_23',
  nombre_completo: 'Test Ing',
  imgPerfil: 'https://picsum.photos/60/60',
  numSeguidores:0,
  numSiguiendo:0,
  numPublicaciones:0,
  descripcion:'',
  };
  
  publicacionesPerfil(listaPublicaciones$: number[]): void {
    if (this.publicacionActual) {
      // Verificar si la publicación ya está guardada para evitar duplicados
      const existe = this.publicacionesGuardadas.some(
        (publicacion) => publicacion.idPublicacion === this.publicacionActual?.idPublicacion
      );
  
      if (!existe) {
        // Agregar la publicación actual a la lista de publicaciones guardadas
        this.publicacionesGuardadas.push(this.publicacionActual);
        console.log("Publicación guardada:", this.publicacionActual);
      } else {
        console.log("La publicación ya está guardada");
      }
    }
  }
}
