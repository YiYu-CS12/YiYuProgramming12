package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private static final String DB_URL = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static DatabaseHandler handler;
    private static final String TABLE_NAME = "TEMP"; // Use TEMP as the table name

    public DatabaseHandler() {
        createConnection();
    }

    public static DatabaseHandler getHandler() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }

    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public boolean execAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch (SQLException throwables) {
            System.out.println(throwables);
            System.out.println("Action execution failed.");
        }
        return false;
    }

    public ResultSet execQuery(String query) {
        try {
            stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void parseCsvAndInsertToDatabase(String csvFilePath) {
        try (Reader reader = new FileReader(csvFilePath)) {
            CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            List<String> headers = new ArrayList<>(parser.getHeaderMap().keySet());

            createTableWithHeaders(headers);

            for (CSVRecord record : parser) {
                List<String> values = new ArrayList<>();
                for (String header : headers) {
                    values.add(record.get(header));
                }

                String query = String.format("INSERT INTO %s (%s) VALUES (%s)",
                        TABLE_NAME,
                        String.join(", ", headers),
                        String.join(", ", values.stream().map(v -> "'" + v.replace("'", "''") + "'").toArray(String[]::new)));

                execAction(query);
            }
            System.out.println("CSV data inserted into database successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createTableWithHeaders(List<String> headers) {
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, TABLE_NAME, null);
            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " exists");
            } else {
                StringBuilder statement = new StringBuilder("CREATE TABLE " + TABLE_NAME + " (");
                for (String header : headers) {
                    statement.append(header).append(" VARCHAR(200), ");
                }
                statement.setLength(statement.length() - 2); // Remove last comma
                statement.append(")");

                System.out.println(statement);
                stmt.execute(statement.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void exportDatabaseToCsv(String outputCsvFilePath) {
        String query = "SELECT * FROM " + TABLE_NAME;
        try (ResultSet rs = execQuery(query);
             FileWriter writer = new FileWriter(outputCsvFilePath);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<String> headers = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                headers.add(metaData.getColumnName(i));
            }
            csvPrinter.printRecord(headers);

            while (rs.next()) {
                List<String> values = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    values.add(rs.getString(i));
                }
                csvPrinter.printRecord(values);
            }
            System.out.println("Database table exported to CSV file successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            dropTable();
        }
    }

    private void dropTable() {
        try {
            stmt = conn.createStatement();
            String dropQuery = "DROP TABLE " + DatabaseHandler.TABLE_NAME;
            stmt.execute(dropQuery);
            System.out.println("Table " + DatabaseHandler.TABLE_NAME + " dropped successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
