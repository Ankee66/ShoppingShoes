
<%@ include file="header.jsp"%>

<div id="myContainer"
	style="height: 500px; width: 100%; overflow: hidden; cursor: pointer">
	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		data-interval="2000">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>

			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="${img}/1jpg" alt="Chania"
					style="height: 500px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

			<div class="item">
				<img src="${img}/2jpg" alt="Chania"
					style="height: 500px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

			<div class="item">
				<img src="${img}/3.jpg" alt="Flower"
					style="height: 500px; width: 100%; overflow: hidden; cursor: pointer">
			</div>

		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<!-- Cards -->
</div>
<div class="row" style="height: 400px; width: 100%;">

	<ul class="nav-justified">
		<li><div class="card ">
				<a href="${cp }/viewlist/iphone"></a><img class="card-img-top"
					src="${img}/5.jpg" alt="Card image cap"
					style="height: 300px; padding: 8%; width: 100%; overflow: hidden; cursor: pointer"></a>
				
			</div></li>
		<li><div class="card">
				<a href="${cp }/viewlist/ipad"></a><img class="card-img-top"
					src="${img}/7.jpg" alt="Card image cap"
					style="height: 300px; padding: 8%; width: 100%; overflow: hidden; cursor: pointer"></a>
				
			</div></li>
		<li><div class="card">
				<a href="${cp }/viewlist/mac"></a><img class="card-img-top"
					src="${img}/6.jpg" alt="Card image cap"
					style="height: 300px; padding: 8%; width: 100%; overflow: hidden; cursor: pointer"></a>
				
			</div></li>
	</ul>
</div>

<%@ include file="footer.jsp"%>

