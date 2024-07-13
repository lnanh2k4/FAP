<%-- 
    Document   : editScheduleDetail
    Created on : Jul 7, 2024, 6:21:09 PM
    Author     : Khanh
--%>
<html>
    <%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Edit Schedule Detail</title>
            <link rel="stylesheet"
                  href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
                  integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
                  crossorigin="anonymous">
        </head>
        <body>
            <h1>Edit Schedule Detail</h1>
            <form action="ScheduleDetailController" method="post">
                <input type="hidden" name="action" value="edit"/>
                <input type="hidden" name="scheduleDetailID" value="${scheduleDetail.scheduleDetailID}"/>
                <div class="form-group">
                    <label>Schedule ID:</label><input class="form-control" type="text" name="scheduleID" value="${scheduleDetail.scheduleID}"/><br/>
                </div>
                <div class="form-group">
                    <label>Room ID:</label><input class="form-control" type="text" name="roomID" value="${scheduleDetail.roomID}"/><br/>
                </div>
                <div class="form-group">
                    <label>User ID:</label><input class="form-control" type="text" name="userID" value="${scheduleDetail.userID}"/><br/>
                </div>
                <div class="form-group">
                    <label>Time ID:</label><input class="form-control" type="text" name="timeID" value="${scheduleDetail.timeID}"/><br/>
                </div>
                <div class="form-group">
                    <label>Campus ID:</label><input class="form-control" type="text" name="campusID" value
