package pbc.schedule.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter

@EntityListeners(AuditingEntityListener.class)
public abstract class CommentBaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column
    private LocalDate updatedAt;
}
