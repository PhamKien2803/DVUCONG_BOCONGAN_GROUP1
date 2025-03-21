/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Citizen;
import Model.PublicService;
import Services.CitizenDB;
import Services.PublicServiceDB;
import Services.RequirementApprovalDB;
import Services.VehicleRegistrationDB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author duong
 */
@WebServlet(name = "VehicleRegistration", urlPatterns = {"/vehicleregistration-procedure"})
public class VehicleRegistration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VehicleRegistration</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleRegistration at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("VehicleProcedure.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ownerName = request.getParameter("ownerName");
        String vehicleType = request.getParameter("vehicleType");
//        String serviceId = request.getParameter("serviceId");


        // Tại đây có thể gọi DAO để lưu vào database
        // Lấy thông tin dịch vụ
        PublicServiceDB publicServiceDB = new PublicServiceDB();
//        PublicService service = publicServiceDB.getPublicServiceById(serviceId);
        // Gửi yêu cầu phê duyệt
        String submissionDate = java.time.LocalDate.now().toString();
        String status = "Chờ xử lý";
        VehicleRegistrationDB vehicleDB = new VehicleRegistrationDB();
        vehicleDB.addInformationVehicle(ownerName, vehicleType);
        RequirementApprovalDB requimentDB = new RequirementApprovalDB();
        requimentDB.createProcedureIdentification2(1, "Yêu cầu đăng kí xe mới", "Đăng kí xe", null, submissionDate, status);

        request.setAttribute("successMessage", "Đăng ký phương tiện thành công!");
        request.getRequestDispatcher("VehicleProcedure.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
