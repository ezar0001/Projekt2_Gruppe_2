import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest {
    public static void main(String[] args) throws Exception {
        String host = System.getenv("DB_HOST");
        String name = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASS");

        String url = "jdbc:mysql://" + host + ":3306/" + name + "?useSSL=true&requireSSL=false";
        
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SHOW COLUMNS FROM onske")) {
            
            while (rs.next()) {
                System.out.println(rs.getString("Field"));
            }
        }
    }
}
