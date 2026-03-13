package com.main.service;

import com.main.entity.Project;
import com.main.event.ProjectEvent;

public interface NotificationService {
    void notifyNewProject(ProjectEvent project);

}
