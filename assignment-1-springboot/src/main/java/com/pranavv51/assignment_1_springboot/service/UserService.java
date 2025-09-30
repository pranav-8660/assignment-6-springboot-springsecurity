package com.pranavv51.assignment_1_springboot.service;

import com.pranavv51.assignment_1_springboot.entity.Movie;
import com.pranavv51.assignment_1_springboot.entity.User;
import com.pranavv51.assignment_1_springboot.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MovieService movieService;

    public UserService(UserRepository userRepository, MovieService movieService) {
        this.userRepository = userRepository;
        this.movieService = movieService;
    }

    private User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Set<Movie> getWatchlist() {
        return getCurrentUser().getWatchlist();
    }

    public void addToWatchlist(Long movieId) {
        User user = getCurrentUser();
        Movie movie = movieService.getMovieById(movieId);
        user.getWatchlist().add(movie);
        userRepository.save(user);
    }

    public void removeFromWatchlist(Long movieId) {
        User user = getCurrentUser();
        Movie movie = movieService.getMovieById(movieId);
        user.getWatchlist().remove(movie);
        userRepository.save(user);
    }
}
