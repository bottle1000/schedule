package pbc.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.dto.request.UserRequestDto;
import pbc.schedule.dto.response.UserResponseDto;
import pbc.schedule.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto user = userService.createUser(userRequestDto.getUsername(), userRequestDto.getEmail());

        return new ResponseEntity<>(user, HttpStatus.OK);
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
