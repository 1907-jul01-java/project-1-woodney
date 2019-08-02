<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
    .imgcontainer { 
    text-align: center; 
    margin: 24px 0 12px 0; 
} 
/*set image properties*/ 
  
img.avatar { 
    width: 40%; 
    border-radius: 50%; 
} 
</style>
</head>
<body>
        <h2 align = 'center'>Player's Account</h2> 
    <%
        if(session.getAttribute("username")==null)
        {
            response.sendRedirect("index.html");
        }

        else if(session.getAttribute("player")==null){
            response.sendRedirect("index.html");
        }

    %>

   
    Welcome ${player}

    
    <!--Step 1 : Adding HTML-->
    <form action="logout" method="GET"> 
        <div class="imgcontainer"> 
            <img src= 
"http://blog.logomyway.com/wp-content/uploads/2017/01/nba-logo-design.jpg" 
                 alt="Avatar" class="avatar"> 
        </div> 
        <div class="container">   
			<button type="submit">Logout</button>
        </div> 
    </form>
    <form action="request" method="POST">
        <div class="container" style="background-color:#f1f1f1"> 
            <button type="button" class="cancelbtn">Cancel</button>
            <a href="viewrequest.jsp">View requests</a>
            <a href="requestform.jsp">Request deal</a>
        </div> 
    </form>
    <form action="update.html">
        <div class="container"> 
            <button type="submit">Edit Information</button>
        </div> 
    </form>
</body>
</html>