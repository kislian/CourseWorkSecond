package sky.pro.Employee.service;

import org.springframework.stereotype.Service;
import sky.pro.Employee.exception.NotEnoughQuestionsException;
import sky.pro.Employee.model.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (questionService.getAllQuestions().size() < amount) {
            throw new NotEnoughQuestionsException();
        }

        Set<Question> set = new HashSet();
        while (set.size() < amount) {
            set.add(questionService.getRandomQuestion());
        }
        return new ArrayList(set);
    }
}
