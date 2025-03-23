module ru.yesnoquiz.yesnoquiz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ru.quizgames.yesnoquiz to javafx.fxml;
    exports ru.quizgames.yesnoquiz;
}