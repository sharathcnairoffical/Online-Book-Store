<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
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
					<a href="/view-cart" class="navlinks"><span
						class="material-icons pe-2 icon" style="color: white">shopping_cart</span><span>Orders</span>
					</a>
					<a href="/logout" class="navlinks login"> <span>Logout</span>
					</a>
				</c:if>

			</div>
		</nav>
	</div>
	<div class="container">
		<img src="css/images/bookstore.jpg" class="hero" alt="" srcset="">
		<div class=" hero overlay"></div>
		<div class="hero-wrap">
			<div class="hero-text">
				Welcome ${name}</br> Start ordering!!!
			</div>
		</div>
		<div class="d-flex flex-wrap justify-content-evenly" >
			<c:forEach var="book" items="${allBooks}">

					<div class="card" style="width: 18rem;height: 100%;">
						<img src="${book.book_image}" class="card-img-top"
							alt="phone image">
						<div class="card-body">
							<h5 class="card-title">${book.book_title}</h5>
							<div class="price">
								<span class="material-icons"> currency_rupee </span>${book.price}</div>
								Author : ${book.author}
							<br>
							Category : ${book.category}
							<br>
							Quantity : ${book.stockcount}
							<br>
							Desc : ${book.summary}
							<div>
								<a
									href="/add-to-cart?id=${book.book_id}" class="btn btn-secondary">Place Order</a>
							</div>
						</div>

					</div>
				
			</c:forEach>
		</div>
	</div>
	<footer>
		<div class="footer-text p-3">&copy; Copyright Reserved</div>
	</footer>
</body>
</html>