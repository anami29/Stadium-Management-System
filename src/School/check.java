package School;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class check extends JFrame implements ActionListener {
    JButton admin,user,back;
    Font font=new Font("Tahoma",Font.BOLD,18);
    check()
    {
        setSize(600,350);
        ButtonGroup btn=new ButtonGroup();
        JLabel l1=new JLabel("CHOOSE TO SIGN UP OR LOGIN");
        l1.setBounds(130,50,400,50);
        l1.setFont(font);
        add(l1);
        admin = new JButton("  LOGIN");
        admin.setBounds(120,160,100,50);
        admin.addActionListener(this);
        btn.add(admin);
        add(admin);
        user=new JButton("  SIGN UP");
        user.setBounds(350,160,100,50);
        user.addActionListener(this);
        btn.add(user);
        add(user);
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("stad/back.png"));
        Image editedimg2 = i2.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        i2= new ImageIcon(editedimg2);
        back = new JButton(i2);
        back.setBounds(0,0,60,60);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new web();
                setVisible(false);
            }
        });
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/mast4.jpeg"));
        Image editedimg1 = i1.getImage().getScaledInstance(600,350,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);

        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,600,350);
        add(lb1);

        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==admin)
        {
            new login();
            setVisible(false);
        }
        else if(ae.getSource()==user)
        {
            new sign();
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new check();
    }
}
