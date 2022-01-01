package luassistant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class HomePage extends JFrame{

    Container container;
    Border border1, border2;
    Font font1, font2;
    JLabel label1, label2;
    ImageIcon img;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    JButton button1, button2, button3, button4;
    String userName, password, studentID;
    ResultSet resultSet;
    HomePage(Connection connection, Statement statement){
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

        textField1 = new JTextField("Enter Your Username");
        textField1.setBounds(350, 280, 300, 40);

        textField2 = new JTextField("Enter Your Password");
        textField2.setBounds(350, 340, 300, 40);

        textField3 = new JTextField("Enter Your Student ID");
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

        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1.setText("");
                textField1.setBorder(border1);
            }
        });

        textField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField2.setText("");
                textField2.setBorder(border1);
            }
        });

        textField3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField3.setText("");
                textField3.setBorder(border1);
            }
        });

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                userName = textField1.getText();
                password = textField2.getText();
                studentID = textField3.getText();

                String query = "select * from users_info";

                try{
                    resultSet = statement.executeQuery(query);

                    boolean matched = false;
                    while(resultSet.next()){
                        String user_name = resultSet.getString("username");
                        String pass = resultSet.getString("password");
                        String sID = resultSet.getString("s_id");
                        if(Objects.equals(sID, studentID) && Objects.equals(user_name, userName) && Objects.equals(pass, password)){
                            matched = true;
                            break;
                        }
                    }

                    if(matched){
                        setVisible(false);
                        new MainPage(connection, statement);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Information!", "" ,JOptionPane.WARNING_MESSAGE);
                    }

                    //statement.close();
                    //connection.close();
                } catch (Exception exc){
                    //exc.getStackTrace();
                }
            }
        });


        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                setVisible(false);
                new Register(connection, statement);
            }
        });

        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                setVisible(false);
                new AdminLogin(connection, statement);
            }
        });

        add(label1);
        add(label2);
        add(textField1);
        add(textField2);
        add(textField3);
        add(button1);
        add(button2);
        add(button3);
    }
}
