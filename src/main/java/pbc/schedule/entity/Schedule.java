package pbc.schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pbc.schedule.dto.request.ScheduleRequestDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule extends ScheduleBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Schedule of(ScheduleRequestDto scheduleRequestDto, User user) {
        return new Schedule(
                null, scheduleRequestDto.getTitle(), scheduleRequestDto.getContent(), user
        );
    }


    public void updateContent(String content) {
        this.content = content;
    }

}
