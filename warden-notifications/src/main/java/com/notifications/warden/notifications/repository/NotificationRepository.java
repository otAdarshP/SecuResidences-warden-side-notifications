package com.notifications.warden.notifications.repository;

import com.notifications.warden.notifications.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByReadFalseOrderByCreatedAtDesc();
}
