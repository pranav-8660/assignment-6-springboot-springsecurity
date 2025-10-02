package com.pranavv51.assignment_2_developer_task_tracker.service.impl;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Project;
import com.pranavv51.assignment_2_developer_task_tracker.repository.ProjectRepository;
import com.pranavv51.assignment_2_developer_task_tracker.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}