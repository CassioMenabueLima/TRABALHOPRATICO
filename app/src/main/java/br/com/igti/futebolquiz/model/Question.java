package br.com.igti.futebolquiz.model;

import java.util.List;

public class Question {
    private String description;
    private int correctAnswer;
    private List<Answer> options;

    public Question(String description, int correctAnswer, List<Answer> options) {
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<Answer> getOptions() {
        return options;
    }

    public void setOptions(List<Answer> options) {
        this.options = options;
    }
}
