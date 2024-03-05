import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatIconModule} from '@angular/material/icon';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [RouterModule, MatIconModule, CommonModule],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {
  modalOpen:boolean = false;
  abrirModal(){
    this.modalOpen = true;
  }
  cerrarModal(){
    this.modalOpen = false;
  }
}
