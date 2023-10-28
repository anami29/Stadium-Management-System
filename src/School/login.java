package School;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class login extends JFrame implements ActionListener {
    JPasswordField password;
    JTextField username;
    JButton login,cancel,back;

    login() {
        setSize(800, 500);
        JLabel l = new JLabel("ENTER YOUR LOGIN DETAILS!!!");
        l.setBounds(250, 30, 300, 50);
        l.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        add(l);

        JLabel l1 = new JLabel("USERNAME");
        l1.setBounds(150, 100, 150, 50);
        l1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        add(l1);

        JLabel l2 = new JLabel("PASSWORD");
        l2.setBounds(150, 200, 150, 50);
        l2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        add(l2);

        username = new JTextField();
        username.setBounds(400, 100, 200, 50);
        username.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        add(username);

        password = new JPasswordField();
        password.setBounds(400, 200, 200, 50);
        password.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        add(password);

        cancel = new JButton("CANCEL");
        cancel.setBounds(100, 350, 100, 50);
        cancel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        cancel.addActionListener(this);
        add(cancel);

        login = new JButton("SIGN IN");
        login.setBounds(550, 350, 100, 50);
        login.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/grass.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0, 0, 800, 500);
        add(lb1);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("stad/back.png"));
        Image editedimg2 = i2.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        i2= new ImageIcon(editedimg2);

        back = new JButton(i2);
        back.setBounds(0,0,60,60);
        back.addActionListener(this);
        add(back);



        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String name = this.username.getText();
            String password = String.valueOf(this.password.getPassword());

            conn c = new conn();
            String query = "select name,password from signing_in where name = '"+name+"' and password = '"+password+"';";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successfull!");
                    new event();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials!!");
                }
                setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if(ae.getSource()==cancel)
        {
            new check();
            setVisible(false);
        }
        if(ae.getSource()==back)
        {
            new check();
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new login();
    }
}