# Assignment 1 - Spring Boot Movie Watchlist API

This is a Spring Boot application that provides a simple movie watchlist API with in-memory authentication and an H2 database.

## Features

- Retrieve a list of movies, optionally sorted or filtered by rating.
- Manage a personal movie watchlist (add, remove, view).
- In-memory user authentication with HTTP Basic Auth.
- H2 database for storing movie data, preloaded from a CSV file.

## API Endpoints

### Movies

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/movies?sortBy=&minRating=` | Returns a list of all movies, optionally sorted and filtered by minimum rating. |

### User Watchlist

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/users/watchlist` | Retrieves the authenticated user's movie watchlist. |
| POST   | `/api/users/watchlist/{movieId}` | Adds a movie to the authenticated user's watchlist. |
| DELETE | `/api/users/watchlist/{movieId}` | Removes a movie from the authenticated user's watchlist. |

## Authentication

The application uses **HTTP Basic Authentication** with the following in-memory users:

| Username | Password | Role |
|----------|---------|------|
| pranav   | 12345   | USER |
| vanarp   | 54321   | USER |

All `/api/**` endpoints require authentication. Other endpoints are publicly accessible.

## H2 Database

- The application uses **H2 in-memory database**.
- Access the H2 console at `/h2-console`.
- Login credentials:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=12345
