package sky.pro.Employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Employee.model.Question;
import sky.pro.Employee.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/add")
    public Question addQuestions(@RequestParam("question") String questionText,
                                 @RequestParam("answer") String answer) {
        return questionService.addQuestions(questionText, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String questionText,
                                   @RequestParam("answer") String answer) {
        return questionService.removeQuestions(questionText, answer);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam("question") String questionText) {
        return questionService.findQuestions(questionText);
    }
}
