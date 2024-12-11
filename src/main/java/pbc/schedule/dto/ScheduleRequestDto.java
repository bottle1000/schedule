package pbc.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pbc.schedule.entity.Schedule;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

    private String username;
    private String title;
    private String content;
}
