package Controller;

import Model.AdministrativeComplaint;
import Model.Business;
import Services.AdministrativeComplaintDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AdministrativeComplaintController", urlPatterns = {"/administrativeComplaint"})
public class AdministrativeComplaintController extends HttpServlet {

    private final AdministrativeComplaintDB complaintDB = new AdministrativeComplaintDB();

    // Xử lý truy cập GET để hiển thị trang khiếu nại
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("administrativeComplaint.jsp").forward(request, response);
    }

    // Xử lý khiếu nại khi người dùng gửi form
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy thông tin từ form
        String businessId = request.getParameter("businessId");
        String complaintType = request.getParameter("complaintType");
        String complaintDetails = request.getParameter("complaintDetails");
        String submissionDateStr = request.getParameter("submissionDate");

        // Lưu lại dữ liệu form để hiển thị khi có lỗi
        request.setAttribute("paramBusinessId", businessId);
        request.setAttribute("paramComplaintType", complaintType);
        request.setAttribute("paramComplaintDetails", complaintDetails);
        request.setAttribute("paramSubmissionDate", submissionDateStr);

        // Kiểm tra dữ liệu đầu vào
        if (businessId == null || businessId.trim().isEmpty() ||
            complaintType == null || complaintType.trim().isEmpty() ||
            complaintDetails == null || complaintDetails.trim().isEmpty() ||
            submissionDateStr == null || submissionDateStr.trim().isEmpty()) {

            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin!");
            request.getRequestDispatcher("administrativeComplaint.jsp").forward(request, response);
            return;
        }

        Date submissionDate = Date.valueOf(submissionDateStr);

        // Tạo đối tượng Business (nếu cần fetch từ DB thì thay thế phần này)
        Business business = new Business();
        business.setBusinessId(businessId);

        // Tạo khiếu nại hành chính
        AdministrativeComplaint complaint = new AdministrativeComplaint();
        complaint.setBusinessId(business);
        complaint.setComplaintType(complaintType);
        complaint.setComplaintDetails(complaintDetails);
        complaint.setSubmissionDate(submissionDate);

        // Lưu vào DB
        complaintDB.insertComplaint(complaint);

        // Lưu thông báo thành công vào session
        request.getSession().setAttribute("successMessage", "Gửi khiếu nại thành công!");
        response.sendRedirect("administrativeComplaint");
    }
}
