package dmdev.http_servlets.validator;

import lombok.Value;

@Value(staticConstructor = "of")
public class Error {

    String code;
    String message;
}
