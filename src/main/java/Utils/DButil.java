package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DButil {
	private static final String URL =
	        "jdbc:mysql://localhost:3306/clients?useSSL=false&serverTimezone=UTC";
	    private static final String USER = "root";
	    private static final String PASS = "";
	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException("Driver JDBC introuvable", e);
	        }
	    }

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASS);
	    }
}



