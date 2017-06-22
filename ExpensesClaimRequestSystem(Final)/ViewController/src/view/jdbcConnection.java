package view;

import java.sql.*;
import java.io.IOException;

import javax.servlet.jsp.jstl.sql.Result;

public class jdbcConnection {
    public jdbcConnection() {
        super();
    }
    
    private String sqlScript;
    private Connection connection;
    
    
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("Server=haston.asuscomm.com;Port=3306;Database=ECRS_Schema;Uid=haston;Pwd=finalyear");
        return connection;
    }
    
    public String getData() {
        return this.sqlScript;
    }
    
    public void setData(String data) {
        this.sqlScript=data;
    }
    
    public static void main(String[] args) throws SQLException {
        //Connection connection = DriverManager.getConnection("Server=haston.asuscomm.com;Port=3306;Database=ECRS_Schema;Uid=haston;Pwd=finalyear");
        //Statement stmt = connection.createStatement();
        
    }
       
}
