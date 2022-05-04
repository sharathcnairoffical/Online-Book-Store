<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bookstore Home Login Page</title>
        <link rel="stylesheet" href="/css/log.css">
        <link rel="stylesheet" href="/portal/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Oswald:400" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
				crossorigin="anonymous">
         <link rel="icon" type="image/x-icon" href="http://cdn.onlinewebfonts.com/svg/img_174666.png">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
            integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
        <script src="/portal/js/bootstrap.min.js"></script>
    </head>
    <style>

                a {
					text-decoration: none;
					color:coral;
					cursor: pointer;
				}
                .btn {
					all: unset;
					background-color: coral;
					color: black;
					padding: 0.23rem 1rem;
					border-radius: 4px;
					box-sizing: border-box;
				}
    </style>
    <body>
        <img src="css/images/bookstore.jpg" class="hero" alt="" srcset="">
        <div class="nav-wrap">
            <nav class="container nav">
                <a href="/login" class="navlinks"> <span class="material-icons pe-2" style="color: white;">home</span>
                    <span>Home</span>
                </a>
                <!-- <div class="nav-right">
                    <div class="form">
                        <form action="/search">
                            <input type="text" name="book_title" class="search-box" placeholder="Search"> <input
                                type="submit" value="Search" class="btn">
                        </form>
                    </div> -->


                </div>
            </nav>
        </div>
           
        


    <div class="card rounded-3 text-black body  p-md-3 mx-md-12 " style=" height: 50%; background-color:rgba(255, 255, 255, 0.25);
    backdrop-filter: blur(6px);-webkit-backdrop-filter: blur(6px); margin-bottom:2cm;margin-right:12cm;margin-left:12cm;margin-top:2cm;">
            <!-- <h1 class="text-danger">${sessionScope.error}</h1> -->
            <div class="row md-12">
                <spring:url value="/home" var="homePageLink"></spring:url>
                <div class="col-md-12 ">
                    <div class="text-center">
                    <h2  style="color: black;">Login</h2><br></div>
                    <spring:url value="/login" var="loginUrl"></spring:url>
                    <form:form method="post" modelAttribute="model" action="${loginUrl}" >
                    <spring:bind path="userName">
                        <div class="form-group ">
                            <label for="userName" style="color: white;" >Username</label>
                            <form:input path="userName" type="text" 
                                class="form-control ${status.error ? 'is-invalid' : ''}" id="userName" placeholder="Username" />
                            <form:errors path="userName" class="invalid-feedback" />
                        </div>
                    </spring:bind>
                    <spring:bind path="password">
                        <div class="form-group ">
                            <label for="password"style="color: white;">Password</label>
                            <form:input path="password" type="password" 
                                class="form-control ${status.error ? 'is-invalid' : ''}" id="password" placeholder="Password" />
                            <form:errors path="password" class="invalid-feedback" />
                        </div>
                        <br>
                    </spring:bind>
                        <button type="submit" class="btn btn-secondary">Login</button>
                    </form:form>
                    <span style="color:red;font-weight:bold">${error }</span>
                </div>
            </div>
        </div>
       


        <footer>
            <div class="footer-text p-3">&copy; Copyright Reserved</div>
        </footer>


    </body>
    </html>