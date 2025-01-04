package pbc.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pbc.schedule.entity.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommentResponseDto {
    private Long id;
    private Long scheduleId;
    private String content;
    private String author;

    public static SaveCommentResponseDto converDto(Comment comment) {
        return new SaveCommentResponseDto(
                comment.getId(),
                comment.getSchedule().getId(),
                comment.getCommentContent(),
                comment.getUser().getUsername()
        );
    }
}
