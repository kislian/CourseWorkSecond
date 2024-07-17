package sky.pro.Employee.service;

import org.springframework.stereotype.Service;
import sky.pro.Employee.exception.NotFoundQuestionsException;
import sky.pro.Employee.model.Question;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private Map<String, Question> store = new HashMap<>();

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        String key = store.keySet().stream().toList().get(random.nextInt(store.size()));

        return store.get(key);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return store.values();
    }

    @Override
    public Question addQuestions(String questionText, String answer) {
        if (store.containsKey(questionText)) {
            store.get(questionText).setAnswer(answer);
        } else {
            store.put(questionText, new Question(questionText, answer));
        }
        return store.get(questionText);
    }

    @Override
    public Question removeQuestions(String questionText, String answer) {
        Question question = store.remove(questionText);
        if (question == null) {
            throw new NotFoundQuestionsException();
        }
        return question;
    }

    @Override
    public Question findQuestions(String questionText) {
        Question question = store.get(questionText);
        if (question == null) {
            throw new NotFoundQuestionsException();
        }
        return question;
    }
}
