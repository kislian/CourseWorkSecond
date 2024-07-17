package sky.pro.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundQuestionsException  extends RuntimeException{
    public NotFoundQuestionsException() {
        super("Not found question in system");
    }
}
