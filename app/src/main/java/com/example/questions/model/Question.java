package com.example.questions.model;

public class Question {
    int questionId;
    boolean answerCorrect;

   public Question(int questionId, boolean answerCorrect) {
        this.questionId = questionId;
        this.answerCorrect = answerCorrect;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(boolean answerCorrect) {
        this.answerCorrect = answerCorrect;
    }
}
