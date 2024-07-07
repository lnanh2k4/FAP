<%-- 
    Document   : addScheduleDetail
    Created on : Jul 7, 2024, 6:21:09 PM
    Author     : Khanh
--%>
<html>
    <%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Add Schedule Detail</title>
            <link rel="stylesheet"
                  href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
                  integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
                  crossorigin="anonymous">
        </head>
        <body>
            <h1>Add Schedule Detail</h1>
            <form action="ScheduleDetailController" method="post">
                <input type="hidden" name="action" value="add"/>
                <div class="form-group">
                    <label>Schedule ID:</label><input class="form-control" type="text" name="scheduleID"/><br/>
                </div>
                <div class="form-group">
                    <label>Room ID:</label><input class="form-control" type="text" name="roomID"/><br/>
                </div>
                <div class="form-group">
                    <label>User ID:</label><input class="form-control" type="text" name="userID"/><br/>
                </div>
                <div class="form-group">
                    <label>Time ID:</label><input class="form-control" type="text" name="timeID"/><br/>
                </div>
                <div class="form-group">
                    <label>Campus ID:</label><input class="form-control" type="text" name="campusID"/><br/>
                </div>
                <div class="form-group">
                    <label>Week ID:</label><input class="form-control" type="text" name="weekID"/><br/>
                </div>
                <div class="form-group">
                    <label>Description:</label><input class="form-control" type="text" name="schlDescription"/><br/>
                </div>
                <div class="form-group">
                    <label>Session:</label><input class="form-control" type="text" name="subjectSession"/><br/>
                </div>
                <div class="form-group">
                    <label>Date:</label><input class="form-control" type="date" name="date"/><br/>
                </div>
                <div class="form-group">
                    <label>Status:</label><input class="form-control" type="text" name="status"/><br/>
                </div>
                <input class="btn btn-primary" type="submit" value="Add"/>
            </form>
        </body>
    </html>
</html>
