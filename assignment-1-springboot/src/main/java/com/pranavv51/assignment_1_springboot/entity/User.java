package com.pranavv51.assignment_1_springboot.entity;

import java.util.Set;

public class User {

    private long user_id;
    private String username;
    private String password;

    private Set<Movie> movies;

    public User() {
    }

    public User(String username, String password, Set<Movie> movies) {
        this.username = username;
        this.password = password;
        this.movies = movies;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", movies=" + movies +
                '}';
    }
}
