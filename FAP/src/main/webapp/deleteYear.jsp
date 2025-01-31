<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Year</title>
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
            color: #dc3545; /* Màu chữ tiêu đề, ví dụ màu đỏ đậm */
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

        .btn-danger {
            background-color: #dc3545; /* Màu đỏ cho nút xóa */
            border: none;
            border-radius: 50px; /* Bo góc cho nút */
            padding: 10px 20px; /* Tăng kích thước nút */
            font-size: 1em; /* Kích thước chữ trong nút */
            font-weight: bold; /* Chữ đậm */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Hiệu ứng chuyển màu và phóng to khi hover */
        }

        .btn-danger:hover {
            background-color: #c82333; /* Màu nền khi hover */
            transform: scale(1.05); /* Phóng to nút khi hover */
        }

        .btn-danger:focus {
            box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.5); /* Hiệu ứng bóng khi nút được chọn */
        }

        .btn-danger:active {
            background-color: #c82333; /* Màu nền khi nhấn */
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
    <form class="row g-3 needs-validation" novalidate method="post" action="YearController" id="deleteYearForm">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="delete" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1>Delete Year</h1>
                <div class="form-group">
                    <label for="yearID">Year ID</label>
                    <input type="text" class="form-control" name="yearID" id="yearID"
                           value="${requestScope.year.yearID}" readonly>
                </div>
                <div class="form-group">
                    <label for="startDate">Start Date</label>
                    <input type="date" class="form-control" name="startDate" id="startDate"
                           value="${requestScope.year.startDate}" readonly>
                </div>
                <div class="form-group">
                    <label for="endDate">End Date</label>
                    <input type="date" class="form-control" name="endDate" id="endDate"
                           value="${requestScope.year.endDate}" readonly>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <button type="submit" class="btn btn-danger btn-lg col-md-5">Delete</button>
                    <span class="col-md-2"></span>
                    <a class="btn btn-primary col-md-5" href="YearController" role="button">Back to Year List</a>
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
