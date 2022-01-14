package luassistant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class AdminLogin extends JFrame implements MouseListener {
    Container container;
    Border border1, border2;
    Font font1, font2;
    JLabel label1, label2;
    ImageIcon img;
    JTextField textField1, textField2;
    JButton button1;
    String userName, password;
    ResultSet resultSet;
    static int isAdminLoggedIn = 0;
    AdminLogin(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setTitle("LU Assistant");
        setLayout(null);
        setResizable(false);

        container = this.getContentPane();
        container.setBackground(Color.lightGray);

        border1 = BorderFactory.createLineBorder(Color.BLACK, 2);

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

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //setVisible(false);
                //new MainPage(connection, statement);
                if(isAdminLoggedIn == 1){
                    new HomePage(connection, statement);
                }

                else{
                    userName = textField1.getText();
                    password = textField2.getText();

                    String query = "select * from admin_info";

                    try{
                        resultSet = statement.executeQuery(query);

                        boolean matched = false;
                        while(resultSet.next()){
                            String user_name = resultSet.getString("username");
                            String pass = resultSet.getString("password");
                            if(Objects.equals(user_name, userName) && Objects.equals(pass, password)){
                                matched = true;
                                break;
                            }
                        }

                        if(matched){
                            isAdminLoggedIn = 1;
                            setVisible(false);
                            new AdminPage(connection, statement);
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
            }
        });
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
