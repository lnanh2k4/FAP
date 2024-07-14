<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Year</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css">
        <style>
            .invalid-feedback {
                display: none;
            }

            .was-validated .invalid-feedback {
                display: block;
            }
        </style>
    </head>

    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="YearController" id="yearForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
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