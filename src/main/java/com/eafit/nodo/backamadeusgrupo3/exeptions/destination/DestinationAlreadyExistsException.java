package com.eafit.nodo.backamadeusgrupo3.exeptions.destination;

public class DestinationAlreadyExistsException extends RuntimeException {
    public DestinationAlreadyExistsException(String message) {
        super(message);
    }
}
