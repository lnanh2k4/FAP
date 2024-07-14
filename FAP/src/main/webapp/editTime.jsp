<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Major</title>
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
            color: #1a5bb8; /* Màu chữ tiêu đề, ví dụ màu xanh dương đậm */
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
            border-color: #2575fc; /* Đổi màu đường viền khi trường được chọn */
            box-shadow: 0 0 0 0.2rem rgba(37, 117, 252, 0.25); /* Hiệu ứng bóng khi trường được chọn */
        }

        .invalid-feedback {
            display: none;
        }

        .was-validated .invalid-feedback {
            display: block;
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

        .btn-secondary {
            background-color: #007bff; /* Màu xanh mặc định của Bootstrap */
            border: none;
            border-radius: 50px; /* Bo góc cho nút */
            padding: 10px 20px; /* Tăng kích thước nút */
            font-size: 1em; /* Kích thước chữ trong nút */
            font-weight: bold; /* Chữ đậm */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Hiệu ứng chuyển màu và phóng to khi hover */
        }

        .btn-secondary:hover {
            background-color: #0056b3; /* Màu nền khi hover */
            transform: scale(1.05); /* Phóng to nút khi hover */
        }

        .btn-secondary:focus {
            box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.5); /* Hiệu ứng bóng khi nút được chọn */
        }

        .btn-secondary:active {
            background-color: #0056b3; /* Màu nền khi nhấn */
            transform: scale(1); /* Đặt lại kích thước nút khi nhấn */
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

        .btn-lg {
            padding: 12px 24px; /* Tăng kích thước nút */
        }
    </style>
</head>

<body>
    <form class="row g-3 needs-validation" novalidate method="post" action="TimeController" id="editTimeForm">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="edit" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1>Edit Time</h1>
                <div class="form-group">
                    <label for="timeID">Time ID</label>
                    <input type="text" class="form-control" name="timeID" id="timeID"
                           value="${requestScope.time.timeID}" readonly>
                </div>
                <div class="form-group">
                    <label for="slot">Slot</label>
                    <input type="number" class="form-control" name="slot" id="slot"
                           value="${requestScope.time.slot}" required>
                    <div class="invalid-feedback">
                        Slot is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="startTime">Start Time</label>
                    <input type="time" class="form-control" name="startTime" id="startTime"
                           value="${requestScope.time.startTime}" required>
                    <div class="invalid-feedback">
                        Start Time is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="endTime">End Time</label>
                    <input type="time" class="form-control" name="endTime" id="endTime"
                           value="${requestScope.time.endTime}" required>
                    <div class="invalid-feedback">
                        End Time is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" name="description" id="description"
                           value="${requestScope.time.description}" required maxlength="30">
                    <div class="invalid-feedback">
                        Description is required and must be less than or equal to 30 characters.
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <button type="submit" class="btn btn-primary btn-lg col-md-5">Save</button>
                    <span class="col-md-2"></span>
                    <a class="btn btn-secondary col-md-5" href="TimeController" role="button">Back to Time list</a>
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
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#editTimeForm").validate({
                rules: {
                    slot: {
                        required: true,
                        number: true
                    },
                    startTime: {
                        required: true
                    },
                    endTime: {
                        required: true
                    },
                    description: {
                        required: true,
                        maxlength: 30
                    }
                },
                messages: {
                    slot: {
                        required: "Slot is required",
                        number: "Slot must be a number"
                    },
                    startTime: {
                        required: "Start Time is required"
                    },
                    endTime: {
                        required: "End Time is required"
                    },
                    description: {
                        required: "Description is required",
                        maxlength: "Description must be less than or equal to 30 characters"
                    }
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
        });
    </script>
</body>

</html>
