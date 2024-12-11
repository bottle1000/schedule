package pbc.schedule.lv2.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
public class User extends UserBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Schedule> scheduleList = new ArrayList<>();
    private String email;

    public User() {
    }

    public User(List<Schedule> scheduleList, String email) {
        this.scheduleList = scheduleList;
        this.email = email;
    }
}
