package com.mentalhealthdashboard.assessment;

import com.mentalhealthdashboard.exceptions.InvalidAssessmentException;

import java.time.LocalDateTime;

public abstract class PsychometricTest {
    protected final String testId;             //only visible to subclasses
    protected String patientId;
    protected int totalScore;
    protected LocalDateTime timestamp;
    protected boolean emergencyFlag;
    public enum SeverityLevel {
        MINIMAL,
        MILD,
        MODERATE,
        MODERATELY_SEVERE,
        SEVERE
    }
    protected final int QUESTION_COUNT;
    protected final int MIN_ANSWER;
    protected final int MAX_ANSWER;
    protected final String testName;

    public PsychometricTest(String testName, String testId, String patientId, int QUESTION_COUNT, int MIN_ANSWER, int  MAX_ANSWER) {

        this.testId    = testId;
        this.patientId = patientId;
        this.totalScore = 0;
        this.timestamp  = LocalDateTime.now();
        this.emergencyFlag = false;
        this.QUESTION_COUNT = QUESTION_COUNT;
        this.MIN_ANSWER = MIN_ANSWER;
        this.MAX_ANSWER = MAX_ANSWER;
        this.testName = testName;
    }

    public void evaluateAnswers(int[] answers) throws InvalidAssessmentException{
        if (answers == null || answers.length != QUESTION_COUNT) {
            int invalidLength;
            if (answers == null) {
                invalidLength = -1;
            } else {
                invalidLength = answers.length;
            }
            throw new InvalidAssessmentException(testId, invalidLength, testName + " requires exactly " + QUESTION_COUNT+" answers.");
        }
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] < MIN_ANSWER || answers[i] > MAX_ANSWER) {
                throw new InvalidAssessmentException(testId,answers[i], "Answer at question " + (i + 1) + " is out of range. " + "Expected " + MIN_ANSWER + "-" + MAX_ANSWER +", got: " + answers[i]);
            }
        }

        totalScore = 0;
        for (int a : answers) {
            totalScore += a;
        }
        checkEmergency(answers);
    }
    public abstract SeverityLevel interpretSeverity();
    public abstract void checkEmergency(int[] answers);

    public String getSummary() {return "[" + testId + "] Patient: " + patientId + " | Score: " + totalScore + " | Time: " + timestamp;}
    public boolean isEmergency() {return emergencyFlag;}
    public String getTestId()      { return testId; }
    public String getPatientId()   { return patientId; }
    public int getTotalScore()     { return totalScore; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getTestName() { return testName; }
}