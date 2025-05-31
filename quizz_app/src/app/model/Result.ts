import { Topic } from "./Topic";
import { User } from "./User";

export interface Result{
    id?: number;
    totalTime?: number;
    correctAnswers?: number;
    statusPass?: Boolean;
    totalQuestions?: number;
    user?:User;
    topic?:Topic;
}