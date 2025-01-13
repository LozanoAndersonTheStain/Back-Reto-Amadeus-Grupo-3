package com.eafit.nodo.backamadeusgrupo3.exeptions.reports;

public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException(String message) {
        super(message);
    }
}
