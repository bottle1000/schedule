package pbc.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pbc.schedule.dto.response.UserResponseDto;
import pbc.schedule.entity.User;
import pbc.schedule.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(String username, String email) {
        User user = new User(username, email);
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getPassword(), savedUser.getEmail());
    }
}
