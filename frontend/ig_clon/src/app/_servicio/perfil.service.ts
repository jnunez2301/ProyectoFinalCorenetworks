import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Perfilusuario } from '../_modelo/perfilusuario';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {
  // confirmar url 
  url:string = "http:/localhost:3000/api/perfil"
  constructor(private http: HttpClient) { }

  obtenerPerfil(id: number): Observable <Perfilusuario> {
  return this.http.get<Perfilusuario>(`${this.url}/${id}`);
  }

  actualizarPerfil(p:Perfilusuario): Observable <Perfilusuario>  {
    return this.http.put<Perfilusuario>(`${this.url}/${p.idPerfil}`,p);

  }
    
  eliminarPerfil(id: number) {
    return this.http.delete (`${this.url}/${id}`);


  }

  altaPerfil(p:Perfilusuario): Observable <Perfilusuario>  {
    return this.http.post<Perfilusuario>(`${this.url}/${p.idPerfil}`,p);

  }
  
}
