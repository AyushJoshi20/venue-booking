import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
    image_1 = "Images/Venue1.jpg";
  image_2 = "Images/Venue2.jpg";
  image_3 = "Images/Venue3.jpg";

}
