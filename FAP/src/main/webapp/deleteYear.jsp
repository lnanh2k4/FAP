<%-- Document : editMajor Created on : Jul 4, 2024, 12:21:56 PM Author : mrmas --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
                integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
                crossorigin="anonymous">

        </head>

        <body>
            <form class="row g-3 needs-validation" novalidate method="post" action="YearController">
                <div class="mb-3">
                    <input type="hidden" class="form-control" name="check" id="check" value="delete" />
                </div>

                <div class="card">
                    <div class="card-body">
                        <h1>Delete Year</h1>
                        <div class="form-group">
                            <label for="yearID">Year ID</label>
                            <input type="text" class="form-control" name="yearID" id="yearID"
                                value="${requestScope.year.yearID}" readonly>
                        </div>
                        <div class="form-group">
                            <label for="startDate">Start Date</label>
                            <input type="date" class="form-control" name="startDate" id="startDate"
                                value="${requestScope.year.startDate}" readonly>
                        </div>
                        <div class="form-group">
                            <label for="endDate">End Date</label>
                            <input type="date" class="form-control" name="endDate" id="endDate"
                                value="${requestScope.year.endDate}" readonly>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <button name="" id="" class="btn btn-primary btn-lg col-md-5">Delete</button>
                            <span class="col-md-2"></span>
                            <a class="btn btn-primary col-md-5" href="YearController" role="button">Back to Year
                                List</a>

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
        </body>

        </html>