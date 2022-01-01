package luassistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Statement;

public class AdminLogin extends JFrame implements MouseListener {
    Container container;
    Font font1, font2;
    JLabel label1, label2;
    ImageIcon img;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    JButton button1, button2, button3, button4;
    AdminLogin(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setTitle("LU Assistant");
        setLayout(null);
        setResizable(false);

        container = this.getContentPane();
        container.setBackground(Color.lightGray);

        img = new ImageIcon("images\\leading.png");

        label1 = new JLabel(img);
        label1.setBounds(350, 30, 300, 200);

        font1 = new Font("Arial", Font.BOLD, 30);

        label2 = new JLabel("Log In");
        label2.setFont(font1);
        label2.setBounds(450, 200, 100, 60);

        textField1 = new JTextField("Enter your username");
        textField1.setBounds(350, 280, 300, 40);

        textField2 = new JTextField("Enter your password");
        textField2.setBounds(350, 340, 300, 40);


        font2 = new Font("Arial", Font.BOLD, 15);

        button1 = new JButton("Log In");
        button1.setFont(font2);
        button1.setBounds(400, 400, 200, 50);

        add(label1);
        add(label2);
        add(textField1);
        add(textField2);
        add(button1);

        textField1.addMouseListener(this);
        textField2.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == textField1){
            textField1.setText("");
        }
        else if(e.getSource() == textField2){
            textField2.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
