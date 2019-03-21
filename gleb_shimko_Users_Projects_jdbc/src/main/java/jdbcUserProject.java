
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.Date;
import java.util.Scanner;


    public class jdbcUserProject {
        static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/users";
        static final String DB_USER = "root";
        static final String DB_PASSWORD = "root";

        static Connection conn;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            try {
                try {
                    // create connection
                    conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                    //initDB();

                    while (true) {
                        System.out.println("1: add user");
                        System.out.println("2: delete user");
                        System.out.println("3: change user");
                        System.out.println("4: view user");
                        System.out.print("-> ");

                        String s = sc.nextLine();
                        if ("1".equals(s)) {
                            addUsers(sc);
                        } else if ("2".equals(s)) {
                            deleteUsers(sc);
                        } else if ("3".equals(s)) {
                            changeUsers(sc);
                        } else if ("4".equals(s)) {
                            viewUsers();
                        } else {
                            return;
                        }
                    }
                } finally {
                    sc.close();
                    if (conn != null) conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return;
            }
        }

/*    private static void initDB() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE IF EXISTS Clients");
            st.execute("CREATE TABLE Clients (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, age INT)");
        } finally {
            st.close();
        }
    }*/

        private static void addUsers(Scanner sc) throws SQLException {
            System.out.print("Enter user email: ");
            String email = sc.nextLine();
            System.out.print("Enter user phone: ");
            String phone = sc.nextLine();
            System.out.print("Enter date of creating new user: ");
            String dateCreated = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (email, phone, data_created) VALUES(?, ?, ?)");
            try {
                ps.setString(1, email);
                ps.setString(2, phone);
                ps.setString(3, dateCreated);
                ps.executeUpdate(); // for INSERT, UPDATE & DELETE
            } finally {
                ps.close();
            }
        }

        private static void deleteUsers(Scanner sc) throws SQLException {
            System.out.print("Enter user email: ");
            String email = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE email = ?");
            try {
                ps.setString(1, email);
                ps.executeUpdate(); // for INSERT, UPDATE & DELETE
            } finally {
                ps.close();
            }
        }

        private static void changeUsers(Scanner sc) throws SQLException {
            System.out.print("Enter client name: ");
            String name = sc.nextLine();
            System.out.print("Enter new age: ");
            String sAge = sc.nextLine();
            int age = Integer.parseInt(sAge);

            PreparedStatement ps = conn.prepareStatement("UPDATE users SET age = ? WHERE name = ?");
            try {
                ps.setInt(1, age);
                ps.setString(2, name);
                ps.executeUpdate(); // for INSERT, UPDATE & DELETE
            } finally {
                ps.close();
            }
        }



        private static void viewUsers() throws SQLException {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
            try {
                // table of data representing a database result set,
                ResultSet rs = ps.executeQuery();
                try {
                    // can be used to get information about the types and properties of the columns in a ResultSet object
                    ResultSetMetaData md = rs.getMetaData();

                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(md.getColumnName(i) + "\t\t");
                    }
                    System.out.println();

                    while (rs.next()) {
                        for (int i = 1; i <= md.getColumnCount(); i++) {
                            System.out.print(rs.getString(i) + "\t\t");
                        }
                        System.out.println();
                    }
                } finally {
                    rs.close(); // rs can't be null according to the docs
                }
            } finally {
                ps.close();
            }
        }
    }

