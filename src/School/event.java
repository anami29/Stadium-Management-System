package School;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class event extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4,r5;
    Font f1=new Font("Tahoma",Font.PLAIN,18);
    ButtonGroup btn =new ButtonGroup();
    JButton back;
    event()
    {
        setSize(1000,800);

        JLabel l1=new JLabel("Please select the event u want to choose");
        l1.setBounds(100,100,500,50);
        l1.setFont(new Font("Tahoma",Font.BOLD,22));
        add(l1);
        r1=new JRadioButton("ODIs");
        r1.setBounds(250,200,150,50);
        r1.setFont(f1);
        btn.add(r1);
        r1.addActionListener(this);
        add(r1);
        r2=new JRadioButton("T20");
        r2.setBounds(250,250,150,50);
        r2.setFont(f1);
        btn.add(r2);
        r2.addActionListener(this);
        add(r2);
        r3=new JRadioButton("Indian Premiere League");
        r3.setBounds(250,300,250,50);
        r3.setFont(f1);
        btn.add(r3);
        r3.addActionListener(this);
        add(r3);
        r4=new JRadioButton("Ranji Trophy");
        r4.setBounds(250,350,150,50);
        r4.setFont(f1);
        btn.add(r4);
        r4.addActionListener(this);
        add(r4);
        r5=new JRadioButton("Test Series");
        r5.setBounds(250,400,150,50);
        r5.setFont(f1);
        btn.add(r5);
        r5.addActionListener(this);
        add(r5);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("stad/back.png"));
        Image editedimg2 = i2.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        i2= new ImageIcon(editedimg2);

        back = new JButton(i2);
        back.setBounds(0,0,60,60);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==r1||ae.getSource()==r2||ae.getSource()==r3||ae.getSource()==r4||ae.getSource()==r5)
        {
            new ticket();
        }
        if(ae.getSource()==back)
        {
            new login();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new event();
    }

}
