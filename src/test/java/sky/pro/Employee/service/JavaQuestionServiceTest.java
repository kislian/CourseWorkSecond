package sky.pro.Employee.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sky.pro.Employee.exception.NotFoundQuestionsException;
import sky.pro.Employee.model.Question;

import java.util.List;

public class JavaQuestionServiceTest {
    private static final Question Q1 = new Question("Q1", "A1");
    private static final Question Q2 = new Question("Q2", "A2");
    private static final Question Q3 = new Question("Q3", "A3");

    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void test() {
        Assertions.assertEquals(0, javaQuestionService.getAllQuestions().size());

        Assertions.assertThrows(NotFoundQuestionsException.class, () -> {
            javaQuestionService.findQuestions(Q1.getQuestion());
        });

        Assertions.assertEquals(Q1, javaQuestionService.addQuestions(Q1.getQuestion(), Q1.getAnswer()));
        Assertions.assertEquals(Q2, javaQuestionService.addQuestions(Q2.getQuestion(), Q2.getAnswer()));
        Assertions.assertEquals(Q3, javaQuestionService.addQuestions(Q3.getQuestion(), Q3.getAnswer()));

        Assertions.assertEquals(3, javaQuestionService.getAllQuestions().size());

        Assertions.assertEquals(Q1, javaQuestionService.findQuestions(Q1.getQuestion()));
        Assertions.assertEquals(Q2, javaQuestionService.findQuestions(Q2.getQuestion()));
        Assertions.assertEquals(Q3, javaQuestionService.findQuestions(Q3.getQuestion()));

        Assertions.assertEquals(Q1, javaQuestionService.removeQuestions(Q1.getQuestion(), Q1.getAnswer()));

        Assertions.assertEquals(2, javaQuestionService.getAllQuestions().size());

        Assertions.assertEquals(Q2, javaQuestionService.findQuestions(Q2.getQuestion()));
        Assertions.assertEquals(Q3, javaQuestionService.findQuestions(Q3.getQuestion()));
        Assertions.assertThrows(NotFoundQuestionsException.class, () -> {
            javaQuestionService.findQuestions(Q1.getQuestion());
        });

        Assertions.assertThrows(NotFoundQuestionsException.class, () -> {
            javaQuestionService.removeQuestions(Q1.getQuestion(), Q1.getAnswer());
        });

        Assertions.assertTrue(List.of(Q2, Q3).contains(javaQuestionService.getRandomQuestion()));
    }

}
