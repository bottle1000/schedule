package pbc.schedule.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

    @NotBlank(message = "제목은 필수 입력입니다.")
    @Size(min = 1, max = 12, message = "제목은 1자 이상 12자 이하여야합니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력입니다.")
    @Size(min = 1, message = "내용은 1자 이상이여야합니다.")
    private String content;
}
