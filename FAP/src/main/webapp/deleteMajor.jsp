<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delete Major</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
          crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
    <style>
        body {
            background: url('./img/background_homepage.jpg') no-repeat center center fixed; /* Background image */
            background-size: cover; /* Cover the entire viewport */
            color: #f1f1f1; /* Light text color for contrast */
            padding-top: 50px; /* Space for fixed navbar */
        }

        h1 {
            margin-bottom: 30px;
            color: #dc3545; /* White text color for the heading */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6); /* Shadow for better readability */
        }

        .card {
            background: rgba(255, 255, 255, 0.9); /* White background with slight transparency */
            border: none; /* Remove default border */
            border-radius: 15px; /* Rounded corners */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Shadow effect for the card */
            margin: 0 auto; /* Center the card */
            max-width: 600px; /* Set a max width */
            padding: 20px; /* Add padding inside the card */
        }

        .form-group label {
            font-weight: bold;
            color: #333; /* Darker text color for labels */
        }

        .form-control {
            border-radius: 5px; /* Rounded corners for inputs */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Light shadow for inputs */
        }

        .form-control:focus {
            border-color: #2575fc; /* Blue border on focus */
            box-shadow: 0 0 0 0.2rem rgba(37, 117, 252, 0.25); /* Blue shadow on focus */
        }

        .btn-primary {
            background-color: #2575fc;
            border: none;
            border-radius: 50px; /* Rounded button corners */
            padding: 10px 20px; /* Increase padding */
            font-size: 1em; /* Increase font size */
            font-weight: bold; /* Bold text */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Smooth transitions */
        }

        .btn-primary:hover {
            background-color: #1a5bb8; /* Darker blue for hover */
            transform: scale(1.05); /* Slightly enlarge button on hover */
        }

        .btn-primary:focus {
            box-shadow: 0 0 0 0.2rem rgba(37, 117, 252, 0.5); /* Blue shadow on focus */
        }

        .btn-primary:active {
            background-color: #1a5bb8; /* Darker blue for active */
            transform: scale(1); /* Reset scale on click */
        }

        .container {
            max-width: 1000px;
        }

        .row {
            margin-top: 30px;
        }

        .card-body {
            padding: 30px; /* Add extra padding inside the card body */
        }

        .btn-lg {
            padding: 12px 24px; /* Increase button size */
        }
    </style>
</head>

<body>
    <form class="row g-3 needs-validation" novalidate method="post" action="MajorController">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="delete" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1 class="text-center">Delete Major</h1>
                <div class="form-group">
                    <label for="majorID">Major ID</label>
                    <input type="text" class="form-control" name="majorID" id="majorID"
                           value="${requestScope.major.majorID}" readonly>
                </div>
                <div class="form-group">
                    <label for="majorName">Major Name</label>
                    <input type="text" class="form-control" name="majorName" id="majorName"
                           value="${requestScope.major.majorName}" readonly>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <button name="" id="" class="btn btn-danger btn-lg col-md-5">Delete</button>
                    <span class="col-md-2"></span>
                    <a class="btn btn-primary col-md-5" href="MajorController" role="button">Back to Major List</a>
                </div>
            </div>
        </div>
    </form>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
            integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz4fnFO9ET3lQsy5x4RQZk8b6B0PZ5QK7A8J8I9v00w6GDDO7TfV2wFwRs"
            crossorigin="anonymous"></script>
</body>

</html>
