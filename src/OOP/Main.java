// This is used for the testing of the Database Connectivity


package OOP;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    "root","8688466782");
            Statement stmt = c.createStatement();
            System.out.println("Connection established");
            ResultSet rset = stmt.executeQuery(
                    "select * "+
                            " from city ");
            while (rset.next()) {
                System.out.println(rset.getString(2));
            }


        }catch (SQLException e){
            System.out.println("Cannot make a connection " + e.getMessage());
        }
    }
}