import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class GlassfishConnection {
 
    public Connection getConnection() {
 
        try {
 
            InitialContext initialContext = new InitialContext();
 
            DataSource dataSource = (DataSource) initialContext.lookup("jdbc/progress");
            return dataSource.getConnection();
 
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 
        return null;
    }
}