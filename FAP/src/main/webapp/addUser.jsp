<%-- Document : userDetail Created on : Jul 15, 2024, 2:20:53 AM Author : CE181767 - Le Nhut Anh --%>

<%@page import="models.Major" %>
<%@page import="daos.MajorDAO" %>
<%@page import="models.Specialization" %>
<%@page import="daos.SpecializationDAO" %>
<%@page import="models.Curriculum" %>
<%@page import="daos.CurriculumDAO" %>
<%@page import="models.Campus" %>
<%@page import="daos.CampusDAO" %>
<%@page import="models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="models.UserCampus" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>Add User</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
              crossorigin="anonymous">
        <style>
            body {
                background: url('./img/background_homepage.jpg') no-repeat center center fixed;
                /* Hình nền trang */
                background-size: cover;
                /* Phủ kín toàn bộ viewport */
                color: #f1f1f1;
                /* Màu chữ nhạt cho văn bản */
                padding-top: 50px;
                /* Khoảng cách cho navbar cố định */
            }

            h1 {
                margin-bottom: 30px;
                color: #dc3545;
                /* Màu chữ tiêu đề, ví dụ màu cam san hô */
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6);
                /* Bóng chữ cho tiêu đề */
                text-align: center;
                /* Căn giữa tiêu đề */
            }

            .card {
                background: rgba(255, 255, 255, 0.9);
                /* Nền thẻ trắng với độ trong suốt */
                border: none;
                /* Xóa đường viền mặc định */
                border-radius: 15px;
                /* Bo góc cho thẻ */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                /* Hiệu ứng bóng cho thẻ */
                margin: 0 auto;
                /* Căn giữa thẻ */
                max-width: 600px;
                /* Đặt chiều rộng tối đa */
                padding: 20px;
                /* Thêm padding bên trong thẻ */
            }

            .form-group label {
                font-weight: bold;
                color: #333;
                /* Màu chữ tối hơn cho nhãn */
            }

            .form-control {
                border-radius: 5px;
                /* Bo góc cho các trường nhập liệu */
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                /* Hiệu ứng bóng cho các trường nhập liệu */
            }

            .form-control:focus {
                border-color: #2575fc;
                /* Đổi màu đường viền khi trường được chọn */
                box-shadow: 0 0 0 0.2rem rgba(37, 117, 252, 0.25);
                /* Hiệu ứng bóng khi trường được chọn */
            }

            .btn-primary {
                background-color: #2575fc;
                border: none;
                border-radius: 50px;
                /* Bo góc cho nút */
                padding: 10px 20px;
                /* Tăng kích thước nút */
                font-size: 1em;
                /* Kích thước chữ trong nút */
                font-weight: bold;
                /* Chữ đậm */
                transition: background-color 0.3s ease, transform 0.3s ease;
                /* Hiệu ứng chuyển màu và phóng to khi hover */
            }

            .btn-primary:hover {
                background-color: #1a5bb8;
                /* Màu nền khi hover */
                transform: scale(1.05);
                /* Phóng to nút khi hover */
            }

            .btn-primary:focus {
                box-shadow: 0 0 0 0.2rem rgba(37, 117, 252, 0.5);
                /* Hiệu ứng bóng khi nút được chọn */
            }

            .btn-primary:active {
                background-color: #1a5bb8;
                /* Màu nền khi nhấn */
                transform: scale(1);
                /* Đặt lại kích thước nút khi nhấn */
            }

            .container {
                max-width: 1000px;
            }

            .row {
                margin-top: 30px;
            }

            .card-body {
                padding: 30px;
                /* Thêm padding bên trong card body */
            }

            .btn-lg {
                padding: 12px 24px;
                /* Tăng kích thước nút */
            }
        </style>
    </head>

    <body>
        <form class="row g-3 needs-validation" novalidate
              method="post" action="UserController">
            <div class="mb-3">
                <input type="hidden" class="form-control"
                       name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>User Information</h1>
                    <div class="form-group">
                        <label for="userID">UserID</label>
                        <input type="text" class="form-control"
                               name="userID" id="userID"
                               value=""
                               >
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="fistName">First
                                Name</label>
                            <input type="text"
                                   class="form-control"
                                   name="fistName" id="fistName"
                                   value="">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="lastName">Last
                                Name</label>
                            <input type="text"
                                   class="form-control"
                                   name="lastName" id="lastName"
                                   value="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="sex">Sex</label>
                            <select name="sex" id="sex">
                                <option value="0">Female
                                </option>
                                <option value="1">Male</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="phone">Phone</label>
                            <input type="text"
                                   class="form-control"
                                   name="phone" id="phone"
                                   value="">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="email">Email</label>
                        <input type="text" class="form-control"
                               name="email" id="email"
                               value="">
                    </div>
                    <%
                        User user = (User) session.getAttribute("user");
                    %>
                    <div class="form-group">
                        <label for="role">Role</label>
                        <select name="role" id="role">
                            <option value="0">Student
                            </option>
                            <option value="1">Lecturer
                            </option>
                            <option value="2">Academic Staff
                            </option>
                            <c:if test="<%= user.getRole() == 3%>">
                                <option value="3">Administrator
                                </option>
                            </c:if>

                        </select>
                    </div>

                </div>
                <div class="container">
                    <div class="row">
                        <button name="btnSave"
                                id="btnSave"
                                class="btn btn-primary col-md-6">Add</button>
                        <a class="btn btn-primary col-md-6"
                           href="UserController"
                           role="button">Back</a>
                    </div>
                </div>
            </div>
        </form>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
            integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    </body>

</html>