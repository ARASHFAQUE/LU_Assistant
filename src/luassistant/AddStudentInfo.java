package luassistant;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;

public class AddStudentInfo extends JFrame {

    AddStudentInfo(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setLayout(null);
        setResizable(false);
        setTitle("LU Assistant");


    }
}
