package pbc.schedule.lv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbc.schedule.lv1.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
