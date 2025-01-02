package pbc.schedule.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pbc.schedule.dto.request.CommentCreateRequestDto;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "comment")
public class Comment extends CommentBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentContent;

    /**
     * 한 명의 유저는 여러 개의 댓글을 달 수 있다. 1 : N
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * 하나의 일정에는 여러 개의 댓글을 달 수 있다. 1 : N
     */
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public static Comment of(CommentCreateRequestDto dto, Schedule schedule, User user) {
        return new Comment(
                null, dto.getContent(), user, schedule
        );
    }

    public void updateContent(String content) {
        this.commentContent = content;
    }
}
