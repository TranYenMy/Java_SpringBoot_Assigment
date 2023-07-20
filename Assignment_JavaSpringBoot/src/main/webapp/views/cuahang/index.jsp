<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

</head>
<body>
<div class="container">
    <h2>Quản lý cửa hàng</h2>
    <table class="table table-striped">
        <br>
        <br>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia </th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="ch" varStatus="viTri">
            <tr>
                <td>${viTri.index + 1}</td>
                <td>${ch.id}</td>
                <td>${ch.ma}</td>
                <td>${ch.ten}</td>
                <td>${ch.diaChi}</td>
                <td>${ch.thanhPho}</td>
                <td>${ch.quocGia}</td>
                <td>
                    <a href="/cua-hang/delete/${ch.id}" class="btn btn-outline-success" onclick="getConfirmDelete()">Delete</a>
                    <a href="/cua-hang/edit/${ch.id}" class="btn btn-outline-success" >Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/cua-hang/create" type="button" class="btn btn-outline-success">Add</a>

</div>
<c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
            ${error}
    </div>
</c:if>

<script>
    function getConfirmDelete() {
        if(confirm("Bạn có muốn xoá không")){
            return true;
        }
        return  false;

    }
</script>
</body>
</html>