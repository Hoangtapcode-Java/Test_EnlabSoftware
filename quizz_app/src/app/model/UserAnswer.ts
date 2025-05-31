import { Answers } from "./Answers";
import { Questions } from "./Questions";
import { User } from "./User";

export interface UserAnswer{
    id?: number;
    isCorrect?: Boolean;
    totalTime?: number;
    user?: User;
    questions?: Questions;
    answers?: Answers;
}