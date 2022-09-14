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
	
    <title>Inventory Management | Processed Material</title>
  </head>
  <body>
    
    <div class="container">
    	<div class="heading">
    		<h1>Manager Dashboard - Processed Material Section</h1>
    	</div>
		
		<nav class="navbar navbar-dark bg-primary">
		  <!-- Navbar content -->
		  	<span>
			  	<a class="btn btn-primary" href="dashboard" role="button"><b>Home</b></a>
				<a class="btn btn-primary" href="addProMatForm" role="button"><b>Add Material</b></a>
				<a class="btn btn-primary" href="viewProMat" role="button"><b>View Material</b></a>
				<a class="btn btn-primary" href="updateProMatform" role="button"><b>Update Material</b></a>
				<a class="btn btn-dark" href="issueProMatform" role="button"><b>Issue Material</b></a>
				<a class="btn btn-primary" href="viewProMatLog" role="button"><b>Processed Material Issue Log</b></a>
			</span>
			<span>
				<a class="btn btn-danger" href="login" role="button"><b>Log Out</b></a>
			</span>
		</nav> 
		<br>
		<div class="heading2">
    		<h2>Issue Processed Material</h2>
    	</div>
    	<hr>
    	<form action="issueProMat" method="post">
		  <div class="form-row">
		  	<div class="form-group col-md-6">
		      <b><label for="inputEmail4">Issue Id:</label></b>
		      <input type="number" min="1" name="issueId" class="form-control" id="inputEmail4" placeholder="Enter Issue Id" required>
		    </div>
		    <div class="form-group col-md-6">
		      <b><label for="inputEmail4">Material Id:</label></b>
		      <input type="number" min="1" name="itemId" class="form-control" id="inputEmail4" placeholder="Enter Material Id" required>
		    </div>
		  </div>
		  <div class="form-row">		
			<div class="form-group col-md-6">
		      <b><label for="inputEmail4">Material Quantity:</label></b>
		      <input type="number" min="1" name="itemQuantity" class="form-control" id="inputEmail4" placeholder="Enter Quantity" required>
		    </div>
		    <div class="form-group col-md-6">
		      <b><label for="inputEmail4">Date:</label></b>
		      <input type="date" name="issueDate" class="form-control" id="inputEmail4" placeholder="Enter Date" required>
		    </div>		
		  </div>
		  <div class="form-group">
			<b><label for="inputPassword4">Issuer Name:</label></b>
	        <input type="text" name="issuerName" class="form-control" id="inputPassword4" placeholder="Enter Issuer Name" required>		    
		  </div>
	
		  <button type="submit" class="btn btn-primary"><b>Issue</b></button>
		</form>
		<br>
		<hr>
		<footer class="footer">
		    <div class="text-center">
	          Copyright © 2022 Hemant
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