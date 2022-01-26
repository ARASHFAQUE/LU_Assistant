package luassistant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Objects;

public class UpdateTeacherInfo extends JFrame{
    JTextField[] textFields;
    JButton[] buttons;
    JLabel label;

    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    Border border;
    Font font;
    ResultSet resultSet;
    boolean found = false;
    JButton button;
    String t_name;

    UpdateTeacherInfo(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setLayout(null);
        setResizable(false);
        setTitle("LU Assistant");

        t_name = JOptionPane.showInputDialog(null, "Enter the teacher name");

        menuBar = new JMenuBar();

        // Placing The Menus of the Menu Bar
        menu1 = new JMenu("Back");
        menu2 = new JMenu("Log Out");
        menu3 = new JMenu("Exit");

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        setJMenuBar(menuBar);

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

        String query = "select * from teacher_info";
        try{
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String name = resultSet.getString("name");
                if(Objects.equals(name, t_name)){
                    found = true;
                    break;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        if(found){
            border = BorderFactory.createLineBorder(Color.BLACK, 2);

            textFields = new JTextField[10];
            buttons = new JButton[10];

            label = new JLabel("Update any information you want");
            label.setBounds(250, 100, 300, 50);
            label.setFont(font);

            textFields[0] = new JTextField("Enter the teacher's name");
            textFields[0].setBounds(200, 150, 400, 40);

            buttons[0] = new JButton("Update");
            buttons[0].setBounds(620, 150, 100, 40);


            textFields[1] = new JTextField("Enter the teacher's email");
            textFields[1].setBounds(200, 200, 400, 40);

            buttons[1] = new JButton("Update");
            buttons[1].setBounds(620, 200, 100, 40);

            textFields[2] = new JTextField("Enter the teacher's position");
            textFields[2].setBounds(200, 250, 400, 40);

            buttons[2] = new JButton("Update");
            buttons[2].setBounds(620, 250, 100, 40);

            textFields[3] = new JTextField("Enter the teacher's department");
            textFields[3].setBounds(200, 300, 400, 40);

            buttons[3] = new JButton("Update");
            buttons[3].setBounds(620, 300, 100, 40);

            textFields[4] = new JTextField("Enter the teacher's phone number");
            textFields[4].setBounds(200, 350, 400, 40);

            buttons[4] = new JButton("Update");
            buttons[4].setBounds(620, 350, 100, 40);

            add(textFields[0]);
            add(textFields[1]);
            add(textFields[2]);
            add(textFields[3]);
            add(textFields[4]);

            add(buttons[0]);
            add(buttons[1]);
            add(buttons[2]);
            add(buttons[3]);
            add(buttons[4]);


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

            buttons[0].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String teacherName = textFields[0].getText();
                    String query = "update teacher_info set name = '"+teacherName+"' where name = '"+t_name+"'";
                    try {
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Information has been updated successfully.");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });

            buttons[1].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String email = textFields[1].getText();
                    String query = "update teacher_info set email = '"+email+"' where name = '"+t_name+"'";
                    try {
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Information has been updated successfully.");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });

            buttons[2].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String position = textFields[2].getText();
                    String query = "update teacher_info set position = '"+position+"' where name = '"+t_name+"'";
                    try {
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Information has been updated successfully.");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });

            buttons[3].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String department = textFields[3].getText();
                    String query = "update teacher_info set department = '"+department+"' where name = '"+t_name+"'";
                    try {
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Information has been updated successfully.");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });

            buttons[4].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String cell = textFields[4].getText();
                    String query = "update teacher_info set cell = '"+cell+"' where name = '"+t_name+"'";
                    try {
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Information has been updated successfully.");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });
        }
        else{
            JOptionPane.showMessageDialog(null, "Teacher info Not found", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
