<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <!-- Cột chọn loại thủ tục -->
                <div class="col-md-4">
                    <div class="form-container">
                        <h4>Chọn loại thủ tục</h4>
                        <select id="procedureSelect" class="form-select" name="serviceId">
                            <option value="">-- Chọn thủ tục --</option>
                            <c:forEach var="service" items="${services}">
                                <option value="${service.serviceId}" 
                                        ${service.serviceId eq selectedService.serviceId ? 'selected' : ''}>
                                    ${service.serviceName}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <!-- Cột hiển thị form nhập -->
                <div class="col-md-8">
                    <div id="cccdForm" class="form-container" 
                         style="display: ${not empty selectedService ? 'block' : 'none'};">
                        <h4>${selectedService.serviceName}</h4>
                        <p>${selectedService.description}</p>

                        <!-- Hiển thị lỗi nếu có -->
                        <c:if test="${not empty param.success}">
                            <div class="alert alert-success">${param.success}</div>
                        </c:if>

                        <c:if test="${not empty param.error}">
                            <div class="alert alert-danger">${param.error}</div>
                        </c:if>


                        <form id="cccdRequestForm" action="procedure-identification" method="POST">
                            <input type="hidden" name="serviceId" value="${selectedService.serviceId}">

                            <div class="mb-3">
                                <label for="fullName" class="form-label">Họ và tên</label>
                                <input type="text" class="form-control" id="fullName" name="fullName" 
                                       value="${param.fullName}" required>
                            </div>

                            <div class="mb-3">
                                <label for="dob" class="form-label">Ngày sinh</label>
                                <input type="date" class="form-control" id="dob" name="dob" 
                                       value="${param.dob}" required>
                            </div>

                            <div class="mb-3">
                                <label for="phone" class="form-label">Số điện thoại</label>
                                <input type="tel" class="form-control" id="phone" name="phone" 
                                       value="${param.phone}" required>
                            </div>

                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" 
                                       value="${param.email}" required>
                            </div>

                            <div class="mb-3">
                                <label for="address" class="form-label">Địa chỉ thường trú</label>
                                <input type="text" class="form-control" id="address" name="address" 
                                       value="${param.address}" required>
                            </div>

                            <div class="mb-3">
                                <label for="reason" class="form-label">Lý do đăng ký</label>
                                <input type="text" class="form-control" id="reason" name="reason" 
                                       value="${param.reason}" required>
                            </div>

                            <button type="submit" class="btn btn-danger">Gửi Yêu Cầu</button>
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

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
