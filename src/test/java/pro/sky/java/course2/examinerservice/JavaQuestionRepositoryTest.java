package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examinerservice.controller.Constants.*;
import static pro.sky.java.course2.examinerservice.controller.Constants.JAVA_OBJ_QUESTION_5;

public class JavaQuestionRepositoryTest {
    private final QuestionRepository out = new JavaQuestionRepository();

    @Test
    void shouldReturnCorrectQuestionInMethodAdd() {
        assertEquals(JAVA_OBJ_QUESTION_2, out.addQuestion(JAVA_OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnTrueInMethodAdd() {
        out.addQuestion(JAVA_OBJ_QUESTION_2);
        assertTrue(out.getAllQuestions().contains(JAVA_OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnQuestionInMethodRemove() {
        out.addQuestion(JAVA_OBJ_QUESTION_2);
        assertEquals(JAVA_OBJ_QUESTION_2, out.removeQuestion(JAVA_OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnFalseInMethodRemove() {
        out.addQuestion(JAVA_OBJ_QUESTION_1);
        out.removeQuestion(JAVA_OBJ_QUESTION_1);
        assertFalse(out.getAllQuestions().contains(JAVA_OBJ_QUESTION_1));
    }

    @Test
    void shouldReturnCorrectCollectionOfQuestionInMethodGetAll() {
        Set<Question> expected = new HashSet<>();
        expected.add(JAVA_OBJ_QUESTION_1);
        expected.add(JAVA_OBJ_QUESTION_4);
        expected.add(JAVA_OBJ_QUESTION_5);


        out.addQuestion(JAVA_OBJ_QUESTION_5);
        out.addQuestion(JAVA_OBJ_QUESTION_4);
        out.addQuestion(JAVA_OBJ_QUESTION_1);


        assertEquals(expected, out.getAllQuestions());
    }
}

