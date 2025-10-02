package com.pranavv51.assignment_2_developer_task_tracker.service;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(Long id);
    List<Project> getAllProjects();
}
