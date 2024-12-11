package pbc.schedule.service;

import pbc.schedule.dto.ScheduleRequestDto;
import pbc.schedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto createSchedule(String username, String title, String content);
    List<ScheduleResponseDto> findAllSchedule();
}
