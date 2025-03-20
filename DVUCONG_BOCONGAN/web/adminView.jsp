<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin - CỔNG DỊCH VỤ CÔNG</title>
        <style>
            * {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f2f5;
                color: #333;
            }
            .header {
                background-color: #003366;
                display: flex;
                align-items: center;
                justify-content: space-between;
                padding: 15px 30px;
                color: white;
            }
            .header .logo {
                display: flex;
                align-items: center;
            }
            .header img {
                height: 50px;
                margin-right: 15px;
            }
            .header h1 {
                font-size: 20px;
            }
            .header .admin-info {
                font-size: 14px;
            }
            .sidebar {
                width: 200px;
                background-color: #002244;
                position: fixed;
                top: 70px;
                bottom: 0;
                padding: 20px 0;
                color: white;
            }
            .sidebar a {
                display: block;
                color: white;
                padding: 12px 20px;
                text-decoration: none;
                transition: background 0.3s;
                cursor: pointer;
            }
            .sidebar a:hover {
                background-color: #004488;
            }
            .main {
                margin-left: 220px;
                padding: 30px;
                min-height: 100vh;
            }
            .card {
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
                margin-bottom: 20px;
            }

            button {
                padding: 8px 16px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-right: 10px;
                font-size: 14px;
            }
            .btn-primary {
                background: #007bff;
                color: white;
            }
            .btn-primary:hover {
                background: #0056b3;
            }
            .btn-success {
                background: #28a745;
                color: white;
            }
            .btn-success:hover {
                background: #1e7e34;
            }
            .btn-secondary {
                background: #6c757d;
                color: white;
            }
            .btn-secondary:hover {
                background: #5a6268;
            }
            .toast {
                position: fixed;
                bottom: 20px;
                right: 20px;
                background: #4caf50;
                color: white;
                padding: 10px 20px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.2);
                display: none;
            }
            .toast.error {
                background: #f44336;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <div class="logo">
                <img src="Images/anh.jpg" alt="Logo Bộ Công An">
                <h1>Admin Panel - Bộ Công An</h1>
            </div>
            <div class="admin-info">
                Xin chào, Admin 
            </div>
        </div>

        <div class="sidebar">
            <a onclick="loadPostList()">Quản lý bài đăng</a>
            <a onclick="loadUserManager()">Quản lý người dùng</a>
        </div>

        <div class="main" id="main-content">
            <h2>Trang quản trị Admin</h2>
            <div class="card">
                <p>Chào mừng bạn đến giao diện quản trị. Tại đây, bạn có thể quản lý người dùng, kiểm tra và tạo các bài đăng.</p>
            </div>
        </div>

        <div id="toast" class="toast"></div>

        <script>
            function loadPostList() {
                const mainContent = document.getElementById('main-content');
                mainContent.innerHTML = `
                    <h2 style="margin-bottom: 20px; color: #003366;">Quản lý bài đăng</h2>
                    <div style="margin-bottom: 20px;">
                        <button onclick="loadPostTable()" class="btn-primary">Xem bài đăng cũ</button>
                        <button onclick="loadCreateForm()" class="btn-success">Tạo bài đăng mới</button>
                    </div>
                    <div id="postContentContainer"></div>
                `;
            }

            function loadPostTable() {
                const container = document.getElementById('postContentContainer');
                container.innerHTML = '<p>Đang tải danh sách bài đăng...</p>';
                fetch('ContentManager') // GỌI servlet ContentManager chứ KHÔNG gọi trực tiếp postListContent.jsp nữa
                        .then(response => response.text())
                        .then(html => {
                            container.innerHTML = html;
                        })
                        .catch(() => {
                            container.innerHTML = '<p style="color:red;">Lỗi tải danh sách bài đăng!</p>';
                        });
            }

            function loadCreateForm() {
                const container = document.getElementById('postContentContainer');
                container.innerHTML = `
                    <div class="card">
                        <form id="createPostForm" action="CreatePost" method="POST">
                            <h3>Tạo bài đăng mới</h3>
                            <label>Tiêu đề:</label><br>
                            <input type="text" name="title" required style="width:100%;padding:5px;"><br><br>
                            <label>Nội dung:</label><br>
                            <textarea name="body" rows="4" style="width:100%;padding:5px;" required></textarea><br><br>
                            <input type="hidden" name="adminId" value="1">
                            <button type="submit" class="btn-success">Tạo bài đăng</button>
                            <button type="button" onclick="clearPostContainer()" class="btn-secondary">Hủy</button>
                        </form>
                    </div>
                `;
                bindFormEvents();
            }

            function clearPostContainer() {
                document.getElementById('postContentContainer').innerHTML = '';
            }

            function bindFormEvents() {
                const form = document.getElementById('createPostForm');
                form.addEventListener('submit', function (e) {
                    e.preventDefault();
                    const submitBtn = form.querySelector('button[type="submit"]');
                    submitBtn.disabled = true;
                    submitBtn.textContent = 'Đang lưu...';

                    const formData = new FormData(form);
                    const params = new URLSearchParams();
                    formData.forEach((value, key) => {
                        params.append(key, value);
                    });

                    fetch(form.action, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
                        },
                        body: params.toString()
                    })
                            .then(response => response.json())
                            .then(data => {
                                if (data.success) {
                                    showToast('Tạo bài đăng thành công!');
                                    clearPostContainer();
                                    loadPostTable();
                                } else {
                                    showToast(data.error || 'Có lỗi xảy ra!', true);
                                }
                            })
                            .catch(() => showToast('Lỗi khi tạo bài!', true))
                            .finally(() => {
                                submitBtn.disabled = false;
                                submitBtn.textContent = 'Tạo bài đăng';
                            });
                });
            }


            function showToast(message, isError = false) {
                const toast = document.getElementById('toast');
                toast.textContent = message;
                toast.className = 'toast' + (isError ? ' error' : '');
                toast.style.display = 'block';
                setTimeout(() => {
                    toast.style.display = 'none';
                }, 3000);
            }

            function loadUserManager() {
                const mainContent = document.getElementById('main-content');
                mainContent.innerHTML = '<p>Đang tải danh sách người dùng...</p>';
                fetch('UserListServlet')
                        .then(response => response.text())
                        .then(html => {
                            mainContent.innerHTML = html;
                        })
                        .catch(() => {
                            mainContent.innerHTML = '<p style="color:red;">Lỗi tải danh sách người dùng!</p>';
                        });
            }

            window.onload = function () {
                const urlParams = new URLSearchParams(window.location.search);
                const view = urlParams.get('view');
                const success = urlParams.get('success');
                const error = urlParams.get('error');

                if (view === 'userList') {
                    loadUserManager();
                    if (success)
                        showToast('Cập nhật thành công!');
                    if (error)
                        showToast('Cập nhật thất bại!', true);
                } else if (view === 'postList') {
                    loadPostList();
                }
            };

        </script>
    </body>
</html>
