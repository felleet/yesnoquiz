module ru.yesnoquiz.yesnoquiz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ru.quizegames.yesnoquiz to javafx.fxml;
    exports ru.quizegames.yesnoquiz;
}