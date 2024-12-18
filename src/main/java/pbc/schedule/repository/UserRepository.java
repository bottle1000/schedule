package pbc.schedule.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pbc.schedule.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

//    //Query 애노테이션을 사용하여 복잡한 JPQL 풀기 (3개 이상 정도 찾을 때)
//    @Query("select u from User u where u.username = :username")
//    Optional<User> findByUsername(@Param("username") String username);
}
