package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The User class handles user authentication by connecting to a MySQL database.
 */
public class User {

    /**
     * Establishes a connection to the MySQL database.
     * 
     * @return Connection object representing the database connection
     * @throws SQLException if a database access error occurs
     */
    public Connection conectarBD() throws SQLException {
        Connection conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Database URL, username, and password
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            // Establish the connection
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            // Handle the case where the JDBC driver is not found
            e.printStackTrace();
        }
        return conn;
    }

    // Variables to store user information
    public String nome = "";
    public boolean result = false;

    /**
     * Verifies the user's credentials against the database.
     * 
     * @param usuario the username to verify
     * @param senha   the password to verify
     * @return true if the user is authenticated, false otherwise
     */
    public boolean verificarUsuario(String usuario, String senha) {
        String sql = "";
        Connection conn = null;
        try {
            // Establish the database connection
            conn = conectarBD();
            // SQL query to retrieve user information
            sql += "SELECT nome FROM usuarios ";
            sql += "WHERE login = ? AND senha = ?";

            // Prepare the SQL statement
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, usuario);
            st.setString(2, senha);

            // Execute the query
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                // If the result set is not empty, user is authenticated
                result = true;
                nome = rs.getString("nome");
            }
            // Close the result set, statement, and connection
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
        }
        return result;
    }
}
