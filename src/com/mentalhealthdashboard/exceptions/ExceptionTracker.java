package com.mentalhealthdashboard.exceptions;
import java.util.ArrayList;

public class ExceptionTracker{
    private int invalidAssessmentCount = 0;
    private final ArrayList<String> eventLog= new ArrayList<>();

    public ExceptionTracker() {}
    public void recordInvalidAssessment(InvalidAssessmentException e) {
        invalidAssessmentCount++;
        eventLog.add("[INVALID] " + e.toString());
    }

    public int getInvalidAssessmentCount() {return invalidAssessmentCount;}
    public ArrayList<String> getEventLog() {return eventLog;}

    public void reset() {
        invalidAssessmentCount = 0;
        eventLog.clear();
    }
}
