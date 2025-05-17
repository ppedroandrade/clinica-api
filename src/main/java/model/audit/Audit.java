package model.audit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "audit_logs")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String entity;

    @Column(nullable = false)
    private Long entityId;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Audit(String action, Long userId, String entity, Long entityId) {
        this.action = action;
        this.userId = userId;
        this.entity = entity;
        this.entityId = entityId;
        this.timestamp = LocalDateTime.now();
    }

    public Audit() {}
}