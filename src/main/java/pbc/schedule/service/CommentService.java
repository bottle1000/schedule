package pbc.schedule.service;

import pbc.schedule.dto.response.FindAllCommentResponseDto;
import pbc.schedule.dto.response.SaveCommentResponseDto;

import java.util.List;

public interface CommentService {

    // 댓글 생성
    SaveCommentResponseDto createComment(Long userId,Long scheduleId, String commentContent);

    //해당 일정에 대한 모든 댓글 목록 조회
    FindAllCommentResponseDto findAllCommentByScheduleId(Long scheduleId);

    // 해당 일정에 대한 특정 댓글 조회
    void findCommentByScheduleIdAndCommentId(Long scheduleId, Long commentId);

    // 해당 일정에 대한 특정 댓글 식별 후, 수정
    void updatedComment(Long userId, Long commentId);

    // 해당 일정에 대한 특정 댓글 식별 후, 삭제
    void deleteByIdComment(Long userId, Long commentId);
}
