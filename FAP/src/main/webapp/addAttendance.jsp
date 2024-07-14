<%-- Document : addAttendance Created on : Jul 6, 2024, 6:33:32 PM Author : Khanh --%>

    <html>
    <%@ page contentType="text/html;charset=UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Add Attendance</title>
            <link rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
                integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
                crossorigin="anonymous">
        </head>

        <body>
            <h1>Add Attendance</h1>
            <<form class="row g-3 needs-validation" novalidate method="post" action="AttendanceController">
                <div class="mb-3">
                    <input type="hidden" class="form-control" name="check" id="check" value="add" />
                </div>
                <div class="form-group">
                    <label>Schedule Detail ID:</label><input class="form-control" type="text"
                        name="scheduleDetailID" /><br />
                </div>
                <div class="form-group">
                    <label>User ID:</label><input class="form-control" type="text" name="userID" /><br />
                </div>
                <div class="form-group">
                    <label>State</label><input class="form-control" type="text" name="state" /><br />
                </div>
                <div class="form-group">
                    <label>Comment:</label><input class="form-control" type="text" name="comment" /><br />
                </div>
                <div class="form-group">
                    <label>Note:</label><input class="form-control" type="text" name="note" /><br />
                </div>
                <div class="container">
                    <div class="row">
                        <button type="submit" class="btn btn-primary btn-lg col-md-5">Save</button>
                        <span class="col-md-2"></span>
                        <button type="reset" class="btn btn-primary btn-lg col-md-5">Reset</button>
                    </div>
                </div>
                </form>
                <script src="./js/jquery-3.7.1.js"></script>
                <script src="./js/jquery.validate.js"></script>
                <script src="./js/additional-methods.js"></script>
        </body>

        </html>

    </html>