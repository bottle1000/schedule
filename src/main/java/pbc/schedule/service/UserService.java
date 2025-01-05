package pbc.schedule.service;

import pbc.schedule.dto.request.LoginRequestDto;
import pbc.schedule.dto.request.UserRequestDto;
import pbc.schedule.dto.response.LoginResponseDto;
import pbc.schedule.dto.response.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserRequestDto userRequestDto);

    List<UserDto> findAllUser();

    UserDto findByIdUser(Long userId);

    void deleteByIdUser(Long userId);

    String login(LoginRequestDto request);
}
