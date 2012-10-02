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
	    <fieldset>
	    	<legend>Contact information</legend>
	    	<div>
	        	<label for="firstName">Prenom</label>
	            <input type="text" id="firstName" name="firstName" required/>
	            <form:errors path="firstName" cssClass="error" />
	        </div>
	        <div>
	        	<label for="lastName">Nom de famille</label>
	            <input type="text" id="lastName" name="lastName" required/>
	            <form:errors path="lastName" cssClass="error" />
	        </div>
	        <div>
	        	<label for="mail">E-mail</label>
	            <input type="email" id="mail" name="mail" required/>
	            <form:errors path="mail" cssClass="error" />
	        </div>
	    </fieldset>
	    <div>
	       	<input type="submit" value="Send" />
	    </div>
	</form:form>
<%@ include file="./templates/footer.jsp" %>