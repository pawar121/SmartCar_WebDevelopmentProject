<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Added Car Details</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
#logout{
margin-right:70px;
float:right;
}
</style>



</head>
<body>

<%
HttpSession session2 = request.getSession();
 if(null!=session2.getAttribute("customers")){
    }
else{
    response.sendRedirect("error.htm");
    }
%>
 
<div id="logout">

<form action="logout.htm" method="post">
<button type="submit" class="btn btn-danger">Logout</button>
</form>

</div>   
  
  <h1>Car Booking Details</h1>
   
<div class="container">
  <p>Please Confirm the following booking details:</p>            
  <br>
  <br>
  
  <form action="/gautam/flows/payment">
  <table class="table table-bordered">
    <thead>
      <tr>
       
        <th>Name</th>
        <th>Car Name</th>
        <th>Car Model</th>
        <th>Car Number </th>
        <th> Total Amount</th>
      </tr>
      
    </thead>
    <tbody>    
      <tr>
          
        <td> <input type="text" name="name"      value ="${customers}" readonly> </td>
        <td> <input type="text" name="carname"   value ="${orderList.carName}" readonly ></td>
        <td> <input type="text" name="carmodel"  value ="${orderList.carModel}"readonly/></td>
        <td> <input type="text" name="carnumber" value ="${orderList.carnumber}"readonly/></td>
        <td><input id = "lmn" type="text" name="carPrice"  value ="${orderList.amount}"readonly/></td>
        
      </tr> 
    </tbody>
  </table>
  
    <input type="submit" class="btn btn-success" value ="Pay Online"/>
  </form>
  </div>
  