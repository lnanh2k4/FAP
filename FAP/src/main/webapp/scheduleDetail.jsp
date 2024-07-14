<%-- 
    Document   : scheduleDetails
    Created on : Jul 7, 2024, 6:21:09 PM
    Author     : Khanh
--%>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Schedule Detail Management</title>
            <link rel="stylesheet"
                  href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
                  integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
                  crossorigin="anonymous">
            <style>
                body {
                    background: url('./img/background_homepage.jpg') no-repeat center center fixed; /* Hình nền trang */
                    background-size: cover; /* Phủ kín toàn bộ viewport */
                    color: #f1f1f1; /* Màu chữ nhạt cho văn bản */
                    padding-top: 50px; /* Khoảng cách cho navbar cố định */
                }

                h1 {
                    color: #f8f9fa;
                    text-align: center;
                    margin-bottom: 30px;
                }

                .btn-primary {
                    background-color: #007bff;
                    border: none;
                    border-radius: 25px; /* Bo tròn các góc của nút */
                    padding: 10px 20px; /* Thay đổi kích thước của nút */
                    font-size: 16px; /* Thay đổi kích thước chữ của nút */
                    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Thêm hiệu ứng đổ bóng */
                    transition: background-color 0.3s ease, box-shadow 0.3s ease; /* Hiệu ứng chuyển tiếp */
                }

                .btn-primary:hover {
                    background-color: #0056b3; /* Màu nền khi di chuột qua nút */
                    box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2); /* Hiệu ứng đổ bóng khi di chuột qua */
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

                .table-primary {
                    background-color: #cce5ff;
                }

                .table-light {
                    background-color: #f8f9fa;
                }

                .table-striped tbody tr:nth-of-type(odd) {
                    background-color: #e9ecef;
                }

                .table-hover tbody tr:hover {
                    background-color: #dee2e6;
                }

                .container {
                    max-width: 1000px; /* Đặt kích thước tối đa cho container */
                    margin-top: 20px; /* Thêm khoảng cách trên cùng của container */
                }
            </style>
        </head>

        <body>
            <div class="container">
                <h1>Manage Schedule Details</h1>
                <div class="d-flex justify-content-between mb-3">
                    <a name="" id="" class="btn btn-primary" href="ScheduleDetailController?check=add" role="button">Add Schedule Details</a>
                    <a class="btn btn-primary" href="./" role="button">Back to Manage list</a>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-borderless table-primary align-middle">
                        <thead class="table-light">
                            <tr>
                                <th>Schedule Detail ID</th>
                                <th>Schedule ID</th>
                                <th>Room ID</th>
                                <th>User ID</th>
                                <th>Time ID</th>
                                <th>Campus ID</th>
                                <th>Week ID</th>
                                <th>Description</th>
                                <th>Session</th>
                                <th>Date</th>
                                <th colspan="2">Action</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach var="item" items="${requestScope.scheduleDetailList}">
                                <tr class="table-primary">
                                    <td scope="row">${item.scheduleDetailID}</td>
                                    <td>${item.scheduleID}</td>
                                    <td>${item.roomID}</td>
                                    <td>${item.userID}</td>
                                    <td>${item.timeID}</td>
                                    <td>${item.campusID}</td>
                                    <td>${item.weekID}</td>
                                    <td>${item.schlDescription}</td>
                                    <td>${item.subjectSession}</td>
                                    <td>${item.date}</td>
                                    <td>
                                        <a class="btn btn-primary" href="ScheduleDetailController?id=${item.scheduleDetailID}&action=edit" role="button">Edit</a>
                                    </td>
                                    <td>
                                        <a class="btn btn-danger" href="ScheduleDetailController?id=${item.scheduleDetailID}&action=delete" role="button">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
                    integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
            crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
        </body>
    </html>
</html>
