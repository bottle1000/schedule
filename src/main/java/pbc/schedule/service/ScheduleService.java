package pbc.schedule.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import pbc.schedule.dto.response.AllScheduleDto;
import pbc.schedule.dto.response.ScheduleResponseDto;

public interface ScheduleService {
    ScheduleResponseDto createSchedule(HttpSession session, String title, String content);
    Page<AllScheduleDto> findAllSchedule(int page, int size);
    ScheduleResponseDto findByIdSchedule(Long scheduleId);
    void updatedByIdSchedule(Long scheduleId, String content);
    void deleteByIdSchedule(Long scheduleId);
}
