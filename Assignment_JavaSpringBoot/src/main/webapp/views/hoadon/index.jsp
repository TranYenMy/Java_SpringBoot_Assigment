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
    <table class="table table-striped">
        <br>
        <h2>Quản lý hoá đơn</h2>

        <br>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Tên khách hàng</th>
            <th>Tên nhân viên</th>
            <th>Mã</th>
            <th>Ngày tạo</th>
            <th>Ngày thanh toán </th>
            <th>Ngày ship</th>
            <th>Ngày nhận</th>
            <th>Tình trạng</th>
            <th>Tên người nhận</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="h" varStatus="viTri">
            <tr>
                <td>${viTri.index + 1}</td>
                <td>${h.id}</td>
                <td>${h.khachHang.ten}</td>
                <td>${h.nhanVien.ten}</td>
                <td>${h.ma}</td>
                <td>${h.ngayTao}</td>
                <td>${h.ngayThanhToan}</td>
                <td>${h.ngayShip}</td>
                <td>${h.ngayNhan}</td>
                <td>${h.tinhTrang}</td>
                <td>${h.tenNguoiNhan}</td>
                <td>${h.diaChi}</td>
                <td>${h.sdt}</td>
                <td>
                    <a href="/hoa-don/delete/${h.id}" class="btn btn-outline-success"  onclick="getConfirmDelete()">Delete</a>
                    <a href="/hoa-don/edit/${h.id}" class="btn btn-outline-success" >Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <a href="/hoa-don/create" type="button" class="btn btn-outline-success">Add</a>

    </table>

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