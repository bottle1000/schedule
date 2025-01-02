package pbc.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pbc.schedule.entity.Comment;

import java.util.List;

@Getter
@AllArgsConstructor
public class FindAllCommentResponseDto {
    private List<Comment> commentList;
}
