package ru.quizgames.yesnoquiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 540);
        QuizController controller = fxmlLoader.getController();
        controller.setPrimaryStage(stage);
        stage.setTitle("Викторина");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}