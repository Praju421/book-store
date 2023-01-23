<%@page import="com.js.dto.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LIST OF BOOKS</h1>
<table border = "2px solid color">
<tr>
<th>book_id</th>
<th>book_name</th>
<th>author_name</th>
<th>no_of_pages</th>
<th>price</th>
<th>Delete</th>
<th>update</th>
<tr>


<% ArrayList<Book> books =(ArrayList)request.getAttribute("data");
for (Book b : books){
%>
<tr>
<td><%= b.getBookid() %></td>
<td><%= b.getBookname() %></td>
<td><%= b.getAuthorname() %></td>
<td><%= b.getPages() %></td>
<td><%= b.getPrice() %></td>
<td><a href="delete?id=<%=b.getBookid()%>">delete</a></td>
<td><a href="update1?id=<%=b.getBookid()%>">edit</a></td>
</tr>
<%} %>

</table>
<a href="welcome.html">HOME</a>

</table>
</body>
</html>