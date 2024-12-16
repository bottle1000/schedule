package pbc.schedule.service;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import pbc.schedule.dto.response.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto createSchedule(HttpSession session, String title, String content);
    List<ScheduleResponseDto> findAllSchedule();
    ScheduleResponseDto findByIdSchedule(Long scheduleId);
    void updatedByIdSchedule(Long scheduleId, String content);
    void deleteByIdSchedule(Long scheduleId);
}
