package dm.http_servlets.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
