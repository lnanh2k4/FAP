<%-- Document : editMajor Created on : Jul 4, 2024, 12:21:56 PM Author : mrmas --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
              crossorigin="anonymous">
        <style>
            body {
                background: url('./img/background_homepage.jpg') no-repeat center center fixed;
                background-size: cover;
                color: #f1f1f1;
                padding-top: 50px;
            }

            h1 {
                margin-bottom: 30px;
                color: #dc3545;
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
        </style>

    </head>

    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="SubjectController">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="delete" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Delete Subject</h1>
                    <div class="form-group">
                        <label for="subjectID">Subject ID</label>
                        <input type="text" class="form-control" name="subjectID" id="subjectID"
                               value="${requestScope.subject.subjectID}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="subjectName">Subject Name</label>
                        <input type="text" class="form-control" name="subjectName" id="subjectName"
                               value="${requestScope.subject.subjectName}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="subjectNocredit">Subject No Credit</label>
                        <input type="text" class="form-control" name="subjectNoCredit" id="subjectNoCredit" 
                               value="${requestScope.subject.subjectNoCredit}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="subjectPrerequisite">Subject Prerequisite</label>
                        <input type="text" class="form-control" name="subjectPrerequisite" id="subjectPrerequisite"
                               value="${requestScope.subject.subjectPrerequisite}" readonly >
                    </div>
                    <div class="form-group">
                        <label for="subjectDescription">Subject Description</label>
                        <input type="text" class="form-control" name="subjectDescription" id="subjectDescription"
                               value="${requestScope.subject.subjectDescription}" readonly  >
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <button type="submit" class="btn btn-danger btn-lg col-md-5">Delete</button>
                        <span class="col-md-2"></span>
                        <a class="btn btn-primary col-md-5" href="SubjectController" role="button">Back to Subject
                            List</a>

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