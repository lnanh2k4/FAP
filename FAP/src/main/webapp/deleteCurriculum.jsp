<%-- Document : editMajor Created on : Jul 4, 2024, 12:21:56 PM Author : mrmas --%>
<%@page import="daos.SpecializationDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Curriculum</title>
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
    </style>
</head>

<%
    SpecializationDAO s = new SpecializationDAO();
    request.setAttribute("specializationList", s.getAllList());
%>

<body>
    <form class="row g-3 needs-validation" novalidate method="post" action="CurriculumController">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="delete" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1>Delete Curriculum</h1>
                <div class="form-group">
                    <label for="curriculumID">Curriculum ID</label>
                    <input type="text" class="form-control" name="curriculumID" id="curriculumID"
                           value="${requestScope.curriculum.curriculumID}" readonly>
                </div>
                <div class="form-group">
                    <label for="curriculumName">Curriculum Name</label>
                    <input type="text" class="form-control" name="curriculumName" id="curriculumName"
                           value="${requestScope.curriculum.curriculumName}" readonly>
                </div>
                <div class="form-group">
                    <label for="specializationID">Specialization ID</label>
                    <input type="text" class="form-control" name="specializationID" id="specializationID"
                           value="${requestScope.curriculum.specializationID.specializationID}" readonly>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <button type="submit" class="btn btn-danger btn-lg col-md-5">Delete</button>
                    <div class="col-md-2"></div>
                    <a class="btn btn-primary col-md-5" href="CurriculumController" role="button">Back to Curriculum List</a>
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
