package com.eafit.nodo.backamadeusgrupo3.exeptions.destination;

public class DestinationNameIsRequired extends RuntimeException {
    public DestinationNameIsRequired(String message) {
        super(message);
    }
}
