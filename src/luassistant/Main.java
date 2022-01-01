package luassistant;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try{
            String url = "jdbc:mysql://localhost:3306/ums";
            String userName = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, userName, password);

            statement = connection.createStatement();

        } catch (Exception e){
            //System.out.println(e);
        }
        new HomePage(connection, statement);
    }
}
