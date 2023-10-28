package School;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class img5 extends JFrame implements ActionListener {
    JLabel lb1;
    JButton lb7;
    img5()
    {
        setSize(500,500);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("stad/new1.jpg"));
        Image edited1 = img1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        img1 = new ImageIcon(edited1);

        lb1 = new JLabel(img1);
        lb1.setBounds(0,0,500,500);
        add(lb1);

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
        if(ae.getSource()==lb7)
        {
            new img();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new img5();
    }
}
