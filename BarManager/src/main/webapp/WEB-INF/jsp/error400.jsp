<%@ include file="./templates/include.jsp" %>
<%@ include file="./templates/header.jsp" %>

	Oopps! An error occured! 
	<c:set var="exception" value="${javax.servlet.error.exception}"/>
	<c:forEach items="${exception}" var="element">
	  		<c:out value="${element}"/>
	</c:forEach>
	
	<c:out value="${test}"/>
	We can always take you <a href="<%=rootMap%>home">home</a>!

<%@ include file="./templates/footer.jsp" %>