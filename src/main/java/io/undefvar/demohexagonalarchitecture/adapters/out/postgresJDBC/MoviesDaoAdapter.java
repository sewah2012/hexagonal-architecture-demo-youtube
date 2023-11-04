package io.undefvar.demohexagonalarchitecture.adapters.out.postgresJDBC;

import io.undefvar.demohexagonalarchitecture.adapters.out.postgresJDBC.entities.MovieEntity;
import io.undefvar.demohexagonalarchitecture.adapters.out.postgresJDBC.repositories.MoviesRepository;
import io.undefvar.demohexagonalarchitecture.application.dao.MovieDAO;
import io.undefvar.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.undefvar.demohexagonalarchitecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Component
public class MoviesDaoAdapter implements MovieDAO {
    private final MoviesRepository moviesRepository;
    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findMovieByTitle(title);

    }

    @Override
    public List<Movie> findAllMovies() {
         return ((List<MovieEntity>) moviesRepository.findAll())
                  .stream()
                  .map(movieEntity -> new Movie(
                          movieEntity.id(),
                          movieEntity.title(),
                          movieEntity.description(),
                          movieEntity.releaseDate(),
                          movieEntity.directorName()
                  )).toList();

    }

    @Override
    public void saveMovie(NewMovieDto movie) {
        moviesRepository.save(new MovieEntity(
                null,
                movie.title(),
                movie.description(),
                movie.releaseDate(),
                movie.directorName(),
                null
        ));
    }

    @Override
    public void updateMovie(Movie newMovie) {
        moviesRepository.save(new MovieEntity(
                newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        ));
    }

    @Override
    public void deleteMovie(Movie oldMovie) {

    }
}
