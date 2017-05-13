<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/resources/images" var="img"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@ include file="header.jsp"%>
<div class="container">
	<div class="panel panel-default" style="hight: 100px; width: 100%;">
	<div class="panel-heading" align="center">
			<h4><b>${product.name} Detail</b></h4>
	</div>
	<table>
	<tr> <div ng-app="myApp" ng-controller="myCtrl" ng-init="test='${pro}'">
		<td style="height: 500px;padding:0%; width: 60%; overflow: hidden;">
			<img src="${img}/${product.id}.jpg" alt="Card image cap" style="height: 500px;padding:8%; width: 100%; overflow: hidden; cursor: pointer">
		</td>
		<td>
		<table>
		<tr>
			<td>
			<b>Product :</b> ${product.name}<br/><br/><br/>
			<b>Version Description :</b> ${product.desc }<br/><br/><br/>
			<b>Price :</b> ${product.price }<br/><br/><br/>
			<b>Supplier :</b> ${product.supplier}<br/><br/><br/>
			</tr>
			<tr><td>
			<td ng-controller="cartCtrl"><button type="button" class="button button5" >ADD TO CART</button>						
			<a href="${cp }/viewlist"><button class="button button2">Back</button></a>
			</td>
			</div></tr>
	</table>
	</td>
</tr>

</table>
				
</div>
</div>	
<%@ include file="footer.jsp"%>

