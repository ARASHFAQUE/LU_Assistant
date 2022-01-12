package luassistant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame {
    Container container;
    JLabel label;
    Font font1, font2;
    JTextField textField1, textField2, textField3, textField4;
    Border border;
    JButton button, button2;
    String studentName, studentID, userName, password;
    int result;
    JMenuBar menuBar;
    JMenu menu;
    Register(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setTitle("LU Assistant");
        setLayout(null);
        setResizable(false);


        container = new Container();
        container.setBackground(Color.WHITE);

        font1 = new Font("Arial", Font.BOLD, 35);
        font2 = new Font("Arial", Font.BOLD, 15);
        border = BorderFactory.createLineBorder(Color.BLACK, 2);

        label = new JLabel();
        label.setText("Sign Up Here");
        label.setFont(font1);
        label.setBounds(170, 150, 270, 60);
        label.setForeground(Color.BLACK);
        label.setBackground(Color.WHITE);

        textField1 = new JTextField("Enter Your Name");
        textField1.setBounds(170, 230, 300, 40);

        textField2 = new JTextField("Enter Your Student ID");
        textField2.setBounds(520, 230, 300, 40);

        textField3 = new JTextField("Enter Your Username");
        textField3.setBounds(170, 310, 300, 40);

        textField4 = new JTextField("Enter Your Password");
        textField4.setBounds(520, 310, 300, 40);

        button = new JButton("Sign Up");
        button.setBounds(170, 390, 200, 50);
        button.setFont(font2);

        button2 = new JButton("Log In Now");
        button2.setBounds(170, 460, 200, 50);
        button2.setVisible(false);
        button2.setFont(font2);

        menuBar = new JMenuBar();

        menu = new JMenu("Back");

        menuBar.add(menu);

        setJMenuBar(menuBar);

        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1.setText("");
                textField1.setBorder(border);
            }
        });

        textField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField2.setText("");
                textField2.setBorder(border);
            }
        });

        textField3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField3.setText("");
                textField3.setBorder(border);
            }
        });

        textField4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField4.setText("");
                textField4.setBorder(border);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                studentName = textField1.getText();
                studentID = textField2.getText();
                userName = textField3.getText();
                password = textField4.getText();

                String query = "insert into users_info (s_name, s_id, username, password) values('"+studentName+"', '"+studentID+"', '"+userName+"', '"+password+"')";

                try{
                    result = statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Your account has been created successfully!", "" ,JOptionPane.PLAIN_MESSAGE);
                    button2.setVisible(true);

                    //statement.close();
                    //connection.close();

                } catch (Exception exc){
                    //exc.getStackTrace();
                }

            }
        });

        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new HomePage(connection, statement);
            }
        });

        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new HomePage(connection, statement);
            }
        });

        add(label);
        add(textField1);
        add(textField2);
        add(textField3);
        add(textField4);
        add(button);
        add(button2);
    }
}
