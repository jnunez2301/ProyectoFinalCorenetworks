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

  error: string = '';
  comentarioActual: string = '';
  publicacionAbierta:boolean = false;

  constructor(
    private service: PublicacionesService,
    private comentariosService: PublicarComentarioService
  ) {}

  ngOnInit(): void {
    this.service.getPublicaciones().subscribe((data) => {
      this.listaPublicaciones$ = data;
    });
    this.comentariosService.getComentarios().subscribe((data) => {
      this.listaComentarios$ = data;
    });
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

  abrirPublicacion(): void{
    this.publicacionAbierta = true;
  }
  cerrarPublicacion(): void{
    this.publicacionAbierta = false;
  }
  usuario = {
    id: 0,
    nombre_usuario: 'test_23',
    nombre_completo: 'Test Ing',
    imgPerfil: 'https://picsum.photos/60/60',
  };
  usuarios = [
    {
      id: 1,
      nombre_usuario: 'llinton0',
      nombre_completo: 'Leah Linton',
      imgPerfil: 'https://picsum.photos/id/1/60/60',
    },
    {
      id: 2,
      nombre_usuario: 'aprene1',
      nombre_completo: 'Asher Prene',
      imgPerfil: 'https://picsum.photos/id/2/60/60',
    },
    {
      id: 3,
      nombre_usuario: 'abaleine2',
      nombre_completo: 'Andre Baleine',
      imgPerfil: 'https://picsum.photos/id/3/60/60',
    },
    {
      id: 4,
      nombre_usuario: 'sglauber3',
      nombre_completo: 'Seline Glauber',
      imgPerfil: 'https://picsum.photos/id/4/60/60',
    },
    {
      id: 5,
      nombre_usuario: 'ageck4',
      nombre_completo: 'Alison Geck',
      imgPerfil: 'https://picsum.photos/id/5/60/60',
    },
    {
      id: 6,
      nombre_usuario: 'ifilipowicz5',
      nombre_completo: 'Itch Filipowicz',
      imgPerfil: 'https://picsum.photos/id/6/60/60',
    },
    {
      id: 7,
      nombre_usuario: 'ccrothers6',
      nombre_completo: 'Carlen Crothers',
      imgPerfil: 'https://picsum.photos/id/7/60/60',
    },
    {
      id: 8,
      nombre_usuario: 'bpreshaw7',
      nombre_completo: 'Barnett Preshaw',
      imgPerfil: 'https://picsum.photos/id/8/60/60',
    },
    {
      id: 9,
      nombre_usuario: 'arumsby8',
      nombre_completo: 'Anthea Rumsby',
      imgPerfil: 'https://picsum.photos/id/9/60/60',
    },
    {
      id: 10,
      nombre_usuario: 'rpettis9',
      nombre_completo: 'Reggi Pettis',
      imgPerfil: 'https://picsum.photos/id/10/60/60',
    },
  ];
}
