package com.pranavv51.assignment_2_developer_task_tracker.repository;

import com.pranavv51.assignment_2_developer_task_tracker.entity.Task;
import com.pranavv51.assignment_2_developer_task_tracker.enums.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByDeveloperId(Long developerId);

    long countByDeveloperIdAndStatus(Long developerId, Status status);  // ensure only max 5 IN_PROGRESS

    List<Task> findByDueDateBeforeAndStatusNot(LocalDate date, Status status);  // overdue tasks

    @Query("SELECT t.developer.id, t.developer.name, COUNT(t) " +
            "FROM Task t " +
            "WHERE t.dueDate < :today AND t.status <> 'DONE' " +
            "GROUP BY t.developer.id, t.developer.name " +
            "ORDER BY COUNT(t) DESC")
    List<Object[]> findTop3Overdue(@Param("today") LocalDate today, Pageable pageable);
}
