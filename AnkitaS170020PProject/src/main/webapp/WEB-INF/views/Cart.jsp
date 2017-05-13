<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources/images" var="img" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
 <%@ include file="header.jsp"%>
<!-- My -->

 <script src="${cp }/resources/js/ex.js?v3"/></script>
<div class="container">
  <div class="container">
   <h2>My Cart</h2>   
    </div>
    </div>
    <div class="container" ng-app="myApp">
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
            <br/>
                <div>
                    <a class="button button1" ng-click = "removeFromCart()" > Clear Cart</a>
                    <a href="${cp}/customer/rest/cart/StartFlow" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
				
                </div>
			<br/>
			<br/>
            <table class="table table-responsive">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat = "item in cart.cartItems">
                        <td>{{item.product.name}}</td>
                        <td>{{item.product.price}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td><a href="#" class="button button3" ng-click="removeFromCart(item.product.id)">Delete</td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>
            </div>
        </div>
        <%@ include file="footer.jsp"%>
        