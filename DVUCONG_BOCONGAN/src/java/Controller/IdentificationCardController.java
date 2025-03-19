package Controller;

import Model.Citizen;
import Services.CitizenDB;
import Services.PublicServiceDB;
import Model.PublicService;
import Services.RequirementApprovalDB;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.util.List;

@WebServlet(name = "IdentificationCardController", urlPatterns = {"/procedure-identification"})
public class IdentificationCardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PublicServiceDB publicServiceDB = new PublicServiceDB();
        List<PublicService> services = publicServiceDB.getAllPublicServices();
        request.setAttribute("services", services);

        String serviceId = request.getParameter("id");
        PublicService selectedService = null;

        if (serviceId != null && !serviceId.trim().isEmpty()) {
            selectedService = publicServiceDB.getPublicServiceById(serviceId);
        }
        request.setAttribute("selectedService", selectedService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("IdentificationcardProceduce.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy thông tin từ form
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String reason = request.getParameter("reason");
        String serviceId = request.getParameter("serviceId");

        request.setAttribute("paramFullName", fullName);
        request.setAttribute("paramPhone", phone);
        request.setAttribute("paramAddress", address);
        request.setAttribute("paramEmail", email);
        request.setAttribute("paramDob", dob);
        request.setAttribute("paramReason", reason);

        // Kiểm tra dữ liệu đầu vào
        if (fullName == null || phone == null || address == null || email == null || dob == null || serviceId == null) {
            request.setAttribute("error", "Vui lòng điền đầy đủ thông tin.");
            request.getRequestDispatcher("IdentificationcardProceduce.jsp").forward(request, response);
            return;
        }

        // Lưu công dân vào DB
        CitizenDB citizenDB = new CitizenDB();
        RequirementApprovalDB requimentDB = new RequirementApprovalDB();
        String citizenId = citizenDB.createInformationCitizen(fullName, phone, address, email, dob);

        if (citizenId == null) {
            request.setAttribute("error", "Không thể tạo thông tin công dân.");
            request.getRequestDispatcher("IdentificationcardProceduce.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng Citizen
        Citizen citizen = new Citizen();
        citizen.setCitizenId(Integer.parseInt(citizenId));
        citizen.setName(fullName);
        citizen.setPhoneNumber(phone);
        citizen.setAddress(address);
        citizen.setEmailAddress(email);
        citizen.setDateOfBirth(dob);

        // Lấy thông tin dịch vụ
        PublicServiceDB publicServiceDB = new PublicServiceDB();
        PublicService service = publicServiceDB.getPublicServiceById(serviceId);

        if (service == null) {
            request.setAttribute("error", "Dịch vụ không hợp lệ.");
            request.getRequestDispatcher("IdentificationcardProceduce.jsp").forward(request, response);
            return;
        }

        // Gửi yêu cầu phê duyệt
        String submissionDate = java.time.LocalDate.now().toString();
        String status = "Chờ xử lý";
        requimentDB.createProcedureIdentification(citizen, "Yêu cầu cấp căn cước công dân mới", service, reason, submissionDate, status);

        request.getSession().setAttribute("successMessage", "Gửi yêu cầu thành công!");
        response.sendRedirect("procedure-identification");

    }

    @Override
    public String getServletInfo() {
        return "Servlet xử lý đăng ký căn cước công dân";
    }
}
