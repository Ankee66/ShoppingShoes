<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<spring:url value="/resources/images" var="img" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
 <%@ include file="header.jsp"%>
	<div class="container" align="center">
	<div class="panel-body text-center">
	<article role="login">
				

			</article>

                    <img src="${cp }/resources/images/s.jpg" style="height:150px; width:20%"></div>
		
		<div class="row">
		<h3>Thanks for shopping have a nice day<br/><br/> You'll Get the Order summary soon through eMail</h3>
		<hr />
		<form:form>
		<input type="submit" name = "_eventId_submit" value="Go To Home" class="button button3"/>
		</form:form>				
</div>
</div>
<%@ include file="footer.jsp"%>
