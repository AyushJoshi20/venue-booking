import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http : HttpClient) { }

  private baseUrl =  'http://localhost:8080/api';

  book(booking:any):Observable<any>{
    return this.http.post(this.baseUrl + '/bookings' , booking);
  }
}
