package pbc.schedule.lv2.service;

import pbc.schedule.lv2.dto.response.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto createSchedule(String username, String title, String content);
    List<ScheduleResponseDto> findAllSchedule();
    ScheduleResponseDto findByIdSchedule(Long scheduleId);
    void updatedByIdSchedule(Long scheduleId, String content);
    void deleteByIdSchedule(Long scheduleId);
}
