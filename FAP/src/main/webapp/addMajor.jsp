<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Major</title>
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

        .btn-lg {
            padding: 12px 24px; /* Increase button size */
        }
    </style>
</head>

<body>
    <form class="row g-3 needs-validation" method="post" action="MajorController" id="majorForm">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="add" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1>Add Major</h1>
                <div class="form-group">
                    <label for="majorID">Major ID</label>
                    <input type="text" class="form-control" name="majorID" id="majorID" required rangelength="1,3">
                    <div class="invalid-feedback">
                        <!-- Validation message will appear here -->
                    </div>
                </div>
                <div class="form-group">
                    <label for="majorName">Major Name</label>
                    <input type="text" class="form-control" name="majorName" id="majorName" required maxlength="30">
                    <div class="invalid-feedback">
                        <!-- Validation message will appear here -->
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row mb-3 justify-content-center">
                    <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                    <span class="col-md-1"></span>
                    <a class="btn btn-primary btn-lg col-md-3" href="MajorController" role="button">Back to Major list</a>
                    <span class="col-md-1"></span>
                    <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
                </div>
            </div>
        </div>
    </form>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
            integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
    <script>
        $(document).ready(function() {
            $.validator.addMethod("rangelength", function (value, element, param) {
                var length = value.length;
                return this.optional(element) || (length >= param[0] && length <= param[1]);
            }, $.validator.format("Please enter between {0} and {1} characters."));

            $("#majorForm").validate({
                rules: {
                    majorID: {
                        required: true,
                        rangelength: [1, 3]
                    },
                    majorName: {
                        required: true,
                        maxlength: 30
                    }
                },
                messages: {
                    majorID: {
                        required: "Please input Major ID",
                        rangelength: "Major ID must be between 1 and 3 characters long"
                    },
                    majorName: {
                        required: "Please input Major Name",
                        maxlength: "Major Name cannot be longer than 30 characters"
                    }
                },
                errorClass: "invalid-feedback",
                validClass: "valid-feedback",
                highlight: function(element, errorClass, validClass) {
                    $(element).addClass("is-invalid").removeClass("is-valid");
                },
                unhighlight: function(element, errorClass, validClass) {
                    $(element).removeClass("is-invalid").addClass("is-valid");
                },
                errorPlacement: function(error, element) {
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
