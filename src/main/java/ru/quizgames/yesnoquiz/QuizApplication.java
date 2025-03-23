package ru.quizgames.yesnoquiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class QuizApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("main-view.fxml"));
        Pane loadQuestionsView = fxmlLoader.load();
        Scene scene = new Scene(loadQuestionsView, 620, 340);
        LoadQuestionsController loadQuestionsController = fxmlLoader.getController();
        loadQuestionsController.setPrimaryStage(stage);
        FXMLLoader quizLoader = new FXMLLoader(QuizApplication.class.getResource("quiz-view.fxml"));
        Pane quizView = quizLoader.load();
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