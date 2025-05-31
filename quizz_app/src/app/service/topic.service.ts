import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Topic } from '../model/Topic';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TopicService {
  private apiUrl = 'http://localhost:8080/api/';
  constructor(private http: HttpClient){

  }
  getAllTopic():Observable<Topic>{
      return this.http.get<Topic>(this.apiUrl + "getAllTopic");
    }
}
