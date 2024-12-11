package pbc.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pbc.schedule.dto.ScheduleResponseDto;
import pbc.schedule.entity.Schedule;
import pbc.schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponseDto createSchedule(String username, String title, String content) {
        Schedule schedule = new Schedule(username, title, content);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getUsername(), savedSchedule.getTitle(), savedSchedule.getContent());
    }
}
