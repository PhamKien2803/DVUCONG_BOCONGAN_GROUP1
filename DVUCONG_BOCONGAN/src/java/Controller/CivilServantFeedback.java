/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.PublicService;
import Services.FeedbackAndSuggestionsDB;
import Services.PublicServiceDB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
/**
 *
 * @author duong
 */
@WebServlet(name="CivilServantFeedback", urlPatterns={"/civilservantfeedback-procedure"})
public class CivilServantFeedback extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet CivilServantFeedback</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CivilServantFeedback at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("FeedBackForm.jsp");
        dispatcher.forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String citizenName = request.getParameter("citizenName");
        String message = request.getParameter("message");

        // Sinh feedbackId ngẫu nhiên
        String feedbackId = UUID.randomUUID().toString();
        String submissionDate = LocalDate.now().toString(); 

        // Gọi DAO để lưu vào database
        FeedbackAndSuggestionsDB feedbackDB = new FeedbackAndSuggestionsDB();
            feedbackDB.createFeedback(feedbackId, citizenName, message, submissionDate);
            request.setAttribute("successMessage", "Gửi phản hồi thành công!");
       

        // Chuyển hướng về trang form JSP
        request.getRequestDispatcher("FeedBackForm.jsp").forward(request, response);
    }
    
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
