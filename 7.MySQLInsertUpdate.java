import java.sql.*;

public class MySQLInsertUpdate {

    // Update these to match your environment
    private static final String URL = "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        // Sample data
        String insertName = "Alice Johnson";
        String insertDept = "Engineering";
        double insertSalary = 85000.0;

        // We'll update salary for id = 1 in this example (adjust accordingly)
        int updateId = 1;
        double newSalary = 90000.0;

        // Run insert then update
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Optional: ensure table exists (uncomment if you want program to create the table)
            // createTableIfNotExists(conn);

            // prefer explicit transaction control for multiple related operations
            conn.setAutoCommit(false);
            try {
                int generatedId = insertEmployee(conn, insertName, insertDept, insertSalary);
                System.out.println("Inserted employee with ID: " + generatedId);

                // Example: update the newly inserted row (you could update any existing id)
                int rows = updateEmployeeSalary(conn, generatedId, newSalary);
                System.out.println("Updated rows: " + rows);

                conn.commit();
            } catch (SQLException e) {
                System.err.println("Operation failed, rolling back. Reason: " + e.getMessage());
                conn.rollback();
            } finally {
                // restore default auto-commit (optional)
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserts a new employee and returns the generated primary key (id).
     */
    private static int insertEmployee(Connection conn, String name, String department, double salary) throws SQLException {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setDouble(3, salary);

            int affected = pstmt.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Insert failed, no rows affected.");
            }

            // get generated key
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new SQLException("Insert succeeded but no ID obtained.");
                }
            }
        }
    }

    /**
     * Updates salary for an employee identified by id. Returns number of rows updated.
     */
    private static int updateEmployeeSalary(Connection conn, int id, double newSalary) throws SQLException {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newSalary);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate();
        }
    }

    /**
     * Optional helper - creates the employees table if it doesn't exist.
     * Uncomment call in main if you'd like the program to create the table.
     */
    @SuppressWarnings("unused")
    private static void createTableIfNotExists(Connection conn) throws SQLException {
        String create =
                "CREATE TABLE IF NOT EXISTS employees (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(100) NOT NULL," +
                        "department VARCHAR(100)," +
                        "salary DOUBLE" +
                        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(create);
        }
    }
}



