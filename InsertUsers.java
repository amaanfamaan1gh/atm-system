import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:users.db";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // Create a new table
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "name TEXT NOT NULL," +
                         "balance REAL NOT NULL)";
            stmt.execute(sql);
            System.out.println("Database and table created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsers {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:users.db";

        String sql = "INSERT INTO users(name, balance) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Insert sample users
            String[][] users = {
                {"Alice", "1000.0"},
                {"Bob", "1500.5"},
                {"Charlie", "2000.75"}
            };

            for (String[] user : users) {
                pstmt.setString(1, user[0]);
                pstmt.setDouble(2, Double.parseDouble(user[1]));
                pstmt.executeUpdate();
            }
            System.out.println("Users inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}import java.sql.*;

public class UserManagement {
    static final String url = "jdbc:sqlite:users.db";

    public static void main(String[] args) {
        // Example: Read and print all users
        fetchAllUsers();
        // You can also add methods for insert, update, delete here
    }

    public static void fetchAllUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Balance: " + rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Add methods for insert, update, delete as needed
}
public class LoopPractice {
    public static void main(String[] args) {
        // Example of 'continue'
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.println(i); // Print odd numbers
        }

        // Example of 'break'
        int count = 0;
        while (true) {
            count++;
            if (count > 5) {
                break; // Exit loop after 5 iterations
            }
            System.out.println("Count: " + count);
        }
    }
}
