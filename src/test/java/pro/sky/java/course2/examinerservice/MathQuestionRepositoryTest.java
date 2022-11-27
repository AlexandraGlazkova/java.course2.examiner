package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.MathQuestionRepository;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examinerservice.controller.Constants.*;
import static pro.sky.java.course2.examinerservice.controller.Constants.MATH_OBJ_QUESTION_1;

public class MathQuestionRepositoryTest {
    private final QuestionRepository out = new MathQuestionRepository();

    @Test
    void shouldReturnCorrectQuestionInMethodAdd() {
        assertEquals(MATH_OBJ_QUESTION_2, out.addQuestion(MATH_OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnTrueInMethodAdd() {
        out.addQuestion(MATH_OBJ_QUESTION_2);
        assertTrue(out.getAllQuestions().contains(MATH_OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnQuestionInMethodRemove() {
        out.addQuestion(MATH_OBJ_QUESTION_2);
        assertEquals(MATH_OBJ_QUESTION_2, out.removeQuestion(MATH_OBJ_QUESTION_2));
    }

    @Test
    void shouldReturnFalseInMethodRemove() {
        out.addQuestion(MATH_OBJ_QUESTION_1);
        out.removeQuestion(MATH_OBJ_QUESTION_1);
        assertFalse(out.getAllQuestions().contains(MATH_OBJ_QUESTION_1));
    }

    @Test
    void shouldReturnCorrectCollectionOfQuestionInMethodGetAll() {
        Set<Question> expected = new HashSet<>();
        expected.add(MATH_OBJ_QUESTION_1);
        expected.add(MATH_OBJ_QUESTION_3);
        expected.add(MATH_OBJ_QUESTION_4);
        expected.add(MATH_OBJ_QUESTION_5);

        out.addQuestion(MATH_OBJ_QUESTION_5);
        out.addQuestion(MATH_OBJ_QUESTION_4);
        out.addQuestion(MATH_OBJ_QUESTION_1);
        out.addQuestion(MATH_OBJ_QUESTION_1);

        assertEquals(expected, out.getAllQuestions());
    }
}

