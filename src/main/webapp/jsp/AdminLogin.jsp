<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>ADMIN LOGIN</title>

<style type="text/css">
.error {
	color: red;
	font-weight: bold;
}

html {
	text-align: center;
}

body {
	background-image:
		url('https://images.unsplash.com/photo-1487700160041-babef9c3cb55?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=852&q=80');
	background-repeat: no-repeat;
	background-size: cover;
}
.text-center{
	color:#fff;	
	text-transform:uppercase;
    font-size: 23px;
    margin: -50px 0 80px 0;
    display: block;
    text-align: center;
}
.input-container{
	position:relative;
	margin-bottom:25px;
}
.input-container label{
	position:absolute;
	top:0px;
	left:0px;
	font-size:16px;
	color:#fff;	
    pointer-event:none;
	transition: all 0.5s ease-in-out;
}
.input-container input{ 
  border:0;
  border-bottom:1px solid #555;  
  background:transparent;
  width:100%;
  padding:8px 0 5px 0;
  font-size:16px;
  color:#fff;
}
.input-container input:focus{ 
 border:none;	
 outline:none;
 border-bottom:1px solid #e74c3c;	
}
.input-container input:focus ~ label,
.input-container input:valid ~ label{
	top:-12px;
	font-size:12px;
	
}
.box{
	position:absolute;
	left:50%;
	top:50%;
	transform: translate(-50%,-50%);
    background-color: rgba(0, 0, 0, 0.89);
	border-radius:3px;
	padding:70px 100px;
}
h4{
color:red;
}
</style>

</head>
<body>
	

<div class="box">
	<form:form action="/adminlogin" method="post" modelAttribute="adminDto">



		<span class="text-center">ADMIN LOGIN</span>
		<div class="input-container">
			<input type="text" name="userId" /> <label>Admin
				Id</label>
			<form:errors path="userId" cssClass="error"></form:errors>
		</div>

		<br>
		<br>

		<div class="input-container">
			<input type="password" name="password" /> <label>Password</label>
			<form:errors path="password" cssClass="error"></form:errors>
		</div>


		<br>
		<br>

		<button type="submit" class="btn btn-primary">Login</button>

		<br>
		<br>
		<h4>${message}</h4>
	</form:form>
	</div>


</body>
</html>