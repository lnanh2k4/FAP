<%-- 
    Document   : editSchedule
    Created on : Jul 6, 2024, 6:28:50 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Schedule</title>
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
        <form class="row g-3 needs-validation" novalidate method="post" action="SchedulesController">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="edit" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Edit Schedules</h1>
                    <div class="form-group">
                        <label for="scheduleID">Schedules ID</label>
                        <input type="text" class="form-control" name="id" id="scheduleID"
                               value="${requestScope.schedule.scheduleID}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="groupSubjectID">Group Subject ID</label>
                        <input type="text" class="form-control" name="groupSubjectID" id="groupSubjectID"
                               value="${requestScope.schedule.groupSubjectID.groupSubjectID}" required maxlength="2" placeholder="groupSubjectID">
                        <div class="invalid-feedback">
                            Please enter group Subject ID.
                        </div>
                        <label for="startDate">Start Date</label>
                        <input type="text" class="form-control" name="startDate" id="startDate"
                               value="${requestScope.schedule.startDate}" required maxlength="30" placeholder="6/2/2024">
                        <div class="invalid-feedback">
                            loi startdate.
                        </div>
                        <label for="startDate">End Date</label>
                        <input type="text" class="form-control" name="endDate" id="endDate"
                               value="${requestScope.schedule.endDate}" required maxlength="30" placeholder="12/3/2024">
                        <div class="invalid-feedback">
                            loi enddate roi.
                        </div>
                    </div>

                </div>
                <div class="container">
                    <div class="row">
                        <button type="submit" class="btn btn-primary btn-lg col-md-5">Save</button>
                        <span class="col-md-2"></span>
                        <a class="btn btn-primary col-md-5" href="SchedulesController" role="button">Back to Schedules list</a>
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
                                event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                        }, false);
                    });
                }, false);
            })();
        </script>
    </body>

</html>
