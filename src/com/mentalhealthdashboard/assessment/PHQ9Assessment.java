package com.mentalhealthdashboard.assessment;

public class PHQ9Assessment extends PsychometricTest{
    public PHQ9Assessment(String testId, String patientId) {super(testId, patientId, 9, 0, 3);}

    public SeverityLevel interpretSeverity() {
        if (totalScore <= 4)  return SeverityLevel.MINIMAL;
        if (totalScore <= 9)  return SeverityLevel.MILD;
        if (totalScore <= 14) return SeverityLevel.MODERATE;
        if (totalScore <= 19) return SeverityLevel.MODERATELY_SEVERE;
        return SeverityLevel.SEVERE;
    }

    @Override
    public void checkEmergency(int[] answers) {
        if (answers[8] > 0) emergencyFlag = true;
    }
}
