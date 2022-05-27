package dm.http_servlets.mapper;

import dm.http_servlets.dto.CreateUserDto;
import dm.http_servlets.entity.Gender;
import dm.http_servlets.entity.Role;
import dm.http_servlets.entity.User;
import dm.http_servlets.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User>{

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    private static final String IMAGE_FOLDER = "users/";

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
