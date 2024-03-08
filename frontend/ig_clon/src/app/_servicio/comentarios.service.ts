import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comentarios } from '../_modelo/Comentarios';

@Injectable({
  providedIn: 'root'
})
export class ComentariosService {

  url:string = "http:/localhost:3000/api/comentarios"

  constructor(private http:HttpClient) { }

  getComentarios(): Observable<Comentarios[]>{
    return this.http.get<Comentarios[]>(this.url);
  }
}