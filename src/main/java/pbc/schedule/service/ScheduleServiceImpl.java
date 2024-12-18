package pbc.schedule.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pbc.schedule.SessionConst;
import pbc.schedule.dto.response.AllScheduleDto;
import pbc.schedule.dto.response.ScheduleResponseDto;
import pbc.schedule.dto.response.UserResponseDto;
import pbc.schedule.entity.Schedule;
import pbc.schedule.entity.User;
import pbc.schedule.repository.ScheduleRepository;
import pbc.schedule.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    public ScheduleResponseDto createSchedule(HttpSession session, String title, String content) {
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("없는 사용자 입니다."));
        Schedule schedule = new Schedule(title, content);
        user.addSchedule(schedule);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getTitle(), savedSchedule.getContent());
    }

    @Override
    public Page<AllScheduleDto> findAllSchedule(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        return scheduleRepository.findByPagingAllSchedule(LocalDate.now(), pageRequest);
    }

    @Override
    public ScheduleResponseDto findByIdSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NoSuchElementException("일정 번호가 존재하지 않습니다"));
        return new ScheduleResponseDto(
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
