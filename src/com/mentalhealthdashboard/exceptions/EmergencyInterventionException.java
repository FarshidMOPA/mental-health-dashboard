package com.mentalhealthdashboard.exceptions;

public class EmergencyInterventionException extends RuntimeException {
    public enum RiskLevel {High , Critical}
    private final String patientID;
    private final RiskLevel riskLevel;
    public EmergencyInterventionException(String patientID, RiskLevel riskLevel, String message) {
        super(message);
        this.patientID = patientID;
        this.riskLevel = riskLevel;
    }
    public String getPatientID() {return patientID;}
    public RiskLevel getRiskLevel() {return riskLevel;}
    @Override
    public String getMessage() {
        return "EmergencyInterventionException [patientId=" + patientID +
                ", riskLevel=" + riskLevel +
                ", message=" + getMessage() + "]";
    }
}
