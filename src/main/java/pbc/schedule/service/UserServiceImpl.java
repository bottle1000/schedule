package pbc.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pbc.schedule.dto.response.LoginResponseDto;
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
    public UserResponseDto createUser(String username, String email, String password) {
        User user = new User(username, email, password);
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getUsername(), savedUser.getEmail());
    }

    /**
     * 로그인 기능
     * @param email : /login 요청 받은 email
     * @param password : /login 요청 받은 password
     * @return
     */
    @Override
    public LoginResponseDto login(String email, String password) {
        /**
         * 유저Repository 에서 email을 찾고 해당 유저가 있다면 그 유저를 반환 받음
         */
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("없는 이메일 입니다."));

        /**
         * 반환 받은 유저 객체의 password 와 요청 받은 password 를 비교함
         */
        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀빈호가 일치하지 않습니다.");
        }

        return new LoginResponseDto(user.getId());
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
