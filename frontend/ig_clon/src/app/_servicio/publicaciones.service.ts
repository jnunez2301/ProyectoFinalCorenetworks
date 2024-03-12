import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Publicaciones } from '../_modelo/Publicaciones';
import { Observable } from 'rxjs';
import { PublicacionPublicar } from '../_modelo/PublicacionPublicar';

@Injectable({
  providedIn: 'root'
})
export class PublicacionesService {

  url:string = "http://localhost:3000/api/publicaciones"

  constructor(private http:HttpClient) { }

  getPublicaciones(): Observable<Publicaciones[]>{
    return this.http.get<Publicaciones[]>(this.url);
  }
  postPublicacion(idUsuario:number, publicacion:PublicacionPublicar): Observable<PublicacionPublicar>{
    return this.http.post<PublicacionPublicar>(`${this.url}/${idUsuario}`, publicacion);
  }
}