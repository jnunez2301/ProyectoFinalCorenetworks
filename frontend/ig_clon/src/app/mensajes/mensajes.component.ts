import { Component, OnInit } from '@angular/core';
import { Usuario } from '../_modelo/Usuario';
import { UsuarioService } from '../_servicio/usuario.service';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { ionAddCircleOutline, ionChatboxEllipsesOutline, ionHappyOutline } from '@ng-icons/ionicons';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-mensajes',
  standalone: true,
  imports: [NgIconComponent, FormsModule],
  templateUrl: './mensajes.component.html',
  styleUrl: './mensajes.component.css',
  viewProviders: [provideIcons({ ionAddCircleOutline, ionHappyOutline, ionChatboxEllipsesOutline })],
})
export class MensajesComponent implements OnInit {
  public listaUsuarios$!: Usuario[];
  mensaje:string = '';
  errorMsg:string = '';

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe((data) => {
      this.listaUsuarios$ = data;
    });
  }

  enviarMensaje():void{
    if(this.mensaje.length < 2){
      this.errorMsg = 'La longitud del mensaje debe ser superior a 2ch'
    }
    console.log(this.mensaje);
    console.log('mensaje enviado');
    this.mensaje = '';
    
    
  }
}
