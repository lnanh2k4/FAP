<%-- Document : user Created on : Jul 15, 2024, 1:42:07 AM Author : CE181767 - Le Nhut Anh --%>

<%@page import="models.User"%>
<%@page import="daos.UserDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage User</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
              crossorigin="anonymous">

    </head>
    <body>
        <h1>Manage User</h1>
        <div class="d-flex justify-content-between mb-3">
            <a name="" id="" class="btn btn-primary" href="UserController?check=add" role="button">Add User</a>
            <a class="btn btn-primary" href="./" role="button">Back to Manage list</a>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-borderless table-primary align-middle">
                <thead class="table-light">
                    <tr>
                        <c:if test="${sessionScope.user.role==3}">
                            <th>UserID</th>
                            </c:if>
                            <c:if test="${sessionScope.user.role==2}">
                            <th>Roll Number</th>
                            </c:if>
                        <th>Full Name</th>
                        <th>Sex</th>
                        <th>Phone</th>
                        <th>Role</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <c:forEach var="item" items="${requestScope.userList}">
                        <c:choose>
                            <c:when test="${sessionScope.user.role==3}">
                                <tr class="table-primary">
                                    <td scope="row">${item.userID}</td>
                                    <td>${item.lastName} ${item.firstName}</td>
                                    <c:choose>
                                        <c:when test="${item.sex==0}">
                                            <td>Female</td>
                                        </c:when>
                                        <c:when test="${item.sex==1}">
                                            <td>Male</td>
                                        </c:when>
                                    </c:choose>

                                    <td>${item.phone}</td>
                                    <c:choose>
                                        <c:when test="${item.role==0}">
<td>Student</td>
                                        </c:when>
                                        <c:when test="${item.role==1}">
                                            <td>Lecturer</td>
                                        </c:when>

                                        <c:when test="${item.role==2}">
                                            <td>Academic Staff</td>
                                        </c:when>
                                        <c:when test="${item.role==3}">
                                            <td>Administrator</td>
                                        </c:when>
                                    </c:choose>
                                    <td><a class="btn btn-primary" href="UserController?id=${item.userID}&check=detail"
                                           role="button">Detail</a>
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${item.role==0}">
                                    <tr class="table-primary">
                                        <td scope="row">${item.userID}</td>
                                        <td>${item.lastName} ${item.firstName}</td>
                                        <c:choose>
                                            <c:when test="${item.sex==0}">
                                                <td>Female</td>
                                            </c:when>
                                            <c:when test="${item.sex==1}">
                                                <td>Male</td>
                                            </c:when>
                                        </c:choose>

                                        <td>${item.phone}</td>
                                        <c:choose>
                                            <c:when test="${item.role==0}">
                                                <td>Student</td>
                                            </c:when>
                                            <c:when test="${item.role==1}">
                                                <td>Lecturer</td>
                                            </c:when>

                                            <c:when test="${item.role==2}">
                                                <td>Academic Staff</td>
                                            </c:when>
                                            <c:when test="${item.role==3}">
                                                <td>Administrator</td>
                                            </c:when>
                                        </c:choose>
                                        <td><a class="btn btn-primary" href="UserController?id=${item.userID}&check=detail"
                                               role="button">Detail</a>
</td>
                                    </tr>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tbody>
            </table>
        </div>


        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    </body>

</html>