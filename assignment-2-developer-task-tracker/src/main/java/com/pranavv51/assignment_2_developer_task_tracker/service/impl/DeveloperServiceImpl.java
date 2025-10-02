package com.pranavv51.assignment_2_developer_task_tracker.service.impl;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Developer;
import com.pranavv51.assignment_2_developer_task_tracker.entity.Project;
import com.pranavv51.assignment_2_developer_task_tracker.repository.DeveloperRepository;
import com.pranavv51.assignment_2_developer_task_tracker.repository.ProjectRepository;
import com.pranavv51.assignment_2_developer_task_tracker.service.DeveloperService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final ProjectRepository projectRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, ProjectRepository projectRepository) {
        this.developerRepository = developerRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Developer createDeveloper(Developer developer, Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        developer.setProject(project);
        return developerRepository.save(developer);
    }

    @Override
    public Developer assignToProject(Long developerId, Long projectId) {
        Developer developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new RuntimeException("Developer not found"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        developer.setProject(project);
        return developerRepository.save(developer);
    }

    @Override
    public List<Developer> getDevelopersByProject(Long projectId) {
        return developerRepository.findByProjectId(projectId);
    }

    @Override
    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Developer not found"));
    }
}
