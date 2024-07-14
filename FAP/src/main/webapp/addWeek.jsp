<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="daos.SemesterDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Week</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css">
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
        SemesterDAO s = new SemesterDAO();
        request.setAttribute("semesterList", s.getAllList());
    %>
    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="WeekController" id="weekForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Week</h1>
                    <div class="form-group">
                        <label for="semesterID">Semester ID</label>
                        <select class="form-control" name="semesterID" id="semesterID" required>
                            <c:forEach var="item" items="${requestScope.semesterList}">
                                <option value="${item.semesterID}">${item.semesterID}</option>
                            </c:forEach>
                        </select>
                        <div class="invalid-feedback">
                            Semester ID is required.
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="text" class="form-control" name="startDate" id="startDate" placeholder="6/2" required>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="text" class="form-control" name="endDate" id="endDate" placeholder="12/2" required>
                    </div>
                </div>
                <div class="container">
                    <div class="row mb-3 justify-content-center">
                        <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                        <span class="col-md-1"></span>
                        <a class="btn btn-primary btn-lg col-md-3" href="WeekController" role="button">Back to Week list</a>
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
            $("#weekForm").validate({
            rules: {
            semesterID: {
            required: true
            },
                    startDate: {
                    required: true,
                            date: true
                    },
                    endDate: {
                    required: true,
                            date: true
                    }
            },
                    messages: {
                    semesterID: {
                    required: "Please select a semester ID"
                    },
                            startDate: {
                            required: "Please input start date",
                                    date: "Please enter a valid date"
                            },
                            endDate: {
                            required: "Please input end date",
                                    date: "Please enter a valid date"
                            }
                    },
                    errorClass: "invalid-feedback",
                    validClass: "valid-feedback",
                    highlight: function (element, errorClass, validClass) {
                    $(element).addClass("is-invalid").removeClass("is-valid");
                    },
                    unhighlight: function (element, errorClass, validClass) {
                    $(element).removeClass("is-invalid").addClass("is-valid");
                    },
                    errorPlacement: function (error, element) {
                    if (element.prop("tagName") === "SELECT" || element.prop("type") === "date") {
                    error.insertAfter(element.parent());
                    } else {
                    error.insertAfter(element);
                    }
                    }
            submitHandler: function(form) {
            var startDate = new Date($("#startDate").val());
                    var endDate = new Date($("#endDate").val());
                    if (endDate < startDate) {
            alert("End Date cannot be before Start Date.");
            } else {
            form.submit();
            }
            }
            });
        </script>
    </body>

</html>
