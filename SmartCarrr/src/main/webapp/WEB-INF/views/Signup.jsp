<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE HTML>
<head>
<title>
Signup Form
</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>


<body background="resources/car.jpg">
<div class="container">
    <div class="row">
        <form:form role="form" action="signup.htm" commandName="customer">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <div class="input-group">
                        <form:input path="userName" class="form-control" placeholder="Enter Username"/><form:errors path="userName"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                 <div class="form-group">
                    <div class="input-group">
                        <form:input type="password" path="password" class="form-control"  placeholder="Enter Password"/><form:errors path="password"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="input-group">
                        <form:input type="text" path="email" class="form-control"  placeholder="Enter Email"/><form:errors path="email"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <form:input type="text" path="phoneno" class="form-control"  placeholder="Enter Phone Number"/><form:errors path="phoneno"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
               <input type="submit" value="Submit" class="btn btn-info pull-right">
            </div>
        </form:form>
   </div>
</div>
</body>