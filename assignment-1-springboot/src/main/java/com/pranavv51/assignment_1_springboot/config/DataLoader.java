package com.pranavv51.assignment_1_springboot.config;

import com.pranavv51.assignment_1_springboot.entity.Movie;
import com.pranavv51.assignment_1_springboot.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Configuration
public class DataLoader {

    // this is to save all stuff from movies.csv file into h2 after the application starts
    @Bean
    CommandLineRunner loadMovies(MovieRepository movieRepository) {
        return args -> {
            try (var is = getClass().getResourceAsStream("/movies.csv")) {
                if (is == null) {
                    throw new RuntimeException("movies.csv not found in resources folder");
                }

                var reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                reader.lines().skip(1).forEach(line -> {
                    String[] parts = line.split(",");
                    if (parts.length >= 6) {
                        Movie movie = new Movie();
                        movie.setFilm(parts[0].trim());
                        movie.setGenre(parts[1].trim());
                        movie.setStudio(parts[2].trim());
                        movie.setRating(Integer.parseInt(parts[3].trim()));
                        movie.setYear(Integer.parseInt(parts[4].trim()));
                        movie.setPosterUrl(parts[5].trim());
                        movieRepository.save(movie);
                    }
                });
            }
        };
    }
}

