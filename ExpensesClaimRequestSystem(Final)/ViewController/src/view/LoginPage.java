package view;

import java.io.IOException;

import java.io.PrintWriter;

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
    static private HtmlOutputText ot1;
    

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


    public void setOt1(HtmlOutputText ot1) {
        this.ot1 = ot1;
    }

    public HtmlOutputText getOt1() {
        return ot1;
    }
    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter(); 
            String uN = request.getParameter("username"); 
            String pW = request.getParameter("password"); 
            
            
            
    }
}
