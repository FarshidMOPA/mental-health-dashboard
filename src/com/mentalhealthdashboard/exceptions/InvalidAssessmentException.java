package com.mentalhealthdashboard.exceptions;

public class InvalidAssessmentException extends Exception {
    private final String testID;
    private final int invalidValue;
    public InvalidAssessmentException(String testID, int invalidValue,  String message) {
        super(message);
        this.testID = testID;
        this.invalidValue = invalidValue;
    }
    public String getTestID() {return testID;}
    public int getInvalidValue() {return invalidValue;}
    @Override
    public String toString() {
        return "InvalidAssessmentException:/n   testId=" + testID +
                "/n   invalidValue=" + invalidValue +
                "/n   message=" + getMessage();
    }
} //checked exception from except. class
