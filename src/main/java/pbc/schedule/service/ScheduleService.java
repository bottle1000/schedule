package pbc.schedule.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import pbc.schedule.dto.response.SchedulePageDto;
import pbc.schedule.dto.response.ScheduleDto;

public interface ScheduleService {
    ScheduleDto createSchedule(HttpSession session, String title, String content);
    Page<SchedulePageDto> findAllSchedule(int page, int size);
    ScheduleDto findByIdSchedule(Long scheduleId);
    ScheduleDto updatedByIdSchedule(Long scheduleId, String content);
    void deleteByIdSchedule(Long scheduleId);
}
