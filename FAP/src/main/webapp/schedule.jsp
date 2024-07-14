<%-- 
    Document   : schedule
    Created on : Jul 6, 2024, 6:21:09 PM
    Author     : Khanh
--%>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Schedule Management</title>
            <link rel="stylesheet"
                  href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
                  integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
                  crossorigin="anonymous">

        </head>

        <body>
            <h1>Manage Schedule</h1>
            <div class="d-flex justify-content-between mb-3">
                <a name="" id="" class="btn btn-primary" href="ScheduleController?check=add" role="button">Add Schedule</a>
                <a class="btn btn-primary" href="./" role="button">Back to Manage list</a>
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-hover table-borderless table-primary align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>Schedule ID</th>
                            <th>Group Subject ID</th>
                            <th>Start date</th>
                            <th>End date</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <c:forEach var="item" items="${requestScope.scheduleList}">
                            <tr class="table-primary">
                                <td scope="row">${item.scheduleID}</td>
                                <td>${item.groupSubjectID}</td>
                                <td>${item.startDate}</td>
                                <td>${item.endDate}</td>
                                <td><a class="btn btn-primary" href="ScheduleController?id=${item.scheduleID}&check=edit"
                                       role="button">Edit</a>
                                    <a class="btn btn-primary"
                                       href="ScheduleController?id=${item.scheduleID}&check=delete"
                                       role="button">Delete</a>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>

                    </tfoot>
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
