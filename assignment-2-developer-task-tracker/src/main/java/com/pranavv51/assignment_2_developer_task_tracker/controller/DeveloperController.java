package com.pranavv51.assignment_2_developer_task_tracker.controller;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Developer;
import com.pranavv51.assignment_2_developer_task_tracker.service.DeveloperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping("/{projectId}")
    public Developer createDeveloper(@PathVariable Long projectId, @RequestBody Developer developer) {
        return developerService.createDeveloper(developer, projectId);
    }

    @PutMapping("/{developerId}/assign/{projectId}")
    public Developer assignDeveloperToProject(@PathVariable Long developerId, @PathVariable Long projectId) {
        return developerService.assignToProject(developerId, projectId);
    }

    @GetMapping("/{id}")
    public Developer getDeveloperById(@PathVariable Long id) {
        return developerService.getDeveloperById(id);
    }

    @GetMapping("/project/{projectId}")
    public List<Developer> getDevelopersByProject(@PathVariable Long projectId) {
        return developerService.getDevelopersByProject(projectId);
    }
}