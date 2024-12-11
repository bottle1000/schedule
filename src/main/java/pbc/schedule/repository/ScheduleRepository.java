package pbc.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbc.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
