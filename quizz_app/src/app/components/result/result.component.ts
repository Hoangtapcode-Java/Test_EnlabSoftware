import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResultService } from '../../service/result.service';
import { Result } from '../../model/Result';

@Component({
  selector: 'app-result',
  imports: [CommonModule],
  templateUrl: './result.component.html',
  styleUrl: './result.component.css'
})
export class ResultComponent implements OnInit{
  topicId!:number;
  result!:Result;
  constructor(private route:ActivatedRoute, private resultService: ResultService, private router: Router){

  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      this.topicId = Number(params.get('id'));
      console.log("topic:" + this.topicId)
      this.resultService.getResult(this.topicId, localStorage.getItem('email')!).subscribe(data =>{
        this.result = data;
      })
    })
  }

  exit(){
    localStorage.removeItem('email');
    this.router.navigateByUrl("/");
  }
  
}
