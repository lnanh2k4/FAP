<%@page import="daos.YearDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Semester</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <style>
            .invalid-feedback {
                display: none;
            }

            .was-validated .invalid-feedback {
                display: block;
            }
        </style>
    </head>
    <%
        YearDAO s = new YearDAO();
        request.setAttribute("yearList", s.getAllList());
    %>
    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="SemesterController">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Semester</h1>
                    <div class="form-group">
                        <label for="semesterID">Year ID</label>
                        <select class="form-control" name="semesterID" id="semesterID">
                            <c:forEach var="item" items="${requestScope.yearList}">
                                <option value="${item.yearID}">${item.yearID}</option>
                            </c:forEach>
                        </select>
                        <div class="form-group">
                            <label for="semesterName">Semester Name</label>
                            <input type="text" class="form-control" name="semesterName" id="semesterName" placeholder="Spring 2023  ">
                        </div>
                        <div class="form-group">
                            <label for="startDate">Start Date</label>
                            <input type="text" class="form-control" name="startDate" id="startDate" placeholder="6/2">
                        </div>
                        <div class="form-group">
                            <label for="endDate">End Date</label>
                            <input type="text" class="form-control" name="endDate" id="endDate" placeholder="12/2">
                        </div>

                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <button type="submit" class="btn btn-primary btn-lg col-md-5">Save</button>
                        <span class="col-md-2"></span>
                        <button type="reset" class="btn btn-primary btn-lg col-md-5">Reset</button>
                    </div>
                </div>
            </div>
        </form>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    </body>

</html>
