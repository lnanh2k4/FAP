<%@page import="models.User"%>
<%@page import="daos.UserCampusDAO"%>
<%@page import="daos.CampusDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
              crossorigin="anonymous">
        <style>
            body {
                padding-top: 50px;
                background: url('./img/background_homepage.jpg') no-repeat center center fixed;
                /* Background image */
                background-size: cover;
                /* Cover the entire viewport */
                color: #f1f1f1;
                /* Light text color for contrast */
            }

            .container {
                max-width: 900px;
            }

            p{
                color: black;
                text-align: left;
            }
            h1 {
                margin-bottom: 30px;
                color: #fff;
                /* White text color for the heading */
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6);
                /* Shadow for better readability */
            }

            .card {
                margin-bottom: 15px;
                background: rgba(255, 255, 255, 0.8);
                /* White background with some transparency */
                border: 1px solid #ddd;
                border-radius: 10px;
                /* Rounded corners */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                /* Subtle shadow for modern look */
                transition: box-shadow 0.3s ease, transform 0.3s ease;
                /* Smooth transition for hover effects */
            }

            .card:hover {
                box-shadow: 0 8px 16px rgba(0, 0, 0, 0.4);
                /* Darker shadow on hover */
                transform: scale(1.05);
                /* Slight zoom on hover */
            }

            .card-body {
                padding: 20px;
                text-align: center;
                /* Center-align text and links */
            }

            .card-link {
                display: block;
                padding: 15px;
                margin: 10px 0;
                background: #2575fc;
                /* Background color */
                color: #fff;
                /* Text color */
                border-radius: 5px;
                /* Rounded corners for buttons */
                font-size: 1.1em;
                /* Increase font size */
                font-weight: bold;
                /* Bold text */
                text-decoration: none;
                /* Remove underline */
                transition: background 0.3s ease, box-shadow 0.3s ease;
                /* Smooth transition for hover effects */
            }

            .card-link:hover {
                background: #1a5bb8;
                /* Darker blue for hover */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
                /* Shadow effect on hover */
                color: yellow;
            }

            .btn {
                border-radius: 50px;
                /* Rounded buttons */
            }

            .btn-primary {
                background-color: #2575fc;
                border: none;
            }

            .btn-primary:hover {
                background-color: #1a5bb8;
                /* Darker blue for hover */
            }
        </style>
    </head>
    <%
        UserCampusDAO uc = new UserCampusDAO();
        User user = (User) session.getAttribute("user");
        String campus = uc.getUserCampus(user.getUserID()).getCampusID().getCampusName();
    %>
    <body class="bodyHomePage">
        <div class="container">
            <h1 class="text-center">FPT UNIVERSITY ACADEMIC BASIC PORTAL</h1>
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <h1>Welcome, ${sessionScope.user.lastName}  ${sessionScope.user.firstName}</h1>
                            <p>Campus: <%= campus%> </p>
                            <p>Roll Number: ${sessionScope.user.userID}</p>
                            <c:if test="${sessionScope.user.role==0}">
                                <p>Role: Student</p>
                            </c:if>
                            <c:if test="${sessionScope.user.role==1}">
                                <p>Role: Lecturer</p>
                            </c:if>
                            <c:if test="${sessionScope.user.role==2}">
                                <p>Role: Academic Staff</p>
                            </c:if>
                            <c:if test="${sessionScope.user.role==3}">
                                <p>Role: Administrator</p>
                            </c:if>
                            <a href="login?check=signout" class="card-link">Sign out</a>
                        </div>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${sessionScope.user.role==0}">
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="ScheduleDetailController" class="card-link">Schedule Detail</a>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${sessionScope.user.role==1}">
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="ScheduleDetailController" class="card-link">Schedule Detail</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="AttendanceController" class="card-link">Attendance</a>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${sessionScope.user.role==2}">
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="MajorController" class="card-link">Major</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="TimeController" class="card-link">Time</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="ScheduleController" class="card-link">Schedule</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="GroupController" class="card-link">Group</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="SemesterController" class="card-link">Semester</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="SubjectController" class="card-link">Subject</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="SpecializationController" class="card-link">Specialization</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="CurriculumController" class="card-link">Curriculum</a>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${sessionScope.user.role==3}">
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="UserCampusController" class="card-link">User's Campus</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="CampusController" class="card-link">Campus</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="YearController" class="card-link">Year</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="WeekController" class="card-link">Week</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card">
                                <div class="card-body">
                                    <a href="RoomController" class="card-link">Room</a>
                                </div>
                            </div>
                        </div>
                    </c:when>
                </c:choose>


            </div>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
                integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
                crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
                crossorigin="anonymous">
        </script>
    </body>

</html>