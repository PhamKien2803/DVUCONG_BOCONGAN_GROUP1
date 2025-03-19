<%-- 
    Document   : LoginGovernmentAgency.jsp
    Created on : Mar 19, 2025, 1:27:54 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Đăng nhập - Cổng Dịch Vụ Công</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8e9c2;
                font-family: Arial, sans-serif;
            }
            .header {
                background: #f8e9c2;
                text-align: center;
                padding: 15px 0;
            }
            .header .logo {
                height: 90px;
            }
            .login-container {
                background: white;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                margin: 50px auto;
            }
            .login-container h3 {
                text-align: center;
                color: #b50000;
                margin-bottom: 20px;
                font-weight: bold;
            }
            .btn-login {
                background-color: #b50000;
                color: white;
                width: 100%;
                padding: 10px;
                border: none;
                border-radius: 5px;
                font-weight: bold;
                cursor: pointer;
            }
            .btn-login:hover {
                background-color: #900000;
            }
            .error-message {
                color: red;
                text-align: center;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <img src="./Images/anh.jpg" alt="Logo" class="logo">
            <h1 style="color: red; font-weight: bold; margin-top: 1rem">CỔNG DỊCH VỤ CÔNG - BỘ CÔNG AN</h1>
        </div>

        <div class="login-container">
            <h3>Đăng nhập dành cho Cơ quan Chính phủ</h3>

            <%-- Hiển thị thông báo lỗi nếu có --%>
            <%
                String errorMessage = (String) session.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
            <p class="error-message"><%= errorMessage %></p>
            <% session.removeAttribute("errorMessage"); } %>

            <form action="login-government" method="POST">
                <div class="mb-3">
                    <label for="username" class="form-label">Username:</label>
                    <input type="text" name="username" id="username" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" name="password" id="password" class="form-control" required>
                </div>
                <button type="submit" class="btn-login">Đăng nhập</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>


