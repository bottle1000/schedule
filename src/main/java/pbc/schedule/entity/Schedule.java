package pbc.schedule.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String title;

    private String content;
}
