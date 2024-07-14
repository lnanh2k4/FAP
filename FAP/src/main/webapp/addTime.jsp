<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Time</title>
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
        <form class="row g-3 needs-validation" novalidate method="post" action="TimeController" id="timeForm">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="add" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Add Time</h1>
                    <div class="form-group">
                        <label for="slot">Slot</label>
                        <input type="number" class="form-control" name="slot" id="slot" required pattern=".{4,4}" maxlength="4">

                    </div>
                    <div class="form-group">
                        <label for="startTime">Start Time</label>
                        <input type="time" class="form-control" name="startTime" id="startTime" required>

                    </div>
                    <div class="form-group">
                        <label for="endTime">End Time</label>
                        <input type="time" class="form-control" name="endTime" id="endTime" required>

                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <input type="text" class="form-control" name="description" id="description" required>

                    </div>
                </div>
                <div class="container">
                    <div class="row mb-3 justify-content-center">
                        <button type="submit" class="btn btn-primary btn-lg col-md-3">Save</button>
                        <span class="col-md-1"></span>
                        <a class="btn btn-primary btn-lg col-md-3" href="TimeController" role="button">Back to Time list</a>
                        <span class="col-md-1"></span>
                        <button type="reset" class="btn btn-primary btn-lg col-md-3">Reset</button>
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
        <script src="./js/jquery-3.7.1.js"></script>
        <script src="./js/jquery.validate.js"></script>
        <script src="./js/additional-methods.js"></script>
        <script>
            $("#timeForm").validate({
            rules: {
            slot: {
            required: true,
                    minlength: 1,
                    maxlength: 4
            },
                    startTime: {
                    required: true
                    },
                    endTime: {
                    required: true
                    },
                    description: {
                    required: true
                    }
            },
                    messages: {
                    slot: {
                    required: "Please input slot",
                            minlength: "Slot must be at least 1 character",
                            maxlength: "Slot must be no more than 4 characters"
                    },
                            startTime: {
                            required: "Please input start time"
                            },
                            endTime: {
                            required: "Please input end time"
                            },
                            description: {
                            required: "Please input description"
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
            submitHandler: function(form) {
            var startTime = new Date("1970-01-01T" + $("#startTime").val() + "Z");
                    var endTime = new Date("1970-01-01T" + $("#endTime").val() + "Z");
                    if (endTime < startTime) {
            alert("End Time cannot be before Start Time.");
            } else {
            form.submit();
            }
            }
            });
        </script>
    </body>

</html>
