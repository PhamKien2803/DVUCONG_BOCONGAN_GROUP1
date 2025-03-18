package Controller;

import Model.RequirementApproval;
import Services.RequirementApprovalDB;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet(name = "RequirementApprovalController", urlPatterns = {"/approval-procedure"})
public class RequirementApprovalController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Lấy danh sách yêu cầu cần duyệt từ database
        RequirementApprovalDB reqDB = new RequirementApprovalDB();
        String agencyId = request.getParameter("agencyId");
        if (agencyId == null || agencyId.isEmpty()) {
            agencyId = "defaultAgencyId";
        }
        ArrayList<RequirementApproval> requestList = reqDB.getProcedureIdentification(agencyId);

        // Gửi danh sách yêu cầu đến trang JSP
        request.setAttribute("requestList", requestList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RequirementApproval.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet để lấy danh sách yêu cầu phê duyệt";
    }
}
