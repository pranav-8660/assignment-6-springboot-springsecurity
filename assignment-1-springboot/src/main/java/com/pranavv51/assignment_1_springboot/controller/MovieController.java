package com.pranavv51.assignment_1_springboot.controller;

import com.pranavv51.assignment_1_springboot.entity.Movie;
import com.pranavv51.assignment_1_springboot.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam(required = false) String sortBy,
                                 @RequestParam(required = false) Double minRating) {
        return movieService.getAllMovies(sortBy, minRating);
    }
}
