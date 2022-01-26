package luassistant;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class DeleteTeacherInfo extends JFrame {

    String t_name;
    boolean found = false;
    ResultSet resultSet;
    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;

    DeleteTeacherInfo(Connection connection, Statement statement) {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setLayout(null);
        setResizable(false);
        setTitle("LU Assistant");

        t_name = JOptionPane.showInputDialog(null, "Enter the teacher name");

        String query = "select * from teacher_info";

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                if (Objects.equals(name, t_name)) {
                    found = true;
                    break;
                }
            }
        } catch (Exception e) {
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

        if (found) {

            String query2 = "delete from teacher_info where name = '" + t_name + "'";
            try {
                statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Information Deleted Successfully", "", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Teacher Info Not Found", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}