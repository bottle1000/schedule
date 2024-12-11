package pbc.schedule.service;

import pbc.schedule.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(String username, String email);

    List<UserResponseDto> findAllUser();

    UserResponseDto findByIdUser(Long userId);
}
