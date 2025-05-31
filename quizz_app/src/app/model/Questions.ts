import { Topic } from "./Topic";

export interface Questions{
    id?: number;
    question?: string;
    options?: Boolean;
    explanation?: string;
    topic?: Topic;
}