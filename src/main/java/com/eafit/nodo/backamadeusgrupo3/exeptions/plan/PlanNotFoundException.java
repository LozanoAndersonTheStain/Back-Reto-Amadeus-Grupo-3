package com.eafit.nodo.backamadeusgrupo3.exeptions.plan;

public class PlanNotFoundException extends RuntimeException {
    public PlanNotFoundException(String message) {
        super(message);
    }
}
