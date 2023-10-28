package School;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    conn(){
        String username = "root";
        String password = "ksha@nb.9876";
        String url = "jdbc:mysql://localhost:3306/stadium";
        try{
            c = DriverManager.getConnection(url,username,password);
            s = c.createStatement();
            System.out.println("connection successful!!");

        }catch (Exception e){
            System.out.println(e);
            System.out.println("Connection failed");
        }
    }

    public static void main(String[] args) {
        new conn();
    }

}