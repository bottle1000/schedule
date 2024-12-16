package pbc.schedule.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.SessionConst;
import pbc.schedule.dto.request.CommentCreateRequestDto;
import pbc.schedule.dto.request.CommentUpdateRequestDto;
import pbc.schedule.dto.response.FindAllCommentResponseDto;
import pbc.schedule.dto.response.SaveCommentResponseDto;
import pbc.schedule.service.CommentService;

@RestController
@RequestMapping("/schedule/{scheduleId}/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 생성 기능
     * @param scheduleId : URL 을 통한 일정 Id 받기
     * @param requestDto : 댓글 작성에 필요한 정보를 담은 DTO 받기
     * @param session : 유저 ID를 받는 대신 로그인 된 사용자 세션에서 ID 받아오기
     * @return
     */
    @PostMapping
    public ResponseEntity<SaveCommentResponseDto> createComment(@PathVariable Long scheduleId,
                                                                @RequestBody CommentCreateRequestDto requestDto,
                                                                HttpSession session) {
        Long userId = (Long) session.getAttribute(SessionConst.LOGIN_USER);
        SaveCommentResponseDto saveCommentResponseDto =
                commentService.createComment(userId,scheduleId, requestDto.getContent());

        return new ResponseEntity<>(saveCommentResponseDto, HttpStatus.CREATED);
    }

    //특정 일정의 댓글 전체 조회
    @GetMapping
    public ResponseEntity<FindAllCommentResponseDto> findAllCommentByScheduleId(@PathVariable Long scheduleId) {
        FindAllCommentResponseDto allCommentResponseDto =
                commentService.findAllCommentByScheduleId(scheduleId);

        return new ResponseEntity<>(allCommentResponseDto, HttpStatus.OK);
    }

    // 특정 일정의 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId,
                                          @RequestBody CommentUpdateRequestDto requestDto) {
        commentService.updatedComment(commentId, requestDto.getUpdateContent());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 특정 일정의 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
