package pbc.schedule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.schedule.dto.request.CommentCreateRequestDto;
import pbc.schedule.dto.request.CommentUpdateRequestDto;

@RestController
@RequestMapping("/schedule/{scheduleId}/comment")
public class CommentController {

    //댓글 생성
    @PostMapping
    public ResponseEntity<> createComment(@PathVariable Long scheduleId,
                                          @RequestBody CommentCreateRequestDto requestDto) {

    }

    //특정 일정의 댓글 전체 조회
    @GetMapping
    public ResponseEntity<> findAllCommentByScheduleId(@PathVariable Long scheduleId) {

    }

    //특정 일정의 특정 댓글 조회
    @GetMapping("/{commentId}")
    public ResponseEntity<> findCommentByScheduleIdAndCommentId(@PathVariable Long scheduleId,
                                                                @PathVariable Long commentId) {

    }

    // 특정 일정의 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<> updateComment(@PathVariable Long scheduleId,
                                          @PathVariable Long commentId,
                                          @RequestBody CommentUpdateRequestDto requestDto) {

    }

    // 특정 일정의 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<> deleteComment(@PathVariable Long scheduleId,
                                          @PathVariable Long commentId) {

    }
}
