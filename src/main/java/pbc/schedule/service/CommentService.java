package pbc.schedule.service;

import pbc.schedule.dto.response.ScheduleResponseDto;

import java.util.List;

public interface CommentService {

    // 댓글 생성
    void createComment(Long postId, Long userId, String commentContent);

    //해당 포스트에 대한 모든 댓글 목록 조회
    List<Void> findCommentById(Long postId);

    // 해당 일정에 대한 특정 댓글 조회
    void findCommentById(Long postId, Long commentId);

    // 해당 일정에 대한 특정 댓글 식별 후, 수정
    void updatedComment(Long userId, Long commentId);

    // 해당 일정에 대한 특정 댓글 식별 후, 삭제
    void deleteByIdComment(Long userId, Long commentId);
}
