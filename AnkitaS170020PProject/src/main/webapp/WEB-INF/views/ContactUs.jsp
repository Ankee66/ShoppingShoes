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

	<h3 align="center">
		<b>Contact Us</b>
	</h3>

	<form action="">

		<div class="container">
			<div class="row">
				<!-- row Start -->
				<div class="col-lg-2">
					<!-- empty column for space from right -->
				</div>
				<div class="col-lg-4">

					<label><b>Frist Name</b></label> <input type="text"
						placeholder="Enter FristName" name="uname" required> <label><b>Last
							Name</b></label> <input type="text" placeholder="Enter LastName" name="uname"
						required> <label><b>City</b></label> <input type="text"
						placeholder="Enter city" name="uname" required> <label><b>Moblie
							Number </b></label> <input type="text" placeholder="Enter Moblie Number"
						name="uname" required> <label><b>Massage</b></label> <input
						type="text" placeholder="Enter Massage" name="uname" required>


					<button type="submit">send</button>


				</div>
				<div class="col-md-6">
					<div>
						<div class="panel panel-default" style="height: 450px; width: 80%">
							<div class="text-center header">
								<legend class="text-center header">
									<b>Our Office</b>
								</legend>
							</div>
							<div class="panel-body text-center">
								<img src="${cp }/resources/images/4.jpg"
									style="height: 250px; width: 60%">
							</div>

							<div align="center">
								<b><h4>Address</h4></b>
								201. Time Square Building<br /> fatehgunj,<br /> Vadodara,
								Gujarat<br />
							</div>
							<hr />
						</div>
					</div>
				</div>
			</div>
		</div>


	</form>
	<%@ include file="footer.jsp"%>