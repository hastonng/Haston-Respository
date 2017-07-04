package view;

import java.sql.*;
import java.io.IOException;

import javax.servlet.jsp.jstl.sql.Result;

public class DBRetrieve {
    
    private String sql;
    private Connection connection;
    private ResultSet result;
    
    public DBRetrieve() throws SQLException {
        super();
        this.sql="";
        connection= DriverManager.getConnection("jdbc:mysql://haston.asuscomm.com:3306/ECRS_SCHEMA","haston","finalyear");
    }
    public void setResult(ResultSet res){
        result=res;
    }
    
    public ResultSet getResult(){
        return result;
    }
    
    public void Query(String sqlStatement) {
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://haston.asuscomm.com:3306/ECRS_SCHEMA","haston","finalyear");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqlStatement);
                result=rs;
        }
        catch (Exception e){
            
        }
    }
    
    public void closeConn (){
        try {
            connection.close();
        } catch (Exception e) {
        }
    }
         
}
