package com.eafit.nodo.backamadeusgrupo3.exeptions;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
