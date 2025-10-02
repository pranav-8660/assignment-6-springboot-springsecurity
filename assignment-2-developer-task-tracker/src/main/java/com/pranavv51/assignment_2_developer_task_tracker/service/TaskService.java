package com.pranavv51.assignment_2_developer_task_tracker.service;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Task;
import com.pranavv51.assignment_2_developer_task_tracker.enums.Status;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    Task assignTaskToDeveloper(Long developerId, Task task);
    List<Task> getTasksForDeveloper(Long developerId);
    Task updateTaskStatus(Long taskId, Status status);
    List<Task> getOverdueTasks(LocalDate today);
    List<Object[]> getTop3DevelopersWithOverdueTasks();

}
