<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - Thêm mới Khách Hàng</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<sf:form action="${action}" method="post"
         modelAttribute="data" cssClass="container">
    <div>
        <label>Mã</label>
        <div class="col-sm-10">
            <sf:input path="ma" class="form-control"/>
            <sf:errors path="ma" cssClass="err"/>
        </div>
    </div>
    <div>
        <label>Tên</label>
        <div class="col-sm-10">
            <sf:input path="ten" class="form-control"/>
            <sf:errors path="ten" cssClass="err"/>
        </div>
    </div>
    <div>
        <label>Tên đệm</label>
        <div class="col-sm-10">
            <sf:input path="tenDem" class="form-control"/>
            <sf:errors path="tenDem" cssClass="err"/>
        </div>
    </div>
    <div>
        <label>Họ</label>
        <div class="col-sm-10">
            <sf:input path="ho" class="form-control"/>
            <sf:errors path="ho" cssClass="err"/>
        </div>
    </div>

    <div>
        <label>Ngày sinh</label>
        <div class="col-sm-10">
            <sf:input path="ngaySinh" class="form-control"/>
            <sf:errors path="ngaySinh" cssClass="err"/>
        </div>
    </div>
    <div>
        <label>Số điện thoại</label>
        <div class="col-sm-10">
            <sf:input path="sdt" class="form-control"/>
            <sf:errors path="sdt" cssClass="err"/>
        </div>
    </div>
    <div>
        <label>Địa chỉ</label>
        <div class="col-sm-10">
            <sf:input path="diaChi" class="form-control"/>
            <sf:errors path="diaChi" cssClass="err"/>
        </div>
    </div>
    <div>
        <label>Thành Phố</label>
        <div class="col-sm-10">
            <sf:input path="thanhPho" class="form-control"/>
            <sf:errors path="thanhPho" cssClass="err"/>
        </div>
    </div>
    <div>
        <label>Quốc Gia</label>
        <div class="col-sm-10">
            <sf:input path="quocGia" class="form-control"/>
            <sf:errors path="quocGia" cssClass="err"/>
        </div>
    </div>

    <div>
        <label class="col-sm-10">Mật khẩu</label>
        <div>
            <sf:input path="matKhau" class="form-control"/>
            <sf:errors path="matKhau" cssClass="err"/>
        </div>
    </div>


    <br>
    <div>
        <button type="submit" class="btn btn-outline-success">Add</button>
        <button type="submit" class="btn btn-outline-success">Update</button>
    </div>
</sf:form>
</body>
</html>