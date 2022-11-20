package pro.sky.java.course2.examinerservice.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.excepshion.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.service.QuestionService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService javaQuestionService;
    private QuestionService mathQuestionService;
    private Collection<Question> randomQuestions = new HashSet<>();

    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        this.random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAllQuestions().size() + mathQuestionService.getAllQuestions().size()) {
            throw new QuestionAlreadyAddedException("Недостаточно вопросов");
        }
        randomQuestions.clear();
//        while (randomQuestions.size() < amount) {
//            int questionCategory = random.nextInt(2);
//            switch (questionCategory) {
//                case 0:
//                    Question question1 = javaQuestionService.getRandomQuestion();
//                    randomQuestions.add(question1);
//                    break;
//                case 1:
//                    Question question2 = mathQuestionService.getRandomQuestion();
//                    randomQuestions.add(question2);
//                    break;
//                default:
//                    throw new RuntimeException("Недопустимое значение: " + questionCategory);
//            }
//        }
        return randomQuestions;
    }
}

