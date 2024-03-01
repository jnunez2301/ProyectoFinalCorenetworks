import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-busqueda',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './busqueda.component.html',
  styleUrl: './busqueda.component.css'
})
export class BusquedaComponent {
  @Output() buscarTermino = new EventEmitter<string>();
  terminoBusqueda: string = '';

  buscar() {
    this.buscarTermino.emit(this.terminoBusqueda);
  }
 
}
