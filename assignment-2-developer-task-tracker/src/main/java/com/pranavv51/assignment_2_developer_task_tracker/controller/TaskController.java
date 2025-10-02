package com.pranavv51.assignment_2_developer_task_tracker.controller;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Task;
import com.pranavv51.assignment_2_developer_task_tracker.enums.Status;
import com.pranavv51.assignment_2_developer_task_tracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/developer/{developerId}")
    public Task assignTask(@PathVariable Long developerId, @RequestBody Task task) {
        return taskService.assignTaskToDeveloper(developerId, task);
    }

    @GetMapping("/developer/{developerId}")
    public List<Task> getTasksForDeveloper(@PathVariable Long developerId) {
        return taskService.getTasksForDeveloper(developerId);
    }

    @PutMapping("/{taskId}/status")
    public Task updateTaskStatus(@PathVariable Long taskId, @RequestParam Status status) {
        return taskService.updateTaskStatus(taskId, status);
    }

    @GetMapping("/overdue")
    public List<Task> getOverdueTasks() {
        return taskService.getOverdueTasks(LocalDate.now());
    }

    @GetMapping("/top-overdue")
    public List<Object[]> getTop3DevelopersWithOverdueTasks() {
        return taskService.getTop3DevelopersWithOverdueTasks();
    }
}