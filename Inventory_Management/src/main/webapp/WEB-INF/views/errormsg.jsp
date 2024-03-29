<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<style>
		body{
	    background-image: url('https://res.cloudinary.com/brazen/image/upload/q_auto,f_auto/default-images/backgrounds/city.jpg');
	    height: 80%;
	    background-repeat: no-repeat;
	    background-size: cover;
	    color:#ffff;
	 	}
		.container{
		width:100%;
		padding:16px;
		margin-top: 20px;
		margin-bottom: 20px;
		background-color: #282f32a3;
		}
		.heading{
		margin:20px;
		text-align:center;
		}
		.heading2{
		text-align:center;
		padding:5px;
		}
	</style>
	
    <title>Inventory Mangement | Raw Material</title>
  </head>
  <body>
    
    <div class="container">
    	<div class="heading">
    		<h1>Manager Dashboard - Raw Material Section</h1>
    	</div>
		
		<nav class="navbar navbar-dark bg-primary">
		  <!-- Navbar content -->
		  	<span>
			  	<a class="btn btn-primary" href="dashboard" role="button"><b>Home</b></a>
				<a class="btn btn-primary" href="addrawmatform" role="button"><b>Add Raw Material</b></a>
				<a class="btn btn-primary" href="viewrawmat" role="button"><b>View Raw Material</b></a>
				<a class="btn btn-primary" href="updateRawMatform" role="button"><b>Update Raw Material</b></a>
				<a class="btn btn-primary" href="issueRawMatform" role="button"><b>Issue Raw Material</b></a>
				<a class="btn btn-primary" href="viewRawMatLog" role="button"><b>Raw Material Issue Log</b></a>
			</span>
			<span>
				<a class="btn btn-danger" href="login" role="button"><b>Log Out</b></a>
			</span>
		</nav> 
		<br>
		<hr>
		<div class="heading2" >
    		<p>
    		<h2><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-exclamation-triangle-fill" viewBox="0 0 16 16">
  					<path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
				</svg> Error
			</h2>
    		<h3><%=request.getAttribute("msg") %></h3>
    	</div>
    	<br>
    	<hr>
    	<footer class="footer">
		   <div class="text-center">
	         Copyright � 2022 Hemant
	       </div>
	    </footer>  	
    </div>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>