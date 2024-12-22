package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class ViewBookedFlight extends JFrame 
{
    JTable t;
    String x[] = {"Ticket Id","Source","Destination","Class","Price","Flight Code","Flight Name","Journey Date","Journey Time","Username","Name","Status"};
     String y[][]=new String[20][12];
    int i=0,j=0;
    Font f;
    ViewBookedFlight()
    {
        super("Flight Journey Details");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("Times New Roman",Font.BOLD,16);
        
         try
        {
            AMS.ConnectionClass obj = new ConnectionClass();
            String q="SELECT * FROM booked";
             ResultSet rs=obj.stm.executeQuery(q);
            while(rs.next())
            {
                y[i][j++]=rs.getString("tid");
                y[i][j++]=rs.getString("source");
                y[i][j++]=rs.getString("destination");
                y[i][j++]=rs.getString("class_name");
                y[i][j++]=rs.getString("price");
                y[i][j++]=rs.getString("fcode");
                y[i][j++]=rs.getString("fname");
                y[i][j++]=rs.getString("journey_date");
                y[i][j++]=rs.getString("journey_time");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("status");

                
                i++;j=0;
            }
            t=new JTable(y,x);
        }
             catch(Exception exx)
           {
               exx.printStackTrace();
           }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane js=new JScrollPane(t);
        
                add(js);
    }
    public static void main(String args[])
    {
        new ViewBookedFlight().setVisible(true);
    }
}
