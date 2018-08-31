import java.sql.*;
import java.util.Scanner;

public class db {
    private String query;
    private String dbUrl = "jdbc:mysql://localhost:3306/kea";
    private String username = "root";
    private String password = "1234";

    public void insertUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert name");
        String name = scanner.nextLine();
        System.out.println();

        String query = "INSERT INTO students (stud_name) VALUES ('" + name + "'); ";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement()) {
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteUsers() {
        String query = "DELETE FROM user WHERE nameuser = 'freja'";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement()) {
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void printUsers() {
        query = "SELECT * FROM students";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            System.out.println("Students");
            while (rs.next()) {
                int iduser = rs.getInt(1);
                String nameuser = rs.getString(2);

                System.out.println("id# " + iduser + "\t" + nameuser + "\t");

            }
            connection.close();
            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
