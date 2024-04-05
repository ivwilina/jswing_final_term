/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connector;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ivwi3
 */
public class connect_to_mysql {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/demo1";
    private static String user = "root";
    private static String password = "";

    
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            System.out.println("Loi ket noi den database");
        }
        return connection;
    }
}
