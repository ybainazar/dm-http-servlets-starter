package dmdev.http_servlets.exception;

import dmdev.http_servlets.validator.Error;
import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException{

    @Getter
    private final List<Error> errors;


    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }

}
