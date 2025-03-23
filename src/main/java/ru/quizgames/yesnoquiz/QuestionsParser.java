package ru.quizgames.yesnoquiz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class QuestionsParser {

    public List<Question> parse(Path path) throws IOException {
        return Files.lines(path).map(line -> {
            String[] splited = line.split(";");
            String text = splited[0];
            Answer answer = Answer.valueOf(splited[1].toUpperCase());
            return new Question(text, answer);
        }).toList();
    }
}
