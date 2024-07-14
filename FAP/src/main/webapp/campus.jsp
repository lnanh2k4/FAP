<%-- Document : major Created on : Jul 4, 2024, 10:49:00 AM Author : mrmas --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Campus</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css"
          integrity="sha384-GLhlTQ2P7a8VqT6js4Cw6j5xRFO5b6DzHupPxT2mgD6Pvc2Ij6P6GghXyXr8v8I3"
          crossorigin="anonymous">

    <style>
        /* Simplistic and Modern Styles */
        body {
            background-color: #f0f4f8; /* Light background color */
            color: #333; /* Dark text color for readability */
            font-family: 'Helvetica Neue', Arial, sans-serif; /* Clean and modern font */
        }

        .container {
            margin-top: 30px;
            max-width: 900px;
        }

        h1 {
            color: #007bff; /* Primary blue color */
            font-size: 2rem; /* Slightly smaller heading */
            margin-bottom: 20px;
            text-align: center;
        }

        .btn-primary {
            background-color: #007bff; /* Primary blue color */
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3; /* Darker shade on hover */
            border-color: #004085;
        }

        .table {
            margin-top: 20px;
            border-radius: 10px; /* Rounded corners */
            overflow: hidden; /* Ensure corners are rounded */
        }

        .table thead {
            background-color: #007bff; /* Header background color */
            color: #fff; /* Header text color */
        }

        .table th, .table td {
            text-align: center;
            padding: 12px; /* Add some padding */
        }

        .table-striped tbody tr:nth-of-type(odd) {
            background-color: #ffffff; /* White background for odd rows */
        }

        .table-hover tbody tr:hover {
            background-color: #f1f5f9; /* Light hover effect */
        }

        .table-primary {
            color: #333; /* Text color for table content */
        }

        .btn {
            margin: 0 5px; /* Spacing between buttons */
        }

        @media (max-width: 768px) {
            .table-responsive {
                overflow-x: auto;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>Manage Campus</h1>
        <div class="d-flex justify-content-between mb-3">
            <a class="btn btn-primary" href="CampusController?check=add" role="button">Add Campus</a>
            <a class="btn btn-primary" href="./" role="button">Back to Manage list</a>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-borderless table-primary align-middle">
                <thead>
                    <tr>
                        <th>Campus ID</th>
                        <th>Campus Name</th>
                        <th>Campus Address</th>
                        <th>Campus Email</th>
                        <th>Campus Hotline</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${requestScope.campusList}">
                        <tr class="table-primary">
                            <td scope="row">${item.campusID}</td>
                            <td>${item.campusName}</td>
                            <td>${item.campusAddress}</td>
                            <td>${item.campusEmail}</td>
                            <td>${item.campusHotline}</td>
                            <td><a class="btn btn-primary" href="CampusController?id=${item.campusID}&check=edit"
                                   role="button">Edit</a>
                                <a class="btn btn-primary"
                                   href="CampusController?id=${item.campusID}&check=delete"
                                   role="button">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"
            integrity="sha384-vO6Z1O2lHhU4Tg5X7h07uyVs6WUSnDQW1/0L0cI0+K7QExwX0kTwC6H0neNsSQJ1L"
            crossorigin="anonymous"></script>
</body>

</html>
