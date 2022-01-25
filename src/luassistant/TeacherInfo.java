package luassistant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class TeacherInfo extends JFrame{
    String dept;
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    ResultSet resultSet;
    Font font;

    String[] columns = {"Name", "Position", "Department", "Department", "Cell"};
    String[] rows = new String[5];

    TeacherInfo(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setLayout(null);
        setResizable(false);
        setTitle("LU Assistant");
        font = new Font("Arial", Font.BOLD, 16);

        dept = JOptionPane.showInputDialog(null, "Please enter the department name: ");

        table = new JTable();

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);

        table.setModel(tableModel);

        table.setSelectionBackground(Color.lightGray);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);


        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 900, 600);
        add(scrollPane);

        String query = "select * from teacher_info";
        try{

            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                String department = resultSet.getString("department");
                String email = resultSet.getString("email");
                String cell = resultSet.getString("cell");

                if(department.equalsIgnoreCase(dept)){
                    rows[0] = name;
                    rows[1] = position;
                    rows[2] = department;
                    rows[3] = email;
                    rows[4] = cell;

                    tableModel.addRow(rows);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
