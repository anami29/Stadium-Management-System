package School;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static java.awt.Transparency.TRANSLUCENT;

public class sign extends JFrame implements ActionListener {
    int x=400;
    int y=140;
    int w=300;
    int h=40;
    JLabel a,b,c,d,e,f,g,l,i;
    JTextField name,phone,email,city;
    JPasswordField password;
    JRadioButton male,female,other;
    JDateChooser date;
    JButton submit,cancel,back;
    Font font =new Font("Roboto",Font.BOLD,18);
    sign()
    {

        setSize(800,800);
        e=new JLabel("WELCOME !!!!");
        e.setBounds(300,30,w+300,h);
        e.setFont(new Font("Tahoma",Font.ITALIC,24));
        add(e);

        f=new JLabel("Please enter ur details to sign in");
        f.setBounds(250,70,w+50,h);
        f.setFont(new Font("Times of Roman",Font.BOLD,16));
        add(f);

        a=new JLabel("NAME");
        a.setBounds(x-250,y,w,h);
        a.setFont(font);
        add(a);

        b=new JLabel("CONTACT NO.");
        b.setBounds(x-250,y+70,w,h);
        b.setFont(font);
        add(b);

        c=new JLabel("EMAIL Id");
        c.setBounds(x-250,y+140,w,h);
        c.setFont(font);
        add(c);

        d=new JLabel("PASSWORD");
        d.setBounds(x-250,y+420,w,h);
        d.setFont(font);
        add(d);

        i=new JLabel("CITY");
        i.setBounds(x-250,y+350,w,h);
        i.setFont(font);
        add(i);

        g=new JLabel("GENDER");
        g.setBounds(x-250,y+280,w,h);
        g.setFont(font);
        add(g);

        l=new JLabel("BIRTH-DATE");
        l.setBounds(x-250,y+210,w,h);
        l.setFont(font);
        add(l);

        city=new JTextField();
        city.setBounds(x,y+350,w,h);
        add(city);


        name =new JTextField();
        name.setBounds(x,y,w,h);
        add(name);

        phone =new JTextField();
        phone.setBounds(x,y+70,w,h);
        add(phone);

        email=new JTextField();
        email.setBounds(x,y+140,w,h);
        add(email);

        password =new JPasswordField();
        password.setBounds(x,y+420,w,h);
        add(password);
        ButtonGroup btn=new ButtonGroup();

        male =new JRadioButton("MALE");
        male.setBounds(x,y+280,w-220,h);
        male.setFont(new Font("Times of Roman",Font.BOLD,14));
        btn.add(male);
        add(male);

        female =new JRadioButton("FEMALE");
        female.setBounds(x+100,y+280,w-200,h);
        female.setFont(new Font("Times of Roman",Font.BOLD,14));
        btn.add(female);
        add(female);

        other =new JRadioButton("OTHERS");
        other.setBounds(x+220,y+280,w-200,h);
        other.setFont(new Font("Times of Roman",Font.BOLD,14));
        btn.add(other);
        add(other);

        date=new JDateChooser();
        date.setBounds(x,y+210,w,h);
        add(date);

        submit = new JButton("SIGN IN");
        submit.setBounds(x+100,y+550,w-150,h);
        submit.setFont(font);
        submit.addActionListener(this);
        add(submit);

        cancel =new JButton("CANCEL");
        cancel.setBounds(x-240,y+550,w-150,h);
        cancel.setFont(font);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/cross.png"));
        Image editedimg1 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,800,800);
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
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String name=this.name.getText();
            String phone=this.phone.getText();
            String email=this.email.getText();
            String city=this.city.getText();

            SimpleDateFormat dt =new SimpleDateFormat("dd-MM-yyyy");
            String date= dt.format(this.date.getDate());

            String gender=null;
            if(male.isSelected())
            {
                gender="Male";
            }
            else if(female.isSelected())
            {
                gender="Female";
            }
            else if(other.isSelected())
            {
                gender="Others";
            }
            String password= String.valueOf(this.password.getPassword());
            conn c=new conn();
            String query="insert into signing_in(name,contact,email,date,gender,password,city)values('"+name+"','"+phone+"','"+email+"','"+date+"','"+gender+"','"+password+"','"+city+"')";
            try{
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Signing successfully\nWELCOME!!!");
                new event();
                setVisible(false);
            }
            catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Sign in Unsuccessfull\nTry Again");
            }
        }
        if(ae.getSource()==cancel||ae.getSource()==back)
        {
            new check();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new sign();
    }
}
