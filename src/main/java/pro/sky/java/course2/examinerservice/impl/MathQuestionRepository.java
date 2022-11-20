package pro.sky.java.course2.examinerservice.impl;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.*;

import static pro.sky.java.course2.examinerservice.controller.Constants.*;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        questions.add(new Question(MATH_QUESTION_1, MATH_ANSWER_1));
        questions.add(new Question(MATH_QUESTION_2, MATH_ANSWER_2));
        questions.add(new Question(MATH_QUESTION_3, MATH_ANSWER_3));
        questions.add(new Question(MATH_QUESTION_4, MATH_ANSWER_4));
        questions.add(new Question(MATH_QUESTION_5, MATH_ANSWER_5));
    }

    @Override
    public Boolean addQuestion(String question, String answer) {
        return addQuestion(new Question(question, answer));
    }

    @Override
    public Boolean addQuestion(Question question) {
        if (questions.add(question)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean removeQuestion(Question question) {
        if (questions.remove(question)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.stream()
                .skip(new Random().nextInt(questions.size()))
                .findFirst()
                .orElse(null);
    }
}
