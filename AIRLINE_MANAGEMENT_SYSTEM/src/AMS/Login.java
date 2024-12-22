package AMS;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JButton bt1, bt2;
    JPasswordField pf;
    JTextField tf;
    

    Login() {
        super("Login Account"); // Set title of the frame
        setBackground(Color.WHITE);
        setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMS/icons/6.jpg"));
        Image i1 = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);

        l2 = new JLabel("USERNAME");
        l2.setBounds(120, 120, 150, 30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l1.add(l2);

        l3 = new JLabel("LOGIN ACCOUNT");
        l3.setBounds(190, 30, 500, 50);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.add(l3);

        l4 = new JLabel("PASSWORD");
        l4.setBounds(120, 170, 150, 30);
        l4.setForeground(Color. WHITE);
        l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l1.add(l4);

        tf = new JTextField();
        tf.setBounds(320, 120, 150, 30);
        l1.add(tf);

        pf = new JPasswordField();
        pf.setBounds(320, 170, 150, 30);
        l1.add(pf);

        bt1 = new JButton("Login");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(120, 220, 150, 40);
         // Add action listener
        l1.add(bt1);

        bt2 = new JButton("Sign Up");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(320, 220, 150, 40);
        // Add action listener
        l1.add(bt2);

        
        add(l1); // Add l1 to the frame
        bt1.addActionListener(this); 
        bt2.addActionListener(this); 

        setVisible(true);
        setSize(580, 350);
        setLocation(300, 100);
    }

    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==bt1)
       {
           String username=tf.getText();
           String pass=pf.getText();
           try
           {
                AMS.ConnectionClass obj = new ConnectionClass();
               String q="Select * from signup where username ='"+username+"'and password='"+pass+"'";
               ResultSet rs=obj.stm.executeQuery(q);
               if(rs.next())
               {
                   new HomePage().setVisible(true);
                   setVisible(false);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"You hae entered wrong user name and password");
                   setVisible(false);
                   setVisible(true);
               }
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
       if(e.getSource()==bt2)
       {
           this.setVisible(false);
           new SignupMessage();
       }
    }

    public static void main(String args[]) {
        new Login();
    }

}
