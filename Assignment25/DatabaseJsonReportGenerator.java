package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class DatabaseRecord {
    public int id;
    public String name;
    public String email;

    public DatabaseRecord(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

public class DatabaseJsonReportGenerator {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, email FROM users");

        List<DatabaseRecord> records = new ArrayList<>();
        while (rs.next()) {
            records.add(new DatabaseRecord(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

        System.out.println(jsonReport);

        conn.close();
    }
}
