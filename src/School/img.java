package School;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class img extends JFrame implements ActionListener {
    int x=480,y=350;

    JButton lb1,lb2,lb3,lb4,lb5,lb6,lb7;
    img()
    {
        setSize(1500,800);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/save3.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);

        lb1 = new JButton(i1);
        lb1.setBounds(50,10,450,y);
        lb1.addActionListener(this);
        add(lb1);

        //ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("stad/stad1.jpg"));
        //Image editedimg2 = i2.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        //i2 = new ImageIcon(editedimg2);

        //lb2 = new JButton(i2);
        //lb2.setBounds(550,10,450,y);
        //lb2.addActionListener(this);
        //add(lb2);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("stad/save2.png"));
        Image editedimg3 = i3.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        i3 = new ImageIcon(editedimg3);

        lb3 = new JButton(i3);
        lb3.setBounds(1050,10,450,y);
        lb3.addActionListener(this);
        add(lb3);

        //ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("stad/IMG-20230929-WA0010.jpg"));
        //Image editedimg4 = i4.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        //i4 = new ImageIcon(editedimg4);

        //lb4 = new JButton(i4);
        //lb4.setBounds(50,400,450,y);
        //lb4.addActionListener(this);
        //add(lb4);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("stad/new1.jpg"));
        Image editedimg5 = i5.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        i5 = new ImageIcon(editedimg5);

        lb5 = new JButton(i5);
        lb5.setBounds(550,400,450,y);
        lb5.addActionListener(this);
        add(lb5);

        //ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("stad/stad3.jpg"));
        //Image editedimg6 = i6.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        //i6 = new ImageIcon(editedimg6);

        //lb6 = new JButton(i6);
        //lb6.setBounds(1050,400,450,y);
        //lb6.addActionListener(this);
        //add(lb6);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("stad/back.png"));
        Image editedimg7 = i7.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i7 = new ImageIcon(editedimg7);

        lb7 = new JButton(i7);
        lb7.setBounds(0,0,50,50);
        lb7.addActionListener(this);
        add(lb7);



        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==lb1)
        {
            new img1();
        }

        else if(ae.getSource()==lb3)
        {
            new img3();
        }

        else if(ae.getSource()==lb5)
        {
            new img5();
        }
        else if(ae.getSource()==lb7)
        {
            new web();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new img();
    }
}
