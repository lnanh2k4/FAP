<%-- 
    Document   : addGroup
    Created on : Jul 7, 2024, 3:41:54 PM
    Author     : Khanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="daos.SemesterDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Group</title>
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
        SemesterDAO s = new SemesterDAO();
        request.setAttribute("semesterList", s.getAllList());
    %>
    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="GroupController" form="groupController">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Group</h1>
                    <div class="form-group">
                        <label for="semesterID">Semester ID</label>
                        <select class="form-control" name="semesterID" id="semesterID">
                            <c:forEach var="item" items="${requestScope.semesterList}">
                                <option value="${item.semesterID}">${item.semesterID}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="groupName">Group Name</label>
                        <input type="text" class="form-control" name="groupName" id="groupName" placeholder="  ">
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
        <script src="./js/jquery-3.7.1.js"></script>
        <script src="./js/jquery.validate.js"></script>
        <script src="./js/additional-methods.js"></script>
        <script>
            $(document).ready(function () {
                $("#groupController").validate({
                    rules: {
                        semesterID {
                            required: true,
                        },
                        groupName {
                            required: true,
                            rangelength: [1, 15]
                        },
                        
                    },
                    messages: {
                        semesterID {
                            required: "Please select semester ID",
                        },
                        groupName {
                            required: "Please enter group name",
                            rangelength: "Group name must be letter between 1 and 15"
                        },
                    }
                });
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
            });
        </script>
    </body>

</html>
