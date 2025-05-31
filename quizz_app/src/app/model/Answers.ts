import { Questions } from "./Questions";
export interface Answers{
    id?: number;
    answer?: string;
    status?: Boolean;
    questions?: Questions;
}