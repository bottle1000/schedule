package pbc.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
public class User extends UserBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Schedule> scheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList = new ArrayList<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    //연관관계 편의 추가 메서드
    public void addSchedule(Schedule schedule) {
        scheduleList.add(schedule);
        schedule.setUser(this);
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
        comment.setUser(this);
    }

    //연관관계 편의 삭제 메서드
    public void removeSchedule(Schedule schedule) {
        scheduleList.remove(schedule);
        schedule.setUser(null);
    }

    public void removeComment(Comment comment) {
        commentList.remove(comment);
        comment.setUser(null);
    }
}
