package luassistant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;

public class UpdateStudentInfo extends JFrame {
    JTextField[] textFields;
    JButton[] buttons;
    JLabel label;

    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    Border border;
    Font font;
    String stdID;
    int sID;
    ResultSet resultSet;
    boolean found = false;
    UpdateStudentInfo(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setLayout(null);
        setResizable(false);
        setTitle("LU Assistant");

        stdID = JOptionPane.showInputDialog(null, "Enter the student ID");
        sID = Integer.parseInt(stdID);

        String query = "select * from student_info";
        try{
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int s_id = resultSet.getInt("sid");
                if(s_id == sID){
                    found = true;
                    break;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        menuBar = new JMenuBar();

        // Placing The Menus of the Menu Bar
        menu1 = new JMenu("Back");
        menu2 = new JMenu("Log Out");
        menu3 = new JMenu("Exit");

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

        if(found){

            border = BorderFactory.createLineBorder(Color.BLACK, 2);

            font = new Font("Arial", Font.BOLD, 18);

            textFields = new JTextField[10];
            buttons = new JButton[10];

            label = new JLabel("Update any information you want");
            label.setBounds(250, 50, 300, 50);
            label.setFont(font);

            textFields[0] = new JTextField("Enter the student's ID");
            textFields[0].setBounds(200, 100, 400, 40);

            buttons[0] = new JButton("Update");
            buttons[0].setBounds(620, 100, 100, 40);

            textFields[1] = new JTextField("Enter the student's name");
            textFields[1].setBounds(200, 150, 400, 40);

            buttons[1] = new JButton("Update");
            buttons[1].setBounds(620, 150, 100, 40);

            textFields[2] = new JTextField("Enter the section");
            textFields[2].setBounds(200, 200, 400, 40);

            buttons[2] = new JButton("Update");
            buttons[2].setBounds(620, 200, 100, 40);

            textFields[3] = new JTextField("Enter the student's CGPA");
            textFields[3].setBounds(200, 250, 400, 40);

            buttons[3] = new JButton("Update");
            buttons[3].setBounds(620, 250, 100, 40);

            textFields[4] = new JTextField("Enter the program");
            textFields[4].setBounds(200, 300, 400, 40);

            buttons[4] = new JButton("Update");
            buttons[4].setBounds(620, 300, 100, 40);

            textFields[5] = new JTextField("Enter the department");
            textFields[5].setBounds(200, 350, 400, 40);

            buttons[5] = new JButton("Update");
            buttons[5].setBounds(620, 350, 100, 40);

            textFields[6] = new JTextField("Payment status");
            textFields[6].setBounds(200, 400, 400, 40);

            buttons[6] = new JButton("Update");
            buttons[6].setBounds(620, 400, 100, 40);

            textFields[7] = new JTextField("Vaccine status");
            textFields[7].setBounds(200, 450, 400, 40);

            buttons[7] = new JButton("Update");
            buttons[7].setBounds(620, 450, 100, 40);

            //button = new JButton("Add");
            //button.setBounds(450, 460, 100, 50);

            add(textFields[0]);
            add(textFields[1]);
            add(textFields[2]);
            add(textFields[3]);
            add(textFields[4]);
            add(textFields[5]);
            add(textFields[6]);
            add(textFields[7]);

            add(buttons[0]);
            add(buttons[1]);
            add(buttons[2]);
            add(buttons[3]);
            add(buttons[4]);
            add(buttons[5]);
            add(buttons[6]);
            add(buttons[7]);

            add(label);

            //add(button);

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

            buttons[0].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String s_id = textFields[0].getText();
                    int sidNum = Integer.parseInt(s_id);
                    String query = "update student_info set sid = '"+sidNum+"' where sid = '"+sID+"'";
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
                    String s_name = textFields[1].getText();
                    String query = "update student_info set name = '"+s_name+"' where sid = '"+sID+"'";
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
                    String section = textFields[2].getText();
                    String query = "update student_info set section = '"+section+"' where sid = '"+sID+"'";
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
                    String s_cgpa = textFields[3].getText();
                    double cgpa = Double.parseDouble(s_cgpa);
                    String query = "update student_info set cgpa = '"+cgpa+"' where sid = '"+sID+"'";
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
                    String program = textFields[4].getText();
                    String query = "update student_info set program = '"+program+"' where sid = '"+sID+"'";
                    try {
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Information has been updated successfully.");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });

            buttons[5].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String department = textFields[5].getText();
                    String query = "update student_info set department = '"+department+"' where sid = '"+sID+"'";
                    try {
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Information has been updated successfully.");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });

            buttons[6].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String payment = textFields[6].getText();
                    String query = "update student_info set payment = '"+payment+"' where sid = '"+sID+"'";
                    try {
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Information has been updated successfully.");
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });

            buttons[7].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String vaccine = textFields[7].getText();
                    String query = "update student_info set vaccine = '"+vaccine+"' where sid = '"+sID+"'";
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
            JOptionPane.showMessageDialog(null, "ID Not Found", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
