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
        return "InvalidAssessmentException [testId=" + testID +
                ", invalidValue=" + invalidValue +
                ", message=" + getMessage() + "]";
    }
}
