package io.undefvar.demohexagonalarchitecture.application.usecases;

import io.undefvar.demohexagonalarchitecture.application.dao.MovieDAO;
import io.undefvar.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.undefvar.demohexagonalarchitecture.domain.Movie;
import io.undefvar.demohexagonalarchitecture.infrastructure.exceptions.MovieAlreadyExistsException;
import io.undefvar.demohexagonalarchitecture.infrastructure.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MovieUseCase {
    private final MovieDAO movieDAO;
    public String saveMovie(NewMovieDto newMovieDto) throws MovieAlreadyExistsException {
        //check if movie is already in DB
      var isPresent = movieDAO.findMovieByTitle(newMovieDto.title()).isPresent();
      if(isPresent) {
          throw new MovieAlreadyExistsException("Movies already exist");
      }

        // continue to save movie
        movieDAO.saveMovie(newMovieDto);

        return "Movie Saved Successfully";
    }

    public List<Movie> getAllMovies(){
        return movieDAO.findAllMovies();
    }

    public String updateMovie(Movie movie) throws MovieNotFoundException{
        //check if movie is already in DB
        var isPresent = movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent){
            throw new MovieNotFoundException("This movie does not exist");
        }
        movieDAO.updateMovie(movie);
        return "Movie Successfully updated";
    }

    public Movie getMovieByTitle(String movieTitle ){
        return movieDAO.findMovieByTitle(movieTitle).orElseThrow(
                ()-> new MovieNotFoundException("This movie does not exist")
        );
    }


}
