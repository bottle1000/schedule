package pbc.schedule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

    private Long userId; //유저 아이디 추가
    private String title;
    private String content;
}
