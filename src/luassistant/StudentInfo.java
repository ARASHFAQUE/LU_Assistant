package luassistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class StudentInfo extends JFrame {

    int s_id;
    String s_name;
    String section;
    double cgpa;
    String program;
    String department;
    String payment;
    String vaccine;
    ResultSet resultSet;
    JLabel[] labels;
    Font font;

    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    StudentInfo(Connection connection, Statement statement, int Sid){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setTitle("LU Assistant");
        setLayout(null);
        setResizable(false);

        labels = new JLabel[10];

        font = new Font("Arial", Font.BOLD, 18);

        menuBar = new JMenuBar();

        // Placing The Menus of the Menu Bar
        menu1 = new JMenu("Back");
        menu2 = new JMenu("Log Out");
        menu3 = new JMenu("Exit");

        String query = "select * from student_info";

        try{
            resultSet = statement.executeQuery(query);

            boolean matched = false;

            while(resultSet.next()){
                s_id = resultSet.getInt("sid");
                s_name = resultSet.getString("name");
                section = resultSet.getString("section");
                cgpa = resultSet.getDouble("cgpa");
                program = resultSet.getString("program");
                department = resultSet.getString("department");
                payment = resultSet.getString("payment");
                vaccine = resultSet.getString("vaccine");

                if(Sid == s_id){
                    matched = true;
                    break;
                }
            }

            if(matched){
                labels[0] = new JLabel("Student ID: " + s_id);
                labels[0].setBounds(150, 170, 600, 60);
                labels[0].setFont(font);

                labels[1] = new JLabel("Name: " + s_name);
                labels[1].setBounds(150, 210, 600, 60);
                labels[1].setFont(font);

                labels[2] = new JLabel("CGPA: " + cgpa);
                labels[2].setBounds(150, 250, 600, 60);
                labels[2].setFont(font);

                labels[3] = new JLabel("Program: " + program);
                labels[3].setBounds(150, 290, 600, 60);
                labels[3].setFont(font);

                labels[4] = new JLabel("Department: " + department);
                labels[4].setBounds(150, 330, 600, 60);
                labels[4].setFont(font);

                labels[5] = new JLabel("Is Payment Completed?: " + payment);
                labels[5].setBounds(150, 370, 600, 60);
                labels[5].setFont(font);

                labels[6] = new JLabel("Vaccinated?: " + vaccine);
                labels[6].setBounds(150, 410, 600, 60);
                labels[6].setFont(font);

                add(labels[0]);
                add(labels[1]);
                add(labels[2]);
                add(labels[3]);
                add(labels[4]);
                add(labels[5]);
                add(labels[6]);
            }
            else{
                JOptionPane.showMessageDialog(null, "Your Information is not added yet.", "" ,JOptionPane.WARNING_MESSAGE);
            }

            //statement.close();
            //connection.close();
        } catch (Exception exc){
            //exc.getStackTrace();
        }

        menu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new MainPage(connection, statement, Sid);
            }
        });

        menu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new LogInPage(connection, statement);
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
    }
}

class OtherInformation extends JFrame{
    int s_id;
    String s_name;
    String section;
    double cgpa;
    String program;
    String department;
    ResultSet resultSet;
    JLabel[] labels;
    Font font;

    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    String studentID;
    int sID;
    OtherInformation(Connection connection, Statement statement, int Sid){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setTitle("LU Assistant");
        setLayout(null);
        setResizable(false);

        labels = new JLabel[10];

        studentID = JOptionPane.showInputDialog(null, "Please Enter the Student ID");

        sID = Integer.parseInt(studentID);

        font = new Font("Arial", Font.BOLD, 18);

        menuBar = new JMenuBar();

        // Placing The Menus of the Menu Bar
        menu1 = new JMenu("Back");
        menu2 = new JMenu("Log Out");
        menu3 = new JMenu("Exit");

        String query = "select * from student_info";

        try{
            resultSet = statement.executeQuery(query);

            boolean matched = false;

            while(resultSet.next()){
                s_id = resultSet.getInt("sid");
                s_name = resultSet.getString("name");
                section = resultSet.getString("section");
                cgpa = resultSet.getDouble("cgpa");
                program = resultSet.getString("program");
                department = resultSet.getString("department");

                if(sID == s_id){
                    matched = true;
                    break;
                }
            }

            if(matched){
                labels[0] = new JLabel("Student ID: " + sID);
                labels[0].setBounds(150, 170, 600, 60);
                labels[0].setFont(font);

                labels[1] = new JLabel("Name: " + s_name);
                labels[1].setBounds(150, 210, 600, 60);
                labels[1].setFont(font);

                labels[2] = new JLabel("CGPA: " + cgpa);
                labels[2].setBounds(150, 250, 600, 60);
                labels[2].setFont(font);

                labels[3] = new JLabel("Program: " + program);
                labels[3].setBounds(150, 290, 600, 60);
                labels[3].setFont(font);

                labels[4] = new JLabel("Department: " + department);
                labels[4].setBounds(150, 330, 600, 60);
                labels[4].setFont(font);

                add(labels[0]);
                add(labels[1]);
                add(labels[2]);
                add(labels[3]);
                add(labels[4]);
            }
            else{
                JOptionPane.showMessageDialog(null, "Student Information is not added yet.", "" ,JOptionPane.WARNING_MESSAGE);
            }

            //statement.close();
            //connection.close();
        } catch (Exception exc){
            //exc.getStackTrace();
        }

        menu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new MainPage(connection, statement, Sid);
            }
        });

        menu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new LogInPage(connection, statement);
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
    }
}