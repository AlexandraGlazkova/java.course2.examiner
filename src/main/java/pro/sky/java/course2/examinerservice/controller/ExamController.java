package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {

        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        Collection<Question> random = null; random = examinerService.getQuestions(amount);
        return random;
    }


}
