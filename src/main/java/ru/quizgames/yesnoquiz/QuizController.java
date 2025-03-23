package ru.quizgames.yesnoquiz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizController {
    @FXML
    public Button startButton;
    @FXML
    public Button loadButton;
    @FXML
    private Label welcomeText;
    FileChooser fileChooser = new FileChooser();
    private Window primaryStage;
    private List<Question> questions = new ArrayList<>();

    @FXML
    private void initialize() {
        startButton.setDisable(questions.isEmpty());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
    }

    @FXML
    protected void onLoadQuestionsButtonClick() {
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        System.out.printf("File selected: %s%n", selectedFile);
        try {
            questions = new QuestionsParser().parse(selectedFile.toPath());
            System.out.println("Loaded questions: " + questions);
            welcomeText.setText("Загружено вопросов: " + questions.size());
            startButton.setDisable(questions.isEmpty());
        } catch (IOException e) {
            System.out.println("Failed to load questions: " + e);
            welcomeText.setText("Ошибка при загрузке вопросов.");
        }
    }

    public void onStartButtonClick() {
        if (questions.isEmpty()) {
            System.out.println("Need to load questions!");
        } else {
            System.out.println("Start button pressed!");
        }
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}