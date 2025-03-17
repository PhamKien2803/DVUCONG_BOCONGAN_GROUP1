package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    protected Connection connection;
    
    public DBContext() {
        try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DVUCONG_BOCONGAN";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
            
            Logger.getLogger(DBContext.class.getName()).log(Level.INFO, "Kết nối SQL thành công!");
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Lỗi kết nối SQL", ex);
        }
    }
    
    public static void main(String[] args) {
        DBContext db = new DBContext();
        if (db.connection != null) {
            System.out.println("Kết nối SQL thành công!");
        } else {
            System.out.println("Kết nối SQL thất bại!");
        }
    }
}
