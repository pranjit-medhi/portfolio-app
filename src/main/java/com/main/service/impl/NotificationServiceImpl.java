package com.main.service.impl;

import com.main.entity.Project;
import com.main.event.ProjectEvent;
import com.main.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Override
    public void notifyNewProject(ProjectEvent project) {
        System.out.println("Project"+project);

    }
}
