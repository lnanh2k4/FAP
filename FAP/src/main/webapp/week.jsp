<%-- Document : major Created on : Jul 4, 2024, 10:49:00 AM Author : mrmas --%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Week Management</title>
                <link rel="stylesheet"
                    href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
                    integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
                    crossorigin="anonymous">

            </head>

            <body>
                <h1>Manage Week</h1>
                <a name="" id="" class="btn btn-primary" href="WeekController?check=add" role="button">Add Week</a>
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-borderless table-primary align-middle">
                        <thead class="table-light">
                            <tr>
                                <th>Week ID</th>
                                <th>Semester ID</th>
                                <th>Start date</th>
                                <th>End date</th>
                                <th colspan="2">Action</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach var="item" items="${requestScope.weekList}">
                                <tr class="table-primary">
                                    <td scope="row">${item.weekID}</td>
                                    <td>${item.semesterID.semesterID}</td>
                                    <td>${item.startDate}</td>
                                    <td>${item.endDate}</td>
                                    <td><a class="btn btn-primary" href="WeekController?id=${item.weekID}&check=edit"
                                            role="button">Edit</a>
                                        <a class="btn btn-primary"
                                            href="WeekController?id=${item.weekID}&check=delete"
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