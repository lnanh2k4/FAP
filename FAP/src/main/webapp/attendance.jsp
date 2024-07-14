<%-- 
    Document   : attendance
    Created on : Jul 7, 2024, 6:21:09 PM
    Author     : Khanh
--%>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Attendance Management</title>
            <link rel="stylesheet"
                  href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
                  integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
                  crossorigin="anonymous">
        </head>

        <body>
            <h1>Manage Attendance</h1>
            <div class="d-flex justify-content-between mb-3">
                <div>
                    <a name="" id="" class="btn btn-primary me-2" href="AttendanceController?check=add" role="button">Add Attendance</a>
                    <a name="" id="" class="btn btn-primary me-2" href="AttendanceController?action=attendAll&scheduleDetailID=${scheduleDetailID}" role="button">Mark All Present</a>
                    <a name="" id="" class="btn btn-danger me-2" href="AttendanceController?action=absentAll&scheduleDetailID=${scheduleDetailID}" role="button">Mark All Absent</a>
                </div>
                <div>
                    <a class="btn btn-primary" href="./" role="button">Back to Manage list</a>
                </div>
            </div>
            <div class="table-responsive">
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
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <c:forEach var="item" items="${requestScope.attendanceList}">
                            <tr class="table-primary">
                                <td scope="row">${item.attendanceID}</td>
                                <td>${item.scheduleDetailID}</td>
                                <td>${item.userID}</td>
                                <td>${item.state}</td>
                                <td>${item.comment}</td>
                                <td>${item.note}</td>
                                <td>${item.status}</td>
                                <<td>
                                    <a class="btn btn-primary" href="AttendanceController?attendanceName=${item.attendanceName}&scheduleDetailID=${item.scheduleDetailID}&userID=${item.userID}&check=present" role="button">Present</a>
                                    <a class="btn btn-primary" href="AttendanceController?attendanceName=${item.attendanceName}&scheduleDetailID=${item.scheduleDetailID}&userID=${item.userID}&check=absent" role="button">absent</a>
                                    <a class="btn btn-primary" href="AttendanceController?attendanceName=${item.attendanceName}&scheduleDetailID=${item.scheduleDetailID}&userID=${item.userID}&check=edit" role="button">Edit</a>
                                    <a class="btn btn-primary" href="AttendanceController?attendanceName=${item.attendanceName}&scheduleDetailID=${item.scheduleDetailID}&userID=${item.userID}&check=delete" role="button">Delete</a>
                                </td>
                            </tr>
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
</html>
