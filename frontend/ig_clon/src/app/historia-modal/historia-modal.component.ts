import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { ionPause, ionHeartOutline, ionSendOutline } from '@ng-icons/ionicons';

@Component({
  selector: 'app-historia-modal',
  standalone: true,
  imports: [NgIconComponent],
  templateUrl: './historia-modal.component.html',
  styleUrl: './historia-modal.component.css',
  viewProviders: [
    provideIcons({
      ionPause,
      ionHeartOutline,
      ionSendOutline
    })
  ]
})
export class HistoriaModalComponent{
 
  @Output() cerrar: EventEmitter<any> = new EventEmitter();

  close(){
    this.cerrar.emit();
  }
}
