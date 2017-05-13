 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
 
 
 <%@ include file="header.jsp"%>

<style>
form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	width: auto;
	padding: 10px 18px;
	border: none;
	cursor: pointer;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
<body>

	<h3 align="center"><b>Login Form</b></h3>

	<form action="">

		<div class="container">
			<div class="row">
				<!-- row Start -->
				<div class="col-lg-3">
					<!-- empty column for space from right -->
					</div>
					<div class="col-lg-6">
				
					<label><b>Username</b></label> <input type="text"
						placeholder="Enter Username" name="uname" required> <label><b>Password</b></label>
					<input type="password" placeholder="Enter Password" name="psw"
						required>

					<button type="submit">Login</button>
										<button type="button" class="cancelbtn">Cancel</button>
					<input type="checkbox" checked="checked"> Remember me
				</div>
				</div>
				<div class="container">
					<span class="psw">Forgot <a href="#">password?</a></span>
				</div>
			</div>

	</form>
<%@ include file="footer.jsp"%>


