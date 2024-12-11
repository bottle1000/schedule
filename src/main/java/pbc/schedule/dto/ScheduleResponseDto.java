package pbc.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pbc.schedule.entity.Schedule;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private String username;
    private String title;
    private String content;

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getUsername(), schedule.getTitle(), schedule.getContent());
    }
}
