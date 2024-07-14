<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="daos.MajorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Specialization</title>
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
            .btn-danger {
                background-color: #dc3545; /* Màu nền đỏ */
                border: none;
                border-radius: 25px; /* Bo tròn các góc của nút */
                padding: 10px 20px; /* Thay đổi kích thước của nút */
                font-size: 16px; /* Thay đổi kích thước chữ của nút */
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Thêm hiệu ứng đổ bóng */
                transition: background-color 0.3s ease, box-shadow 0.3s ease; /* Hiệu ứng chuyển tiếp */
            }

            .btn-danger:hover {
                background-color: #c82333; /* Màu nền khi di chuột qua nút */
                box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2); /* Hiệu ứng đổ bóng khi di chuột qua */
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

            .row {
                margin-top: 20px;
            }
            p {
                color: #dc3545; /* Màu chữ */
                font-size: 16px; /* Kích thước phông chữ */
                line-height: 1.6; /* Chiều cao dòng */
                margin-bottom: 15px; /* Khoảng cách dưới */
            }
        </style>
    </head>
    <%
        MajorDAO s = new MajorDAO();
        request.setAttribute("majorList", s.getAllList());
    %>
    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="SpecializationController" id="addSpecializationForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Specialization</h1>
                    <div class="form-group">
                        <label for="specializationID">Specialization ID</label>
                        <input type="text" class="form-control" name="specializationID" id="specializationID"
                               >
                        <div class="invalid-feedback">

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="specializationName">Specialization Name</label>
                        <input type="text" class="form-control" name="specializationName" id="specializationName" required maxlength="30">
                        <div class="invalid-feedback">

                        </div>
                    </div>

                    <div class="card">
                        <div class="form-group">
                            <label for="majorID">Major ID</label>
                            <select class="form-control" name="majorID" id="majorID">
                                <c:forEach var="item" items="${requestScope.majorList}">
                                    <option value="${item.majorID}">${item.majorID}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <p class="errorAddSpecialization">${requestScope.errorAddSpecialization}</p>
                    <div class="container">
                        <div class="row mb-3 justify-content-center">
                            <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                            <span class="col-md-1"></span>
                            <a class="btn btn-primary btn-lg col-md-3" href="SpecializationController" role="button">Back to Specialization list</a>
                            <span class="col-md-1"></span>
                            <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
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

                $('#addSpecializationForm').validate({
                    rules: {
                        specializationID: {
                            required: true,
                            maxlength: 2,
                            noNumbers: true
                        },
                        specializationName: {
                            required: true,
                            maxlength: 30
                           
                        }
                    },
                    messages: {
                        specializationID: {
                            required: "Please enter the specialization ID.",

                            noNumbers: "Specialization ID must be a word"
                        },
                        specializationName: {
                            required: "Please enter the specialization name."

                           
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
