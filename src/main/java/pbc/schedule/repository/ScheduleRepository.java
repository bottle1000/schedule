package pbc.schedule.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pbc.schedule.dto.response.AllScheduleDto;
import pbc.schedule.entity.Schedule;

import java.time.LocalDate;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("select new pbc.schedule.dto.response.AllScheduleDto(" +
            "s.title, s.content, size(s.commentList), s.createdAt, s.updatedAt, u.username) " +
            "from Schedule s " +
            "join s.user u " +
            "order by s.updatedAt DESC ")
    Page<AllScheduleDto> findByPagingAllSchedule(Pageable pageable);
}
