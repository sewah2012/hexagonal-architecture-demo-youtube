package io.undefvar.demohexagonalarchitecture.application.dao;

import io.undefvar.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.undefvar.demohexagonalarchitecture.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    Optional<Movie> findMovieByTitle(String title);
    List<Movie> findAllMovies();
    void saveMovie(NewMovieDto movie);
    void updateMovie(Movie newMovie);
    void deleteMovie(Movie oldMovie);
}
