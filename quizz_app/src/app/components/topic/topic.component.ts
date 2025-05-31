import { Component, OnInit } from '@angular/core';
import { Topic } from '../../model/Topic';
import { CommonModule } from '@angular/common';
import { TopicService } from '../../service/topic.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-topic',
  imports: [CommonModule],
  templateUrl: './topic.component.html',
  styleUrl: './topic.component.css'
})
export class TopicComponent implements OnInit{
  topics: Topic[] = [];

  selectedTopicId: number | null = null;
  constructor(private topicService: TopicService, private router: Router){

  }
  ngOnInit() {
    this.topicService.getAllTopic().subscribe((data) =>{
      this.topics = data as Topic[];
    })
  }

  selectTopic(topicId: number){
    this.selectedTopicId = topicId;
  }

  startQuizz() {
    if(this.selectedTopicId != null){
      this.router.navigate(['/question', this.selectedTopicId]);
    }
    
  }
}
