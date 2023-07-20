<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 style="text-align: center; color: black; font-family: SansSerif ">Quản lý nhân viên</h2>

    <table class="table table-striped">
        <br>

        <br>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đệm</th>
            <th>Họ</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>Mật khẩu</th>
            <th>Trạng thái</th>
            <th>Tên cửa hàng</th>
            <th>Tên chức vụ</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="nv" varStatus="viTri">
            <tr>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.tenDem}</td>
                <td>${nv.ho}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.sdt}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.trangThai}</td>
                <td>${nv.cuaHang.ten}</td>
                <td>${nv.chucVu.ten}</td>


                <td>
                    <a href="/nhan-vien/delete/${nv.id}" class="btn btn-outline-success" onclick="getConfirmDelete()">Delete</a>
                    <a href="/nhan-vien/edit/${nv.id}" class="btn btn-outline-success">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <a href="/nhan-vien/create" type="button" class="btn btn-outline-success">Add</a>
    

    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>
</div>

<script>
    function getConfirmDelete() {
        if (confirm("Bạn có muốn xoá không")) {
            return true;
        }
        return false;

    }
</script>
</body>
</html>