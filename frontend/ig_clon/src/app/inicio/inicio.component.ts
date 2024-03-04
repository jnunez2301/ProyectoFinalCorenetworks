import { AsyncPipe, CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { PublicacionesService } from '../_servicio/publicaciones.service';
import { Observable } from 'rxjs';
import { Publicaciones } from '../_modelo/Publicaciones';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [RouterModule, MatIconModule, CommonModule, AsyncPipe],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css',
})

/* 
TODO: Hacer las rutas ?variant=home || ?variant=following en el url
TODO: Mostrar el perfil en :hover al ver la sugerencia
 */
export class InicioComponent implements OnInit {
  public listaPublicaciones$!: Publicaciones[];

  constructor(private service: PublicacionesService) {}
  ngOnInit(): void {
    this.service.getPublicaciones().subscribe((data) => {
      this.listaPublicaciones$ = data;      
      console.log(data);
      
    });
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
