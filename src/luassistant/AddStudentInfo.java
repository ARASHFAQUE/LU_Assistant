package luassistant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.sql.Statement;

public class AddStudentInfo extends JFrame {
    JTextField[] textFields;
    JButton button;

    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    Border border;
    AddStudentInfo(Connection connection, Statement statement){
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

        textFields[0] = new JTextField("Enter the student's ID");
        textFields[0].setBounds(300, 50, 400, 40);

        textFields[1] = new JTextField("Enter the student's name");
        textFields[1].setBounds(300, 100, 400, 40);

        textFields[2] = new JTextField("Enter the section");
        textFields[2].setBounds(300, 150, 400, 40);

        textFields[3] = new JTextField("Enter the student's CGPA");
        textFields[3].setBounds(300, 200, 400, 40);

        textFields[4] = new JTextField("Enter the program");
        textFields[4].setBounds(300, 250, 400, 40);

        textFields[5] = new JTextField("Enter the department");
        textFields[5].setBounds(300, 300, 400, 40);

        textFields[6] = new JTextField("Payment status");
        textFields[6].setBounds(300, 350, 400, 40);

        textFields[7] = new JTextField("Vaccine status");
        textFields[7].setBounds(300, 400, 400, 40);

        button = new JButton("Add");
        button.setBounds(450, 460, 100, 50);

        add(textFields[0]);
        add(textFields[1]);
        add(textFields[2]);
        add(textFields[3]);
        add(textFields[4]);
        add(textFields[5]);
        add(textFields[6]);
        add(textFields[7]);

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

        textFields[5].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[5].setText("");
                textFields[5].setBorder(border);
            }
        });

        textFields[6].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[6].setText("");
                textFields[6].setBorder(border);
            }
        });

        textFields[7].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[7].setText("");
                textFields[7].setBorder(border);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String s_id = textFields[0].getText();
                String s_name = textFields[1].getText();
                String section = textFields[2].getText();
                String cgpa = textFields[3].getText();
                String program = textFields[4].getText();
                String department = textFields[5].getText();
                String payment = textFields[6].getText();
                String vaccine = textFields[7].getText();
                String query = "insert into student_info (sid, name, section, cgpa, program, department, payment, vaccine) values('"+s_id+"', '"+s_name+"', '"+section+"', '"+cgpa+"', '"+program+"', '"+department+"', '"+payment+"', '"+vaccine+"')";

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
