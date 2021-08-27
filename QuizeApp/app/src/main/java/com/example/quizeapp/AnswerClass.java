package com.example.quizeapp;

public class AnswerClass {

    private int optionA , optionB , optionC , optionD , answerId , questionId;

    public AnswerClass(int questionId , int optionA  , int optionB,int optionC , int optionD , int answerId ){
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answerId = answerId;
        this.questionId = questionId;
    }

    public int getOptionA() {
        return this.optionA;
    }

    public int getOptionB() {
        return this.optionB;
    }

    public int getOptionC() {
        return this.optionC;
    }

    public int getOptionD() {
        return this.optionD;
    }

    public int getAnswerId() {
        return this.answerId;
    }

    public int getQuestionId() {
        return this.questionId;
    }
}
