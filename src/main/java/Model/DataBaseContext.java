package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KAAF0
 */
public class DataBaseContext {
    private final String connectionString = "jdbc:mariadb://localhost:3306/dbds120251";
    private final String user = "root";
    private final String password = "030191";
    
    public Connection connection = null;
    
    public DataBaseContext() {
        this.init();
    }
    
    private void init() {
        try {
            this.connection = DriverManager.getConnection(connectionString, user, password);
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
