package sky.pro.Employee.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.Employee.exception.NotEnoughQuestionsException;
import sky.pro.Employee.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private static final Question Q1 = new Question("Q1", "A1");
    private static final Question Q2 = new Question("Q2", "A2");
    private static final Question Q3 = new Question("Q3", "A3");

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestionsForBigAmountTest() {
        when(questionService.getAllQuestions()).thenReturn(List.of(Q1));

        assertThrows(NotEnoughQuestionsException.class, () -> {
            examinerService.getQuestions(2);
        });
    }

    @Test
    void getQuestionsTest() {
        when(questionService.getAllQuestions()).thenReturn(List.of(Q1, Q2));

        when(questionService.getRandomQuestion())
                .thenReturn(Q1)
                .thenReturn(Q1)
                .thenReturn(Q1)
                .thenReturn(Q2);

        List<Question> list = examinerService.getQuestions(2);

        assertEquals(2, list.size());
    }

    @Test
    void getQuestionsTest2() {
        when(questionService.getAllQuestions()).thenReturn(List.of(Q1, Q2, Q3));

        when(questionService.getRandomQuestion())
                .thenReturn(Q2)
                .thenReturn(Q3)
                .thenReturn(Q1);

        List<Question> list = examinerService.getQuestions(2);

        assertEquals(2, list.size());
        assertEquals(Q2, list.get(0));
        assertEquals(Q3, list.get(1));
    }
}

