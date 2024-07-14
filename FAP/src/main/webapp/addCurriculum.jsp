<%@page import="daos.SpecializationDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Curriculum</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <style>
            body {
                background: url('./img/background_homepage.jpg') no-repeat center center fixed;
                background-size: cover;
                color: #f1f1f1;
                padding-top: 50px;
            }

            h1 {
                margin-bottom: 30px;
                color: #fff;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6);
            }

            .card {
                background: rgba(255, 255, 255, 0.9);
                border: none;
                border-radius: 15px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                margin: 0 auto;
                max-width: 600px;
                padding: 20px;
            }

            .form-group label {
                font-weight: bold;
                color: #333;
            }

            .form-control {
                border-radius: 5px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            .form-control:focus {
                border-color: #2575fc;
                box-shadow: 0 0 0 0.2rem rgba(37, 117, 252, 0.25);
            }

            .invalid-feedback {
                color: #dc3545;
            }

            .btn-primary {
                background-color: #2575fc;
                border: none;
                border-radius: 50px;
                padding: 10px 20px;
                font-size: 1em;
                font-weight: bold;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            .btn-primary:hover {
                background-color: #1a5bb8;
                transform: scale(1.05);
            }

            .btn-primary:focus {
                box-shadow: 0 0 0 0.2rem rgba(37, 117, 252, 0.5);
            }

            .btn-primary:active {
                background-color: #1a5bb8;
                transform: scale(1);
            }

            .container {
                max-width: 1000px;
            }

            .row.mb-3 {
                margin-top: 30px;
            }

            .card-body {
                padding: 30px;
            }

            .btn-lg {
                padding: 12px 24px;
            }
        </style>
    </head>

    <%
        SpecializationDAO s = new SpecializationDAO();
        request.setAttribute("specializationList", s.getAllList());
    %>

    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="CurriculumController" id="addCurriculumForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1 class="text-center">Add Curriculum</h1>
                    <div class="form-group">
                        <label for="curriculumID">Curriculum ID</label>
                        <input type="text" class="form-control" name="curriculumID" id="curriculumID"
                               value="${requestScope.curriculum.curriculumID}">
                        <div class="invalid-feedback"></div>
                    </div>
                    <div class="form-group">
                        <label for="curriculumName">Curriculum Name</label>
                        <input type="text" class="form-control" name="curriculumName" id="curriculumName"
                               value="${requestScope.curriculum.curriculumName}" required>
                        <div class="invalid-feedback"></div>
                    </div>
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
                    <div class="row mb-3 justify-content-center">
                        <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                        <span class="col-md-1"></span>
                        <a class="btn btn-primary btn-lg col-md-3" href="CurriculumController" role="button">Back to Curriculum list</a>
                        <span class="col-md-1"></span>
                        <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
                    </div>
                </div>
            </div>
        </form>

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXlDw5TnP12MjAeu5RsENQGnZ4py+6kQmA8AKOzwi3BIi+d2DCtwIk8p2KUE" crossorigin="anonymous">
        </script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.min.js"></script>
        <script>
                    $(document).ready(function () {
                        $.validator.addMethod("noNumbers", function (value, element) {
                            return this.optional(element) || /^[A-Za-z\s]+$/.test(value);
                        }, "Field must not contain numbers.");

                        $.validator.addMethod("numbersOnly", function (value, element) {
                            return this.optional(element) || /^\d+$/.test(value);
                        }, "Field must contain only numbers.");

                        $('#addCurriculumForm').validate({
                            rules: {
                                curriculumID: {
                                    required: true,
                                    maxlength: 30
                                },
                                curriculumName: {
                                    required: true,
                                    maxlength: 255
                                }
                            },
                            messages: {
                                curriculumID: {
                                    required: "Please enter the curriculum ID.",
                                    maxlength: "Curriculum ID must be less than or equal to 30 characters."
                                },
                                curriculumName: {
                                    required: "Please enter the curriculum name.",
                                    maxlength: "Curriculum Name must be less than or equal to 255 characters."
                                }
                            },
                            errorPlacement: function (error, element) {
                                error.addClass('invalid-feedback');
                                element.closest('.form-group').append(error);
                            },
                            highlight: function (element, errorClass, validClass) {
                                $(element).addClass('is-invalid').removeClass('is-valid');
                            },
                            unhighlight: function (element, errorClass, validClass) {
                                $(element).addClass('is-valid').removeClass('is-invalid');
                            }
                        });
                    });
        </script>
    </body>

</html>
