package org.twoeye;

public class Question {
    private String category;
    private String question;
    private String[] answers;
    private int correctAnswerIndex;
    private boolean asked;

    public Question(String category, String question, String[] answers, int correctAnswerIndex) {
        this.category = category;
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
        this.asked = false;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
}