<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Subject</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <style>
            body {
                background: url('./img/background_homepage.jpg') no-repeat center center fixed; /* Background image */
                background-size: cover; /* Cover the entire viewport */
                color: #f1f1f1; /* Light text color for contrast */
                padding-top: 50px; /* Space for fixed navbar */
            }

            h1 {
                margin-bottom: 30px;
                color: #fff; /* White text color for the heading */
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
        <form class="row g-3 needs-validation" novalidate method="post" action="SubjectController" id="addSubjectForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Subject</h1>
                    <div class="form-group">
                        <label for="subjectID">Subject ID</label>
                        <input type="text" class="form-control" name="subjectID" id="subjectID"
                               >
                    </div>
                    <div class="form-group">
                        <label for="subjectName">Subject Name</label>
                        <input type="text" class="form-control" name="subjectName" id="subjectName"
                               >

                    </div>
                    <div class="form-group">
                        <label for="subjectNoCredit">Subject No Credit</label>
                        <input type="text" class="form-control" name="subjectNoCredit" id="subjectNoCredit" 
                               >

                    </div>
                    <div class="form-group">
                        <label for="subjectPrerequisite">Subject Prerequisite</label>
                        <input type="text" class="form-control" name="subjectPrerequisite" id="subjectPrerequisite"
                               >

                    </div>
                    <div class="form-group">
                        <label for="subjectDescription">Subject Description</label>
                        <input type="text" class="form-control" name="subjectDescription" id="subjectDescription"
                               >

                    </div>
                </div>
                <div class="container">
                    <div class="row mb-3 justify-content-center">
                        <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                        <span class="col-md-1"></span>
                        <a class="btn btn-primary btn-lg col-md-3" href="SubjectController" role="button">Back to Subject list</a>
                        <span class="col-md-1"></span>
                        <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
                    </div>
                </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXlDw5TnP12MjAeu5RsENQGnZ4py+6kQmA8AKOzwi3BIi+d2DCtwIk8p2KUE"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.min.js"></script>
        <script>
            $(document).ready(function () {
                $.validator.addMethod("noNumbers", function (value, element) {
                    return this.optional(element) || /^[A-Za-z\s]+$/.test(value);
                }, "Field must not contain numbers.");

                $.validator.addMethod("numbersOnly", function (value, element) {
                    return this.optional(element) || /^\d+$/.test(value);
                }, "Field must contain only numbers.");

                $('#addSubjectForm').validate({
                    rules: {
                        subjectID: {
                            required: true,
                            noNumbers: true
                        },
                        subjectName: {
                            required: true,
                            noNumbers: true
                        },
                        subjectNoCredit: {
                            required: true,
                            numbersOnly: true
                        },
                        subjectPrerequisite: {
                            required: true,
                            noNumbers: true
                        },
                        subjectDescription: {
                            required: true,
                            noNumbers: true
                        }
                    },
                    messages: {
                        subjectID: {
                            required: "Please enter the subject ID.",
                            noNumbers: "Subject ID must be a word."
                        },
                        subjectName: {
                            required: "Please enter the subject name.",
                            noNumbers: "Subject Name must be a word."
                        },
                        subjectNoCredit: {
                            required: "Please enter the subject no credit.",
                            numbersOnly: "Subject No Credit must be a number."
                        },
                        subjectPrerequisite: {
                            required: "Please enter the subject prerequisite.",
                            noNumbers: "Subject Prerequisite must be a word."
                        },
                        subjectDescription: {
                            required: "Please enter the subject description.",
                            noNumbers: "Subject Description be a word."
                        }
                    },
                    errorPlacement: function (error, element) {
                        error.addClass('invalid-feedback');
                        element.closest('.form-group').append(error);
                    },
                    highlight: function (element, errorClass, validClass) {
                        $(element).addClass('is-invalid').removeClass('is-valid');
                    },
                    unhighlight: function (element, errorClass, validClass) {
                        $(element).addClass('is-valid').removeClass('is-invalid');
                    }
                });
            });
        </script>
    </body>

</html>