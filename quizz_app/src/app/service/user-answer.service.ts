import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserAnswerService {
  private apiUrl = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) { }

  submitAnswer(answer: any):Observable<any>{
    return this.http.post<any>(this.apiUrl + "submitAnswer", answer);
  }
}
