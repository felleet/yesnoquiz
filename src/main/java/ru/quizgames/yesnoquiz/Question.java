package ru.quizgames.yesnoquiz;

import java.util.Objects;

public class Question {

    private final String text;
    private final Answer answer;

    public Question(String text, Answer answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(text, question1.text) && answer == question1.answer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", answer=" + answer +
                '}';
    }
}
