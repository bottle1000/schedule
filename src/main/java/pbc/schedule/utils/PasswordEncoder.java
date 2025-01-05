package pbc.schedule.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    /**
     * 입력된 평문 비밀번호를 암호화 하는 메서드
     * @param rawPassword : 유저로 부터 입력 받은 평문 비밀번호
     * @return : 해쉬된 비밀번호를 반환
     */
    public String encode(String rawPassword) {
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, rawPassword.toCharArray());
    }

    /**
     * 평문 비밀번호와 저장된 암호화된 비밀번호를 비교
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
        return result.verified;
    }
}
