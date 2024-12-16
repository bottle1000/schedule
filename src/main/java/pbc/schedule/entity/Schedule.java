package pbc.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends ScheduleBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    private String content;

    @OneToMany(mappedBy = "schedule")
    private List<Comment> commentList = new ArrayList<>();

    public Schedule() {
    }

    // 연관관계 편의 추가 메서드
    public void addComment(Comment comment) {
        commentList.add(comment);
        comment.setSchedule(this);
    }

    //연관관계 편의 삭제 메서드
    public void removeComment(Comment comment) {
        commentList.remove(comment);
        comment.setSchedule(null);
    }

    public Schedule(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void updateContent(String content) {
        this.content = content;
    }

}
