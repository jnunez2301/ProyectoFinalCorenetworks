import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Mensaje } from '../_modelo/Mensaje';

@Injectable({
  providedIn: 'root'
})
export class MensajeServiceService {

  baseURL:string = 'localhost:3000/api/mensajes/chats/'
  constructor(private http: HttpClient) { }

  getMsgById(id:number): Observable<Mensaje>{
    return this.http.get<Mensaje>(`${this.baseURL}/${id}`)
  }
}
