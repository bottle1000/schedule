package pbc.schedule.lv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pbc.schedule.lv2.dto.response.ScheduleResponseDto;
import pbc.schedule.lv2.entity.Schedule;
import pbc.schedule.lv2.repository.ScheduleRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponseDto createSchedule(String username, String title, String content) {
        Schedule schedule = new Schedule(username, title, content);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getUsername(), savedSchedule.getTitle(), savedSchedule.getContent());
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    @Override
    public ScheduleResponseDto findByIdSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NoSuchElementException("일정 번호가 존재하지 않습니다"));
        return new ScheduleResponseDto(
                        schedule.getUsername(),
                        schedule.getTitle(),
                        schedule.getContent()
                );
    }

    @Transactional
    @Override
    public void updatedByIdSchedule(Long scheduleId, String content) {
        Schedule findSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NoSuchElementException("일정 번호가 존재하지 않습니다."));
        findSchedule.updateContent(content);
    }

    @Override
    public void deleteByIdSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }
}
