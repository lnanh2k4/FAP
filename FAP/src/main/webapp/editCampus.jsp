<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Campus</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
    <style>
        body {
            background: url('./img/background_homepage.jpg') no-repeat center center fixed; /* Hình nền trang */
            background-size: cover; /* Phủ kín toàn bộ viewport */
            color: #f1f1f1; /* Màu chữ nhạt cho văn bản */
            padding-top: 50px; /* Khoảng cách cho navbar cố định */
        }

        h1 {
            margin-bottom: 30px;
            color: #1a5bb8; /* Màu chữ tiêu đề, ví dụ màu đỏ đậm */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6); /* Bóng chữ cho tiêu đề */
            text-align: center; /* Căn giữa tiêu đề */
        }

        .card {
            background: rgba(255, 255, 255, 0.9); /* Nền thẻ trắng với độ trong suốt */
            border: none; /* Xóa đường viền mặc định */
            border-radius: 15px; /* Bo góc cho thẻ */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Hiệu ứng bóng cho thẻ */
            margin: 0 auto; /* Căn giữa thẻ */
            max-width: 600px; /* Đặt chiều rộng tối đa */
            padding: 20px; /* Thêm padding bên trong thẻ */
        }

        .form-group label {
            font-weight: bold;
            color: #333; /* Màu chữ tối hơn cho nhãn */
        }

        .form-control {
            border-radius: 5px; /* Bo góc cho các trường nhập liệu */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Hiệu ứng bóng cho các trường nhập liệu */
        }

        .form-control:focus {
            border-color: #e94e77; /* Đổi màu đường viền khi trường được chọn */
            box-shadow: 0 0 0 0.2rem rgba(233, 78, 119, 0.25); /* Hiệu ứng bóng khi trường được chọn */
        }

        .btn-primary {
            background-color: #2575fc; /* Màu xanh dương cho nút chính */
            border: none;
            border-radius: 50px; /* Bo góc cho nút */
            padding: 10px 20px; /* Tăng kích thước nút */
            font-size: 1em; /* Kích thước chữ trong nút */
            font-weight: bold; /* Chữ đậm */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Hiệu ứng chuyển màu và phóng to khi hover */
        }

        .btn-primary:hover {
            background-color: #1a5bb8; /* Màu nền khi hover */
            transform: scale(1.05); /* Phóng to nút khi hover */
        }

        .btn-primary:focus {
            box-shadow: 0 0 0 0.2rem rgba(37, 117, 252, 0.5); /* Hiệu ứng bóng khi nút được chọn */
        }

        .btn-primary:active {
            background-color: #1a5bb8; /* Màu nền khi nhấn */
            transform: scale(1); /* Đặt lại kích thước nút khi nhấn */
        }

        .btn-lg {
            padding: 12px 24px; /* Tăng kích thước nút */
        }

        .container {
            max-width: 1000px;
        }

        .row {
            margin-top: 30px;
        }

        .card-body {
            padding: 30px; /* Thêm padding bên trong card body */
        }
    </style>
</head>

<body>
    <form class="row g-3 needs-validation" novalidate method="post" action="CampusController" id="editCampusForm">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="edit" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1>Edit Campus</h1>
                <div class="form-group">
                    <label for="campusID">Campus ID</label>
                    <input type="text" class="form-control" name="campusID" id="campusID"
                           value="${requestScope.campus.campusID}" readonly>
                </div>
                <div class="form-group">
                    <label for="campusName">Campus Name</label>
                    <input type="text" class="form-control" name="campusName" id="campusName"
                           value="${requestScope.campus.campusName}" required maxlength="30">
                    <div class="invalid-feedback">
                        Campus Name is required and must be less than or equal to 30 characters.
                    </div>
                </div>
                <div class="form-group">
                    <label for="campusAddress">Campus Address</label>
                    <input type="text" class="form-control" name="campusAddress" id="campusAddress"
                           value="${requestScope.campus.campusAddress}" required maxlength="255">
                    <div class="invalid-feedback">
                        Campus Address is required and must be less than or equal to 255 characters.
                    </div>
                </div>
                <div class="form-group">
                    <label for="campusEmail">Campus Email</label>
                    <input type="email" class="form-control" name="campusEmail" id="campusEmail"
                           value="${requestScope.campus.campusEmail}" required maxlength="50">
                    <div class="invalid-feedback">
                        A valid Campus Email is required and must be less than or equal to 50 characters.
                    </div>
                </div>
                <div class="form-group">
                    <label for="campusHotline">Campus Hotline</label>
                    <input type="text" class="form-control" name="campusHotline" id="campusHotline"
                           value="${requestScope.campus.campusHotline}" required maxlength="15">
                    <div class="invalid-feedback">
                        Campus Hotline is required and must be less than or equal to 15 digits.
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <button type="submit" class="btn btn-primary btn-lg col-md-5">Save</button>
                    <span class="col-md-2"></span>
                    <a class="btn btn-primary col-md-5" href="CampusController" role="button">Back to Campus List</a>
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
            $.validator.addMethod("numbersOnly", function (value, element) {
                return this.optional(element) || /^\d+$/.test(value);
            }, "Field must contain only numbers.");

            $('#editCampusForm').validate({
                rules: {
                    campusName: {
                        required: true,
                        maxlength: 30
                    },
                    campusAddress: {
                        required: true,
                        maxlength: 255
                    },
                    campusEmail: {
                        required: true,
                        email: true,
                        maxlength: 50
                    },
                    campusHotline: {
                        required: true,
                        numbersOnly: true,
                        maxlength: 15
                    }
                },
                messages: {
                    campusName: {
                        required: "Please enter the campus name.",
                        maxlength: "Campus Name must be less than or equal to 30 characters."
                    },
                    campusAddress: {
                        required: "Please enter the campus address.",
                        maxlength: "Campus address must be less than or equal to 255 characters."
                    },
                    campusEmail: {
                        required: "Please enter a valid campus email.",
                        email: "Please enter a valid email address.",
                        maxlength: "Campus email must be less than or equal to 50 characters."
                    },
                    campusHotline: {
                        required: "Please enter the campus hotline.",
                        numbersOnly: "Campus hotline must be a number.",
                        maxlength: "Campus hotline must be less than or equal to 15 digits."
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
