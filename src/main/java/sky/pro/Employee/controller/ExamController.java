package sky.pro.Employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Employee.model.Question;
import sky.pro.Employee.service.ExaminerService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
