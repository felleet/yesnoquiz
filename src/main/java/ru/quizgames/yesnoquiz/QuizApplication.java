package ru.quizgames.yesnoquiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QuizApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Background background;
        try (InputStream inputStream = QuizApplication.class.getResourceAsStream("background.jpg")) {
            Image image = new Image(inputStream);
            BackgroundSize size = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
            background = new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
        }

        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("main-view.fxml"));
        Pane loadQuestionsView = fxmlLoader.load();
        loadQuestionsView.setBackground(background);
        Scene scene = new Scene(loadQuestionsView, 620, 340);
        LoadQuestionsController loadQuestionsController = fxmlLoader.getController();
        loadQuestionsController.setPrimaryStage(stage);
        FXMLLoader quizLoader = new FXMLLoader(QuizApplication.class.getResource("quiz-view.fxml"));
        Pane quizView = quizLoader.load();
        quizView.setBackground(background);
        QuizController quizController = quizLoader.getController();
        loadQuestionsController.setOnStartCallback(questions -> {
            scene.setRoot(quizView);
            quizController.start(questions);
        });
        quizController.setFinishCallback(new FinishQuizCallback() {
            @Override
            public void onFinish(int correct, int total) {
                loadQuestionsController.setQuizResults(correct, total);
                scene.setRoot(loadQuestionsView);
            }
        });

        stage.setTitle("Викторина");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}