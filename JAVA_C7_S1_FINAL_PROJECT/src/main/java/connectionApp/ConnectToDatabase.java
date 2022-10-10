package connectionApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectToDatabase
{
   static Connection con;
   public static Connection establishconnection() throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection
              ("jdbc:mysql://localhost:3306/JukeBox", "root", "root@123");
      return con;
   }
}

