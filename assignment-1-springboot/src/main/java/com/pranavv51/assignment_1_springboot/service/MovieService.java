package com.pranavv51.assignment_1_springboot.service;

import com.pranavv51.assignment_1_springboot.entity.Movie;
import com.pranavv51.assignment_1_springboot.repository.MovieRepository;
import com.pranavv51.assignment_1_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(String sortBy, Double minRating) {
        // just see if minimum rating is passed, else return all. if minimum rating is passed then consider all movies with rating above it
        List<Movie> movies = (minRating != null) ? movieRepository.findByRatingGreaterThanEqual(minRating) : movieRepository.findAll();

        //sort by which parameter?? we consider sorting it by year also...if year is passed as an argument, then we will sort based on the year(after retrieval of movies)
        if ("year".equalsIgnoreCase(sortBy)) {
            movies.sort(Comparator.comparing(Movie::getYear));
        }
        return movies;
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }
}
