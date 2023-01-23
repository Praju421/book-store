<%@page import="com.js.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ENTER DETAILS TO UPDATE</h1>
<% Book b = (Book)request.getAttribute("book"); %>
 <form action="update2">
 BOOK ID : <input type = "number" name="id" value="<%=b.getBookid()%>" readonly="readonly"> <br> <br>
 BOOK NAME :<input type = "text" name="bookname" value="<%=b.getBookname()%>"> <br> <br>
 AUTHOR NAME : <input type = "text" name="authorname" value="<%=b.getAuthorname()%>"> <br> <br>
 NO OF PAGES : <input type = "text" name="nop" value="<%=b.getPages()%>"> <br> <br>
 PRICE :<input type = "text" name="price" value="<%=b.getPrice()%>"> <br> <br>
        <input type = "submit" value="update"> 
         </form>
</body>
</html>