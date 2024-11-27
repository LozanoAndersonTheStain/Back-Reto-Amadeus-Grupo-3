package com.eafit.nodo.backamadeusgrupo3.exeptions.plan;

public class PlanAlreadyExistsException extends RuntimeException {
    public PlanAlreadyExistsException(String message) {
        super(message);
    }
}
