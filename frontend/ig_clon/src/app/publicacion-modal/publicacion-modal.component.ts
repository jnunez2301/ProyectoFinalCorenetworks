import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Publicaciones } from '../_modelo/Publicaciones';

@Component({
  selector: 'app-publicacion-modal',
  standalone: true,
  imports: [],
  templateUrl: './publicacion-modal.component.html',
  styleUrl: './publicacion-modal.component.css'
})
export class PublicacionModalComponent {
  @Input() isOpen:boolean = false;
  @Input() idPublicacion:number = 0;
  @Output() cerrar: EventEmitter<any> = new EventEmitter();

  close() {
    this.cerrar.emit(); 
  }
}
