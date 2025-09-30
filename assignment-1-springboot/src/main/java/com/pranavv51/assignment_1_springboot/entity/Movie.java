package com.pranavv51.assignment_1_springboot.entity;


import jakarta.persistence.*;

@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_id;
    private String film;
    private String genre;
    private String studio;
    private int rating;
    private int year;

    @Column(name = "poster_url")
    private String posterUrl;

    public Movie(){}

    public Movie(String film, String genre, String studio, int rating, int year, String posterUrl) {
        this.film = film;
        this.genre = genre;
        this.studio = studio;
        this.rating = rating;
        this.year = year;
        this.posterUrl = posterUrl;
    }

    public long getId() {
        return movie_id;
    }

    public void setId(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", film='" + film + '\'' +
                ", genre='" + genre + '\'' +
                ", studio='" + studio + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                ", posterUrl='" + posterUrl + '\'' +
                '}';
    }
}
