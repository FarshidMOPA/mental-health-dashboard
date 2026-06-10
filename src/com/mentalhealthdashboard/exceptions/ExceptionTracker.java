package com.mentalhealthdashboard.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTracker{

    private int invalidAssessmentCount = 0;
    private int emergencyInterventionCount = 0;
    private final ArrayList<String> eventLog= new ArrayList<>();
    public ExceptionTracker() {}
    public void recordInvalidAssessment(InvalidAssessmentException e) {
        invalidAssessmentCount++;
        eventLog.add("[INVALID] " + e.toString());
    }
    public void recordEmergencyIntervention(EmergencyInterventionException e) {
        emergencyInterventionCount++;
        eventLog.add("[EMERGENCY] " + e.toString());
    }

    public int getInvalidAssessmentCount() {return invalidAssessmentCount;}
    public int getEmergencyInterventionCount() {return emergencyInterventionCount;}
    public ArrayList<String> getEventLog() {return eventLog;}
    public void reset() {
        invalidAssessmentCount = 0;
        emergencyInterventionCount = 0;
        eventLog.clear();
    }
}
