package luassistant;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {
    Container container;
    Register(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 50, 1000, 700);
        setTitle("LU Assistant");
        setLayout(null);
        setResizable(false);

        container = new Container();
        container.setBackground(Color.LIGHT_GRAY);
    }
}
