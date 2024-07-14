<%@page import="daos.SpecializationDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Curriculum</title>
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
        <form class="row g-3 needs-validation" novalidate method="post" action="CurriculumController" id="editCurriculumForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="edit" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Edit Curriculum</h1>
                    <div class="form-group">
                        <label for="curriculumID">Curriculum ID</label>
                        <input type="text" class="form-control" name="curriculumID" id="curriculumID"
                               value="${requestScope.curriculum.curriculumID}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="curriculumName">Curriculum Name</label>
                        <input type="text" class="form-control" name="curriculumName" id="curriculumName"
                               value="${requestScope.curriculum.curriculumName}" required>
                        <div class="invalid-feedback">
                        </div>
                    </div>
                    <div class="card">
                        <div class="form-group">
                            <label for="majorID">Specialization ID</label>
                            <select class="form-control" name="specializationID" id="specializationID">
                                <c:forEach var="item" items="${requestScope.specializationList}">
                                    <option value="${item.specializationID}">${item.specializationID}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <button type="submit" class="btn btn-primary btn-lg col-md-5">Save</button>
                        <span class="col-md-2"></span>
                        <a class="btn btn-primary col-md-5" href="CurriculumController" role="button">Back to Curriculum List</a>
                    </div>
                </div>
            </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXlDw5TnP12MjAeu5RsENQGnZ4py+6kQmA8AKOzwi3BIi+d2DCtwIk8p2KUE"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.min.js"></script>
        <script>
            $(document).ready(function () {
                $.validator.addMethod("noNumbers", function (value, element) {
                    return this.optional(element) || /^[A-Za-z\s]+$/.test(value);
                }, "Field must not contain numbers.");

                $('#editCurriculumForm').validate({
                    rules: {
                        curriculumName: {
                            required: true,
                           maxlenght : 255
                        }
                    },
                    messages: {
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
