<%-- 
    Document   : register
    Created on : Oct 19, 2020, 3:20:59 PM
    Author     : 584893
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            Username: <input type="text" name="username" value="${username}" />
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register Name" />
        </form>
        
    </body>
</html>
