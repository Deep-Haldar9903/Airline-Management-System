
package AMS;

import java.sql.*;

public class ConnectionClass 
{
Connection con;
Statement stm;
String u="jdbc:mysql://localhost:3306/air";
String n="root";
String p="Deephaldar@03";

ConnectionClass()
{
    try
    {
       Class.forName("com.mysql.cj.jdbc.Driver");
       con=DriverManager.getConnection(u,n,p);
       stm=con.createStatement();
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
}
public static void main(String args[])
{
    new ConnectionClass();
}
        
}
