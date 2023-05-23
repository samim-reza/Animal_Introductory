import java.sql.*;

import com.mysql.cj.xdevapi.SelectStatement;

class Database {

    private static Connection connection;

    Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connection == null || (connection != null && connection.isClosed()))
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "S@mim101");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public Connection getConnection() {
        return connection;
    }
    // public ResultSet getUserName(String email) {
    //     var name;
    //     try {
    //         name=getConnection().createStatement().executeQuery("Select name from Userinfo where Email='email'");
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return name;
    // }

    public static void main(String[] args) throws Exception {

        //Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "S@mim101");
        Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("SELECT * FROM Userinfo");
        // while (rs.next())
        //     System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+"  "+rs.getInt(4));
        //stmt.executeUpdate("insert into Userinfo values('Jubayer@gmail.com','Jubayer','1234',20)");
        //stmt.executeUpdate("delete from Userinfo where Email='Jubayer@gmail.com'");
        stmt.executeUpdate("update Userinfo set Name='Jubayer',Password='1234' where Email='Jubayer@gmail.com'");
        
        con.close();
        stmt.close();
    }
}
