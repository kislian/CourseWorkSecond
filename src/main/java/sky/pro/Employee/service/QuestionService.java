package sky.pro.Employee.service;

import sky.pro.Employee.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question getRandomQuestion();

    Collection<Question> getAllQuestions();

    Question addQuestions(String questionText, String answer);

    Question removeQuestions(String questionText, String answer);

    Question findQuestions(String questionText);
}
