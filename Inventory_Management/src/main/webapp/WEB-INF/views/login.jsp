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
		width: 50%;
		padding: 16px;
		margin-top: 60px;
		margin-bottom: 40px;
		background-color: #282f32a3;
		}
		.heading{
		margin:20px;
		text-align:center;
		}
	</style>
	
    <title>Inventory Management | Login</title>
  </head>
  <body>
    <div class=container>
    	<div class=heading>
    		<h2>Inventory Management Tool</h2>
    	</div>
    	<hr>
    	<div class=heading>
    		<h1>Manager Login</h1>
    	</div>
    	<hr>
		<form action="checkLogin" method="post">
		  <div class="form-group">
		    <b><label for="exampleInputEmail1">Email Address</label></b>
		    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
		  </div>
		  <div class="form-group">
		    <b><label for="exampleInputPassword1">Password</label></b>
		    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
		  </div>
		  <button type="submit" class="btn btn-primary"><b>Login</b></button>
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