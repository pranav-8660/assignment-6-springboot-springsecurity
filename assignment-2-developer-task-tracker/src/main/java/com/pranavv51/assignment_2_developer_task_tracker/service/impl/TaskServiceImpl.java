package com.pranavv51.assignment_2_developer_task_tracker.service.impl;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Developer;
import com.pranavv51.assignment_2_developer_task_tracker.entity.Task;
import com.pranavv51.assignment_2_developer_task_tracker.enums.Status;
import com.pranavv51.assignment_2_developer_task_tracker.repository.DeveloperRepository;
import com.pranavv51.assignment_2_developer_task_tracker.repository.TaskRepository;
import com.pranavv51.assignment_2_developer_task_tracker.service.TaskService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final DeveloperRepository developerRepository;

    public TaskServiceImpl(TaskRepository taskRepository, DeveloperRepository developerRepository) {
        this.taskRepository = taskRepository;
        this.developerRepository = developerRepository;
    }

    @Override
    public Task assignTaskToDeveloper(Long developerId, Task task) {
        Developer developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new RuntimeException("Developer not found"));

        // Business Rule: Max 5 IN_PROGRESS tasks
        long inProgressCount = taskRepository.countByDeveloperIdAndStatus(developerId, Status.IN_PROGRESS);
        if (task.getStatus() == Status.IN_PROGRESS && inProgressCount >= 5) {
            throw new RuntimeException("Developer cannot have more than 5 tasks in progress");
        }

        task.setDeveloper(developer);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksForDeveloper(Long developerId) {
        return taskRepository.findByDeveloperId(developerId);
    }

    @Override
    public Task updateTaskStatus(Long taskId, Status status) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Business Rule: Prevent update if DONE
        if (task.getStatus() == Status.DONE) {
            throw new RuntimeException("Cannot update a completed task");
        }

        task.setStatus(status);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getOverdueTasks(LocalDate today) {
        return taskRepository.findByDueDateBeforeAndStatusNot(today, Status.DONE);
    }

    @Override
    public List<Object[]> getTop3DevelopersWithOverdueTasks() {
        // Use custom query with Pageable
        return taskRepository.findTop3Overdue(LocalDate.now(), PageRequest.of(0, 3));
    }
}