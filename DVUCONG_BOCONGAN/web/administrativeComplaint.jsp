<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Khiếu Nại Hành Chính</title>
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
                            <c:forEach var="service" items="${serviceList.rows}">
                                <option value="${service.serviceId}">
                                    ${service.serviceName}
                                </option>
                            </c:forEach>
                        </select>

                    </div>
                </div>

                <div class="col-md-8">
                    <h1 class="text-center mt-5">Khiếu Nại Hành Chính</h1>

                    <div class="form-container">
                        <%-- Hiển thị thông báo nếu có --%>
                        <% String successMessage = (String) session.getAttribute("successMessage"); %>
                        <% if (successMessage != null) { %>
                        <div class="alert alert-success alert-dismissible fade show" role="alert" id="success-alert">
                            <%= successMessage %>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                        <% session.removeAttribute("successMessage"); %>
                        <% } %>
                        <h4>Nhập thông tin khiếu nại</h4>
                        <form action="administrativeComplaint" method="POST">
                            <div class="mb-3">
                                <label for="businessId" class="form-label">Mã Doanh Nghiệp</label>
                                <input type="text" class="form-control" id="businessId" name="businessId" required>
                            </div>
                            <div class="mb-3">
                                <label for="complaintType" class="form-label">Loại Khiếu Nại</label>
                                <input type="text" class="form-control" id="complaintType" name="complaintType" required>
                            </div>
                            <div class="mb-3">
                                <label for="submissionDate" class="form-label">Ngày Nộp</label>
                                <input type="date" class="form-control" id="submissionDate" name="submissionDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="complaintDetails" class="form-label">Chi Tiết Khiếu Nại</label>
                                <textarea class="form-control" id="complaintDetails" name="complaintDetails" required></textarea>
                            </div>
                            <button type="submit" class="btn btn-danger">Gửi Khiếu Nại</button>
                        </form>
                    </div>
                </div>
                </body>
                </html>
