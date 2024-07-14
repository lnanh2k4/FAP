
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
=======
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FAP</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
              crossorigin="anonymous">

    <body>
        <h1>Hello, ${sessionScope.user.lastName} ${sessionScope.user.firstName} <span><a name="" id=""
                                                                                         class="btn btn-primary" href="login?check=signout" role="button">Signout</a></span></h1>
        <a href="MajorController">Major</a>
        <br>
        <a href="YearController">Year</a>
        <br>
        <a href="TimeController">Time</a>
        <br>
        <a href="WeekController">Week</a>
        <br>
        <a href="RoomController">Room</a>
        <br>
        <a href="ScheduleController">Schedule</a>
        <br>
        <a href="GroupController">Group</a>
        <br>
        <a href="SemesterController">Semester</a>
        <br>
        <a href="ScheduleDetailController">Schedule Detail</a>
        <br>
        <a href="SubjectController">Subject</a>
        <br>
        <a href="SpecializationController">Specialization</a>
        <br>
        <a href="CurriculumController">Curriculum</a>
        <br>
        <a href="AttendanceController">Attendance</a>
        <br>
        <a href="UserCampusController">User's Campus</a>


        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"

                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    </head>
>>>>>>> bba188f30c366b3eafa9cacd2a3ed887bef2521b
</body>

</html>
