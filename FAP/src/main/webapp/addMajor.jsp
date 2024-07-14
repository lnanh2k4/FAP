<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Major</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css">
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
                        <input type="text" class="form-control" name="majorID" id="majorID">
                    </div>
                    <div class="form-group">
                        <label for="majorName">Major Name</label>
                        <input type="text" class="form-control" name="majorName" id="majorName" required maxlength="30">
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
                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
        <script src="./js/jquery-3.7.1.js"></script>
        <script src="./js/jquery.validate.js"></script>
        <script src="./js/additional-methods.js"></script>
        <script>
            $("#majorForm").validate({
            rules: {
            majorID: {
            required: true,
                    rangelength: [1, 3]
            }
            },
                    messages: {
                    majorID: {
                    required: "Please input major ID",
                            rangelength: "Major ID must be letter between 1 and 3"
                    }

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
                    })
        </script>
    </body>

</html>