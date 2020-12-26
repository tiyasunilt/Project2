<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="webjars/bootstrap/4.5.3/css/bootstrap.min.css"/>
<script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
<style>
 a:hover{  
  box-shadow:0 0 10px black;
  text-decoration:none;
  border-radius:10px;
 }
</style>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-success"> 
   <a class="navbar-brand text-white" href="#">User Management Application</a> 
</nav>
<div class="container">
	<h4 class="bg-primary text-center p-1 rounded mt-1"><ins>Sign In Here</ins></h4>
		
	<!--  success or failure message region after insertion or deletion -->	
	 <div class="w-25 p-2 rounded font-weight-bold">
	  ${succMsg} ${errMsg}
	 </div>
	

	<form:form action="login" method="POST" modelAttribute="user">	    
		<table class="table mt-3 w-50 table-dark table-bordered font-weight-bold">
		 <thead>
			<tr>
				<td>Email</td>
				<td><form:input path="email" autofocus="autofocus" placeholder="enter email id"/></td>
			</tr>
			<tr>
				<td>Passwprd</td>
				<td><form:input path="" placeholder="enter password"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Login" class="btn btn-primary"/></td>
			</tr>
			<tr>
			    <td><a href="#">Sign-Up</a></td>
			    <td><a href="#">Forgot Password</a></td>
			</tr>
		</thead>	
		</table>

		
	</form:form>
	</div>   
</body>
</html>