package luassistant;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class MainPage extends JFrame {
    JMenuBar menuBar;
    JMenu menu1, menu2, menu3, menu4, menu5;
    JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6;
    MainPage(Connection connection, Statement statement){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setLayout(null);
        setTitle("LU Assistant");

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
    }
}
