package org.example;

public class Main {

    public static void main(String[] args) {
        DatabaseHandler dbHandler = DatabaseHandler.getHandler();

        String csvFilePath = "PlayerData.csv";
        String outputCsvFilePath = "exported_PlayerData.csv";
        dbHandler.parseCsvAndInsertToDatabase(csvFilePath);
        dbHandler.exportDatabaseToCsv(outputCsvFilePath);

        csvFilePath = "members.csv";
        outputCsvFilePath = "exported_members.csv";
        dbHandler.parseCsvAndInsertToDatabase(csvFilePath);
        dbHandler.exportDatabaseToCsv(outputCsvFilePath);


        System.out.println("Database operations completed.");
    }
}
