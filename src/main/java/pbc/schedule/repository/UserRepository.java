package pbc.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbc.schedule.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
