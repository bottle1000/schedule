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
import pbc.schedule.dto.response.SchedulePageDto;
import pbc.schedule.dto.response.ScheduleDto;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@Valid @RequestBody ScheduleRequestDto requestDto, HttpSession session) {
        ScheduleDto scheduleDto
                = scheduleService.createSchedule(session,requestDto.getTitle(), requestDto.getContent());

        return new ResponseEntity<>(scheduleDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<SchedulePageDto>> findAllSchedule(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<SchedulePageDto> schedulePageDto = scheduleService.findAllSchedule(page, size);

        return new ResponseEntity<>(schedulePageDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDto> findByIdSchedule(@PathVariable Long id) {
        ScheduleDto scheduleDto = scheduleService.findByIdSchedule(id);

        return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDto> updatedByIdSchedule(@PathVariable Long id, @RequestBody UpdatedRequestScheduleDto dto) {
        ScheduleDto scheduleDto = scheduleService.updatedByIdSchedule(id, dto.getContent());

        return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdSchedule(@PathVariable Long id) {
        scheduleService.deleteByIdSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
