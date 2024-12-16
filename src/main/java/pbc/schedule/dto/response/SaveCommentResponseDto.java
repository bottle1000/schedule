package pbc.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveCommentResponseDto {
    private Long id;
    private Long scheduleId;
    private String content;
    private String author;
}
