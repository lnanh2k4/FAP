<%-- 
    Document   : addSchedule
    Created on : Jul 6, 2024, 6:27:30 PM
    Author     : Khanh
--%>

<%@page import="daos.GroupSubjectDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Schedule</title>
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
        GroupSubjectDAO s = new GroupSubjectDAO();
        request.setAttribute("groupSubjectList", s.getAllList());
    %>
    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="ScheduleController" form="ScheduleForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Schedule</h1>
                    <div class="form-group">
                        <label for="groupSubjectID">Group Subject ID</label>
                        <select class="form-control" name="groupSubjectID" id="groupSubjectID" required>
                            <c:forEach var="item" items="${requestScope.groupSubjectList}">
                                <option value="${item.groupSubjectID}">${item.groupSubjectID}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" class="form-control" name="startDate" id="startDate" required>

                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" class="form-control" name="endDate" id="endDate" required>

                    </div>
                </div>
                <div class="container">
                    <div class="row mb-3 justify-content-center">
                        <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                        <span class="col-md-1"></span>
                        <a class="btn btn-primary btn-lg col-md-3" href="ScheduleController" role="button">Back to Schedule list</a>
                        <span class="col-md-1"></span>
                        <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
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
        <script src="./js/jquery-3.7.1.js"></script>
        <script src="./js/jquery.validate.js"></script>
        <script src="./js/additional-methods.js"></script>
        <script>
            $(document).ready(function () {
                $.validator.addMethod("greaterThan", function (value, element, params) {
                    if (!/Invalid|NaN/.test(new Date(value))) {
                        return new Date(value) > new Date($(params).val());
                    }
                    return isNaN(value) && isNaN($(params).val()) || (Number(value) > Number($(params).val()));
                }, 'Must be greater than {0}.');

                $("#scheduleForm").validate({
                    rules: {
                        groupSubjectID: {
                            required: true,
                        },
                        startDate: {
                            required: true,
                            date: true,
                        },
                        endDate: {
                            required: true,
                            date: true,
                            greaterThan: "#startDate"
                        }
                    },
                    messages: {
                        groupSubjectID: {
                            required: "Please select groupSubject ID",
                        },
                        startDate: {
                            required: "Please enter start date",
                        },
                        endDate: {
                            required: "Please enter end date",
                            greaterThan: "End date must be after start date"
                        }
                    }
                });
            });
        </script>

    </body>

</html>

