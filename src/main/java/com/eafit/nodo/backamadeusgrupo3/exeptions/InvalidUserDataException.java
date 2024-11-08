package com.eafit.nodo.backamadeusgrupo3.exeptions;

public class InvalidUserDataException extends  RuntimeException{
    public InvalidUserDataException(String message) {
        super(message);
    }
}
