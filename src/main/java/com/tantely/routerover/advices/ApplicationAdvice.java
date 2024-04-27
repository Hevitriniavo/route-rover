package com.tantely.routerover.advices;

import com.tantely.routerover.exceptions.BadRequestException;
import com.tantely.routerover.exceptions.InternalServerException;
import com.tantely.routerover.exceptions.NotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ApplicationAdvice {


    @ExceptionHandler(NotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ApplicationError handler(NotFountException ex) {
        return new ApplicationError(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ApplicationError handler(BadRequestException ex) {
        return new ApplicationError(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value()
        );
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ApplicationError handler(InternalServerException ex) {
        return new ApplicationError(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }

}
