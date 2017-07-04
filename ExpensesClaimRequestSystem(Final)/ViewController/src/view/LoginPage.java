package view;

import groovy.sql.Sql;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.ResultSet;
import java.sql.*;

import javax.faces.component.html.HtmlOutputText;

import javax.servlet.*;
import javax.servlet.http.*;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;

public class LoginPage extends HttpServlet
{
     private RichPanelGroupLayout pgl2;
     private RichPanelHeader ph1;
     private RichPanelGroupLayout pgl1;
     private RichForm f1;
     private RichDocument d1;
    private int typeRole;


    public LoginPage() {
    }


    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
          try{
              response.setContentType("text/html");
              PrintWriter out = response.getWriter(); 
              String uN = request.getParameter("username");
              String pW = request.getParameter("password"); 
              String loginId="",loginPW="";
              int admin=1,requester=2,approver=3;
              
              String  Sql = "select LOGIN_ID,PASSWORD from ECRS_SCHEMA.ECRS_LOGIN where USER_ID=\'"+uN+"\'";

                  
                  
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://haston.asuscomm.com:3306/ECRS_SCHEMA","haston","finalyear");
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(Sql);
              while(rs.next()) {
                  loginId = rs.getString("LOGIN_ID");
                  loginPW = rs.getString("PASSWORD");
              }
              rs.close();
              stmt.close();
              conn.close();
              
              
              if(loginId.equals(uN)) {
                  
                  if(loginPW.equals(pW)) {
                      
                      checkUserRole(loginId);
                      
                      if(typeRole == admin){
                
                          RequestDispatcher rd = request.getRequestDispatcher("/requesterPage.jspx");
                          out.flush();
                          rd.forward(request,response);
                          return;
                      }
                          
                              
                      
                      
                  }
                     //wrong page
              }
                  
          }
          
          catch(SQLException e){
            
          }
          catch(IOException e){
             
          } catch (ClassNotFoundException e) {
          }

      }

    public void checkUserRole(String userName) {
        try{
            
        String Sql = "select USER_ROLE from ECRS_SCHEMA.ECRS_LOGIN where USER_ID=\'"+userName+"\'";
            
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://haston.asuscomm.com:3306/ECRS_SCHEMA","haston","finalyear");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Sql);
            while(rs.next()){
                typeRole =rs.getInt("USER_ROLE");
            }
            
            rs.close();
            stmt.close();
            conn.close();

        }
       catch (ClassNotFoundException e) {
        } 
        catch (SQLException e) {
        }
    }
}
