<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Time</title>
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
    <form class="row g-3 needs-validation" novalidate method="post" action="TimeController" id="editTimeForm">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="edit" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1>Edit Time</h1>
                <div class="form-group">
                    <label for="timeID">Time ID</label>
                    <input type="text" class="form-control" name="timeID" id="timeID"
                           value="${requestScope.time.timeID}" readonly>
                </div>
                <div class="form-group">
                    <label for="slot">Slot</label>
                    <input type="number" class="form-control" name="slot" id="slot"
                           value="${requestScope.time.slot}" required>
                    <div class="invalid-feedback">
                        Slot is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="startTime">Start Time</label>
                    <input type="time" class="form-control" name="startTime" id="startTime"
                           value="${requestScope.time.startTime}" required>
                    <div class="invalid-feedback">
                        Start Time is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="endTime">End Time</label>
                    <input type="time" class="form-control" name="endTime" id="endTime"
                           value="${requestScope.time.endTime}" required>
                    <div class="invalid-feedback">
                        End Time is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" name="description" id="description"
                           value="${requestScope.time.description}" required maxlength="30">
                    <div class="invalid-feedback">
                        Description is required and must be less than or equal to 30 characters.
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <button type="submit" class="btn btn-primary btn-lg col-md-5">Save</button>
                    <span class="col-md-2"></span>
                    <a class="btn btn-primary col-md-5" href="TimeController" role="button">Back to Time list</a>
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
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#editTimeForm").validate({
                rules: {
                    slot: {
                        required: true,
                        number: true
                    },
                    startTime: {
                        required: true
                    },
                    endTime: {
                        required: true
                    },
                    description: {
                        required: true,
                        maxlength: 30
                    }
                },
                messages: {
                    slot: {
                        required: "Slot is required",
                        number: "Slot must be a number"
                    },
                    startTime: {
                        required: "Start Time is required"
                    },
                    endTime: {
                        required: "End Time is required"
                    },
                    description: {
                        required: "Description is required",
                        maxlength: "Description must be less than or equal to 30 characters"
                    }
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
        });
    </script>
</body>

</html>
