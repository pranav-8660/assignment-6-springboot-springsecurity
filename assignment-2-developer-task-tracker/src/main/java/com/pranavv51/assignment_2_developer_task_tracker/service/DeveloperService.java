package com.pranavv51.assignment_2_developer_task_tracker.service;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Developer;

import java.util.List;

public interface DeveloperService {

    Developer createDeveloper(Developer developer, Long projectId);
    Developer assignToProject(Long developerId, Long projectId);
    List<Developer> getDevelopersByProject(Long projectId);
    Developer getDeveloperById(Long id);
}
