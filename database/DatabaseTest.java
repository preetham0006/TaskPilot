package database;

import java.sql.Connection;

public class DatabaseTest {

    public static void main(String[] args) {

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            System.out.println("✅ Database Connected Successfully!");

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}