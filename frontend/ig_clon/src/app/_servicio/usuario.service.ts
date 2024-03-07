import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../_modelo/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url:string = "http://localhost:3000/api/usuarios"

  constructor(private http:HttpClient) { }

  getUsuarios(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.url);
  }
}
