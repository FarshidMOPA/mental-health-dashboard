package com.mentalhealthdashboard.assessment;

public class GAD7Assessment extends PsychometricTest {

    public GAD7Assessment(String testId, String patientId) {
        super(testId, patientId, 7, 0, 3);
    }

    @Override
    public SeverityLevel interpretSeverity() {
        if (totalScore <= 4)  return SeverityLevel.MINIMAL;
        if (totalScore <= 9)  return SeverityLevel.MILD;
        if (totalScore <= 14) return SeverityLevel.MODERATE;
        return SeverityLevel.SEVERE;
    }

    @Override
    public void checkEmergency(int[] answers) {
        if (totalScore>15) emergencyFlag = true;
    }
}