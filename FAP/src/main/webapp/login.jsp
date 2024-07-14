<%-- 
    Document   : login
    Created on : Jul 14, 2024, 5:47:49 AM
    Author     : CE181767 - Le Nhut Anh
--%>

 <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Login</title>
            <link rel="stylesheet" href="./css/style.css">
            <link rel="stylesheet" href="./css/bootstrap.css">
        </head>

        <body>
            <div class="myForm">
                <h1 class="login">Login</h1>
                <form action="login" method="post" id="loginForm">
                    <div class="form-group">
                        <label for="user">Username</label>
                        <input type="text" class="form-control" name="user" id="user" aria-describedby="helpId"
                            placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="pass">Password</label>
                        <input type="password" class="form-control" name="pass" id="pass" aria-describedby="helpId"
                            placeholder="">
                    </div>
                    <button name="btnLogin" id="btnLogin" class="btn btn-primary btn-lg btn-block">Login</button>
                </form>
            </div>
            <script src="./js/bootstrap.js"></script>
            <script src="./js/jquery-3.7.1.js"></script>
            <script src="./js/jquery.validate.js"></script>
            <script src="./js/additional-methods.js"></script>
            <script>
                $("#loginForm").validate({
                    rules: {
                        user: {
                            required: true,
                            minlength: 3
                        },
                        pass: {
                            required: true,
                            minlength: 3
                        }
                    },
                    messages: {
                        user: {
                            required: "Please enter username",
                            minlength: "Please ente username at least 3 characters"
                        },

                        pass: {
                            required: "Please enter password",
                            minlength: "Please ente password at least 3 characters"
                        }
                    }
                });

            </script>
        </body>

        </html>