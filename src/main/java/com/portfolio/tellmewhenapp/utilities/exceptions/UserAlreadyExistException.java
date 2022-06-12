package com.portfolio.tellmewhenapp.utilities.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
