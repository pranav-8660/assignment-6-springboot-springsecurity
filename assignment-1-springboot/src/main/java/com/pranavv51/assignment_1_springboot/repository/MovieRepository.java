package com.pranavv51.assignment_1_springboot.repository;


import com.pranavv51.assignment_1_springboot.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findByRatingGreaterThanEqual(Double rating);
}
