package pbc.schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pbc.schedule.dto.request.CommentCreateRequestDto;
import pbc.schedule.dto.response.FindAllCommentResponseDto;
import pbc.schedule.dto.response.SaveCommentResponseDto;
import pbc.schedule.entity.Comment;
import pbc.schedule.entity.Schedule;
import pbc.schedule.entity.User;
import pbc.schedule.exception.NotFoundCommentException;
import pbc.schedule.exception.NotFoundScheduleIdException;
import pbc.schedule.exception.NotFoundUserException;
import pbc.schedule.repository.CommentRepository;
import pbc.schedule.repository.ScheduleRepository;
import pbc.schedule.repository.UserRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    /**
     * @param scheduleId
     */
    @Override
    public SaveCommentResponseDto createComment(Long userId, Long scheduleId, CommentCreateRequestDto dto) {
        Schedule findSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NotFoundScheduleIdException("찾으시는 일정이 존재하지 않습니다."));
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundUserException("해당 유저가 존재하지 않습니다."));

        Comment comment = Comment.of(dto, findSchedule, findUser);

        Comment saveComment = commentRepository.save(comment);

        return SaveCommentResponseDto.converDto(saveComment);
    }

    @Override
    public FindAllCommentResponseDto findAllCommentByScheduleId(Long scheduleId) {

        Schedule findSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()-> new NotFoundScheduleIdException("찾으시는 일정이 존재하지 않습니다."));
        List<Comment> commentList = commentRepository.findAllByScheduleId(scheduleId);
        return new FindAllCommentResponseDto(commentList);
    }

    @Transactional
    @Override
    public void updatedComment(Long commentId , String updateContent) {

        Comment findComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundCommentException("해당 댓글이 존재하지 않습니다."));
        findComment.updateContent(updateContent);
        commentRepository.save(findComment);
    }

    @Override
    public void deleteCommentById(Long commentId) {

        Comment findComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundCommentException("해당 댓글이 존재하지 않습니다."));

        commentRepository.delete(findComment);
    }
}
