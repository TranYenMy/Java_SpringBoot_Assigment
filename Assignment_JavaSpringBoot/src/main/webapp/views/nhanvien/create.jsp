<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>SD17313 - Thêm mới Nhân viên</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="container">
<sf:form action="${ action }"  method="post"
         modelAttribute="data">
    <div>
        <label>Mã</label>
        <div class="col-sm-10">
            <sf:input path="ma" class="form-control"/>
            <sf:errors path="ma"/>
        </div>
    </div>
    <div>
        <label>Tên</label>
        <div class="col-sm-10">
            <sf:input path="ten" class="form-control"/>
            <sf:errors path="ten"/>
        </div>
    </div>
    <div>
        <label>Tên đệm</label>
        <div class="col-sm-10">
            <sf:input path="tenDem" class="form-control"/>
            <sf:errors path="tenDem"/>
        </div>
    </div>
    <div>
        <label>Họ</label>
        <div class="col-sm-10">
            <sf:input path="ho" class="form-control"/>
            <sf:errors path="ho"/>
        </div>
    </div>
    <div>
        <label>Giới tính</label>
        <div class="col-sm-10">
            <sf:input path="gioiTinh" class="form-control"/>
            <sf:errors path="gioiTinh"/>
        </div>
    </div>
    <div>
        <label>Ngày sinh</label>
        <div class="col-sm-10">
            <sf:input path="ngaySinh" class="form-control"/>
            <sf:errors path="ngaySinh"/>
        </div>
    </div>

    <div>
        <label>Địa chỉ</label>
        <div class="col-sm-10">
            <sf:input path="diaChi" class="form-control"/>
            <sf:errors path="diaChi"/>
        </div>
    </div>
    <div>
        <label>Số điện thoại</label>
        <div class="col-sm-10">
            <sf:input path="sdt" class="form-control"/>
            <sf:errors path="sdt"/>
        </div>
    </div>
    <div>
        <label>Mật khẩu</label>
        <div class="col-sm-10">
            <sf:input path="matKhau" class="form-control"/>
            <sf:errors path="matKhau"/>
        </div>
    </div>

    <div>
        <label>Trạng thái</label>
        <div class="col-sm-10">
            <sf:input path="trangThai" class="form-control"/>
            <sf:errors path="trangThai"/>
        </div>
    </div>
    <br>

    <div>
        <label>Cửa Hàng</label>
        <div class="col-sm-10">
                <sf:select path="cuaHang"  class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                    <c:forEach  items="${listCh}" var="cuaHang">
                        <sf:option value="${cuaHang.id}">${cuaHang.ten}</sf:option>
                    </c:forEach>
                </sf:select>

        </div>
    </div>

    <div>
        <label>Chức vụ</label>
        <div class="col-sm-10">
            <sf:select path="chucVu"  class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                <c:forEach  items="${listCv}" var="chucVu">
                    <sf:option value="${chucVu.id}">${chucVu.ten}</sf:option>
                </c:forEach>
            </sf:select>

        </div>
    </div>
    <br>
    <div>
        <button type="submit" class="btn btn-outline-success" >Thêm mới</button>
        <button type="submit"  class="btn btn-outline-success">Update</button>
    </div>
</sf:form>

    </div>
</body>
</html>