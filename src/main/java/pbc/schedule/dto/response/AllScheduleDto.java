package pbc.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class AllScheduleDto {
    private String title;
    private String content;
    private Long size;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String username;
}
