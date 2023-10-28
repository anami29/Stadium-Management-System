package School;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class SecondFrame extends JFrame implements ActionListener{
    private JLabel dataLabel;
    private JLabel conte;
    String name,email,gender,password,date,city,idno;
    JButton lag,lb7,back;
    public SecondFrame(String data) {
        // Initialize and set up the second JFrame
        setTitle("Second Frame");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        dataLabel = new JLabel("Received Data: " + data);
        dataLabel.setBounds(100,10,300,50);
        dataLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
        dataLabel.setVisible(false);

        lag = new JButton("UPDATE");
        lag.setBounds(250,600,150,50);
        lag.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));

        add(lag);




        add(dataLabel);
        conn c=new conn();
        try{

            String query ="select idno,name,email,gender,password,date,city from signing_in where contact='"+data+"';";
            ResultSet rs=c.s.executeQuery(query);
            StringBuilder csvData =new StringBuilder();
            while(rs.next())
            {
                idno =rs.getString("idno");
                name = rs.getString("name");
                email =rs.getString("email");
                gender =rs.getString("gender");
                password =rs.getString("password");
                date =rs.getString("date");
                city=rs.getString("city");
                System.out.println(idno);
               // csvData.append(name);
               // csvData.append(email);
                //csvData.append(gender);
                //csvData.append(password);
               // csvData.append(date);
                JLabel l=new JLabel("USER DETAILS.....");
                l.setBounds(200,100,300,50);
                l.setFont(new Font("Tahoma", Font.BOLD, 20));
                l.setBackground(Color.BLUE);
                add(l);

                JLabel l1= new JLabel("NAME :      ");
                l1.setBounds(200,200,300,50);
                l1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(l1);
                JLabel la1= new JLabel(name);//data
                la1.setBounds(300,200,250,50);
                la1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(la1);

                JLabel l2= new JLabel("GENDER :      ");
                l2.setBounds(200,250,300,50);
                l2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(l2);
                JLabel la2=new JLabel(gender);//data
                la2.setBounds(300,250,200,50);
                la2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(la2);

                JLabel l3= new JLabel("EMAIL ID :      ");
                l3.setBounds(200,300,300,50);
                l3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(l3);
                JLabel la3=new JLabel(email);//data
                la3.setBounds(300,300,200,50);
                la3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(la3);

                JLabel l4= new JLabel("PHONE :      ");
                l4.setBounds(200,350,250,50);
                l4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(l4);
                JLabel l6=new JLabel(data);//data
                l6.setBounds(300,350,200,50);
                l6.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(l6);

                JLabel l5= new JLabel("PASSWORD :      ");
                l5.setBounds(200,500,300,50);
                l5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(l5);
                JLabel la5=new JLabel(password);//data
                la5.setBounds(350,500,200,50);
                la5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(la5);

                JLabel l7= new JLabel("CITY :      ");
                l7.setBounds(200,450,300,50);
                l7.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(l7);
                JLabel la7=new JLabel(city);//data
                la7.setBounds(300,450,200,50);
                la7.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(la7);

                JLabel l8= new JLabel("BIRTHDATE :      ");
                l8.setBounds(200,400,300,50);
                l8.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(l8);
                JLabel la8=new JLabel(date);//data
                la8.setBounds(350,400,200,50);
                la8.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                add(la8);
                JLabel la9=new JLabel(idno);
                la9.setBounds(600,600,50,60);
                la9.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
                la9.setVisible(false);

                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/aes.jpg"));
                Image editedimg1 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
                i1 = new ImageIcon(editedimg1);
                JLabel lb1 = new JLabel(i1);
                lb1.setBounds(0,0,700,700);
                add(lb1);

                ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("stad/back.png"));
                Image editedimg7 = i7.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
                i7 = new ImageIcon(editedimg7);

                lb7 = new JButton(i7);
                lb7.setBounds(0,0,50,50);
                lb7.addActionListener(this);
                add(lb7);

                lag.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String conte = l6.getText();
                        String namee= la1.getText();
                        String gen = la2.getText();
                        String email= la3.getText();
                        String password = la5.getText();
                        String city = la7.getText();
                        String date =la8.getText();
                        String idno=la9.getText();
                        // Create an instance of the second frame and pass the data
                        update upd = new update(conte,namee,gen,email,password,city,date,idno);
                        upd.setVisible(true);
                        System.out.println(conte);
                    }
                });
            }
            rs.close();
            System.out.println(csvData.toString());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        this.setVisible(false);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==lb7)
        {
            new FirstFrame();
            setVisible(false);
        }
    }
}
