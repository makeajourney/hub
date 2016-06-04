<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="/css/lib/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="/css/index.css">
        
        <script type="text/javascript" src="/js/lib/bootstrap.min.js"></script>
        
        <title>Hub</title>
    </head>
    <body>
        <div class="sign-container">
            <h1>Hub</h1>
            <form action="login.do" method="post">
                <input type="text" id="id" class="input-form" />
                <input type="password" id="password" class="input-form" />
                <input type="password" id="password2" class="input-form" />
                <input type="submit" id="sign-button" value="LOGIN"/>
            </form>
        </div>
    </body>
</html>