package pbc.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbc.schedule.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
