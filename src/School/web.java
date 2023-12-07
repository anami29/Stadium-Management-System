package School;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class web extends JFrame implements ActionListener {
    JButton lag,l1,lb2;
    JTabbedPane tabs;
    JScrollPane sp1,sp2;
    JLabel photo,sem1,sem2;
    Font font=new Font("Roboto",Font.BOLD,15);
    web() {
        setSize(1500,800);

        lag = new JButton("BOOK ");
        lag.setBounds(1300, 200,100,50);
        lag.setBackground(Color.green);
        lag.addActionListener(this);
        add(lag);

        photo = new JLabel("Want to Know more about Stadium??");
        photo.setBounds(100,700,300,40);
        photo.setForeground(Color.green);
        photo.setFont(font);
        add(photo);

        tabs = new JTabbedPane();
        tabs.setBounds(100,100,300,170);
        tabs.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(tabs);

        sem1=new JLabel("<html>1.ODI (New Zealand v/s England)<p style=\"font-size:7px;\">(tickets sold out)</p><br>2.T20 (Hong Kong v/s Cambodia)<p style=\"font-size:7px;\">(tickets sold out)</p></html>");
        sem1.setBounds(10,0,40,50);
        sem1.setFont(new Font("Tahoma", Font.BOLD, 16));

        sem2=new JLabel("<html>1.ODI (Pakistan v/s Netherlands)<p style=\"font-size:7px;\">(13-11-2023)(D.Y.Patil)</p><br>2.Test Series (IND v/s SL)<p style=\"font-size:7px;\">(19-11-2023)(R.Premadasa)</p><br>3.IPL (KKR v/s DC)<p style=\"font-size:7px;\">(10-11-2023)(Wankhede)</p></html>");
        sem2.setBounds(10,0,40,50);
        sem2.setFont(new Font("Tahoma", Font.BOLD, 16));


        sp1 = new JScrollPane();
        sp1.setViewportView(sem1);

        sp2 = new JScrollPane();
        sp2.setViewportView(sem2);
        tabs.addTab("Today",sp1);
        tabs.addTab("Further",sp2);



        l1=new JButton("Images");
        l1.setBounds(420,700,120,40);
        l1.setFont(font);
        l1.setBackground(Color.CYAN);
        l1.addActionListener(this);
        add(l1);
        JLabel l0=new JLabel("PROFILE");
        l0.setBounds(1410,85,70,30);
        l0.setFont(new Font("Tahoma",Font.PLAIN,12));
        add(l0);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/IMG-20230929-WA0009.jpg"));
       Image editedimg1 = i1.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
       i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,1500,800);
        add(lb1);

        

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("stad/user3.png"));
        Image editedimg2 = i2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i2 = new ImageIcon(editedimg2);

        lb2 = new JButton(i2);
        lb2.setBounds(1400,20,60,60);
        lb2.addActionListener(this);
        add(lb2);






        //setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
   public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==lag)
        {
            String data=null;
            new check();
            new web().setVisible(false);
            new FirstFrame().setVisible(false);
            new SecondFrame(data).setVisible(false);
        }
        else if(ae.getSource()==l1)
        {
            new img();
        }
        else if(ae.getSource()==lb2)
       {
        new FirstFrame();
        this.setVisible(false);


       }
    }
    public static void main(String[] args) {
        new web();

    }
}
