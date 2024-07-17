package sky.pro.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NotEnoughQuestionsException extends RuntimeException{
    public NotEnoughQuestionsException() {
        super("Requested amount is too big. Not enough questions in system");
    }
}
