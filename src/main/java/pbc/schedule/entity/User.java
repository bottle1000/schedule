package pbc.schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pbc.schedule.dto.request.UserRequestDto;
import pbc.schedule.dto.response.UserDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User extends UserBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    public static User CreateUser(UserRequestDto userRequestDto, String encodePassword) {
        return new User(
                null, userRequestDto.getUsername(), userRequestDto.getEmail(), encodePassword
        );
    }
}
