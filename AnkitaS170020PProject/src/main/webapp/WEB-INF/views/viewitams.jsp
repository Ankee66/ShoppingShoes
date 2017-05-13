<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/resources/images" var="img"/>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="header.jsp"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

 <div ng-app="myApp" ng-controller="Cart" ng-init="test='${pro}">
	 	<div class="container" align="center">
			<div class="panel panel-default">
				<div class="panel-heading"><B>${pro} List</B></div>
				<div class="panel-body">
					<input type="text" class="form-control input-lg" ng-model="test" placeholder="Search"><br />
					<table class="table table-responsive">
						<tr>
				<th ng-click="orderByMe('id')">ID</th>			
				<th ng-click="orderByMe('name')">Name</th>
				<th ng-click="orderByMe('quantity')">Quantity</th>
				<th ng-click="orderByMe('price')">Price</th>
				<th ng-click="orderByMe('supplier')">Sppier</th>
				<th ng-click="orderByMe('file')">Image</th>
				
							<th align="center"> View &#160; &#160; &#160; &#160; Add To Cart</th>
						</tr>
				<tr ng-repeat="x in names | orderBy:myOrderBy | filter:test">
				<td >{{x.id}}</td>
				<td >{{x.name}}</td>
				<td >{{x.quantity}}</td>
				<td >{{x.price}}</td>
				<td >{{x.supplier}}</td>
				<td><a href="${cp }/viewdetail/{{x.id}}"><button class="button button1">View</button></a>
				<td ng-controller="cartCtrl"><button type="button" class="button button5" ng-click="addToCart(x.id)">
				ADD TO CART</button>						
				</td>
		 		</tr>
				</table>
				</div>
			</div>
		</div>	
		
	</div><script src="${cp }/resources/js/ex.js?v3"></script> 
	<%@ include file="footer.jsp"%>