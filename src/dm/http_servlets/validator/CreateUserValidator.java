package dm.http_servlets.validator;

import dm.http_servlets.dto.CreateUserDto;
import dm.http_servlets.entity.Gender;
import dm.http_servlets.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto>{

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (object.getName().isEmpty()) {
            validationResult.add(Error.of("invalid.name", "Name is invalid"));
        }
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
