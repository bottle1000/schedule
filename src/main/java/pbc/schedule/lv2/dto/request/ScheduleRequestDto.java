package pbc.schedule.lv2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

    private String username;
    private String title;
    private String content;
}
