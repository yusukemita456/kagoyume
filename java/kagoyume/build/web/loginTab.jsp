<%-- 
    Document   : loginTab
    Created on : 2016/12/26, 13:41:56
    Author     : user2
--%>

<%@page import="base.UserDataDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        HttpSession hs = request.getSession();
        UserDataDTO login = new UserDataDTO();
        login = (UserDataDTO) hs.getAttribute("resultData");
        

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action = "LoginResult" method="post">
            
           <% if (login == null) { %>
            <input type="button" name = "btn"  value = "ログイン">
           <% } else { %>
            <input type="button" name = "btn" value = "ログアウト" >      
            <input type="button" name = "btn" value = "購入履歴" >      
       <%  } %>
           
        </form>
        
       <a href="UserInsert.jsp">新規登録</a>
       
    </body>
</html>
