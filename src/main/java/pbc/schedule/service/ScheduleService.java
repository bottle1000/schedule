package pbc.schedule.service;

import pbc.schedule.dto.response.ScheduleResponseDto;
import pbc.schedule.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    ScheduleResponseDto createSchedule(String username, String title, String content);
    List<ScheduleResponseDto> findAllSchedule();
    ScheduleResponseDto findByIdSchedule(Long scheduleId);
    void updatedByIdSchedule(Long scheduleId, String content);
    void deleteByIdSchedule(Long scheduleId);
}
