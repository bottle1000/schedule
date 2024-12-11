package pbc.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.dto.request.ScheduleRequestDto;
import pbc.schedule.dto.request.UpdatedRequestScheduleDto;
import pbc.schedule.dto.response.ScheduleResponseDto;
import pbc.schedule.service.ScheduleService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findByIdSchedule(@PathVariable Long id) {
        ScheduleResponseDto byIdSchedule = scheduleService.findByIdSchedule(id);

        return new ResponseEntity<>(byIdSchedule, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatedByIdSchedule(@PathVariable Long id, @RequestBody UpdatedRequestScheduleDto dto) {
        scheduleService.updatedByIdSchedule(id, dto.getContent());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
