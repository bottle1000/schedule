package pbc.schedule;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pbc.schedule.entity.User;
import pbc.schedule.repository.UserRepository;
import pbc.schedule.utils.PasswordEncoder;
import pbc.schedule.utils.UserRoleEnum;

/**
 * 초기 관리자를 설정하는 클래스
 */

@Component
@RequiredArgsConstructor
public class InitData {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void init() {
        if (!userRepository.existsByUsername("박병천")) {
            User admin = new User(
                    null,
                    "박병천",
                    "genius1788@naver.com",
                    passwordEncoder.encode( "Qudcjs5027!"),
                    UserRoleEnum.ADMIN
            );
            userRepository.save(admin);
        }
    }
}
