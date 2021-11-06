package org.example.hellomaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSetup {

    public Connection createConnection() throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Password@123");
        return con;
    }
}
