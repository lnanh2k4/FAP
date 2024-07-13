<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Time</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
          integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
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
    <form class="row g-3 needs-validation" novalidate method="post" action="TimeController">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="check" id="check" value="add" />
        </div>

        <div class="card">
            <div class="card-body">
                <h1>Add Time</h1>
                <div class="form-group">
                    <label for="startTime">Slot</label>
                    <input type="number" class="form-control" name="slot" id="slot" required pattern=".{4,4}"
                           maxlength="4">
                    <div class="invalid-feedback">
                        slot is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="startTime">Start Time</label>
                    <input type="time" class="form-control" name="startTime" id="startTime" required>
                    <div class="invalid-feedback">
                        Start Date is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="endTime">End Time</label>
                    <input type="time" class="form-control" name="endTime" id="endTime" required>
                    <div class="invalid-feedback">
                        End Date is required.
                    </div>
                </div>
                <div class="form-group">
                    <label for="endDate">Description</label>
                    <input type="text" class="form-control" name="description" id="description" required>
                    <div class="invalid-feedback">
                        End Date is required.
                    </div>
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
    <script>
        // JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict';

            window.addEventListener('load', function () {
                var forms = document.getElementsByClassName('needs-validation');
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            
                        } else {
                            // Additional check to ensure endDate is not before startDate
                            var startDate = document.getElementById('startDate').value;
                            var endDate = document.getElementById('endDate').value;
                            if (new Date(endDate) < new Date(startDate)) {
                                event.preventDefault();
                                event.stopPropagation();
                                document.getElementById('endDate').setCustomValidity('End Date cannot be before Start Date.');
                                document.getElementById('endDate').reportValidity();
                            } else {
                                document.getElementById('endDate').setCustomValidity('');
                            }
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</body>

</html>
