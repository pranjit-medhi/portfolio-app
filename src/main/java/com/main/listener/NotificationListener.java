package com.main.listener;

import com.main.event.ProjectEvent;
import com.main.service.NotificationService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    private final NotificationService notificationService;

    public NotificationListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Async
    @EventListener
    public void handleProjectCreatedEvent(ProjectEvent event) {

        notificationService.notifyNewProject(event);
    }
}
