package pbc.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String title;

    private String content;

    public Schedule() {
    }

    public Schedule(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

}
