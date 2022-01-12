package luassistant;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
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

        label1 = new JLabel("Student");
        label1.setFont(font1);
        label1.setBounds(120, 70, 130, 60);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(50, 150, 280, 400);

        buttons[0] = new JButton("Your Information");
        buttons[0].setFont(font2);
        buttons[0].setBounds(15, 100, 250, 80);

        buttons[1] = new JButton("Other Student Information");
        buttons[1].setFont(font2);
        buttons[1].setBounds(15, 210, 250, 80);

        panel1.setBackground(Color.PINK);
        panel1.add(buttons[0]);
        panel1.add(buttons[1]);

        label2 = new JLabel("Teacher");
        label2.setFont(font1);
        label2.setBounds(435, 70, 130, 60);

        panel2 = new JPanel();
        panel2.setBounds(360, 150, 280, 400);
        panel2.setBackground(Color.cyan);

        label3 = new JLabel("Others");
        label3.setFont(font1);
        label3.setBounds(745, 70, 130, 60);

        panel3 = new JPanel();
        panel3.setBounds(670, 150, 280, 400);
        panel3.setBackground(Color.GREEN);


        // Creating a Menu Bar
        menuBar = new JMenuBar();

        // Placing The Menus of the Menu Bar
        menu1 = new JMenu("Student");
        menu2 = new JMenu("Teacher");
        menu3 = new JMenu("Routine");
        menu4 = new JMenu("Bus Schedule");
        menu5 = new JMenu("Exit");

        // Placing the Menu items into specific Menu Bar
        menuItem1 = new JMenuItem("Your Information");
        menuItem2 = new JMenuItem("Other Student Information");

        menu1.add(menuItem1);
        menu1.add(menuItem2);

        menuItem3 = new JMenuItem("Teacher Information");
        menu2.add(menuItem3);

        menuItem4 = new JMenuItem("Download");
        menu3.add(menuItem4);

        menuItem5 = new JMenuItem("Download");
        menu4.add(menuItem5);

        menuItem6 = new JMenuItem("Exit");
        menu5.add(menuItem6);

        // Adding the menus
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);

        setJMenuBar(menuBar);

        add(label1);
        add(label2);
        add(label3);

        add(panel1);
        add(panel2);
        add(panel3);
    }
}
