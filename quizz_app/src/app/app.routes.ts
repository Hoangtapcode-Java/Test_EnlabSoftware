import { Routes } from '@angular/router';
import { StartComponent } from './components/start/start.component';
import { QuestionComponent } from './components/question/question.component';
import { ResultComponent } from './components/result/result.component';
import { TopicComponent } from './components/topic/topic.component';

export const routes: Routes = [
    { path: '', component: StartComponent },
    { path: 'question/:id', component: QuestionComponent },
    { path: 'results/:id', component: ResultComponent },
    {path: 'topic', component: TopicComponent}
];