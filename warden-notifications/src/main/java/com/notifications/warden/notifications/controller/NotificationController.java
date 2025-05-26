package com.notifications.warden.notifications.controller;

import com.notifications.warden.notifications.entity.Notification;
import com.notifications.warden.notifications.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warden/notifications")
public class NotificationController {
    private final NotificationService svc;

    public NotificationController(NotificationService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Notification> getUnread() {
        return svc.getUnread();
    }

    @PatchMapping("/{id}/read")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void markAsRead(@PathVariable Long id) {
        svc.markAsRead(id);
    }
}
