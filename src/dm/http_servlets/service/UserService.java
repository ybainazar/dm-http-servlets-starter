package dm.http_servlets.service;

import dm.http_servlets.dao.UserDao;
import dm.http_servlets.dto.CreateUserDto;
import dm.http_servlets.dto.UserDto;
import dm.http_servlets.exception.ValidationException;
import dm.http_servlets.mapper.CreateUserMapper;
import dm.http_servlets.mapper.UserMapper;
import dm.http_servlets.validator.CreateUserValidator;
import lombok.SneakyThrows;

import java.util.Optional;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email,password)
                .map(userMapper::mapFrom);
    }

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
