package luassistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainPage extends JFrame {
    JMenuBar menuBar;
    JMenu menu1, menu2, menu3, menu4, menu5;
    JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6;
    JPanel panel1, panel2, panel3;
    JLabel label1, label2, label3;
    Font font1, font2;
    JButton[] buttons;
    MainPage(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setLayout(null);
        setResizable(false);
        setTitle("LU Assistant");

        font1 = new Font("Arial", Font.BOLD, 30);
        font2 = new Font("Arial", Font.BOLD, 17);

        buttons = new JButton[10];

        // First Section

        label1 = new JLabel("Student");
        label1.setFont(font1);
        label1.setBounds(120, 70, 130, 60);

        // First Panel

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(50, 150, 280, 400);
        panel1.setBackground(Color.PINK);

        buttons[0] = new JButton("Your Information");
        buttons[0].setFont(font2);
        buttons[0].setBounds(15, 100, 250, 80);

        buttons[1] = new JButton("Other Student Information");
        buttons[1].setFont(font2);
        buttons[1].setBounds(15, 210, 250, 80);

        panel1.add(buttons[0]);
        panel1.add(buttons[1]);

        // Second Section

        label2 = new JLabel("Teacher");
        label2.setFont(font1);
        label2.setBounds(435, 70, 130, 60);

        // Second Panel

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(360, 150, 280, 400);
        panel2.setBackground(Color.cyan);

        buttons[2] = new JButton("Teacher Information");
        buttons[2].setFont(font2);
        buttons[2].setBounds(15, 150, 250, 80);

        panel2.add(buttons[2]);

        // Third Section

        label3 = new JLabel("Others");
        label3.setFont(font1);
        label3.setBounds(745, 70, 130, 60);

        // Third Panel

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(670, 150, 280, 400);
        panel3.setBackground(Color.GREEN);

        buttons[3] = new JButton("Class Routine");
        buttons[3].setFont(font2);
        buttons[3].setBounds(15, 100, 250, 80);

        buttons[4] = new JButton("Bus Schedule");
        buttons[4].setFont(font2);
        buttons[4].setBounds(15, 210, 250, 80);

        panel3.add(buttons[3]);
        panel3.add(buttons[4]);

        // Creating a Menu Bar
        menuBar = new JMenuBar();

        // Placing The Menus of the Menu Bar
        menu1 = new JMenu("Exit");

        menu1.addMouseListener(new MouseAdapter() {
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


        // Adding the menus
        menuBar.add(menu1);

        setJMenuBar(menuBar);

        add(label1);
        add(label2);
        add(label3);

        add(panel1);
        add(panel2);
        add(panel3);
    }
}
