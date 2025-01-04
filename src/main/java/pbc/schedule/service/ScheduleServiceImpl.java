package pbc.schedule.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pbc.schedule.SessionConst;
import pbc.schedule.dto.request.ScheduleRequestDto;
import pbc.schedule.dto.response.SchedulePageDto;
import pbc.schedule.dto.response.ScheduleDto;
import pbc.schedule.entity.Schedule;
import pbc.schedule.entity.User;
import pbc.schedule.exception.NotFoundScheduleIdException;
import pbc.schedule.exception.NotFoundUserException;
import pbc.schedule.repository.ScheduleRepository;
import pbc.schedule.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    public ScheduleDto createSchedule(HttpSession session, ScheduleRequestDto scheduleRequestDto) {
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundUserException("없는 사용자 입니다."));

        Schedule schedule = Schedule.of(scheduleRequestDto, user);
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return ScheduleDto.convertDto(savedSchedule);
    }

    @Override
    public Page<SchedulePageDto> findAllSchedule(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        return scheduleRepository.findByPagingAllSchedule(pageRequest);
    }

    @Override
    public ScheduleDto findByIdSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NotFoundScheduleIdException("일정 번호가 존재하지 않습니다"));
        return ScheduleDto.convertDto(schedule);
    }

    @Transactional
    @Override
    public ScheduleDto updatedByIdSchedule(Long scheduleId, String content) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NotFoundScheduleIdException("일정 번호가 존재하지 않습니다."));
        schedule.updateContent(content);
        return ScheduleDto.convertDto(schedule);
    }

    @Override
    public void deleteByIdSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }
}
