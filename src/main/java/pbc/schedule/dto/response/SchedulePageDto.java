package pbc.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class SchedulePageDto {

    private String title;
    private String content;
    private int commentCount;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String username;
}
