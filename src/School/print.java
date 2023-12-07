package School;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class print extends JFrame {
    JTextField name;
    JComboBox <String> event;
    JRadioButton r1,r2,r3;
    JTextArea tc;
    JButton back;
    String eve,dat,location,time,tick,a,b,vprice,lprice,gprice;
    Font f1=new Font("Tahoma",Font.BOLD,16);
    Font f2=new Font("Tahoma",Font.BOLD,15);
    JDateChooser d1;
    JLabel lb1;

    print()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1525,800);
        setLayout(null);


        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("stad/back.png"));
        Image editedimg2 = i2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i2= new ImageIcon(editedimg2);

        back = new JButton(i2);
        back.setBounds(0,0,50,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new web();
                setVisible(false);
            }
        });
        add(back);


        JLabel l1= new JLabel("Purchaser's Name");
        l1.setBounds(50,50,150,40);
        l1.setFont(f1);
        l1.setForeground(Color.white);
        add(l1);

        name = new JTextField();
        name.setBounds(250,50,150,40);
        name.setFont(f1);
        add(name);

        JLabel l2=new JLabel("Purchasing Date");
        l2.setBounds(50,130,150,40);
        l2.setFont(f1);
        l2.setForeground(Color.white);
        add(l2);

        d1=new JDateChooser();
        d1.setBounds(250,130,150,40);
        d1.setFont(f1);
        add(d1);

        JLabel l3=new JLabel("Ticket Type  ");
        l3.setBounds(470,50,150,40);
        l3.setFont(f1);
        l3.setForeground(Color.white);
        add(l3);
        //String [] arr={"ODI(Pak v/s NL)","Ranji Trophy(BIH v/s MUM)","IPL(KKR v/s DC)"};

        event=new JComboBox<>();
        event.addItem("GOLDEN TICKET");
        event.addItem("VIP TICKET");
        event.addItem("GENERAL TICKET");
        event.setBounds(700,50,200,40);
        event.setBackground(Color.white);
        event.setFont(f1);
        event.setSelectedIndex(-1);
        add(event);

        tc = new JTextArea();
        tc.setBounds(50,300,400,350);
        tc.setBackground(Color.decode("#fafaa5"));
        tc.setVisible(false);
        tc.setFont(f1);
        add(tc);
        JLabel lab1=new JLabel("<html>*Golden Ticket will allow the holders to attend all the matches from ground zero<br>*VIP Ticket include additional benefits like backstage access or complimentary amenities.</html>");
        lab1.setBounds(850,700,530,50);
        add(lab1);

        JLabel lab2=new JLabel("Events : ");
        lab2.setBounds(470,120,100,40);
        lab2.setFont(f1);
        lab2.setForeground(Color.white);
        add(lab2);
        r1=new JRadioButton("IPL(KKR v/s DC)");
        r1.setBounds(600,120,170,40);
        r1.setFont(f2);
        r1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventDetails();
            }
        });
        add(r1);
        r2=new JRadioButton("ODI(PAK v/s BAN)");
        r2.setBounds(600,170,170,40);
        r2.setFont(f2);
        r2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventDetails2();
            }
        });
        add(r2);
        r3=new JRadioButton("Test Series(IND v/s SL)");
        r3.setBounds(600,220,220,40);
        r3.setFont(f2);
        r3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventDetails3();
            }
        });
        add(r3);
        ButtonGroup btn=new ButtonGroup();
        btn.add(r1);
        btn.add(r2);
        btn.add(r3);

        JButton gb = new JButton("PAY");
        gb.setBounds(100,220,100,40);
        gb.setFont(f1);
        add(gb);
        gb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Payment Successful");
                tc.setVisible(true);
                generate();
            }
        });
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/stadu.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(1525,800,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);

        lb1 = new JLabel(i1);
        lb1.setBounds(0,0,1525,800);
        add(lb1);
        setVisible(true);
        //setBackground(Color.white);
        //add(panel);


    }

    public void eventDetails()
    {
        conn c=new conn();
        String query="select event_name,event_locate,event_date,event_time,ticket_sold,team1,team2,gol_prize,vip_prize,gen_prize from event where event_id=1;";
        try
        {
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                eve=rs.getString("event_name");
                location=rs.getString("event_locate");
                dat=rs.getString("event_date");
                time=rs.getString("event_time");
                tick=rs.getString("ticket_sold");
                a=rs.getString("team1");
                b=rs.getString("team2");
                gprice=rs.getString("gol_prize");
                lprice=rs.getString("gen_prize");
                vprice=rs.getString("vip_prize");
                System.out.println(b);

                StringBuilder sb1=new StringBuilder();
                sb1.append(" Event : ").append(eve).append("\n\n");
                sb1.append(" Location : "+location).append("\n\n");
                sb1.append(" Date : "+dat+"\n\n");
                sb1.append(" Time : "+time).append("\n\n");
                sb1.append("             "+a +" v/s "+b).append("\n\n");
                sb1.append(" No.of Seats Remaining : "+tick).append("\n\n");
                sb1.append(" Golden Ticket Prize : "+gprice).append("\n\n");
                sb1.append(" VIP Ticket Prize : "+vprice).append("\n\n");
                sb1.append(" General Ticket Prize : "+lprice).append("\n\n");

                JTextArea ta=new JTextArea();
                ta.setBounds(1100,100,350,350);
                ta.setFont(f2);
                add(ta);
                ta.setText(sb1.toString());

            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }

    public void eventDetails2()
    {
        conn c=new conn();
        String query="select event_name,event_locate,event_date,event_time,ticket_sold,team1,team2,gol_prize,vip_prize,gen_prize from event where event_id=2;";
        try
        {
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                eve=rs.getString("event_name");
                location=rs.getString("event_locate");
                dat=rs.getString("event_date");
                time=rs.getString("event_time");
                tick=rs.getString("ticket_sold");
                a=rs.getString("team1");
                b=rs.getString("team2");
                gprice=rs.getString("gol_prize");
                lprice=rs.getString("gen_prize");
                vprice=rs.getString("vip_prize");
                System.out.println(b);

                StringBuilder sb1=new StringBuilder();
                sb1.append(" Event : ").append(eve).append("\n\n");
                sb1.append(" Location : "+location).append("\n\n");
                sb1.append(" Date : "+dat+"\n\n");
                sb1.append(" Time : "+time).append("\n\n");
                sb1.append("             "+a +" v/s "+b).append("\n\n");
                sb1.append(" No.of Seats Remaining : "+tick).append("\n\n");
                sb1.append(" Golden Ticket Prize : "+gprice).append("\n\n");
                sb1.append(" VIP Ticket Prize : "+vprice).append("\n\n");
                sb1.append(" General Ticket Prize : "+lprice).append("\n\n");

                JTextArea ta=new JTextArea();
                ta.setBounds(1100,100,350,350);
                ta.setFont(f2);
                add(ta);
                ta.setText(sb1.toString());

            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }

    public void eventDetails3()
    {
        conn c=new conn();
        String query="select event_name,event_locate,event_date,event_time,ticket_sold,team1,team2,gol_prize,vip_prize,gen_prize from event where event_id=3;";
        try
        {
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                eve=rs.getString("event_name");
                location=rs.getString("event_locate");
                dat=rs.getString("event_date");
                time=rs.getString("event_time");
                tick=rs.getString("ticket_sold");
                a=rs.getString("team1");
                b=rs.getString("team2");
                gprice=rs.getString("gol_prize");
                lprice=rs.getString("gen_prize");
                vprice=rs.getString("vip_prize");
                System.out.println(b);

                StringBuilder sb1=new StringBuilder();
                sb1.append(" Event : ").append(eve).append("\n\n");
                sb1.append(" Location : "+location).append("\n\n");
                sb1.append(" Date : "+dat+"\n\n");
                sb1.append(" Time : "+time).append("\n\n");
                sb1.append("             "+a +" v/s "+b).append("\n\n");
                sb1.append(" No.of Seats Remaining : "+tick).append("\n\n");
                sb1.append(" Golden Ticket Prize : "+gprice).append("\n\n");
                sb1.append(" VIP Ticket Prize : "+vprice).append("\n\n");
                sb1.append(" General Ticket Prize : "+lprice).append("\n\n");

                JTextArea ta=new JTextArea();
                ta.setBounds(1100,100,350,350);
                ta.setFont(f2);
                add(ta);
                ta.setText(sb1.toString());

            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }

    public void generate()
    {
        JButton printButton = new JButton("Print Ticket");
        printButton.setBounds(250,220,150,40);
        printButton.setFont(f1);
        printButton.addActionListener(e -> printTicket(tc));
        add(printButton);
        String name=this.name.getText();
        SimpleDateFormat dt =new SimpleDateFormat("dd-MM-yyyy");
        String date= dt.format(this.d1.getDate());
        String cb1 = this.event.getSelectedItem().toString();
           /* String evente=null;
            if(r1.isSelected())
            {
                evente="IPL(KKR v/s DC)";
            }
            if(r2.isSelected())
            {
                evente="ODI(PAK v/s BAN)";
            }
            if(r3.isSelected())
            {
                evente="Test Series(IND v/s SL)";
            }*/
        String fare=null;
        if(cb1=="VIP TICKET")
        {
            fare=vprice;
        }
        if(cb1=="GENERAL TICKET")
        {
            fare=lprice;
        }
        if(cb1=="GOLDEN TICKET")
        {
            fare=gprice;
        }
        System.out.println(cb1);
        StringBuilder ticket =new StringBuilder();
        ticket.append("Event : "+eve).append("\n\n");
        ticket.append("****************************************").append("\n");
        ticket.append("Name : ").append(name).append("         ");
        ticket.append("Issued on : ").append(date).append("\n\n");
        ticket.append(cb1+"   Price  ₹"+fare).append("\n\n");
        ticket.append("Time : "+time+"\n\n");
        ticket.append("Event Date : "+dat+"\n\n");
        ticket.append("Location : "+location+"\n\n");
        ticket.append("     "+a+" v/s "+b+"\n\n");
        ticket.append("****************************************").append("\n");

        tc.setText(ticket.toString());
        conn c=new conn();
        String query="insert into ticket(event_name,name,pur_date,ticket_type,price)values('"+eve+"','"+name+"','"+date+"','"+cb1+"','"+fare+"')";
        try{
            c.s.executeUpdate(query);
            printButton.setVisible(true);
            JOptionPane.showMessageDialog(null,"Thank You\nPLease print your Ticket");

        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Try Again");
        }
    }
    public void printTicket(JTextArea tcToPrint)
    {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printerJob.defaultPage();
        pageFormat.setOrientation(PageFormat.PORTRAIT);
        printerJob.setPrintable(new Printable() {
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                tcToPrint.printAll(g2d);

                return Printable.PAGE_EXISTS;
            }
        }, pageFormat);
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new print();

    }
}

