package luassistant;

import java.sql.*;

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
        new LogInPage(connection, statement);
    }
}

/*
* ashfaque129
* ashfaque_1_two_9
* 1912020198
* */