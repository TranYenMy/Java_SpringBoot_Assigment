<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 style="text-align: center; color: black; font-family: SansSerif">Quản lý khách hàng</h2>

    <table class="table table-striped">
        <br/>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đệm</th>
            <th>Họ</th>
            <th>Ngày sinh</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Thành Phố</th>
            <th>Quốc gia</th>
            <th>Mật khẩu</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="kh" varStatus="viTri">
            <tr>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.tenDem}</td>
                <td>${kh.ho}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.sdt}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.thanhPho}</td>
                <td>${kh.quocGia}</td>
                <td>${kh.matKhau}</td>


                <td>
                    <a href="/khach-hang/delete/${kh.id}" class="btn btn-outline-success" onclick="getConfirmDelete()">Delete</a>
                    <a href="/khach-hang/edit/${kh.id}" class="btn btn-outline-success">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/khach-hang/create" type="button" class="btn btn-outline-success">Add</a>

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