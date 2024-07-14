<%-- 
    Document   : group
    Created on : Jul 7, 2024, 3:41:46 PM
    Author     : Khanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group Management</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    </head>

    <body>
        <h1>Manage Group</h1>
        <div class="d-flex justify-content-between mb-3">
            <a name="" id="" class="btn btn-primary" href="GroupController?check=add" role="button">Add Group</a>
            <a class="btn btn-primary" href="./" role="button">Back to Manage list</a>
        </div>
        <div class="table-responsive mt-3">
            <table class="table table-striped table-hover table-borderless table-primary align-middle">
                <thead class="table-light">
                    <tr>
                        <th>Group ID</th>
                        <th>Group Name</th>
                        <th>Semester ID</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <c:choose>
                        <c:when test="${not empty requestScope.groupList}">
                            <c:forEach var="item" items="${requestScope.groupList}">
                                <tr class="table-primary">
                                    <td scope="row">${item.groupID}</td>
                                    <td>${item.groupName}</td>
                                    <td>${item.semesterID.semesterID}</td>
                                    <td>
                                        <a class="btn btn-primary" href="GroupController?groupID=${item.groupID}&check=edit" role="button">Edit</a>
                                        <a class="btn btn-primary" href="GroupController?groupID=${item.groupID}&check=delete" role="button">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="4">No groups available</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
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
