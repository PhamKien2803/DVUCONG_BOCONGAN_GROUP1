<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--IdentificationcardProceduce.jsp-->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cổng Dịch Vụ Công - Bộ Công An</title>
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
            .navbar {
                background-color: #b50000;
            }
            .navbar .nav-link {
                color: white !important;
                font-weight: bold;
            }
            .navbar .nav-link:hover {
                background-color: #900000;
                border-radius: 5px;
            }
            .content {
                margin-top: 20px;
            }
            .form-container {
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
                margin-top: 20px;
            }
            .footer {
                background-color: #d70000;
                color: white;
                text-align: center;
                padding: 15px 0;
                margin-top: 20px;
            }
            .error-message {
                color: red;
                font-weight: bold;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <img src="./Images/anh.jpg" alt="Logo" class="logo">
            <h1 style="font-weight: bold; color: red; margin-top: 1rem" class="d-inline ms-3">
                CỔNG DỊCH VỤ CÔNG - BỘ CÔNG AN
            </h1>
        </div>

        <nav class="navbar navbar-expand-lg navbar-dark">
            <div class="container">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="#">Giới thiệu</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Thủ tục hành chính</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Nộp hồ sơ trực tuyến</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Tra cứu hồ sơ</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Phản ánh - Kiến nghị</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Đánh giá</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Thống kê</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Hỗ trợ</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container content">
            <div class="row">
                <!-- Cột hiển thị form nhập -->
                <div class="col-md-8">
                    <h2>Đánh giá công chức</h2>
                    <form action="civilservantfeedback-procedure" method="post">
                        <div class="mb-3">
                            <label class="form-label">Tên công dân:</label>
                            <input  name="citizenName" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Nội dung phản hồi:</label>
                            <textarea name="message" class="form-control" rows="4" required></textarea>
                        </div>
                        <button type="submit" class="btn btn-submit">Gửi Phản Hồi</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <footer class="footer">
        <div class="container">
            <p class="mb-1">CỔNG DỊCH VỤ CÔNG - BỘ CÔNG AN</p>
            <p class="mb-1">Địa chỉ: KM29 Thang Long Boulevard Thach Hoa Commune 10000 Hà Nội</p>
            <p class="mb-1">Email: vanphongbo@mps.gov.vn</p>
            <p class="mb-0">© 2025 Cổng Dịch Vụ Công - Bộ Công An. Mọi quyền được bảo lưu.</p>
        </div>
    </footer>

    <script>
        document.getElementById("procedureSelect").addEventListener("change", function () {
            if (this.value) {
                window.location.href = "procedure-identification?id=" + this.value;
            }
        });
    </script>
    <script>
        window.onload = function () {
            var message = "<c:out value='${sessionScope.successMessage}' />";
            if (message.trim() !== "") {
                alert(message);
        <% session.removeAttribute("successMessage"); %>
            }
        };
    </script>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
