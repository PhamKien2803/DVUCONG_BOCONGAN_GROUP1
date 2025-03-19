<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--RequirementApproval.jsp-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Duyệt Yêu Cầu - Cổng Dịch Vụ Công</title>
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
            .table-container {
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            }
            .status-pending {
                color: orange;
                font-weight: bold;
            }
            .status-approved {
                color: green;
                font-weight: bold;
            }
            .status-rejected {
                color: red;
                font-weight: bold;
            }
            .footer{
                margin-top: 2rem
            }
        </style>
    </head>
    <body>
        <div class="header">
            <img src="./Images/anh.jpg" alt="Logo" class="logo">
            <h1 style="font-weight: bold; color: red; margin-top: 1rem" class="d-inline ms-3">
                DUYỆT YÊU CẦU - CỔNG DỊCH VỤ CÔNG
            </h1>
        </div>

        <nav class="navbar navbar-expand-lg navbar-dark">
            <div class="container">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="#">Trang chủ</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Thủ tục hành chính</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Hỗ trợ</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container content">
            <div class="table-container">
                <h4 class="mb-3">Danh sách yêu cầu cần phê duyệt</h4>

                <!-- Bảng danh sách đơn -->
                <table class="table table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Công dân</th>
                            <th>Dịch vụ</th>
                            <th>Lý do</th>
                            <th>Ngày nộp</th>
                            <th>Trạng thái</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="request" items="${requestList}">
                            <tr>
                                <td>${request.requestId}</td>
                                <td>${request.citizenId.name}</td>
                                <td>${request.serviceId.serviceName}</td>
                                <td>${request.details}</td>
                                <td>${request.submissionDate}</td>
                                <td class="${request.status eq 'Chờ xử lý' ? 'status-pending' :
                                             request.status eq 'Đã duyệt' ? 'status-approved' :
                                             'status-rejected'}">
                                        ${request.status}
                                    </td>
                                    <td>
                                        <form action="approval-procedure" method="POST" class="d-inline">
                                            <input type="hidden" name="requestId" value="${request.requestId}">
                                            <button type="submit" name="action" value="approve" class="btn btn-success btn-sm">Duyệt</button>
                                        </form>
                                        <form action="approval-procedure" method="POST" class="d-inline">
                                            <input type="hidden" name="requestId" value="${request.requestId}">
                                            <button type="submit" name="action" value="reject" class="btn btn-danger btn-sm">Từ chối</button>
                                        </form>
                                        <form action="approval-procedure" method="POST" class="d-inline">
                                            <input type="hidden" name="requestId" value="${request.requestId}">
                                            <button type="submit" name="action" value="cancel" class="btn btn-warning btn-sm">Hủy</button>
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
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
                function filterTable() {
                    let searchInput = document.getElementById("searchInput").value.toLowerCase();
                    let statusFilter = document.getElementById("statusFilter").value;
                    let rows = document.querySelectorAll("tbody tr");

                    rows.forEach(row => {
                        let citizenName = row.cells[1].innerText.toLowerCase();
                        let status = row.cells[5].innerText;

                        if ((searchInput === "" || citizenName.includes(searchInput)) &&
                                (statusFilter === "" || status === statusFilter)) {
                            row.style.display = "";
                        } else {
                            row.style.display = "none";
                        }
                    });
                }
            </script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        </body>
    </html>
