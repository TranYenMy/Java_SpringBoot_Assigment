<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <label>Tên sản phẩm</label>
            <div class="col-sm-10">
                <sf:select path="sanPham"  class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                    <c:forEach  items="${listSp}" var="sanPham">
                        <sf:option value="${sanPham.id}">${sanPham.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>
        <div>
            <label>Nhà sản xuất</label>
            <div class="col-sm-10">
                <sf:select path="nsx"  class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                    <c:forEach  items="${listNsx}" var="nsx">
                        <sf:option value="${nsx.id}">${nsx.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>



        <div>
            <label>Màu sắc</label>
            <div class="col-sm-10">
                <sf:select path="mauSac"  class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                    <c:forEach  items="${listMs}" var="mauSac">
                        <sf:option value="${mauSac.id}">${mauSac.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>

        <div>
            <label>Dòng sản phẩm</label>
            <div class="col-sm-10">
                <sf:select path="dongSp"  class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                    <c:forEach  items="${listDongSp}" var="dongSp">
                        <sf:option value="${dongSp.id}">${dongSp.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>


        <div>
            <label>Năm bảo hành</label>
            <div class="col-sm-10">
                <sf:input path="namBH" class="form-control"/>
                <sf:errors path="namBH" cssClass="err"/>
            </div>
        </div>
        <div>
            <label>Mô tả</label>
            <div class="col-sm-10">
                <sf:input path="moTa" class="form-control"/>
                <sf:errors path="moTa" cssClass="err"/>
            </div>
        </div>

        <div>
            <label>Số lượng tồn</label>
            <div class="col-sm-10">
                <sf:input path="soLuongTon" class="form-control"/>
                <sf:errors path="soLuongTon" cssClass="err"/>
            </div>
        </div>

        <div>
            <label>Giá nhập</label>
            <div class="col-sm-10">
                <sf:input path="giaNhap" class="form-control"/>
                <sf:errors path="giaNhap" cssClass="err"/>
            </div>
        </div>


        <div>
            <label>Giá bán</label>
            <div class="col-sm-10">
                <sf:input path="giaBan" class="form-control"/>
                <sf:errors path="GiaBan" cssClass="err"/>
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