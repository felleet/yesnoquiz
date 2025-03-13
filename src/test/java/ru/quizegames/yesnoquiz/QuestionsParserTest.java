package ru.quizegames.yesnoquiz;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.quizegames.yesnoquiz.Answer.NO;
import static ru.quizegames.yesnoquiz.Answer.YES;

class QuestionsParserTest {

    @Test
    void parse() throws IOException {
        List<Question> actual = new QuestionsParser().parse(Paths.get("src/test/resources/questions.csv"));
        List<Question> expected = List.of(new Question("вы робот", NO), new Question("три умножить на два равно шесть", YES));
        assertEquals(expected, actual);
    }
}