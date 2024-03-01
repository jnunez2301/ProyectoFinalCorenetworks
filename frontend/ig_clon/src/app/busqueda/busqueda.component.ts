import { Component } from '@angular/core';

@Component({
  selector: 'app-busqueda',
  standalone: true,
  imports: [],
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
