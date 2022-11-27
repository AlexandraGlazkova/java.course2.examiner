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
public class JavaController {
    private final QuestionService service;

    public JavaController(@Qualifier ("javaQuestionService") QuestionService service){

        this.service = service;
    }

    @GetMapping("/java/addJava")
    public Boolean addQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer) {
        return service.addQuestion(question, answer);
    }

    @GetMapping("/java/removeJava")
    public Boolean removeQuestion(
            @RequestParam ("question") String question,
            @RequestParam ("question") String answer) {

        return service.removeQuestion(new Question(question, answer));
    }

    @GetMapping("/javaJava")
    public Collection<Question> getAll(){
        Collection<Question> questions = null; questions = service.getAllQuestions();
        return questions;

    }
}
