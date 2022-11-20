package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.impl.ExaminerServiceImpl;
import pro.sky.java.course2.examinerservice.impl.JavaQuestionService;
import pro.sky.java.course2.examinerservice.impl.MathQuestionService;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static pro.sky.java.course2.examinerservice.controller.Constants.*;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @Mock
    private MathQuestionService mathQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach() {
        List<Question> javaQuestions = List.of(
                new Question(JAVA_QUESTION_1, JAVA_ANSWER_1),
                new Question(JAVA_QUESTION_2, JAVA_ANSWER_2),
                new Question(JAVA_QUESTION_3, JAVA_ANSWER_3),
                new Question(JAVA_QUESTION_4, JAVA_ANSWER_4),
                new Question(JAVA_QUESTION_5, JAVA_ANSWER_5)
        );
        List<Question> mathQuestions = List.of(
                new Question(MATH_QUESTION_1, MATH_ANSWER_1),
                new Question(MATH_QUESTION_2, MATH_ANSWER_2),
                new Question(MATH_QUESTION_3, MATH_ANSWER_3),
                new Question(MATH_QUESTION_4, MATH_ANSWER_4),
                new Question(MATH_QUESTION_5, MATH_ANSWER_5)
        );
        when(javaQuestionServiceMock.getAllQuestions()).thenReturn(javaQuestions);
        when(mathQuestionServiceMock.getAllQuestions()).thenReturn(mathQuestions);

        examinerService = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);
    }

    @Test
    void getQuestionsPositiveTest() {
        Mockito.when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(new Question(JAVA_QUESTION_1, JAVA_ANSWER_1));

        assertThat(examinerService.getQuestions(1))
                .hasSize(1);

        Mockito.when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question(MATH_QUESTION_2, MATH_ANSWER_2),
                new Question(MATH_QUESTION_1, MATH_ANSWER_1),
                new Question(MATH_QUESTION_5, MATH_ANSWER_5));

        assertThat(examinerService.getQuestions(3))
                .hasSize(3);

        Mockito.when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question(JAVA_QUESTION_1, JAVA_ANSWER_1),
                new Question(JAVA_QUESTION_3, JAVA_ANSWER_3),
                new Question(JAVA_QUESTION_5, JAVA_ANSWER_5));
        assertThat(examinerService.getQuestions(3))
                .hasSize(3);
    }

    @Test
    void getQuestionsNegativeTest() {
        assertThatExceptionOfType(NotEnoughQuestionsException.class)
    }
     .isThrownBy(() -> examinerService.getQuestions(
            javaQuestionServiceMock.getAllQuestions().size() +
            mathQuestionServiceMock.getAllQuestions().size() + 1));
}

