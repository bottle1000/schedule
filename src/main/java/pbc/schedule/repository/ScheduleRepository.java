package pbc.schedule.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pbc.schedule.dto.response.SchedulePageDto;
import pbc.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("select new pbc.schedule.dto.response.AllScheduleDto(" +
            "s.title, s.content, size(s.commentList), s.createdAt, s.updatedAt, u.username) " +
            "from Schedule s " +
            "join s.user u " +
            "order by s.updatedAt DESC ")
    Page<SchedulePageDto> findByPagingAllSchedule(Pageable pageable);
}
