package pbc.schedule.service;

import pbc.schedule.dto.response.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(String username, String email);
}
