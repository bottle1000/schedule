package pbc.schedule.dto.response;

import lombok.Getter;
import pbc.schedule.entity.User;


@Getter
public class UserDto {

    private String username;
    private String email;

    private UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public static pbc.schedule.dto.response.UserDto from(User user) {
        return new pbc.schedule.dto.response.UserDto(user.getUsername(), user.getEmail());
    }

}

