<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>"Tesing"</title>
<style>
html {
	text-align: center;
}

body {
	background-image:
		url('https://images.unsplash.com/photo-1621193793262-4127d9855c91?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80');
	background-repeat: no-repeat;
	background-size: cover;
	place-items: center;
}
</style>
</head>
<body>

	<div class="row">


		<div class="col-md-1">
			
		</div>

		<div class="col-md-3">
			<br> <br>
			<div class="card" style="width: 18rem;">
				<img src="https://cdn-icons-png.flaticon.com/512/1055/1055645.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Check Vaccine Data</h5>
					<p class="card-text">You can see all the available locations
						and vaccine count</p>
					<a href="/vaccinedata" class="btn btn-primary">Check</a>
				</div>
			</div>
		</div>


		<div class="col-md-3">
			<br> <br>
			<div class="card" style="width: 18rem;">
				<img
					src="https://cdn-icons.flaticon.com/png/512/2347/premium/2347121.png?token=exp=1649073258~hmac=53d5c6c50ba4ee825c90a58da3fb6564"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Update Vaccine Data</h5>
					<p class="card-text">To update the vaccine count at a specific
						location</p>
					<a href="/updatevaccinedata" class="btn btn-info">Update</a>
				</div>
			</div>
		</div>


		<div class="col-md-3">
			<br> <br>
			<div class="card" style="width: 18rem;">
				<img src="https://cdn-icons-png.flaticon.com/512/6568/6568636.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Logout</h5>
					<p class="card-text">Please visit us back dear Admin ! We miss
						your presense</p>
					<a href="/dashboard" class="btn btn-danger">Bye</a>
				</div>
			</div>
		</div>
		
	

	</div>



</body>
</html>