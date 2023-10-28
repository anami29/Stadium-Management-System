package School;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ticket extends JFrame implements ActionListener {
    JLabel deta,name;
    JButton vip,normal;
    Font font=new Font("Tahoma",Font.BOLD,20);
    ticket()
    {
        setSize(700,500);
        deta = new JLabel("Hello User!!!! \n Pay to buy the Ticket");
        deta.setBounds(150,20,400,50);
        deta.setFont(font);
        add(deta);

        vip=new JButton("VIP TICKET");
        vip.setBounds(100,200,150,50);
        vip.setBackground(Color.lightGray);
        add(vip);

        normal=new JButton("LOCAL TICKET");
        normal.setBounds(400,200,150,50);
        normal.setBackground(Color.lightGray);
        add(normal);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/tick.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);

        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,700,700);
        add(lb1);




        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==vip)
        {
            new vip1();
        }
        if(ae.getSource()==normal)
        {
            new paid1();
        }
    }

    public static void main(String[] args) {
        new ticket();
    }
}
