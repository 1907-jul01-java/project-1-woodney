<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/view.css">
</head>
<body>
    <h2 align='center'>Requests</h2>

<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Requested Deal</th>
    <th>Highlights</th>
    <th>Status</th>
  </tr>
  <%
Connection conn;
try
{
Class.forName("org.postgresql.Driver");
String url="jdbc:postgresql://192.168.99.100:5432/project1db";
String username="project1db";
String password="project1db";
String query="select * from request";
conn=DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/project1db", "project1db", "project1db");
PreparedStatement pStatement = conn.prepareStatement(query);
ResultSet rs = pStatement.executeQuery();
while(rs.next())
{

%>
<tr>
  <td><%=rs.getString("firstName") %></td>
  <td><%=rs.getString("lastName") %></td>
  <td><%=rs.getString("deal") %></td>
  <td><%=rs.getString("highlight") %></td>
  <td><%=rs.getString("status") %></td>
</tr>
    <%

}
%>
</table>
<%
conn.close();
}
catch(Exception e)
{
e.printStackTrace();
}


%>
</table>
<form action="gmProfile.html">
  <input type="submit" value="Account Page" />
</form>
</body>
</html>