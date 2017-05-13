<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
//get the station list
        com.me.spring.dao.StationDAO stationDao= new com.me.spring.dao.StationDAO();
        java.util.List stationList = stationDao.getList();
        pageContext.setAttribute("stations", stationList);
//get the cars list
		com.me.spring.dao.CarDAO carDao= new com.me.spring.dao.CarDAO();
        java.util.List carsList = carDao.getList();
        session.setAttribute("cars", carsList);
%>

<html>
<head>

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

 #addcar{
 
 margin-left: 180px;
 display:none;
 background-color: gray;
 
 }
 
 #viewcar{
  margin-left: 450px;
 display:none; 
 }
</style>

<script>
              
 
function addCar(){
	
	document.getElementById("addcar").style.display = "block";
	document.getElementById("viewcar").style.display = "none";

	}
function viewsCar(){
	
	document.getElementById("viewcar").style.display = "block";
	document.getElementById("addcar").style.display = "none";
}

</script>
</head>

<body onload="abc()" background="resources/car.jpg">

<div id="logout">

<form action="logout.htm" method="post">
<button type="submit" class="btn btn-danger">Logout</button>
</form>

</div> 


 
<h1>
	Hello
	<%= session.getAttribute("ad") %>
</h1>

	<button type="button" class="btn btn-primary" id="Add_Button" onClick="addCar()">Add Car</button> <br> <br> <br>
	<button type="button" class="btn btn-primary" id="View_Button" onClick="viewsCar()">View Cars</button>
  


<div id ="addcar">
<h3>Add Cars</h3>
<br>

<form:form  action="addCar.htm" method="POST" commandName="car" class="form-horizontal" role="form">

<div class="col-xs-3"> <strong>Car Number</strong>
	<form:input type="text" path="Car_No" class="form-control"
		placeholder="Car Number" />
</div>	
<br>
<div class="col-xs-3">	
	<form:input type="text" path="carName" class="form-control"
		placeholder="Car Name" />
		</div>
<div class="col-xs-3">
		
	<form:input type="text" path="carModel" class="form-control"
		placeholder="Car Model" />
		</div>
	<div class="col-xs-3">
		
	<form:input type="text" path="price" class="form-control"
		placeholder="Car Price" />
	</div>	
	<br> <br>
	<b>Station ID</b>	
	<form:select path="stationId" > Station Id
		<c:forEach var="stat" items="${stations}">
			<form:option value="${stat.station_id}" />
		</c:forEach>
	</form:select>
	<br> <br> <br> <br>
<button type="submit" class="btn btn-success">Add</button>
</form:form>
</div>


<div id="viewcar">


<table  class="table table-striped" border="1" >
      <thead>
      <tr>
        <th>CarNumber</th>
        <th>CarName</th>
        <th>Car Model</th>
        <th>Is Car In Use </th>
        <th>Price</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="itr" items="${cars}">
      	<form:form action="updateCar.htm" commandName="car" method="POST">
	      <tr>
		    <td id="abc"><form:input id="carno" type = "text" path="car_No"   value="${itr.car_No}"/></td>
	 	    <td><form:input type = "text" path="carName"  value="${itr.carName}"/></td>
	        <td><form:input type = "text" path="carModel" value="${itr.carModel}"/></td>
	        <td><form:input type = "text" path="car_In_Use" value="${itr.car_In_Use}"/></td>
	        <td><form:input type = "text" path="price" value="${itr.price}"/></td>
	        <td><button type="submit" class="btn btn-info">Update</button>
	        </td>
	      </tr>
	  	</form:form>
      </c:forEach>
      </tbody>
  </table>

</div>
</body>
</html>