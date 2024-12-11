package pbc.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pbc.schedule.entity.Schedule;
import pbc.schedule.entity.User;

@Getter
@AllArgsConstructor
public class UserResponseDto {

    private String username;
    private String email;

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getUsername(), user.getEmail());
    }

}
