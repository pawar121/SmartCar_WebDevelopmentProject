<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drop Car</title>
</head>
<body background="resources/car.jpg">
 <%
 HttpSession session2 = request.getSession();
 if(null!=session2.getAttribute("customers")){
    out.write("username is "+session2.getAttribute("customers")); 
    }
else{
    response.sendRedirect("error.htm");
    }
%>

 <form action = "dropcar.htm" method="POST">
       <input type = "text" name="drop"/> Enter Car Number to Drop <br>
       
        <button type="submit" class="btn btn-primary" >Drop Car</button> 		 
        
 </form>
  
</body>
</html>