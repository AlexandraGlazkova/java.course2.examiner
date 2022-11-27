package pro.sky.java.course2.examinerservice.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class MathController {
    private final QuestionService service;

    public MathController(@Qualifier(value = "mathQuestionService") QuestionService service) {
        this.service = service;
    }

    @GetMapping(path = "/java/addMath")
    public Boolean addQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer) {
        return service.addQuestion(question, answer);
    }

    @GetMapping(path = "/java/removeMath")
    public Boolean removeQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer) {
        return service.removeQuestion(new Question(question, answer));
    }

    @GetMapping(path = "/javaMath")
    public Object getAll() {
        Collection<Question> questions = null;
        try {
            questions = service.getAllQuestions();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return questions;
    }
}
