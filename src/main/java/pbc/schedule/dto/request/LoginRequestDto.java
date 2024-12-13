package pbc.schedule.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestDto {

    @NotNull(message = "이메일 입력은 필수입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "이메일 형식에 맞게 입력해주세요.")
    private final String email;

    @NotBlank
    @Size(min = 4, max = 12, message = "비밀번호는 4자 이상 12자 이하여야합니다.")
    private final String password;
}
