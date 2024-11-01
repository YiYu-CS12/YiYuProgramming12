package org.example;

public class Main {

    public static void main(String[] args) {
        DatabaseHandler dbHandler = DatabaseHandler.getHandler();

        // Path to the CSV file
        String csvFilePath = "PlayerData.csv";  // Ensure this file exists with appropriate data and headers
        String outputCsvFilePath = "exported_PlayerData.csv";

        // Parse CSV and insert into the database
        dbHandler.parseCsvAndInsertToDatabase(csvFilePath);

        // Export the database table to a CSV file
        dbHandler.exportDatabaseToCsv(outputCsvFilePath);

        System.out.println("Database operations completed.");
    }
}
