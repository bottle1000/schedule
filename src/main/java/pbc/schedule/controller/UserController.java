package pbc.schedule.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.SessionConst;
import pbc.schedule.dto.request.LoginRequestDto;
import pbc.schedule.dto.request.UserRequestDto;
import pbc.schedule.dto.response.LoginResponseDto;
import pbc.schedule.dto.response.UserResponseDto;
import pbc.schedule.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto user = userService.createUser(userRequestDto.getUsername(), userRequestDto.getEmail(), userRequestDto.getPassword());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto,
                                                     HttpServletResponse response,
                                                     HttpServletRequest request) {
        //로그인 유저 조회
        LoginResponseDto responseDto = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        if (responseDto.getId() == null) {
            // 로그인 실패 예외처리
            throw new NoSuchElementException("다시 로그인 해주세요");
        }

        //로그인 성공처리
        //세션 생성 및 사용자 정보 저장
        HttpSession session = request.getSession();

        //회원 정보 조회
        UserResponseDto loginUser = userService.findByIdUser(responseDto.getId());

        // Session 에 로그인 회원 정보를 저장
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);

        //세션 ID를 쿠키에 저장
        Cookie cookie = new Cookie("session_id", session.getId());
        //쿠키 값 세팅
        // Response Set-Cookie : session_id : UUID 형태로 전달
        response.addCookie(cookie);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser() {
        List<UserResponseDto> allUser = userService.findAllUser();

        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findByIdUser(@PathVariable Long id) {
        UserResponseDto byIdUser = userService.findByIdUser(id);

        return new ResponseEntity<>(byIdUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdUser(@PathVariable Long id) {
        userService.deleteByIdUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
