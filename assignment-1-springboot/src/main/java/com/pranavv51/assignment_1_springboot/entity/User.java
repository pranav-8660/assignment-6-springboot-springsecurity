package com.pranavv51.assignment_1_springboot.entity;

import java.util.Set;
import jakarta.persistence.*;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(name = "watchlist", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id") )
    private Set<Movie> watchlist;

    public User() {
    }

    public User(String username, String password, Set<Movie> watchlist) {
        this.username = username;
        this.password = password;
        this.watchlist = watchlist;
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

    public Set<Movie> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(Set<Movie> watchlist) {
        this.watchlist = watchlist;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", watchlist=" + watchlist +
                '}';
    }
}
