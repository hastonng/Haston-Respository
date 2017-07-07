package view;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;

public class RequestPage extends HttpServlet{
    private RichPanelHeader ph1;
    private RichPanelGroupLayout pgl1;
    private RichDocument d1;
    private RichPanelGroupLayout pgl2;

    public RequestPage() {
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

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }
    

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        try {
            PrintWriter out;
            out = response.getWriter();
            
            String buttonCreateNewRequest = request.getParameter("createNewRequest");
            String buttonRequestList = request.getParameter("requestList");
            
            
            
        } catch (IOException e) {
        }
}


}
