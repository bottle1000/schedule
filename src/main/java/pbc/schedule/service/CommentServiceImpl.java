package pbc.schedule.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pbc.schedule.dto.response.FindAllCommentResponseDto;
import pbc.schedule.dto.response.SaveCommentResponseDto;
import pbc.schedule.entity.Comment;
import pbc.schedule.entity.Schedule;
import pbc.schedule.entity.User;
import pbc.schedule.repository.CommentRepository;
import pbc.schedule.repository.ScheduleRepository;
import pbc.schedule.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    /**
     * @param scheduleId
     * @param commentContent
     */
    @Override
    public SaveCommentResponseDto createComment(Long userId, Long scheduleId, String commentContent) {
        Schedule findSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NoSuchElementException("찾으시는 일정이 존재하지 않습니다."));
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("해당 유저가 존재하지 않습니다."));

        Comment comment = new Comment(commentContent);

        findSchedule.addComment(comment);
        findUser.addComment(comment);

        Comment saveComment = commentRepository.save(comment);

        return new SaveCommentResponseDto(saveComment.getId(),saveComment.getSchedule().getId(),
                saveComment.getCommentContent(), saveComment.getUser().getUsername());
    }

    @Override
    public FindAllCommentResponseDto findAllCommentByScheduleId(Long scheduleId) {

        Schedule findSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()-> new NoSuchElementException("찾으시는 일정이 존재하지 않습니다."));
        return new FindAllCommentResponseDto(findSchedule.getCommentList());
    }

    @Override
    public void findCommentByScheduleIdAndCommentId(Long postId, Long scheduleId) {

    }

    @Override
    public void updatedComment(Long userId, Long scheduleId) {

    }

    @Override
    public void deleteByIdComment(Long userId, Long commentId) {

    }
}
