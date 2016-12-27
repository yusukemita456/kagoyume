<%-- 
    Document   : item
    Created on : 2016/12/22, 16:57:06
    Author     : user2
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.itembeans"%>
<%

    HttpSession hs = request.getSession();
    itembeans item  = new itembeans();
    item = (itembeans) hs.getAttribute("itm");
    int i = item.getItemId();
    
    ArrayList <itembeans> itm = new ArrayList<itembeans>();
    itm = (ArrayList<itembeans>)hs.getAttribute("searchResultData");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         
            <img src="<% out.print(itm.get(i).getImage()); %>" ><br> 
            <%= itm.get(i).getName() %><br>
            <%= itm.get(i).getDescription() %><br>
            <%= itm.get(i).getHeadline() %><br>
            <%= itm.get(i).getCode() %><br>
            <%= itm.get(i).getPrice() %><br>
            
            <form action="add" method = "get">
            <input type="hidden" name ="itemID" value="<%=i%>">    
            <input type="submit" value="カートに追加">
            
        </form>
        
        
            
    </body>
</html>
