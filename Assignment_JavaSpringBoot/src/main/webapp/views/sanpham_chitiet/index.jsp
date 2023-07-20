<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

</head>
<body>
<div class="container">
    <h2 style="text-align: center; color: black; font-family: SansSerif">Chi tiết sản phẩm</h2>
    <table class="table table-striped">
        <br>

        <br>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Nhà sản xuất</th>
            <th>Màu sắc</th>
            <th>Dòng sản phẩm</th>
            <th>Năm bảo hành </th>
            <th>Mô tả </th>
            <th>Số lượng tồn</th>
            <th>Giá nhập</th>
            <th>Giá bán</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="ct" varStatus="viTri">
            <tr>
                <td>${viTri.index + 1}</td>
                <td>${ct.id}</td>
                <td>${ct.sanPham.ten}</td>
                <td>${ct.nsx.ten}</td>
                <td>${ct.mauSac.ten}</td>
                <td>${ct.dongSp.ten}</td>
                <td>${ct.namBH}</td>
                <td>${ct.moTa}</td>
                <td>${ct.soLuongTon}</td>
                <td>${ct.giaNhap}</td>
                <td>${ct.giaBan}</td>
                <td>
                    <a href="/chi-tiet-san-pham/delete/${ct.id}" class="btn btn-outline-success"  onclick="getConfirmDelete()">Delete</a>
                    <a href="/chi-tiet-san-pham/edit/${ct.id}" class="btn btn-outline-success" >Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <a href="/chi-tiet-san-pham/create" type="button" class="btn btn-outline-success">Add</a>




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