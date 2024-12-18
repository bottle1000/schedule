package pbc.schedule.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pbc.schedule.config.PasswordEncoder;
import pbc.schedule.dto.response.LoginResponseDto;
import pbc.schedule.dto.response.UserResponseDto;
import pbc.schedule.entity.User;
import pbc.schedule.exception.InvalidPasswordException;
import pbc.schedule.exception.NotFoundEmailException;
import pbc.schedule.exception.NotFoundUserException;
import pbc.schedule.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 유저 생성 기능(회원가입)
     * @param username
     * @param email
     * @param password
     * @return
     */
    @Override
    public UserResponseDto createUser(String username, String email, String password) {

        // 평문 비밀번호 암호화
        String encodePassword = passwordEncoder.encode(password);
        // 암호화된 비밀번호 확인
        log.info("암호화 된 비밀번호 = {}", encodePassword);

        User user = new User(username, email, encodePassword);
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
         * orElseThrow를 사용하여 Optional 에서 바로 객체를 받음
         */
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundEmailException("이메일이 존재하지 않습니다."));

        /**
         * 반환 받은 유저 객체의 password 와 요청 받은 password 를 비교함
         */
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
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
                .orElseThrow(() -> new NotFoundUserException("회원이 존재하지 않습니다."));

        return new UserResponseDto(user.getUsername(), user.getEmail());
    }

    @Override
    public void deleteByIdUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
