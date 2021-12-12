package luassistant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements MouseListener{
    Container container;
    Border border1, border2;
    Font font1, font2;
    JLabel label1, label2;
    ImageIcon img;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    JButton button1, button2, button3, button4;
    HomePage(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setTitle("LU Assistant");
        setLayout(null);
        setResizable(false);

        // Getting the reference of the JFrame Class
        container = this.getContentPane();
        container.setBackground(Color.WHITE);

        // Creating border for Text area
        border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        border2 = BorderFactory.createLineBorder(Color.BLACK, 1);

        img = new ImageIcon("images\\leading.png");

        label1 = new JLabel(img);
        label1.setBounds(350, 30, 300, 200);

        font1 = new Font("Arial", Font.BOLD, 30);

        label2 = new JLabel("Log In");
        label2.setForeground(Color.black);
        label2.setFont(font1);
        label2.setBounds(450, 200, 100, 60);

        textField1 = new JTextField("Enter your username");
        textField1.setBounds(350, 280, 300, 40);

        textField2 = new JTextField("Enter your password");
        textField2.setBounds(350, 340, 300, 40);

        textField3 = new JTextField("Enter your ID");
        textField3.setBounds(350, 400, 300, 40);

        font2 = new Font("Arial", Font.BOLD, 15);

        button1 = new JButton("Log In");
        button1.setFont(font2);
        button1.setBounds(400, 460, 200, 50);

        button2 = new JButton("Create New Account");
        button2.setFont(font2);
        button2.setBounds(400, 520, 200, 50);

        button3 = new JButton("Log In As Admin");
        button3.setFont(font2);
        button3.setBounds(400, 580, 200, 50);

        add(label1);
        add(label2);
        add(textField1);
        add(textField2);
        add(textField3);
        add(button1);
        add(button2);
        add(button3);

        textField1.addMouseListener(this);
        textField2.addMouseListener(this);
        textField3.addMouseListener(this);
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == textField1){
            textField1.setText("");
            textField1.setBorder(border1);
        }
        else if(e.getSource() == textField2){
            textField2.setText("");
            textField2.setBorder(border1);
        }
        else if(e.getSource() == textField3){
            textField3.setText("");
            textField3.setBorder(border1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == button1){
            setVisible(false);
            String userName = textField1.getText();
            String password = textField2.getText();
            System.out.println(userName + "  " + password);
            new MainPage();
        }
        else if(e.getSource() == button2){
            new Register();
        }
        else if(e.getSource() == button3){
            setVisible(false);
            new AdminLogin();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == textField1){
            textField1.setBorder(border2);
        }
        else if(e.getSource() == textField2){
            textField2.setBorder(border2);
        }
        else if(e.getSource() == textField3){
            textField3.setBorder(border2);
        }
    }
}
