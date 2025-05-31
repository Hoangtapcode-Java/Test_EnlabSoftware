import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  summitUser(user: User):Observable<any>{
    return this.http.post<any>(this.apiUrl + "addUser", user);
  }
}
