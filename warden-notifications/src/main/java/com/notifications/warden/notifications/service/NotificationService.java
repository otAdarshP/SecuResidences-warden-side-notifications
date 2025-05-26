package com.notifications.warden.notifications.service;

import com.notifications.warden.notifications.entity.Notification;
import com.notifications.warden.notifications.repository.NotificationRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository repo;
    private final SimpMessagingTemplate messaging;

    public NotificationService(NotificationRepository repo, SimpMessagingTemplate messaging) {
        this.repo = repo;
        this.messaging = messaging;
    }

    public Notification create(String type, String message, Long refId) {
        Notification n = repo.save(new Notification(type, message, refId));
        messaging.convertAndSend("/topic/warden-notifications", n);
        return n;
    }

    public List<Notification> getUnread() {
        return repo.findByReadFalseOrderByCreatedAtDesc();
    }

    @Transactional
    public void markAsRead(Long id) {
        repo.findById(id).ifPresent(n -> n.setRead(true));
    }
}

