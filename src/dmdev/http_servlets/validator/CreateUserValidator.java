package dmdev.http_servlets.validator;

import dmdev.http_servlets.dto.CreateUserDto;
import dmdev.http_servlets.entity.Gender;
import dmdev.http_servlets.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto>{

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (!Gender.find(object.getGender()).isPresent()) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
