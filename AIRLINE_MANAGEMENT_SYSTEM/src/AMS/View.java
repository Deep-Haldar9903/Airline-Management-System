package AMS;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;




public class View extends JFrame
{
    JTable t;
    String x[] = {"Username","Name","Date of birth","Address","Phone","Email","Nationality","Gender","Passport"};
    String y[][]=new String[20][10];
    int i=0,j=0;
    Font f;
 
    View()
    {
        super("All Passenger Details");
        setSize(1200,400);
        setLocation(0,10);
        f=new Font("Times New Roman",Font.BOLD,16);
        
        try
        {
            AMS.ConnectionClass obj = new ConnectionClass();
            String q="SELECT * FROM passenger";
             ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next())
            {
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("age");
                y[i][j++]=rs.getString("dob");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("phone");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("nationality");
                y[i][j++]=rs.getString("gender");
                y[i][j++]=rs.getString("passport");

                
                i++;j=0;
            }
            t=new JTable(y,x);
        }
            catch(Exception ex)
           {
               ex.printStackTrace();
           }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane js=new JScrollPane(t);
        
                add(js);
    }
    
     public static void main(String args[])
    {
        new View().setVisible(true);
    }
}
