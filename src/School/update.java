package School;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class update extends JFrame implements ActionListener {
    private JLabel dataLabel,conte;
    JTextField name,contact,email,city,date,gender,ide;
    JRadioButton male,female,other;
    Font f=new Font("Tahoma",Font.PLAIN,20);
    JPasswordField password;
    ButtonGroup btn = new ButtonGroup();
    JButton upd;
    public update(String conte,String namee,String gen,String eml,String pasword,String cit,String dat,String idno)
    {
        setSize(800,800);
        JLabel l1=new JLabel("Update The Information....");
        l1.setBounds(250,20,400,50);
        l1.setFont(f);
        add(l1);
        
        JLabel l2=new JLabel("Name : ");
        l2.setBounds(200,100,150,40);
        l2.setFont(f);
        add(l2);
        
        JLabel l3=new JLabel("Gender : ");
        l3.setBounds(200,160,150,40);
        l3.setFont(f);
        add(l3);
        
        JLabel l4=new JLabel("Date Of Birth : ");
        l4.setBounds(200,220,150,40);
        l4.setFont(f);
        add(l4);
        
        JLabel l5=new JLabel("Contact No. : ");
        l5.setBounds(200,280,150,40);
        l5.setFont(f);
        add(l5);
        
        JLabel l6=new JLabel("Email : ");
        l6.setBounds(200,340,150,40);
        l6.setFont(f);
        add(l6);
        
        JLabel l7=new JLabel("City : ");
        l7.setBounds(200,400,150,40);
        l7.setFont(f);
        add(l7);
        
        JLabel l8=new JLabel("Password : ");
        l8.setBounds(200,460,150,40);
        l8.setFont(f);
        add(l8);
        
        name= new JTextField(namee);
        name.setBounds(400,100,200,40);
        name.setFont(f);
        add(name);
        ide=new JTextField(idno);
        ide.setBounds(600,600,100,50);
        ide.setFont(f);
        ide.setVisible(false);

        gender = new JTextField(gen);
        gender.setBounds(400,160,200,40);
        gender.setFont(f);
        add(gender);

        date=new JTextField(dat);
        date.setBounds(400,220,200,40);
        date.setFont(f);
        add(date);

        contact= new JTextField(conte);
        contact.setBounds(400,280,200,40);
        contact.setFont(f);
        add(contact);

        email= new JTextField(eml);
        email.setBounds(400,340,200,40);
        email.setFont(f);
        add(email);
        city= new JTextField(cit);
        city.setBounds(400,400,200,40);
        city.setFont(f);
        add(city);
        password = new JPasswordField(pasword);
        password.setBounds(400,460,200,40);
        password.setFont(f);
        add(password);

        upd =new JButton("SAVE");
        upd.setBounds(320,600,100,50);
        upd.addActionListener(this);
        upd.setFont(f);
        add(upd);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==upd)
        {
            conn c= new conn();
            String nam =this.name.getText();
            String contact = this.contact.getText();
            String email = this.email.getText();
            String city = this.city.getText();
            String date = this.date.getText();
            String gender=this.gender.getText();
            String password=String.valueOf(this.password.getPassword());
            String idno=this.ide.getText();
            try {
                String query = "select idno,contact from signing_in where idno='"+idno+"';";
                //System.out.println(name);
                ResultSet rs = c.s.executeQuery(query);
                rs.next();
                System.out.println(rs);
                String id = rs.getString("idno");
                String pho = rs.getString("contact");
                System.out.println(id);
                String query2 = "UPDATE signing_in SET `idno` = '" + id + "', `name` = '" + nam + "', `contact` = '" + contact + "', `email` = '" + email + "', `gender` = '" + gender + "', `password` = '" + password + "', `date` = '" + date + "',`city` = '" + city + "' WHERE (`idno` = '" + id + "') and (`contact` = '" + pho + "');";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Updated successfully");
                this.setVisible(false);
            }
            catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"error occurred please try again");

            }
            new FirstFrame();




        }


    }

    public static void main(String[] args) {

    }

}
