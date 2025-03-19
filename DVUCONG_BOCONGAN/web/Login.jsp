<%-- 
    Document   : Login.jsp
    Created on : Mar 19, 2025, 10:52:04 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Công Dân đăng nhập - Cổng Dịch Vụ Công</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8e9c2;
                font-family: Arial, sans-serif;
            }
            .login-container {
                max-width: 400px;
                margin: 100px auto;
                background: white;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            }
            .login-container h3 {
                color: #d70000;
                text-align: center;
                margin-bottom: 20px;
            }
            .btn-login {
                background-color: #d70000;
                color: white;
                font-weight: bold;
                width: 100%;
            }
            .btn-login:hover {
                background-color: #900000;
            }
            .footer {
                background-color: #d70000;
                color: white;
                text-align: center;
                padding: 15px 0;
                margin-top: 20px;
            }
            .header {
                background: #f8e9c2;
                text-align: center;
                padding: 15px 0;
            }
            .header .logo {
                height: 90px;
            }
        </style>
    </head>
    <body>

        <div class="header">
            <img src="./Images/anh.jpg" alt="Logo" class="logo">
            <h1 style="color: red; font-weight: bold; margin-top: 1rem">CỔNG DỊCH VỤ CÔNG - CÔNG DÂN/DOANH NGHIỆP</h1>
        </div>

        <div class="login-container">
            <h3>ĐĂNG NHẬP</h3>

            <!-- Hiển thị lỗi nếu có -->
            <% String error = (String) session.getAttribute("error");
               if (error != null) { %>
            <div class="alert alert-danger text-center"><%= error %></div>
            <% session.removeAttribute("error"); // Xóa lỗi sau khi hiển thị %>
            <% } %>

            <form action="login" method="POST">
                <div class="mb-3">
                    <label for="username" class="form-label">Tên đăng nhập</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Nhập tên đăng nhập" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu" required>
                </div>
                <button type="submit" class="btn btn-login">Đăng nhập</button>
            </form>
        </div>

        <footer class="footer">
            <div class="container">
                <p class="mb-1">CỔNG DỊCH VỤ CÔNG - BỘ CÔNG AN</p>
                <p class="mb-0">© 2025 Mọi quyền được bảo lưu.</p>
            </div>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>


