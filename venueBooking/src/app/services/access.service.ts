import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccessService {

  constructor(private http : HttpClient) { }

  private baseUrl =  'http://localhost:8080/api/users';

  register(user : any):Observable<any>{
    return this.http.post(this.baseUrl + '/register' , user);
  }

  login(email : string , password:string):Observable<any>{
    return this.http.post(this.baseUrl + '/login',{email,password});
  }
}
