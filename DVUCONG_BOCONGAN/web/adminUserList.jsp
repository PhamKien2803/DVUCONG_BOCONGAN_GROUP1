<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Danh sách người dùng</h2>

<c:if test="${not empty message}">
    <div style="padding:10px; background-color: #d4edda; color: #155724; margin-bottom: 15px; border: 1px solid #c3e6cb; border-radius: 5px;">
        ${message}
    </div>
</c:if>

<div class="card">
    <table border="1">
        <thead>
            <tr>
                <th>Account ID</th>
                <th>Username</th>
                <th>Role</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.accountId}</td>
                    <td>${user.username}</td>
                    <td>
                        <select name="role" form="form_${user.accountId}">
                            <option value="admin" <c:if test="${user.role == 4}">selected="selected"</c:if>>Admin</option>
                            <option value="agency" <c:if test="${user.role == 1}">selected="selected"</c:if>>Agency</option>
                            <option value="citizen" <c:if test="${user.role == 2}">selected="selected"</c:if>>Citizen</option>
                            <option value="business" <c:if test="${user.role == 3}">selected="selected"</c:if>>Business</option>
                            </select>
                        </td>
                        <td>
                            <select name="isActive" form="form_${user.accountId}">
                            <option value="true" ${user.isIsActive() ? 'selected' : ''}>Block</option>
                            <option value="false" ${!user.isIsActive() ? 'selected' : ''}>UnBlock</option>
                        </select>
                    </td>
                    <td>
                        <form id="form_${user.accountId}" action="UpdateUser" method="post" onsubmit="return reloadPageAfterSubmit()">
                            <input type="hidden" name="accountId" value="${user.accountId}">
                            <button type="submit" class="btn-primary">Cập nhật</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
