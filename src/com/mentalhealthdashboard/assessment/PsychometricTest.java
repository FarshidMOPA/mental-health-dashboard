package com.mentalhealthdashboard.assessment;

import com.mentalhealthdashboard.exceptions.InvalidAssessmentException;

import java.time.LocalDateTime;

public abstract class PsychometricTest {
    protected final String testId;             //only visible to subclasses
    protected String patientId;
    protected int totalScore;
    protected LocalDateTime timestamp;
    public boolean emergencyFlag;

    public PsychometricTest(String testId, String patientId) {
        this.testId    = testId;
        this.patientId = patientId;
        this.totalScore = 0;
        this.timestamp  = LocalDateTime.now();
    }
    public abstract void evaluateAnswers(int[] answers) throws InvalidAssessmentException;
    public String getSummary() {
        return "[" + testId + "] Patient: " + patientId + " | Score: " + totalScore + " | Time: " + timestamp;
    }
    public boolean isEmergency() {

        return emergencyFlag;
    }

    public String getTestId()      { return testId; }
    public String getPatientId()   { return patientId; }
    public int getTotalScore()     { return totalScore; }
    public LocalDateTime getTimestamp() { return timestamp; }
}