package pbc.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbc.schedule.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByScheduleId(Long scheduleId);
}
