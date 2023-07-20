<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - Thêm mới Cửa hàng</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="container">

<sf:form action="${ action }" method="post"
         modelAttribute="data">
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


    <br>
    <div>
        <button type="submit" class="btn btn-outline-success">Add</button>
        <button type="submit" class="btn btn-outline-success"> Update</button>
    </div>
</sf:form>
</div>

</body>
</html>