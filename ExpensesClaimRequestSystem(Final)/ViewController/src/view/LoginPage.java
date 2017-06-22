package view;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.component.html.HtmlOutputText;

import javax.servlet.*;
import javax.servlet.http.*;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;

public class LoginPage extends HttpServlet
{
    static private RichPanelGroupLayout pgl2;
    static private RichPanelHeader ph1;
    static private RichPanelGroupLayout pgl1;
    static private RichForm f1;
    static private RichDocument d1;
    static private HtmlOutputText resultText;
    static private String outputStr;


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
    
    public void setResultText(HtmlOutputText resultText) {
        LoginPage.resultText = resultText;
    }

    public static HtmlOutputText getResultText() {
        return resultText;
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,
                                                                                       SQLException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter(); 
            String uN = request.getParameter("username"); 
            String pW = request.getParameter("password"); 
            ResultSet userResult,passResult; // Declaring DBRetrieve
            DBRetrieve userQuery,passQuery; // Query for DBRetrieve
            int role;
            
            //Query Database for pass and user
            
            userResult = userQuery.Query("SELECT * from ECRS_USER,WHERE USER_NAME='"+uN+"';");
            passResult = passQuery.Query("SELECT * from ECRS_USER,WHERE PASSWORD='"+pW+"';");
                
            String UNResult = userResult.toString();
            String PWResult = passResult.toString();
            
            if(uN == UNResult ) {
                
                if(pW == PWResult){
                    
                    role = checkUserRole(uN);
                    
                    switch(role){
                    
                    case 1: break;
                    
                    case 2: out.print("<a href=C://Users//Haston Ng//Documents//GitHub//Haston-Respository//ExpensesClaimRequestSystem(Final)//ViewController//public_html//ecrs-requester-main-page.jspx");
                            break;
                    
                    case 3: out.print("<a href=C://Users//Haston Ng//Documents//GitHub//Haston-Respository//ExpensesClaimRequestSystem(Final)//ViewController//public_html//ecrs-approver-main-page.jspx");
                            break;
                        
                    }
                }
                
            }
            else
                
                           
    }
    
    public int checkUserRole(String userName) throws SQLException {
        DBRetrieve getRole;
        ResultSet result;
        
        result=getRole.Query("SELECT USER_ROLE FROM ECRS_USER, WHERE USER_NAME='"+userName+"';");
        int roleResult = result.getInt(0);
        
        return roleResult;
    }
}
