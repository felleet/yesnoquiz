package ru.quizgames.yesnoquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuizController {
    @FXML
    public Label questionText;
    private Iterator<Question> iterator;
    private Question currentQuestion;

    private int correctAnswersCounter;

    public void start(List<Question> questions) {
        correctAnswersCounter = 0;
        iterator = new ArrayList<>(questions).iterator();
        nextQuestion();
    }

    private void nextQuestion() {
        if (iterator.hasNext()) {
            currentQuestion = iterator.next();
            questionText.setText(currentQuestion.getText());
            System.out.println("Question: '" + currentQuestion.getText() + "' Answer: " + currentQuestion.getAnswer());
        } else {
            System.out.println("Questions finished");
        }
    }

    public void onYesButtonClick(ActionEvent actionEvent) {
        if (currentQuestion.getAnswer().equals(Answer.YES)) {
            correctAnswersCounter++;
            System.out.println("Correct answer. Result " + correctAnswersCounter);
        } else {
            System.out.println("Wrong answer. Correct is YES");
        }
        nextQuestion();
    }

    public void onNoButtonClick(ActionEvent actionEvent) {
        if (currentQuestion.getAnswer().equals(Answer.NO)) {
            correctAnswersCounter++;
            System.out.println("Correct answer. Result " + correctAnswersCounter);
        } else {
            System.out.println("Wrong answer. Correct is NO");
        }
        nextQuestion();
    }
}