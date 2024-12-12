package pbc.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbc.schedule.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
