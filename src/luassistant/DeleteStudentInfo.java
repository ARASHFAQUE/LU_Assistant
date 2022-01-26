package luassistant;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudentInfo extends JFrame{

    String stdID;
    int sID;
    boolean found = false;
    ResultSet resultSet;
    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    DeleteStudentInfo(Connection connection, Statement statement){
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

            String query2 = "delete from student_info where sid = '"+sID+"'";
            try {
                statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Information Deleted Successfully", "", JOptionPane.PLAIN_MESSAGE);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "ID Not Found", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
