package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Example {


        static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/users";
        static final String DB_USER = "root";
        static final String DB_PASSWORD = "root";

        static Connection conn;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Class.forName("com.")

                    //it's a dev suka

            try (Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(3);
                    System.out.println(id + ", " + name);
                }
                // create connection
//            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

