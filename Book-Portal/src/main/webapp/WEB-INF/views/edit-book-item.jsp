<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="icon" type="image/x-icon"
	href="http://cdn.onlinewebfonts.com/svg/img_174666.png">
<style>
a {
	text-decoration: none;
	color: white;
	cursor: pointer;
}

.form-row {
	margin-bottom: 20px;
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
}

.nav-wrap {
	height: 10vh;
	background-color: black;
	position: sticky;
	top: 0;
	left: 0;
	z-index: 100;
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

.login:hover {
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

.form-control {
	height: 30px;
	background-color: transparent;
}

.product {
	color: black;
}

.footer-text {
	color: white;
	text-align: center;
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
</style>
</head>

<body>
	<img src="css/images/bookstore.jpg" class="hero" alt="" srcset=""
		style="background-size: cover;">

	<div class="nav-wrap">
		<nav class="container nav">
			<a href="/" class="navlinks"> <span class="material-icons pe-2"
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

				<c:if test="${name != null }">
					<a href="/view-cart" class="navlinks"><span
						class="material-icons pe-2 icon" style="color: white">Orders</span><span>Order</span>
					</a>
					<a href="/logout" class="navlinks login"> <span>Logout</span>
					</a>
				</c:if>

			</div>
		</nav>
	</div>
	<div class="card rounded-3 text-black body  p-md-3 mx-md-12 "
		style="height: 50%; background-color: rgba(255, 255, 255, 0.25); backdrop-filter: blur(6px); -webkit-backdrop-filter: blur(6px); margin-bottom: 2cm; margin-right: 12cm; margin-left: 12cm; margin-top: 2cm;">
		<form:form action="edit-book-item-success" method="post"
			modelAttribute="editBook">
			<div class="container-fluid">

				<div class="title"
					style="color: tomato; text-align: center; font-size: 25px;">Edit
					Book Details</div>
				<div class="form-row">
					<div class="col-sm-3">
						<form:label path="book_id" for="id">ID</form:label>
						<form:input path="book_id" class="form-control" id="id"
							value="${book_id} " />
					</div>
					<div class="col-sm-9">
						<form:label path="book_title" for="title">Title</form:label>
						<form:input path="book_title" type="text" class="form-control"
							id="title" value="${book_title}" required="required" />
					</div>
					<div class="col-sm-9">
						<form:label path="book_image" for="image">Book Image</form:label>
						<form:input path="book_image" type="text" class="form-control"
							id="image" value="${book_image}" required="required" />
					</div>
				</div>

				<div class="form-row">
					<div class="col-sm-4">
						<form:label path="price" for="price">Book Price</form:label>
						<form:input path="price" type="text" class="form-control"
							id="price" value="${price}" required="required" />
					</div>
					<div class="col-sm-4">
						<form:label path="author" for="author">Author</form:label>
						<form:input path="author" type="text" class="form-control"
							id="author" value="${author}" required="required" />
					</div>
					<div class="col-sm-4">
						<form:label path="summary" for="summary">summary</form:label>
						<form:input path="summary" type="text" class="form-control"
							id="summary" value="${summary}" required="required" />
					</div>
					<div class="col-sm-4">
						<form:label path="category" for="category">Category</form:label>
						<form:input path="category" type="text" class="form-control"
							id="category" value="${category}" required="required" />
					</div>
					<div class="col-sm-4">
						<form:label path="stockcount" for="stockcount">StockCount</form:label>
						<form:input path="stockcount" type="text" class="form-control"
							id="stockcount" value="${stockcount}" required="required" />
					</div>

				</div>
			</div>


			<div class="row">
				<div class="col-sm-3">
					<input name="submit" class="btn btn-success" value="Save"
						type="submit" />
				</div>
			</div>
	

	</form:form>
	</div>
	<footer>
		<div class="footer-text p-3">&copy; Copyright Reserved</div>
	</footer>
</body>

</html>