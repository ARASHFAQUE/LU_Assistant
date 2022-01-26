package luassistant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddTeacherInfo extends JFrame{

    JTextField[] textFields;
    JButton button;

    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    Border border;
    AddTeacherInfo(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setLayout(null);
        setResizable(false);
        setTitle("LU Assistant");

        menuBar = new JMenuBar();

        // Placing The Menus of the Menu Bar
        menu1 = new JMenu("Back");
        menu2 = new JMenu("Log Out");
        menu3 = new JMenu("Exit");

        border = BorderFactory.createLineBorder(Color.BLACK, 2);

        textFields = new JTextField[10];

        textFields[0] = new JTextField("Enter the teacher's name");
        textFields[0].setBounds(300, 150, 400, 40);

        textFields[1] = new JTextField("Enter the teacher's email");
        textFields[1].setBounds(300, 200, 400, 40);

        textFields[2] = new JTextField("Enter the teacher's position");
        textFields[2].setBounds(300, 250, 400, 40);

        textFields[3] = new JTextField("Enter the teacher's department");
        textFields[3].setBounds(300, 300, 400, 40);

        textFields[4] = new JTextField("Enter the teacher's phone number");
        textFields[4].setBounds(300, 350, 400, 40);


        button = new JButton("Add");
        button.setBounds(450, 410, 100, 50);

        add(textFields[0]);
        add(textFields[1]);
        add(textFields[2]);
        add(textFields[3]);
        add(textFields[4]);

        add(button);

        menu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new AdminPage(connection, statement);
            }
        });

        menu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new AdminLogin(connection, statement);
            }
        });

        menu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    setVisible(false);
                    connection.close();
                    statement.close();
                    System.exit(0);
                } catch (SQLException ex) {
                    //ex.printStackTrace();
                }
            }
        });

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        setJMenuBar(menuBar);

        textFields[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[0].setText("");
                textFields[0].setBorder(border);
            }
        });

        textFields[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[1].setText("");
                textFields[1].setBorder(border);
            }
        });

        textFields[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[2].setText("");
                textFields[2].setBorder(border);
            }
        });

        textFields[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[3].setText("");
                textFields[3].setBorder(border);
            }
        });

        textFields[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[4].setText("");
                textFields[4].setBorder(border);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String name = textFields[0].getText();
                String email = textFields[1].getText();
                String position = textFields[2].getText();
                String department = textFields[3].getText();
                String cell = textFields[4].getText();
                String query = "insert into teacher_info (name, email, position, department, cell) values('"+name+"', '"+email+"', '"+position+"', '"+department+"', '"+cell+"')";

                try{
                    statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Information has been added successfully!", "" ,JOptionPane.PLAIN_MESSAGE);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

    }
}
