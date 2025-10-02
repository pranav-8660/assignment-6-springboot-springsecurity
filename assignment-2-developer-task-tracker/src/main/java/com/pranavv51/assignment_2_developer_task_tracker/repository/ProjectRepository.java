package com.pranavv51.assignment_2_developer_task_tracker.repository;


import com.pranavv51.assignment_2_developer_task_tracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
