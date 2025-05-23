import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';
import { VenueService } from '../../services/venue.service';
import { FormsModule } from '@angular/forms';
import { BookingService } from '../../services/booking.service';

@Component({
  selector: 'app-venues',
  imports: [CommonModule,FormsModule],
  templateUrl: './venues.component.html',
  styleUrl: './venues.component.css'
})
export class VenuesComponent {

  constructor(private venueService : VenueService,private bookingService : BookingService){}
  booking: any = {};
  venues: any[] = [];

 image_1 = "Images/v1.jpg";

  ngOnInit(){
    this.venueService.displayVenues().subscribe((data) =>{
      this.venues = data;
    })
  }

onSubmit(venue: any) {
  const userId = sessionStorage.getItem('userId'); //  Get stored user ID
  if (!userId) {
    alert("User not logged in");
    return;
  }

  this.booking.user = { id: userId };  //  Only ID is needed
  this.booking.venue = { id: venue.id };  //  Assuming venue is passed

  this.bookingService.book(this.booking).subscribe({
    next: (response) => {
      console.log("Booking Successful");
      alert('Booking confirmed!');
    },
    error: (error) => {
      console.error('Booking Failed', error);
      alert('Booking failed. Please try again.');
    }
  });
}

}
