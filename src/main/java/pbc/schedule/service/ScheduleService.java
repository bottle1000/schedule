package pbc.schedule.service;

import pbc.schedule.dto.ScheduleResponseDto;

public interface ScheduleService {
    ScheduleResponseDto createSchedule(String username, String title, String content);
}
