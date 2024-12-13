package pbc.schedule.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank(message = "이름 입력은 필수입니다!")
    @Size(min = 2, max = 5, message = "이름은 2자 이상 5자 이하여야합니다.")
    @Pattern(regexp = "^[가-힣]*$", message = "한글만 입력할 수 있습니다.")
    private String username;

    @NotBlank(message = "이메일 입력은 필수입니다!")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
            , message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotEmpty(message = "비밀번호 입력은 필수입니다!")
    @Size(min = 4, max = 12, message = "비밀번호는 4자 이상 12자 이하여야합니다.")
    private String password;
}
