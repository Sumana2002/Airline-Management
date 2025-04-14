package airlinemanagementsystem;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //registering the driver for connection
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "sql@Maity02");
            s = c.createStatement();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
