package ru.quizgames.yesnoquiz;

import java.util.List;

public interface StartQuizCallback {

    void onStart(List<Question> questions);
}
