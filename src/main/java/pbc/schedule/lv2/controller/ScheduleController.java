package pbc.schedule.lv2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.lv2.dto.request.ScheduleRequestDto;
import pbc.schedule.lv2.dto.request.UpdatedRequestScheduleDto;
import pbc.schedule.lv2.dto.response.ScheduleResponseDto;
import pbc.schedule.lv2.service.ScheduleService;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdSchedule(@PathVariable Long id) {
        scheduleService.deleteByIdSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
