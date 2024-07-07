<%-- 
    Document   : attendance
    Created on : Jul 6, 2024, 6:33:26 PM
    Author     : Khanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance Management</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    </head>

    <body>
        <div class="container">
            <h1>Manage Attendance</h1>
            <a name="" id="" class="btn btn-primary" href="AttendanceController?check=add" role="button">Add Attendance</a>
            <div class="table-responsive mt-3">
                <table class="table table-striped table-hover table-borderless table-primary align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>Attendance ID</th>
                            <th>Schedule Detail ID</th>
                            <th>User ID</th>
                            <th>State</th>
                            <th>Comment</th>
                            <th>Note</th>
                            <th>Status</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody class="table-attendance-divider">
                        <c:forEach var="item" items="${requestScope.attendanceList}">
                            <tr class="table-primary">
                                <td scope="row">${item.attendanceID}</td>
                                <td>${item.attendanceName}</td>
                                <td>${item.semesterID}</td>
                                <td>${item.status}</td>
                                <td>
                                    <a class="btn btn-primary" href="AttendanceController?attendanceName=${item.attendanceName}&scheduleDetailID=${item.scheduleDetailID}&userID=${item.userID}&check=edit" role="button">Edit</a>
                                    <a class="btn btn-primary" href="AttendanceController?attendanceName=${item.attendanceName}&scheduleDetailID=${item.scheduleDetailID}&userID=${item.userID}&check=delete" role="button">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    </body>

</html>