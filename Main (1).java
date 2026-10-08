import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
        String USERNAME = "root";
        String PASSWORD = "your_password";

        String sqlQuery = "SELECT * FROM users";

        try (
            Connection connection =
                DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery)
        ) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");

                System.out.println(
                    "User ID: " + id +
                    ", Username: " + username +
                    ", Email: " + email
                );
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
