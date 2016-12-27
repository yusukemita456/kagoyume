<%-- 
    Document   : Search1
    Created on : 2016/12/21, 18:28:07
    Author     : user2
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.itembeans"%>
<%@page import="kagoyume.SearchResultData"%>

<%  
    
    HttpSession hs = request.getSession();
    
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
        
        
        <%  for(int i = 0;i < itm.size(); i++){ %>
        
        <a href = "Item?id=<%=i%>"><img src="<% out.print(itm.get(i).getImage()); %>" ></a>商品名 <a href = "Item?id=<%=i%>"><%= itm.get(i).getName() %> </a>　<%= itm.get(i).getPrice()%>円 <br>
            
        
        <% } %> 
          
                
                    
    </body>
</html>
