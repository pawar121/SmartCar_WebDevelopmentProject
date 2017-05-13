<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Select Card Type</title>

</head>
<body>
<h3> Please enter the Type of card you want to Use:</h3> 
<form action="" method="Post">
 <select id="mySelect" class="input-small" >

  <option>Card Type</option>
  <option>Visa</option>	
  <option>Master</option>
  <option>American Express</option>
</select>

  <input type="submit"  name="_eventId_next" class="btn btn-success" value = "Go"/>
</form>

</body>
</html>