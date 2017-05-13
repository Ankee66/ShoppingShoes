<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
  <spring:url value="/resources/css" var="css" />
  <spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="img" />

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart </title>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"> <a href="${cp}/listall"><span class="glyphicon glyphicon-home"></span>&nbsp;<b>Shoes.com</b></a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Man <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${cp}/listall/man">BOOTS</a></li>
          <li><a href="${cp}/listall">LOAFERS</a></li>
          <li><a href="${cp}/listall">SPROTSHOES</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">women <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${cp}/listall">FLATS</a></li>
          <li><a href="${cp}/listall">HEELS</a></li>
          <li><a href="${cp}/listall">SPROTSHOES</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Kids <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${cp}/listall">SANDALS</a></li>
          <li><a href="${cp}/listall">BOOTS</a></li>
          <li><a href="${cp}/listall">SLIPPERS</a></li>
        </ul>
      </li>
      <li><a href="${cp}/admin">Admin</a></li>
      
      
      <li><a href="${cp}/aboutus">About Us</a></li>
      <li><a href="${cp}/contactus">Contact Us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${cp}/RegistrationPage"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${cp}/LoginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>