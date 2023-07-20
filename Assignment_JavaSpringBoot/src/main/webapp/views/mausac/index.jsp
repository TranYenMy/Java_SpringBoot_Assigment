<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý màu sắc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

</head>
<body>
<div class="container">
    <h2 style="text-align: center; color: black; font-family: SansSerif">Quản lý màu sắc</h2>
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
        <c:forEach items="${list}" var="cv" varStatus="viTri">
            <tr>
                <td>${viTri.index + 1}</td>
                <td>${cv.id}</td>
                <td>${cv.ma}</td>
                <td>${cv.ten}</td>

                <td>
                    <a href="/mau-sac/delete/${cv.id}" class="btn btn-outline-success" >Delete</a>
                    <a href="/mau-sac/edit/${cv.id}" class="btn btn-outline-success" >Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/mau-sac/create" type="button" class="btn btn-outline-success">Add</a>
    <c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
            ${error}
    </div>
</c:if>
</div>
</body>
</html>