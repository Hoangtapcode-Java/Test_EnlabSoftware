import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Questions } from '../model/Questions';
import { Answers } from '../model/Answers';

@Injectable({
  providedIn: 'root'
})
export class QuestionsService {
  private apiUrl = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) { }

  getQuestionsByTopic(id: number): Observable<Questions[]>{
    return this.http.get<Questions[]>(this.apiUrl + "getQuestionByTopic/" + id);
  }

  getAnswersByQuestion(id: number): Observable<Answers[]>{
    return this.http.get<Answers[]>(this.apiUrl + "getAnswersByQuestion/" + id);
  }
}
