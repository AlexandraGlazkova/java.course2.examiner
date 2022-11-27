package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Boolean addQuestion(String question, String answer);
    Boolean addQuestion (Question question);
    Boolean removeQuestion (Question question);
    Collection<Question> getAllQuestions();
    Question getRandomQuestion();

}
