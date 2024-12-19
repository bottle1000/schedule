package pbc.schedule.service;

import pbc.schedule.dto.response.LoginResponseDto;
import pbc.schedule.dto.response.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(String username, String email, String password);

    List<UserDto> findAllUser();

    UserDto findByIdUser(Long userId);

    void deleteByIdUser(Long userId);

    LoginResponseDto login(String email, String password);
}
