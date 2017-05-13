<%@page import="org.hibernate.Session"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE HTML>

<head>
<style>

.head{

margin-left:1400px;
}

#signup{
margin-left:1630px;


#address{

height:200px;
font-size:14pt;

}
}
#div1{
margin-top:500px;
margin-left:760px;
}

#admin_login{
margin-left:1300px;
}

.headers{
 
 margin-top:-20px; 
 height:130px;
 
}

#pick_response{
margin-top:300px;
margin-left:500px;
margin-right: 200px;
display:none;
color:white;
}
#coord{width:300px;}
#map_canvas {
width: 500px;
height: 400px;
}

#logout{
margin-right:30px;
float:right;
}


</style>
<title>Smart Car</title>
<link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css" />
<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.7.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

 <script>
 
  
		$(document).ready(function(){
		$("#pick").click(function(){
		alert("I'm here!");		
		$("#div1").hide();
		$("#pick_response").show();
		var a = $("#address").val();	
		var d = 2;	
		var unit = "km";
					$.ajax({ 
					type: 'GET', 
					url:  "https://www.zipcodeapi.com/rest/9fXPeE2Tn6KwWJdNvudi91ybQGRpCwIMLFC0jETGLEdHnrvSVJb5KJgBp802EIPq/radius.json/" +a+ "/" +d+ "/" +unit+ "", 
					dataType: "json",	
					success: function (zip_codes) 
					{   
						var str,str1,str2;
						var s=[];
						for(i=0; i<zip_codes.zip_codes.length;i++)
						{
							str1 = 	zip_codes.zip_codes[i].zip_code;
							str2 = '';
						    s.push(str1);
						}
					    console.log(s);	
					    searchCar(s);			
					}		
						   });
					
			     							
										});
		});
      
      function searchCar(zipdata){
    	  alert(zipdata);
    	
    	  $.ajax({
    		  traditional: true,
    		  type: 'POST',
    		  url:'searchCar.htm',
    		  data:{zipdata:zipdata},
    		  success: function (cars){
    			  		
    			  alert(cars);
    			  var resultHtml = "";
    			  var obj = jQuery.parseJSON(cars);
    			  var c=0;
    			  $.each(obj.cars, function(key, val){
    			     alert("Key+"+key+"Value"+val);
    				  alert(val[key]);
    					var c=0;
	$("#table1 > tbody").append("<tr><td>" +val[c]+ "</td> <td>"+val[c+1]+"</td> <td>"+val[c+2]+"</td> <td>"+val[c+3]+"</td><td>"+val[c+4]+"</td><td><form action ='bookCar.htm?a="+val[c]+"&b="+val[c+1]+"&c="+val[c+2]+"&d="+val[c+3]+"&e="+val[c+4]+"'  method='POST'><input type='submit' value='Book' onClick='checkUser()'/></form></td></tr>");
			
    				  
    			    });
    			  
    		  }		  
    	      });	  
      }
          
</script>



 </head>
 <body background="resources/car.jpg">
<h3> 
<%
HttpSession session2 = request.getSession();
 if(null!=session2.getAttribute("customers")){
    out.write("Welcome"+""+session2.getAttribute("customers")); 
    }
else{
    }
%>
</h3>

<div class="headers">
<h1> Smart Car </h1>
  
<div id="logout">
<form action="logout.htm" method="post">
<button type="submit" class="btn btn-danger">Logout</button>
</form>
</div> 

<div id="admin_login">

<form:form class="form-inline"  action="admin.htm"  method="POST" commandName="Admin">
<div class ="form-group"> 
<form:input type = "text"        path="username" class="form-control" id="abc"  placeholder="Username"/>
<form:input type = "password"    path="password" class="form-control" id="password"  placeholder="Password"/>
<button type="submit" class="btn btn-default" id="logins" onClick="abcd()">Login</button>
</div>
</form:form>
</div>

<div id="signup">
<form action="signup.htm">
New User?<button type="submit" class="btn btn-primary">Signup</button>
</form>
</div>


</div>


  <div class="form-group" id="div1">
  <form class="form-inline" >
    <br>
    <input type="text"  class="form-control" name="zip" id="address" placeholder="Enter Zip Code" value=""/>
	<br>
	<button type="button" class="btn btn-primary" id="pick">Pick up a Car</button> 		 
  
 </form>
 
 <form class="form-inline" action= "drop.htm" method="GET">
 
 <button type="submit" class="btn btn-primary" id="drop">Drop a Car</button> 		 
 
 
 </form>
 </div>
 
 
 
 
 
  
 <div id="pick_response">
   <h4>Following cars are available near your Location</h4>
  	  <table border="1" class="table table-bordered" id="table1">
  	  <thead>
	  <tr>
	  <th> CarName</th>
	  <th> Car Model </th>
	  <th> Car Number </th>
	  <th> Zip Code </th>
	  <th> Rate Per Hour</th>
	  </tr>
	  </thead>
	  <tbody>
	  <tr>
	  
	  </tr>
	  </tbody>	  
  	</table>
</div>


</body>
</html>