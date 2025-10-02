package com.pranavv51.assignment_2_developer_task_tracker.repository;


import com.pranavv51.assignment_2_developer_task_tracker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Long> {

    List<Developer> findByProjectId(Long projectId);
}
