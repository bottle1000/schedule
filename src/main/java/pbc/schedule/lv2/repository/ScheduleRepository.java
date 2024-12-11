package pbc.schedule.lv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbc.schedule.lv2.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
