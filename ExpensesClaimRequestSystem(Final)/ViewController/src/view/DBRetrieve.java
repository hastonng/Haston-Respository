package view;

import java.sql.*;
import java.io.IOException;

import javax.servlet.jsp.jstl.sql.Result;

public class DBRetrieve {
    
    private String sql;
    private Connection connection;
    private String setTable;
    private String getTable;
    
    
    public DBRetrieve() throws SQLException {
        super();
        this.sql="";
        this.connection= DriverManager.getConnection("Server=haston.asuscomm.com;Port=3306;Database=ECRS_Schema;Uid=haston;Pwd=finalyear");
    }
    
    public void setConnection(String connectString) throws SQLException {
    this.connection = DriverManager.getConnection(connectString);
}
    
    public Connection getConnection() throws SQLException {
        //this.connection = DriverManager.getConnection("Server=haston.asuscomm.com;Port=3306;Database=ECRS_Schema;Uid=haston;Pwd=finalyear");
        return this.connection;
    }
    
    public ResultSet Query(String sqlStatement) throws SQLException {
        Statement stmt = this.connection.createStatement();
        String Sql = sqlStatement;
        ResultSet rs = stmt.executeQuery(Sql);
        return rs;
    }

     
      
}
