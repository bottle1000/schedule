package pbc.schedule.lv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UserBaseEntity {

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdAt;
}
