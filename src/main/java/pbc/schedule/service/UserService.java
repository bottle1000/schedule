package pbc.schedule.service;

import pbc.schedule.dto.response.LoginResponseDto;
import pbc.schedule.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(String username, String email, String password);

    List<UserResponseDto> findAllUser();

    UserResponseDto findByIdUser(Long userId);

    void deleteByIdUser(Long userId);

    LoginResponseDto login(String email, String password);
}
