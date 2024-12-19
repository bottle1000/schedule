package pbc.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pbc.schedule.entity.Schedule;

@Getter
@AllArgsConstructor
public class ScheduleDto {

    private String title;
    private String content;

    public static ScheduleDto from(Schedule schedule) {
        return new ScheduleDto(
                schedule.getTitle(),
                schedule.getContent()
        );
    }
}
