package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.impl.MathQuestionService;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;
import pro.sky.java.course2.examinerservice.service.QuestionService;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepositoryMock;
    @InjectMocks
    private QuestionService questionService = new MathQuestionService(questionRepositoryMock);

    @AfterEach
    public void AfterEach() {
        questionService.getAllQuestions().forEach(question -> questionService.removeQuestion(question));
    }

    @ParameterizedTest
    @MethodSource("params")
    void addQuestionPositiveTest(String question, String answer) {
        when(questionRepositoryMock.addQuestion(question, answer))
                .thenReturn(true);
        when(questionRepositoryMock.addQuestion(new Question(question, answer)))
                .thenReturn(true);

        assertEquals(true, questionService.addQuestion(question, answer));
        assertEquals(true, questionService.addQuestion(new Question(question, answer)));

        Mockito.verify(questionRepositoryMock, times(1)).addQuestion(question, answer);
        Mockito.verify(questionRepositoryMock, times(1)).addQuestion(new Question(question, answer));
    }

    @ParameterizedTest
    @MethodSource("params")
    void removeQuestionPositiveTest(String question, String answer) {
        when(questionRepositoryMock.removeQuestion(new Question(question, answer)))
                .thenReturn(true);
        assertEquals(true, questionService.removeQuestion(new Question(question, answer)));
        Mockito.verify(questionRepositoryMock, times(1)).removeQuestion(new Question(question, answer));
    }

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("Question1", "Answer1")
        );
    }
}

