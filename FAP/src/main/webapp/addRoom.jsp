<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Room</title>
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
    <form class="row g-3 needs-validation" novalidate method="post" action="RoomController" id="roomForm">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="add" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1>Add Room</h1>
                <div class="form-group">
                    <label for="roomID">Room ID</label>
                    <input type="text" class="form-control" name="roomID" id="roomID" required maxlength="7">
                </div>
                <div class="form-group">
                    <label for="roomName">Room Name</label>
                    <input type="text" class="form-control" name="roomName" id="roomName" required>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <button type="submit" class="btn btn-primary btn-lg col-md-5">Save</button>
                    <span class="col-md-2"></span>
                    <button type="reset" class="btn btn-primary btn-lg col-md-5">Reset</button>
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
            $("#roomForm").validate({
                rules: {
                    roomID: {
                        required: true,
                        rangelength: [4, 4]
                    },
                    roomName: {
                        required: true
                    }
                },
                messages: {
                    roomID: {
                        required: "Please input Room ID",
                        rangelength: "Room ID must be exactly 4 characters long"
                    },
                    roomName: {
                        required: "Please input Room Name"
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
