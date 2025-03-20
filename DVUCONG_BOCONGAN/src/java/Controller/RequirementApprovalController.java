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
        RequirementApprovalDB reqDB = new RequirementApprovalDB();

        String action = request.getParameter("action");
        String requestId = request.getParameter("requestId");

        if (action != null && requestId != null) {
            boolean success = false;
            switch (action) {
                case "approve":
                    success = reqDB.updateStatus(requestId, "Đã duyệt");
                    break;
                case "reject":
                    success = reqDB.updateStatus(requestId, "Bị từ chối");
                    break;
                case "cancel":
                    success = reqDB.updateStatus(requestId, "Chờ xử lý");
                    break;
            }

            if (success) {
                request.getSession().setAttribute("message", "Xử lý đơn thành công!");
            } else {
                request.getSession().setAttribute("error", "Xử lý đơn thất bại!");
            }

        }

        // Lấy danh sách yêu cầu cập nhật
        ArrayList<RequirementApproval> requestList = reqDB.getProcedureIdentification();
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
        return "Servlet để lấy danh sách yêu cầu phê duyệt cho agencyId = 1";
    }
}
