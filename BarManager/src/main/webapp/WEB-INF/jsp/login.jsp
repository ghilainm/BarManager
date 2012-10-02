<%@ include file="./templates/include.jsp" %>
<%@ include file="./templates/header.jsp" %>
	<form:form method="POST" commandName="user">
		<form:errors path="*" element="div" cssClass="errorblock" />
		<fieldset>
	    	<legend>Login information</legend>
	    	<div>
	        	<label for="login">Login</label>
	            <input type="text" id="login" name="login" required/>
	            <form:errors path="login" cssClass="error" />
	        </div>
	        <div>
	        	<label for="password">Password</label>
	            <input type="password" id="password" name="password" required/>
	            <form:errors path="password" cssClass="error" />
	        </div>
	    </fieldset>
	</form:form>
<%@ include file="./templates/footer.jsp" %>