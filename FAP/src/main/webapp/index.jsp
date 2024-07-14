<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
        integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <style>
        body {
            padding-top: 50px;
            background-color: #f8f9fa;
        }

        .container {
            max-width: 800px;
        }

        .card {
            margin-bottom: 15px;
        }

        .card-header {
            font-weight: bold;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1 class="text-center mb-4">FPT UNIVERSITY BASIC ACADEMIC PORTAL</h1>
        <div class="card">
            <div class="card-header">
                Tra cứu thông tin
            </div>
            <div class="list-group list-group-flush">
                <a href="MajorController" class="list-group-item list-group-item-action">Major</a>
                <a href="YearController" class="list-group-item list-group-item-action">Year</a>
                <a href="TimeController" class="list-group-item list-group-item-action">Time</a>
                <a href="WeekController" class="list-group-item list-group-item-action">Week</a>
                <a href="RoomController" class="list-group-item list-group-item-action">Room</a>
                <a href="ScheduleController" class="list-group-item list-group-item-action">Schedule</a>
                <a href="GroupController" class="list-group-item list-group-item-action">Group</a>
                <a href="SemesterController" class="list-group-item list-group-item-action">Semester</a>
                <a href="ScheduleDetailController" class="list-group-item list-group-item-action">Schedule Detail</a>
                <a href="SubjectController" class="list-group-item list-group-item-action">Subject</a>
                <a href="SpecializationController" class="list-group-item list-group-item-action">Specialization</a>
                <a href="CurriculumController" class="list-group-item list-group-item-action">Curriculum</a>
                <a href="AttendanceController" class="list-group-item list-group-item-action">Attendance</a>
                <a href="UserCampusController" class="list-group-item list-group-item-action">User's Campus</a>
            </div>
        </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
        integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
    </script>
</body>

</html>
