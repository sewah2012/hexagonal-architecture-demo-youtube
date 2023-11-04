package io.undefvar.demohexagonalarchitecture.infrastructure.exceptions;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(String message){
        super(message);
    }
}
