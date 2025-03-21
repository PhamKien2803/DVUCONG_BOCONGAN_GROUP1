/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Citizen;
import Model.UserAccount;
import Services.CitizenDB;
import Services.UserAccountDB;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("Login.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserAccountDB db = new UserAccountDB();
        UserAccount user = db.userLogin(username, password);

        HttpSession session = request.getSession();

        if (user != null) {
            session.setAttribute("accountId", user.getAccountId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());

            System.out.println("User role: " + user.getRole());

            if (user.getRole() == 1) { // Citizen
//                CitizenDB dbs = new CitizenDB();
//                Citizen citizen = dbs.getCitizenInforById();
//                session.setAttribute("citizenId", citizen != null ? citizen.getCitizenId() : "N/A");
                response.sendRedirect("procedure-identification");
            } else if (user.getRole() == 2) { // Business
                System.out.println("Điều hướng đến Business");
                response.sendRedirect("business/home.jsp");
            } else if (user.getRole() == 3) { // Government Agency
                System.out.println("Điều hướng đến Government Agency");
                response.sendRedirect("approval-procedure");
            }else if (user.getRole() == 4) { // Government Agency
                System.out.println("Điều hướng đến admin");
                response.sendRedirect("adminView.jsp");
            } else {
                System.out.println("Vai trò không hợp lệ: " + user.getRole());
                session.setAttribute("error", "Vai trò không hợp lệ.");
                response.sendRedirect("login");
            }
        } else {
            System.out.println("Đăng nhập thất bại.");
            session.setAttribute("error", "Sai thông tin đăng nhập hoặc tài khoản chưa kích hoạt.");
            response.sendRedirect("login");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
