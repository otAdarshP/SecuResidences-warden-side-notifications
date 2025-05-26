package com.notifications.warden.notifications.entity;

import jakarta.persistence.*;
import lombok.Setter;
import java.time.Instant;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String type;
    @Setter
    private String message;
    @Setter
    private Long referenceId;
    @Setter
    private Instant createdAt;
    @Setter
    private boolean read;

    public Notification() {
        this.createdAt = Instant.now();
        this.read = false;
    }

    public Notification(String type, String message, Long referenceId) {
        this();
        this.type = type;
        this.message = message;
        this.referenceId = referenceId;
    }

    // Getters and setters...
    public Long getId() { return id; }
    public String getType() { return type; }

    public String getMessage() { return message; }

    public Long getReferenceId() { return referenceId; }

    public Instant getCreatedAt() { return createdAt; }

    public boolean isRead() { return read; }
}
