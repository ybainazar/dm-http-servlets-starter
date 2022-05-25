package dmdev.http_servlets.service;

import dmdev.http_servlets.dao.UserDao;
import dmdev.http_servlets.dto.CreateUserDto;
import dmdev.http_servlets.entity.User;
import dmdev.http_servlets.exception.ValidationException;
import dmdev.http_servlets.mapper.CreateUserMapper;
import dmdev.http_servlets.validator.CreateUserValidator;
import dmdev.http_servlets.validator.ValidationResult;
import lombok.SneakyThrows;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
//        validation
//        map
//        userDao.save
//        return id
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        userDao.save(userEntity);

        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
