<%-- 
    Document   : UserInsert
    Created on : 2016/12/26, 14:50:39
    Author     : user2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>  新規作成画面 </h1>
        
            <form action = "InsertResult" method ="post">              
                
                userId;<input type = text name = "userID"><br>
                name;<input type = text name = "name"><br>
                password;<input type = text name = "password"><br>
                mail;<input type = text name = "mail"><br>
                address;<input type = text name = "address"><br>
                
            </form>
             
       
    </body>
</html>
