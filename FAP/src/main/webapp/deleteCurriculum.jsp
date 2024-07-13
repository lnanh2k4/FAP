<%-- Document : editMajor Created on : Jul 4, 2024, 12:21:56 PM Author : mrmas --%>
<%@page import="daos.SpecializationDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
 <%
        SpecializationDAO s = new SpecializationDAO();
        request.setAttribute("specializationList", s.getAllList());
    %>
    <body>
        <form class="row g-3 needs-validation" novalidate method="post" action="CurriculumController">
            <div class="mb-3">
                <input type="hidden" class="form-control" name="check" id="check" value="delete" />
            </div>

            <div class="card">
                <div class="card-body">
                    <h1>Delete Curriculum</h1>
                    <div class="form-group">
                        <label for="curriculumID">Curriculum ID</label>
                        <input type="text" class="form-control" name="curriculumID" id="curriculumID"
                               value="${requestScope.curriculum.curriculumID}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="curriculumName">Curriculum Name</label>
                        <input type="text" class="form-control" name="curriculumName" id="curriculumName"
                               value="${requestScope.curriculum.curriculumName}" readonly>
                    </div>
                     <div class="form-group">
                        <label for="specializationID">Specialization ID</label>
                        <input type="text" class="form-control" name="specializationID" id="specializationID"
                               value="${requestScope.curriculum.specializationID.specializationID}" readonly>
                        <div class="invalid-feedback">
                            nhap gi di chu.
                        </div>

                </div>
                <div class="container">
                    <div class="row">
                        <button name="" id="" class="btn btn-primary btn-lg col-md-5">Delete</button>
                        <span class="col-md-2"></span>
                        <a class="btn btn-primary col-md-5" href="CurriculumController" role="button">Back to Curriculum
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