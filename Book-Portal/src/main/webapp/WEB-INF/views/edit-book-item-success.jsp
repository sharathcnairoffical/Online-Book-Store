<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!-- Starts -->




<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Edit Success</title>
<!-- google material Icons -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- fa Icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- bootstrap css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<style>

a {
	text-decoration: none;
	color: white;
	cursor: pointer;
}

.hero {
	position: absolute;
	width: 100%;
	height: 100vh;
	opacity: 90%;
	top: 0;
	left: 0;
	z-index: -100;
}

.hero-wrap {
	height: 80vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.hero-text {
	font-size: 4rem;
	font-weight: 900;
	color: white;
	text-transform: capitalize;
	text-align: center;
	font-family: 'Josefin Sans', sans-serif;
}

.overlay {
	opacity: 65%;
	background-color: black;
}

body {
	background-color: hsl(0, 20%, 0%);
	font-family: 'raleway', serif;
}

.nav-wrap {
	height: 10vh;
	background-color: black;
	position: sticky;
	top: 0;
	left:0;
	z-index:100;
}

nav {
	height: 100%;
	/* background-color: blue; */
}

.nav {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.navlinks {
	display: flex;
	align-items: center;
	padding: 0 1rem 0 0.7rem;
}

.login {
	background-color: tomato;
	border-radius: 4px;
}

.login:hover{
	color: black;
}

.nav-right {
	display: flex;
}

form {
	padding-right: 1rem;
	height: 100%;
}

.btn {
	all: unset;
	background-color: turquoise;
	color: black;
	padding: 0.23rem 1rem;
	border-radius: 4px;
	box-sizing: border-box;
}

.search-box {
	padding: 0.2rem 0.7rem;
	border-radius: 4px;
	border: none;
	outline: none;
	box-sizing: border-box;
}

.price {
	display: flex;
	align-items: center;
	font-weight: bold;
	font-size: 1.1rem;
	align-items: flex-end;
}

.product {
	color: black;
}

.footer-text {
	color: white;
	text-align: center;
	margin-top: 32%;
}

.card {
	position: relative;
	height: 75vh;
	transition: 500ms;
	margin-bottom: 2rem;
}

.card-img-top {
	height: 70%;
	width: 100%;
	object-fit: cover;
}

.card:hover {
	transform: scale(1.02);
}

a:hover {
	color: tomato;
}


.navbar {
	background-color: darkblue;
	font-size: 20px;
}

.alert {
	text-align: center;
}

.alert alert-success{
	color:red;
}
.nav-link {
	color: white;
}
</style>

</head>

<body>
	<div>
	
	</div>
	<div class="nav-wrap">
		<nav class="container nav">
			<a href="/cust" class="navlinks"> <span class="material-icons pe-2"
				style="color: white;">home</span> <span>Home</span>
			</a>
			<div class="nav-right">
				<div class="form">
					<form action="/search">
						<input type="text" name="book_title" class="search-box"
							placeholder="Search"> <input type="submit" value="Search"
							class="btn">
					</form>
				</div>

				<c:if test="${user != null }">
					<!-- <a href="/view-cart" class="navlinks"><span
						class="material-icons pe-2 icon" style="color: white">Orders</span><span>Order</span>
					</a> -->
					<a href="/logout" class="navlinks login"> <span>Logout</span>
					</a>
				</c:if>

			</div>
		</nav>
	</div>
		<br>
		<img src="css/images/bookstore.jpg" class="hero" alt="" srcset="">
		<div class="container">
			<div class="alert alert-success"> Book Details Updated
				Successfully</div>
		</div>
		<br>
		<!-- Footer -->
		<footer>
			<div class="footer-text p-3">&copy; Copyright Reserved</div>
		</footer>

		<!-- Footer -->

	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		setTimeout(function() {
			location = "/"
		},  1 * 2000)
	</script>

</body>

</html>

<!-- End -->
