package com.pranavv51.assignment_1_springboot.controller;

import com.pranavv51.assignment_1_springboot.entity.Movie;
import com.pranavv51.assignment_1_springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/watchlist")
    public Set<Movie> getWatchlist() {
        return userService.getWatchlist();
    }

    @PostMapping("/watchlist/{movieId}")
    public String addMovie(@PathVariable Long movieId) {
        userService.addToWatchlist(movieId);
        return "Movie added to watchlist";
    }

    @DeleteMapping("/watchlist/{movieId}")
    public String removeMovie(@PathVariable Long movieId) {
        userService.removeFromWatchlist(movieId);
        return "Movie removed from watchlist";
    }
}
