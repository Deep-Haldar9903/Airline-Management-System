package AMS;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;


public class Book extends JFrame implements ActionListener

{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12,l13;
    JButton bt1, bt2;
    JTextField tf1, tf2, tf3, tf4, tf5;
    JPanel p1,p2,p3;
    Font f,f1;
    Choice ch1,ch2,ch3,ch4,ch5,ch6;
    
    
    Book()
    {
        super("Book Airlines India Flight");
        setLocation(50,10);
        setSize(1100,650);
        
        f=new Font("Times New Roman",Font.BOLD,25);
        f1=new Font("Times New Roman",Font.BOLD,18);

        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();
        ch4=new Choice();
        ch5=new Choice();
        ch6=new Choice();
        
        try
        {
             AMS.ConnectionClass obj = new ConnectionClass();
             String q = "SELECT distinct Source from flight";
             ResultSet rs=obj.stm.executeQuery(q);
              while(rs.next())
            {
              ch1.add(rs.getString("Source"));
            }
             rs.close();
        }
        catch(Exception ex)
           {
               ex.printStackTrace();
           }
        
        try
            
        {
             AMS.ConnectionClass obj = new ConnectionClass();
             String q = "SELECT username from passenger";
             ResultSet rs=obj.stm.executeQuery(q);
              while(rs.next())
            {
              ch2.add(rs.getString("username"));
            }
             rs.close();
        }

        catch(Exception ex)
           {
               ex.printStackTrace();
           }
        
        l1=new JLabel("Book Airlines India Flight");
        l2=new JLabel("Ticket Id");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Class");
        l6=new JLabel("Price");
        l7=new JLabel("Flight Code");
        l8=new JLabel("Flight Name");
        l9=new JLabel("Journey Date");
        l10=new JLabel("Journey Time");
        l11=new JLabel("Username");
        l13=new JLabel("Name");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        
        tf1.setEditable(false);
         tf2.setEditable(false);
          tf5.setEditable(false);
        
       Random r=new Random();
       tf1.setText(""+Math.abs(r.nextInt()%100000));
       tf1.setForeground(Color.RED);
       
       bt1 = new JButton("Book Flight");
       bt2 = new JButton("Back");
       
        bt1.addActionListener(this); 
        bt2.addActionListener(this); 
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(new java.awt.Color(232,2,125));
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l13.setFont(f1);
        
        ch1.setFont(f1);
        ch2.setFont(f1);
        ch3.setFont(f1);
        ch4.setFont(f1);
        ch5.setFont(f1);
        ch6.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        l2.setForeground(new java.awt.Color(103,3,173));
        l3.setForeground(new java.awt.Color(103,3,173));
        l4.setForeground(new java.awt.Color(103,3,173));
        l5.setForeground(new java.awt.Color(103,3,173));
        l6.setForeground(new java.awt.Color(103,3,173));
        l7.setForeground(new java.awt.Color(103,3,173));
        l8.setForeground(new java.awt.Color(103,3,173));
        l9.setForeground(new java.awt.Color(103,3,173));
        l10.setForeground(new java.awt.Color(103,3,173));
        l11.setForeground(new java.awt.Color(103,3,173));
        l13.setForeground(new java.awt.Color(103,3,173));
        
         bt1.setBackground(new java.awt.Color(232,2,125));
         bt2.setForeground(Color.BLACK);
          
         bt1.setForeground(Color.WHITE);
         bt2.setForeground(new java.awt.Color(232,2,125));
         
         p1=new JPanel();
         p1.setLayout(new GridLayout(1,1,10,10));
         p1.add(l1);
         
         p2=new JPanel();
         p2.setLayout(new GridLayout(12, 12, 10, 10));
         p2.add(l2);
         p2.add(tf1);
         p2.add(l3);
         p2.add(ch1);
         p2.add(l4);
         p2.add(ch6);
         p2.add(l5);
         p2.add(ch3);
         p2.add(l6);
         p2.add(ch4);
         p2.add(l7);
         p2.add(ch5);
         p2.add(l8);
         p2.add(tf2);
         p2.add(l9);
         p2.add(tf3);
         p2.add(l10);
         p2.add(tf4);
         p2.add(l11);
         p2.add(ch2);
         p2.add(l13);
         p2.add(tf5);
         p2.add(bt1);
         p2.add(bt2);
         
          
         p3=new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));

         
         ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMS/icons/3.jpg"));
        Image img1 = img.getImage().getScaledInstance(620, 570, Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img1);
        l12 =new JLabel(ic1);
         p3.add(l12);
         
         setLayout(new BorderLayout(10,10));
         add(p1,"North");
         add(p2,"Center");
         add(p3,"West");
         
         ch2.addMouseListener(new MouseAdapter()
         {
             @Override
             public void mouseClicked(MouseEvent arg0)
             {
                 try
           {
                AMS.ConnectionClass obj = new ConnectionClass();
                String username=ch2.getSelectedItem();
                String q1 = "SELECT name FROM passenger WHERE username = '"+username+"'";
                ResultSet rs1=obj.stm.executeQuery(q1);
            while(rs1.next())
            {
              tf5.setText(rs1.getString("name"));
            }
            rs1.close();
           }
               
                  catch(Exception exx)
           {
               exx.printStackTrace();
           }
                 
             }
         });
         
         ch1.addMouseListener(new MouseAdapter()
         {
             @Override
             public void mouseClicked(MouseEvent arg0)
             {
                 ch6.removeAll();
                 try
           {
                AMS.ConnectionClass obj = new ConnectionClass();
                String source=ch1.getSelectedItem();
                String q1 = "SELECT DISTINCT destination FROM flight WHERE source = '"+source+"'";
                ResultSet rs1=obj.stm.executeQuery(q1);
            while(rs1.next())
            {
              ch6.add(rs1.getString("destination"));
            }
            rs1.close();
           }
               
                  catch(Exception exx)
           {
               exx.printStackTrace();
           }
                 
             }
         });
         
         ch6.addMouseListener(new MouseAdapter()
         {
             @Override
             public void mouseClicked(MouseEvent arg0)
             {
                 ch3.removeAll();
                 try
           {
                AMS.ConnectionClass obj = new ConnectionClass();
                String source=ch1.getSelectedItem();
                String destination=ch6.getSelectedItem();
                String q1 = "SELECT DISTINCT class_name FROM flight WHERE source = '"+source+"' AND destination='"+destination+"'"; 
                ResultSet rs1=obj.stm.executeQuery(q1);
            while(rs1.next())
            {
              ch3.add(rs1.getString("class_name"));
            }
           }
               
                  catch(Exception exx)
           {
               exx.printStackTrace();
           }
                 
             }
         });
         
         ch3.addMouseListener(new MouseAdapter()
         {
             @Override
             public void mouseClicked(MouseEvent arg0)
             {
                 ch4.removeAll();
                 try
           {
                AMS.ConnectionClass obj = new ConnectionClass();
                String source=ch1.getSelectedItem();
                String destination=ch6.getSelectedItem();
                String classname=ch3.getSelectedItem();
                String q1 = "SELECT DISTINCT price FROM flight WHERE source = '"+source+"' AND destination='"+destination+"' AND class_name='"+classname+"'";
                ResultSet rs1=obj.stm.executeQuery(q1);
            while(rs1.next())
            {
              ch4.add(rs1.getString("price"));
            }
           }
               
                  catch(Exception exx)
           {
               exx.printStackTrace();
           }
                 
             }
         });
         
         ch4.addMouseListener(new MouseAdapter()
         {
             @Override
             public void mouseClicked(MouseEvent arg0)
             {
                 ch5.removeAll();
                 try
           {
                AMS.ConnectionClass obj = new ConnectionClass();
                String source=ch1.getSelectedItem();
                String destination=ch6.getSelectedItem();
                String classname=ch3.getSelectedItem();
                String p=ch4.getSelectedItem();
                String q1 = "SELECT DISTINCT flight_code FROM flight WHERE source = '"+source+"' AND destination='"+destination+"' AND class_name='"+classname+"' AND price='"+p+"'";
                ResultSet rs1=obj.stm.executeQuery(q1);
            while(rs1.next())
            {
              ch5.add(rs1.getString("flight_code"));
            }
           }
               
                  catch(Exception exx)
           {
               exx.printStackTrace();
           }
                 
             }
         });
         
          ch5.addMouseListener(new MouseAdapter()
         {
             @Override
             public void mouseClicked(MouseEvent arg0)
             {
                 
                 try
           {
                AMS.ConnectionClass obj = new ConnectionClass();
                String source=ch1.getSelectedItem();
                String destination=ch6.getSelectedItem();
                String classname=ch3.getSelectedItem();
                String p=ch4.getSelectedItem();
                String f=ch5.getSelectedItem();
                String q1 = "SELECT DISTINCT f_name FROM flight WHERE source = '"+source+"' AND destination='"+destination+"' AND class_name='"+classname+"' AND price='"+p+"' AND flight_code='"+f+"'";
                ResultSet rs1=obj.stm.executeQuery(q1);
            while(rs1.next())
            {
              tf2.setText(rs1.getString("f_name"));
            }
           }
               
                  catch(Exception exx)
           {
               exx.printStackTrace();
           }
                 
             }
         });
         
         
         
    }
    
     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String tid=tf1.getText();
            String source=ch1.getSelectedItem();
            String destination=ch6.getSelectedItem();
            String classname=ch3.getSelectedItem();
            String price=ch4.getSelectedItem();
            String fcode=ch5.getSelectedItem();
            String fname=tf2.getText();
            String jdate=tf3.getText();
            String jtime=tf4.getText();
            String username=ch2.getSelectedItem();
            String name=tf5.getText();
            String status="Success";
            
           try
           {
               AMS.ConnectionClass obj3 = new ConnectionClass();
String q1 = "INSERT INTO BOOKED (tid, source, destination, class_name, price, fcode, fname, journey_date, journey_time, username, name, status) VALUES ('"+tid+"', '"+source+"', '"+destination+"', '"+classname+"', '"+price+"', '"+fcode+"', '"+fname+"', '"+jdate+"', '"+jtime+"', '"+username+"', '"+name+"', '"+status+"')";
                
                int aa=obj3.stm.executeUpdate(q1);
                if(aa==1)
                { 
                    JOptionPane.showMessageDialog(null,"YOUR FLIGHT HAS BEEN BOOKED SUCCESSFULLY");
                    this.setVisible(false);

                }
                else
                 {
                    JOptionPane.showMessageDialog(null,"PLS! FILL THE DETAILS CAREFULLY");
                       
                    }

                
                    }
                 
               
                  catch(Exception exx)
           {
               exx.printStackTrace();
           }
                 
             }

         
                
            if(e.getSource()==bt2)
       {
           
            JOptionPane.showMessageDialog(null,"Are you sure to cancel");
            setVisible(false);
       }
            
        }
        
    

    
     public static void main(String args[])
    {
        new Book().setVisible(true);
    }
}
