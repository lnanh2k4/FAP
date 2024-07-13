<%@page import="daos.SpecializationDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Specialization</title>
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
        SpecializationDAO s = new SpecializationDAO();
        request.setAttribute("specializationList", s.getAllList());
    %>
    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="CurriculumController">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Curriculum</h1>
                    <div class="form-group">
                        <label for="curriculumID">Curriculum ID</label>
                        <input type="text" class="form-control" name="curriculumID" id="curriculumID"
                               value="${requestScope.curriculum.curriculumID}" required maxlength="2">
                        <div class="invalid-feedback">

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="curriculumName">Curriculum Name</label>
                        <input type="text" class="form-control" name="curriculumName" id="curriculumName" 
                               value="${requestScope.curriculum.curriculumName}">
                    </div>

                    <div class="card">
                        <div class="form-group">
                            <label for="specializationID">Specialization ID</label>
                            <select class="form-control" name="specializationID" id="specializationID">
                                <c:forEach var="item" items="${requestScope.specializationList}">
                                    <option value="${item.specializationID}">${item.specializationID}</option>
                                </c:forEach>
                            </select>
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
        <script>
            // JavaScript for disabling form submissions if there are invalid fields
            (function () {
                'use strict';

                window.addEventListener('load', function () {
                    var forms = document.getElementsByClassName('needs-validation');
                    var validation = Array.prototype.filter.call(forms, function (form) {
                        form.addEventListener('submit', function (event) {
                            if (form.checkValidity() === false) {
                                event.preventDefault();
                                event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                        }, false);
                    });
                }, false);
            })();
        </script>
    </body>

</html>