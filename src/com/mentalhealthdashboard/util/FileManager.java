package com.mentalhealthdashboard.util;

import com.mentalhealthdashboard.assessment.PsychometricTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH = "results.csv";
    private static final String CSV_HEADER = "patientId,testType,totalScore,severity,isEmergency,timestamp";

    public static void saveResult(PsychometricTest test) throws IOException {
        File file = new File(FILE_PATH);
        boolean isNewFile = !file.exists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            if (isNewFile) {
                writer.write(CSV_HEADER);
                writer.newLine();
            }

            String row = String.join(",", test.getPatientId(), test.getTestName(), String.valueOf(test.getTotalScore()), test.interpretSeverity().name(), String.valueOf(test.isEmergency()), test.getTimestamp().toString());
            writer.write(row);
            writer.newLine();
        }  //buffer the data in memory to increase the efficency/ set the actual FlieWriter in append mode
         catch (IOException e) {
        System.err.println("Failed to save result: " + e.getMessage());
        }
    }


    public static List<String[]> loadResults() {
        List<String[]> results = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) return results;  // nothing saved yet, return empty list

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {  // read once, assign, check
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                results.add(line.split(","));
            }

        } catch (IOException e) {
            System.err.println("Failed to load results: " + e.getMessage());
        }
        return results;
    }
}
