package sky.pro.Employee.service;

import sky.pro.Employee.model.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
