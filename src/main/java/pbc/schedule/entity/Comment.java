package pbc.schedule.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
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

    public Comment() {
    }

    public Comment(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
