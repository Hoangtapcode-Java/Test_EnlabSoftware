import { Component, OnInit } from '@angular/core';
import { Questions } from '../../model/Questions';
import { CommonModule } from '@angular/common';
import { QuestionsService } from '../../service/questions.service';
import { ActivatedRoute, Router } from '@angular/router';
import { interval, Subscription } from 'rxjs';
import { Answers } from '../../model/Answers';
import { ToastrService } from 'ngx-toastr';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { UserAnswerService } from '../../service/user-answer.service';
import { ResultService } from '../../service/result.service';

@Component({
  selector: 'app-question',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './question.component.html',
  styleUrl: './question.component.css'
})
export class QuestionComponent implements OnInit {
  topicId: number | null = null;
  currentQuestionIndex = 0;
  questions: Questions[] = [];
  currentQuestion: Questions | null = null;
  timer = 0;
  timerSubscription: Subscription | null = null;
  selectedAnswers: number[] = [];
  feedback: string | null = null;
  currentAnswers: Answers[] = [];
  showResult = false;
  previousAnswers: Answers[] = []; 
  answerForm!: FormGroup;
  checkCorrect: boolean = false;
  constructor(private questionsService: QuestionsService, private route: ActivatedRoute, private toastr: ToastrService, 
    private userAnswerService: UserAnswerService, private resultService: ResultService, private router: Router){
  
  }
  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      this.topicId = Number(params.get('id'));
      this.questionsService.getQuestionsByTopic(this.topicId).subscribe(data => {
        this.questions = data;
        this.loadCurrentQuestion();
      })
    })
  }

  loadCurrentQuestion(){
    this.currentQuestion = this.questions[this.currentQuestionIndex];

    if (this.currentQuestion?.id) {
      this.questionsService.getAnswersByQuestion(this.currentQuestion.id).subscribe(data => {
        this.currentAnswers = data;
      });
    }else {
      this.currentAnswers = [];
    }
    this.startTimer();
  }


  startTimer() {
    this.timer = 0;
    this.timerSubscription?.unsubscribe();
    this.timerSubscription = interval(1000).subscribe(() => {
      this.timer++;
    });
  }
  
  stopTimer() {
    this.timerSubscription?.unsubscribe();
  }

  selectSingleAnswer(answerId: number) {
    this.selectedAnswers = [answerId];
  }
  
  // Chọn nhiều đáp án (checkbox)
  toggleAnswerSelection(answerId: number) {
    const isMultipleChoice = this.currentQuestion?.options;
  
    if (isMultipleChoice) {
      if (this.selectedAnswers.includes(answerId)) {
        this.selectedAnswers = this.selectedAnswers.filter(id => id !== answerId);
      } else {
        this.selectedAnswers.push(answerId);
      }
    } else {
      this.selectedAnswers = [answerId];
    }
  }

  checkAnswers() {
    this.stopTimer();
    const correctAnswerIds = this.currentAnswers
      .filter(a => a.status)
      .map(a => a.id);
  
    const isCorrect =
      this.selectedAnswers.length === correctAnswerIds.length &&
      this.selectedAnswers.every(id => correctAnswerIds.includes(id));
  
    this.feedback = isCorrect ? 'Correct!' : 'Wrong!';
    const check = this.feedback === 'Correct!';
    this.checkCorrect = check;
    this.answerForm = new FormGroup({
      totalTime: new FormControl(this.timer),
      email: new FormControl(localStorage.getItem('email')),
      questionsId: new FormControl(this.currentQuestion?.id),
      answersId: new FormControl(this.selectedAnswers),
      isCorrect: new FormControl(this.checkCorrect),
      topicId: new FormControl(this.topicId)
    })
    this.userAnswerService.submitAnswer(this.answerForm.value).subscribe({next:
      (res) => {
        this.toastr.success("Your answer has been saved.")
      },
    })
  }
  

  nextQuestion() {
    this.currentQuestionIndex++;
    this.feedback = null;
    this.selectedAnswers = [];
  
    if (this.currentQuestionIndex < this.questions.length) {
      this.loadCurrentQuestion();
    } else {
      this.resultService.addResult(this.topicId!, localStorage.getItem('email')!).subscribe({
        next: (res) => {
          this.showResult = true;
          this.router.navigate(['/results', this.topicId]);
        },
        error: (err) => {
          console.error('Error submitting result:', err);
        }
      });
    }
  }
  

  onCheckboxChange(event: Event, answerId: number) {
    const inputElement = event.target as HTMLInputElement;
    const isChecked = inputElement.checked;
    this.toggleAnswerSelection(answerId);
  }
  
  
}
