package pbc.schedule.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.SessionConst;
import pbc.schedule.dto.request.LoginRequestDto;
import pbc.schedule.dto.request.UserRequestDto;
import pbc.schedule.dto.response.LoginResponseDto;
import pbc.schedule.dto.response.UserDto;
import pbc.schedule.entity.User;
import pbc.schedule.exception.NotFoundEmailException;
import pbc.schedule.repository.UserRepository;
import pbc.schedule.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userService.createUser(userRequestDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginRequestDto request) {

        String token = userService.login(request);

        return new ResponseEntity<>(new LoginResponseDto(token), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUser() {
        List<UserDto> allUser = userService.findAllUser();

        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findByIdUser(@PathVariable Long id) {
        UserDto byIdUser = userService.findByIdUser(id);

        return new ResponseEntity<>(byIdUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdUser(@PathVariable Long id) {
        userService.deleteByIdUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
