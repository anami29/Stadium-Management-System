package School;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class img extends JFrame implements ActionListener {
    int x=480,y=350;

    JButton lb1,lb3,lb5,lb7,lb9;
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

        JTextArea ta=new JTextArea("\nStadiums are like the colossal coliseums of modern times, where the \nroars of the crowd and the cheers of fans create a symphony of\neuphoria. These mammoth marvels of architecture are more than \njust concrete and steel; they are the beating hearts of sports\nand entertainment.\n\nThe seating arrangements are like a colorful mosaic,forming a sea \nof eager faces, each one a brushstroke in the grand tapestry of \nfandom. From the nosebleed seats to the VIP boxes, there's a\nvantage point for every level of passion and pocketbook.\n\nStadium vendors sell a variety of food items and other wares either\nby walking around and calling out the name of the food or product\nthey are selling, or by operating small booths or kiosks. ");
        ta.setBounds(550,10,450,y);
        ta.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        add(ta);


        JTextArea tc=new JTextArea("Customer Support Details:\n\nEmail id:stadcustomersupport@gmail.com\n\nContact :1234567890\n\n\n\n\n                        Thank You For Your Support");
        tc.setBounds(1050,400,450,y);
        tc.setFont(new Font("Berlin Sans FB",Font.PLAIN,16));
        add(tc);
        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("stad/logo.jpg"));
        Image editedimg9 = i9.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        i9 = new ImageIcon(editedimg9);

        lb9 = new JButton(i9);
        lb9.setBounds(50,400,450,y);
        lb9.addActionListener(this);
        add(lb9);




        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("stad/save2.png"));
        Image editedimg3 = i3.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        i3 = new ImageIcon(editedimg3);

        lb3 = new JButton(i3);
        lb3.setBounds(1050,10,450,y);
        lb3.addActionListener(this);
        add(lb3);


        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("stad/new1.jpg"));
        Image editedimg5 = i5.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT);
        i5 = new ImageIcon(editedimg5);

        lb5 = new JButton(i5);
        lb5.setBounds(550,400,450,y);
        lb5.addActionListener(this);
        add(lb5);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("stad/back.png"));
        Image editedimg7 = i7.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i7 = new ImageIcon(editedimg7);

        lb7 = new JButton(i7);
        lb7.setBounds(0,0,50,50);
        lb7.addActionListener(this);
        add(lb7);



       // setUndecorated(true);
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
