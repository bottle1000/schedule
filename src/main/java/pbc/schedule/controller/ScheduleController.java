package pbc.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.dto.ScheduleRequestDto;
import pbc.schedule.dto.ScheduleResponseDto;
import pbc.schedule.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto
                = scheduleService.createSchedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContent());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule() {
        List<ScheduleResponseDto> allSchedule = scheduleService.findAllSchedule();

        return new ResponseEntity<>(allSchedule, HttpStatus.OK);
    }
}
