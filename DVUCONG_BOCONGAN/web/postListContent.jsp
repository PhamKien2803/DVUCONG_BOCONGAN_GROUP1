<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }
    th, td {
        padding: 12px 15px;
        text-align: left;
    }
    th {
        background-color: #003366;
        color: white;
        font-weight: bold;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #e6f0ff;
    }
    button {
        padding: 6px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-right: 5px;
        font-size: 13px;
    }
    button.delete-btn {
        background-color: #dc3545;
        color: white;
    }
    button.delete-btn:hover {
        background-color: #c82333;
    }

    /* Toast Styles */
    .toast {
        visibility: hidden;
        min-width: 250px;
        margin-left: -125px;
        background-color: #333;
        color: #fff;
        text-align: center;
        border-radius: 8px;
        padding: 16px;
        position: fixed;
        z-index: 1;
        left: 50%;
        bottom: 30px;
        font-size: 14px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.2);
        transition: visibility 0s, opacity 0.5s linear;
        opacity: 0;
    }

    .toast.show {
        visibility: visible;
        opacity: 1;
    }

    .toast.error {
        background-color: #dc3545;
    }

    .toast.success {
        background-color: #28a745;
    }
</style>

<h2 style="margin-bottom: 20px; color: #003366;">Danh sách bài đăng</h2>
<div class="card">
    <table>
        <tr>
            <th>Tiêu đề</th>
            <th>Ngày đăng</th>
            <th>Nội dung</th>

        </tr>
        <c:forEach var="post" items="${postList}">
            <tr id="row-${post.contentId}">
                <td style="width: 20%;">${post.title}</td>
                <td style="width: 15%;">${post.createdAt}</td>
                <td style="width: 45%;">${post.body}</td>

            </tr>
        </c:forEach>
    </table>
</div>

<!-- Toast -->
<div id="toast" class="toast"></div>

<script>
    var contextPath = "${pageContext.request.contextPath}";

    function deletePost(contentId) {
        if (confirm("Bạn có chắc chắn muốn xóa bài này?")) {
            fetch(contextPath + '/ContentManager?action=deletePost', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'contentId=' + encodeURIComponent(contentId)
            })
                    .then(response => response.json())
                    .then(data => {
                        if (data.success) {
                            const row = document.getElementById('row-' + contentId);
                            if (row) {
                                row.remove();
                            }
                            showToast('Xóa thành công!', 'success');
                        } else {
                            showToast('Xóa thất bại!', 'error');
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        showToast('Có lỗi xảy ra khi xóa!', 'error');
                    });
        }
    }

    function showToast(message, type) {
        const toast = document.getElementById("toast");
        toast.className = 'toast ' + (type === 'error' ? 'error' : 'success');
        toast.innerText = message;
        toast.classList.add("show");
        setTimeout(() => {
            toast.classList.remove("show");
        }, 3000);
    }
</script>
