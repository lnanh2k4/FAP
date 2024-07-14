<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<<<<<<< HEAD
<<<<<<< HEAD
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
=======
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
>>>>>>> 6f932e06d9d90f46e33bc3961c3c2ab201d6780a
        <title>Add Year</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css">
        <style>
<<<<<<< HEAD
            .invalid-feedback {
                display: none;
            }

            .was-validated .invalid-feedback {
                display: block;
            }
        </style>
    </head>
=======
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Add Year</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
    <style>
        body {
            background: url('./img/background_homepage.jpg') no-repeat center center fixed; /* Background image */
            background-size: cover; /* Cover the entire viewport */
            color: #f1f1f1; /* Light text color for contrast */
            padding-top: 50px; /* Space for fixed navbar */
        }
=======
            body {
                background: url('./img/background_homepage.jpg') no-repeat center center fixed; /* Background image */
                background-size: cover; /* Cover the entire viewport */
                color: #f1f1f1; /* Light text color for contrast */
                padding-top: 50px; /* Space for fixed navbar */
            }
>>>>>>> 6f932e06d9d90f46e33bc3961c3c2ab201d6780a

            .card {
                background: rgba(255, 255, 255, 0.9); /* White background with slight transparency */
                border: none; /* Remove default border */
                border-radius: 15px; /* Rounded corners */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Shadow effect for the card */
                margin: 0 auto; /* Center the card */
                max-width: 600px; /* Set a max width */
                padding: 20px; /* Add padding inside the card */
            }

            h1 {
                margin-bottom: 30px;
                color: #333; /* Darker text color for the heading */
                text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2); /* Shadow for better readability */
                text-align: center; /* Center align heading */
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

            .invalid-feedback {
                color: #dc3545; /* Red color for invalid feedback */
            }

            .valid-feedback {
                color: #28a745; /* Green color for valid feedback */
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

            .row.mb-3 {
                margin-top: 30px;
            }

            .card-body {
                padding: 30px; /* Add extra padding inside the card body */
            }

<<<<<<< HEAD
        .btn-lg {
            padding: 12px 24px; /* Increase button size */
        }
    </style>
</head>
>>>>>>> 1501f4ded9020d6bcb974387290c1667d9777d69
=======
            .btn-lg {
                padding: 12px 24px; /* Increase button size */
            }
            p {
                color: #dc3545; /* Màu chữ */
                font-size: 16px; /* Kích thước phông chữ */
                line-height: 1.6; /* Chiều cao dòng */
                margin-bottom: 15px; /* Khoảng cách dưới */
            }
        </style>
    </head>
>>>>>>> 6f932e06d9d90f46e33bc3961c3c2ab201d6780a

    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="YearController" id="yearForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
<<<<<<< HEAD
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Year</h1>
                    <div class="form-group">
                        <label for="yearID">Year ID</label>
                        <input type="text" class="form-control" name="yearID" id="yearID" required pattern=".{4,4}" maxlength="4">
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" class="form-control" name="startDate" id="startDate" required>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" class="form-control" name="endDate" id="endDate" required>
                    </div>
                </div>
                <div class="container">
                    <div class="row mb-3 justify-content-center">
                        <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                        <span class="col-md-1"></span>
                        <a class="btn btn-primary btn-lg col-md-3" href="YearController" role="button">Back to Year list</a>
                        <span class="col-md-1"></span>
                        <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
                    </div>
                </div>
            </div>
<<<<<<< HEAD
        </form>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
        integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#yearForm").validate({
                    rules: {
                        yearID: {
                            required: true,
                            rangelength: [4, 4]
                        },
                        startDate: {
                            required: true,
                            date: true
                        },
                        endDate: {
                            required: true,
                            date: true
                        }
=======
            <div class="container">
                <div class="row mb-3 justify-content-center">
                    <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                    <span class="col-md-1"></span>
                    <a class="btn btn-primary btn-lg col-md-3" href="YearController" role="button">Back to Year list</a>
                    <span class="col-md-1"></span>
                    <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
=======
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Year</h1>
                    <div class="form-group">
                        <label for="yearID">Year ID</label>
                        <input type="text" class="form-control" name="yearID" id="yearID" required pattern=".{4,4}" maxlength="4">
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" class="form-control" name="startDate" id="startDate" required>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" class="form-control" name="endDate" id="endDate" required>
                    </div>
>>>>>>> 6f932e06d9d90f46e33bc3961c3c2ab201d6780a
                </div>
                <p class="errorAddYear">${requestScope.errorAddYear}</p>
                <div class="container">
                    <div class="row mb-3 justify-content-center">
                        <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                        <span class="col-md-1"></span>
                        <a class="btn btn-primary btn-lg col-md-3" href="YearController" role="button">Back to Year list</a>
                        <span class="col-md-1"></span>
                        <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
                    </div>
                </div>

            </div>
<<<<<<< HEAD
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
            $("#yearForm").validate({
                rules: {
                    yearID: {
                        required: true,
                        rangelength: [4, 4]
>>>>>>> 1501f4ded9020d6bcb974387290c1667d9777d69
=======
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
            $(document).ready(function () {
                $("#yearForm").validate({
                    rules: {
                        yearID: {
                            required: true,
                            rangelength: [4, 4]
                        },
                        startDate: {
                            required: true,
                            date: true
                        },
                        endDate: {
                            required: true,
                            date: true
                        }
>>>>>>> 6f932e06d9d90f46e33bc3961c3c2ab201d6780a
                    },
                    messages: {
                        yearID: {
                            required: "Please input Year ID",
                            rangelength: "Year ID must be exactly 4 characters long"
                        },
                        startDate: {
                            required: "Please input Start Date",
                            date: "Please enter a valid date"
                        },
                        endDate: {
                            required: "Please input End Date",
                            date: "Please enter a valid date"
                        }
                    },
                    submitHandler: function (form) {
                        var startDate = new Date($("#startDate").val());
                        var endDate = new Date($("#endDate").val());
                        if (endDate < startDate) {
                            alert("End Date cannot be before Start Date.");
                        } else {
                            form.submit();
                        }
                    },
                    errorClass: "invalid-feedback",
                    validClass: "valid-feedback",
                    highlight: function (element, errorClass, validClass) {
                        $(element).addClass("is-invalid").removeClass("is-valid");
                    },
                    unhighlight: function (element, errorClass, validClass) {
                        $(element).removeClass("is-invalid").addClass("is-valid");
                    },
                    errorPlacement: function (error, element) {
                        if (element.prop("tagName") === "SELECT" || element.prop("type") === "date") {
                            error.insertAfter(element.parent());
                        } else {
                            error.insertAfter(element);
                        }
                    }
                });
            });
        </script>
    </body>

</html>
