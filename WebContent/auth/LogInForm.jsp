<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript" src="../js/lib/jquery-2.2.4.js"></script>
        <script type="text/javascript" src="../js/lib/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/LogInForm.js"></script>
        
        <link rel="stylesheet" type="text/css" href="../css/lib/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="../css/LogInForm.css">
        
        <title>Hub</title>
    </head>
    <body>
        <div class="sign-container">
            <h1>Hub</h1>
            <form action="login.do" method="post">
                <input type="text" id="id-form" name="id" class="input-form" placeholder="ID"/>
                <input type="password" id="password-form" name="password" class="input-form" placeholder="Password"/>
                <input type="password" id="password-form2" name="password2" class="input-form" placeholder="Retype the Password"/>
                <input type="submit" id="sign-button" value="LOGIN"/>
            </form>
            <span class="toggle-button">Sign UP</span>
        </div>
    </body>
</html>