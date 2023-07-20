<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

</head>
<body>
<div class="container">
    <h2 style="text-align: center; color: black; font-family: SansSerif">Quản lý giỏ hàng</h2>
    <table class="table table-striped">
        <br/>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Ngày tạo</th>
            <th>Ngày thanh toán </th>
            <th>Tình trạng</th>
            <th>Tên người nhận</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>Tên khách hàng</th>
            <th>Tên nhân viên</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="h" varStatus="viTri">
            <tr>
                <td>${viTri.index + 1}</td>
                <td>${h.id}</td>

                <td>${h.ma}</td>
                <td>${h.ngayTao}</td>
                <td>${h.ngayThanhToan}</td>
                <td>${h.tinhTrang}</td>
                <td>${h.tenNguoiNhan}</td>
                <td>${h.diaChi}</td>
                <td>${h.sdt}</td>
                <td>${h.khachHang.ten}</td>
                <td>${h.nhanVien.ten}</td>
                <td>
                    <a href="/gio-hang/delete/${h.id}" class="btn btn-outline-success"  onclick="getConfirmDelete()">Delete</a>
                    <a href="/gio-hang/edit/${h.id}" class="btn btn-outline-success" >Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/gio-hang/create" type="button" class="btn btn-outline-success">Add</a>


    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
</div>

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