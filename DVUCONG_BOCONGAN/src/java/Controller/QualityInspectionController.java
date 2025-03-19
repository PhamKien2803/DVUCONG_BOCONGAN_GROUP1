/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Services.BusinessDB;
import Services.PublicServiceDB;
import Services.QualityInspectionRequestDB;
import Services.RequirementApprovalDB;
import Model.Business;
import Model.PublicService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ACER
 */
@WebServlet(name = "QualityInspectionController", urlPatterns = {"/QualityInspectionController"})
public class QualityInspectionController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PublicServiceDB publicServiceDB = new PublicServiceDB();

        // Lấy danh sách tất cả dịch vụ
        List<PublicService> publicServiceList = publicServiceDB.getAllPublicServices();
        request.setAttribute("publicServiceList", publicServiceList);

        // Kiểm tra xem có serviceId được chọn không
        String serviceIdParam = request.getParameter("serviceId");
        if (serviceIdParam != null && !serviceIdParam.isEmpty()) {
            String serviceId = serviceIdParam;
            PublicService selectedService = publicServiceDB.getPublicServiceById(serviceId);
            request.setAttribute("selectedService", selectedService);
        }

        request.getRequestDispatcher("publicService.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Lấy thông tin từ form
        String productType = request.getParameter("productType");
        String details = request.getParameter("details");
        String serviceId = request.getParameter("serviceId");

        request.setAttribute("paramProductType", productType);
        request.setAttribute("paramDetails", details);

        // Kiểm tra dữ liệu đầu vào
        if (productType == null || details == null || serviceId == null
                || productType.trim().isEmpty() || details.trim().isEmpty()) {
            request.setAttribute("error", "Vui lòng điền đầy đủ thông tin.");
            request.getRequestDispatcher("publicService.jsp").forward(request, response);
            return;
        }

        // Lấy thông tin dịch vụ từ DB
        PublicServiceDB publicServiceDB = new PublicServiceDB();
        PublicService service = publicServiceDB.getPublicServiceById(serviceId);

        if (service == null) {
            request.setAttribute("error", "Dịch vụ không hợp lệ.");
            request.getRequestDispatcher("publicService.jsp").forward(request, response);
            return;
        }

        // Đăng ký yêu cầu kiểm định
        QualityInspectionRequestDB inspectionDB = new QualityInspectionRequestDB();
        String requestId = "REQ" + System.currentTimeMillis();
        String requestDate = LocalDate.now().toString();
        String status = "Chờ xử lý";

        try {
            inspectionDB.registerQualityInspectionRequest(requestId, productType, requestDate, status, details);
        } catch (Exception e) {
            request.setAttribute("error", "Lỗi hệ thống khi đăng ký kiểm định: " + e.getMessage());
            request.getRequestDispatcher("publicService.jsp").forward(request, response);
            return;
        }

        // Gửi yêu cầu phê duyệt
        RequirementApprovalDB approvalDB = new RequirementApprovalDB();
        String submissionDate = LocalDate.now().toString();
        int agencyId = 1; // Cơ quan phê duyệt mặc định

        try {
            approvalDB.createApprovalRequest(requestId, service, "Doanh nghiệp", details, submissionDate, status, agencyId);
        } catch (Exception e) {
            request.setAttribute("error", "Lỗi hệ thống khi gửi yêu cầu phê duyệt: " + e.getMessage());
            request.getRequestDispatcher("publicService.jsp").forward(request, response);
            return;
        }

        session.setAttribute("success", "Nộp đơn kiểm định chất lượng thành công!");
        response.sendRedirect("QualityInspectionController");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
