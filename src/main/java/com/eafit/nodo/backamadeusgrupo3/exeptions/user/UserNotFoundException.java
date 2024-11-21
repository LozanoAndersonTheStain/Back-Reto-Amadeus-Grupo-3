package com.eafit.nodo.backamadeusgrupo3.exeptions.user;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
