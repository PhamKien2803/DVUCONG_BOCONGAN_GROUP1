<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>



<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Phạt Giao Thông</title>
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
        <div class="container">
            <div class="row">
                <!-- Mục Chọn tra cứu -->
                <div class="col-md-4">
                    <div class="form-container">
                        <h4>Chọn mục tra cứu</h4>
                        <select id="procedureSelect" class="form-select" name="serviceId">
                            <option value="">-- Chọn mục tra cứu --</option>
                            <option value="trafficFine">Thông tin phạt giao thông</option>
                            <option value="cccdInfo">Thông tin CCCD</option>
                            <option value="adminInfo">Thông tin hành chính</option>
                        </select>
                    </div>
                </div>

                <!-- Phần thông tin phạt giao thông (Ẩn ban đầu) -->
                <div class="col-md-8" id="trafficFineSection" style="display: none;">
                    <h1 class="text-center mt-5">Thông Tin Phạt Giao Thông</h1>

                    <!-- Form nhập tiền phạt giao thông -->
                    <div class="form-container">
                        <h4>Nhập thông tin phạt giao thông</h4>
                        <form action="trafficFines" method="POST">
                            <div class="mb-3">
                                <label for="citizenId" class="form-label">Mã CCCD</label>
                                <input type="text" class="form-control" id="citizenId" name="citizenId" required>
                            </div>
                            <div class="mb-3">
                                <label for="violationType" class="form-label">Lỗi vi phạm</label>
                                <input type="text" class="form-control" id="violationType" name="violationType" required>
                            </div>
                            <div class="mb-3">
                                <label for="violationDate" class="form-label">Ngày Vi Phạm</label>
                                <input type="date" class="form-control" id="violationDate" name="violationDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="fineDate" class="form-label">Ngày Nộp phạt</label>
                                <input type="date" class="form-control" id="fineDate" name="fineDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="fineAmount" class="form-label">Số Tiền Phạt</label>
                                <input type="number" class="form-control" id="fineAmount" name="fineAmount" required>
                            </div>
                            <div class="mb-3">
                                <label for="status" class="form-label">Trạng Thái</label>
                                <select class="form-select" id="status" name="status" required>
                                    <option value="Pending">Đang Xử Lý</option>
                                    <option value="Paid">Đã Nộp</option>
                                    <option value="notPaid">Chưa Nộp</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-danger">Lưu Thông Tin</button>
                        </form>
                    </div>

                    <!-- Form tra cứu thông tin phạt giao thông -->
                    <div class="form-container mt-5">
                        <h4>Tra cứu thông tin phạt giao thông</h4>
                        <form action="trafficFines" method="GET">
                            <div class="mb-3">
                                <label for="fineId" class="form-label">Mã Phạt</label>
                                <input type="text" class="form-control" id="fineId" name="fineId" required>
                            </div>
                            <button type="submit" class="btn btn-info">Tra Cứu</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- JavaScript để ẩn/hiện phần thông tin phạt giao thông -->
        <script>
            document.getElementById("procedureSelect").addEventListener("change", function () {
                var selectedValue = this.value;
                var trafficFineSection = document.getElementById("trafficFineSection");

                if (selectedValue === "trafficFine") {
                    trafficFineSection.style.display = "block";
                } else {
                    trafficFineSection.style.display = "none";
                }
            });
        </script>




        <footer class="footer">
            <div class="container">
                <p class="mb-1">CỔNG DỊCH VỤ CÔNG - BỘ CÔNG AN</p>
                <p class="mb-1">Địa chỉ: KM29 Thang Long Boulevard Thach Hoa Commune 10000 Hà Nội</p>
                <p class="mb-1">Email: vanphongbo@mps.gov.vn</p>
                <p class="mb-0">© 2025 Cổng Dịch Vụ Công - Bộ Công An. Mọi quyền được bảo lưu.</p>
            </div>
        </footer>

        <!-- JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
