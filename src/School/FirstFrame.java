package School;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame {
    private JButton sendDataButton;
    private JTextField dataField;
    JLabel cont;
    JButton lb7;

    public FirstFrame() {
        // Initialize and set up the first JFrame
        setTitle("First Frame");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);



        cont=new JLabel("Enter your Contact Number :");
        cont.setBounds(30,100,300,50);
        cont.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));

        sendDataButton = new JButton("VIEW");
        sendDataButton.setBounds(300,200,100,40);
        sendDataButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));

        dataField = new JTextField(20);
        dataField.setBounds(330,100,220,50);
        dataField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));

        sendDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the data from the text field
                String data = dataField.getText();

                // Create an instance of the second frame and pass the data
                SecondFrame secondFrame = new SecondFrame(data);
                secondFrame.setVisible(true);
            }
        });
        add(cont);
        add(dataField);
        add(sendDataButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("stad/gree.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(700,400,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,700,400);
        add(lb1);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("stad/back.png"));
        Image editedimg7 = i7.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        i7 = new ImageIcon(editedimg7);

        lb7 = new JButton(i7);
        lb7.setBounds(0,0,50,50);
        lb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new web();
            }
        });
        add(lb7);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
        {
            FirstFrame firstFrame = new FirstFrame();
            firstFrame.setVisible(true);
        });
    }
}

