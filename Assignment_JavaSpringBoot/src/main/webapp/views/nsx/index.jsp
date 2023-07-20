<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý nhà sản xuất</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

</head>
<body>
<div class="container">
    <h2 style="text-align: center; color: black; font-family: SansSerif">Quản lý nhà sản xuất</h2>
    <table class="table table-striped">
        <br/>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>

            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="nsx" varStatus="viTri">
            <tr>
                <td>${viTri.index + 1}</td>
                <td>${nsx.id}</td>
                <td>${nsx.ma}</td>
                <td>${nsx.ten}</td>

                <td>
                    <a href="/nsx/delete/${nsx.id}" class="btn btn-outline-success" onclick="getConfirmDelete()">Delete</a>
                    <a href="/nsx/edit/${nsx.id}" class="btn btn-outline-success" >Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <a href="/nsx/create" type="button" class="btn btn-outline-success">Add</a>

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