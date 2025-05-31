import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResultService {
  private apiUrl = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) { }

  addResult(topicId: number, email:string):Observable<any>{
    let params = new HttpParams()
          .set('topicId', topicId)
          .set('email', email)
    return this.http.post<any>(this.apiUrl + "addResult",{}, {params});
  }

  getResult(topicId: number, email:string):Observable<any>{
    let params = new HttpParams()
          .set('topicId', topicId)
          .set('email', email)
    return this.http.get<any>(this.apiUrl + "getResult",{params});
  }
}
