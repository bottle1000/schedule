package pbc.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pbc.schedule.dto.response.UserResponseDto;
import pbc.schedule.entity.User;
import pbc.schedule.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(String username, String email) {
        User user = new User(username, email);
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getUsername(), savedUser.getEmail());
    }

    @Override
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll().stream()
                .map(UserResponseDto :: toDto)
                .toList();
    }

    @Override
    public UserResponseDto findByIdUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("조회된 회원이 존재하지 않습니다."));

        return new UserResponseDto(user.getUsername(), user.getEmail());
    }

    @Override
    public void deleteByIdUser(Long userId) {
        userRepository.deleteById(userId);
    }


}