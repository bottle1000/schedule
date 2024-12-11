package pbc.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

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

    public Schedule() {
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
