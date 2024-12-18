package pbc.schedule.controller;

import pbc.schedule.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.dto.request.ScheduleRequestDto;
import pbc.schedule.dto.request.UpdatedRequestScheduleDto;
import pbc.schedule.dto.response.AllScheduleDto;
import pbc.schedule.dto.response.ScheduleResponseDto;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Valid @RequestBody ScheduleRequestDto requestDto, HttpSession session) {
        ScheduleResponseDto scheduleResponseDto
                = scheduleService.createSchedule(session,requestDto.getTitle(), requestDto.getContent());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<AllScheduleDto>> findAllSchedule(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<AllScheduleDto> allSchedule = scheduleService.findAllSchedule(page, size);

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
