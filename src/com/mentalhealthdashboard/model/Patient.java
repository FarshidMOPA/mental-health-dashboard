package com.mentalhealthdashboard.model;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private final String patientId;
    private int age;
    private final List<String> assessmentHistory;
    public Patient(String patientId, int age) {
        if (patientId == null) {
            throw new IllegalArgumentException("Patient ID cannot be empty.");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        this.patientId = patientId;
        this.age = age;
        this.assessmentHistory = new ArrayList<>();
    }
    public String getPatientId() { return patientId; }
    public int getAge() { return age; }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        this.age = age;
    }

    public void addAssessmentRecord(String record) {assessmentHistory.add(record);}

    public ArrayList<String> getAssessmentHistory() {
        return new ArrayList<>(assessmentHistory);  // defensive copy
    }

    public void printPatientInfo() {
        System.out.println("Patient [ID=" + patientId + ", Age=" + age +
                ", Assessments=" + assessmentHistory.size() + "]");
    }
}
