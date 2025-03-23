package ru.quizgames.yesnoquiz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadQuestionsController {
    @FXML
    public Button startButton;
    @FXML
    private Label welcomeText;
    FileChooser fileChooser = new FileChooser();
    private Window primaryStage;
    private List<Question> questions = new ArrayList<>();
    private StartQuizCallback startQuizCallback;

    @FXML
    private void initialize() {
        startButton.setDisable(questions.isEmpty());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        welcomeText.setFont(new Font("Arial", 30));
    }

    @FXML
    protected void onLoadQuestionsButtonClick() {
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        System.out.printf("File selected: %s%n", selectedFile);
        if (selectedFile != null) {
            try {
                questions = new QuestionsParser().parse(selectedFile.toPath());
                System.out.println("Loaded questions: " + questions);
                welcomeText.setText("Загружено вопросов: " + questions.size());
            } catch (Exception e) {
                questions = new ArrayList<>();
                System.out.println("Failed to load questions: " + e);
                welcomeText.setText("Ошибка при загрузке вопросов.");
            }
        }
        startButton.setDisable(questions.isEmpty());
    }

    public void onStartButtonClick() {
        if (questions.isEmpty()) {
            System.out.println("Need to load questions!");
        } else {
            System.out.println("Start button pressed!");
            startQuizCallback.onStart(questions);
        }
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setOnStartCallback(StartQuizCallback startQuizCallback) {
        this.startQuizCallback = startQuizCallback;
    }

    public void setQuizResults(int correct, int total) {
        welcomeText.setText("Результат: правильных ответов " + correct + " / " + total);
    }
}