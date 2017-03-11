<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<script src="<spring:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<spring:url value="/project/add" var="formUrl" />
			<form:form action="${formUrl}" method="POST" cssClass="col-md-8 col-md-offset-2" modelAttribute="project">
				<div class="form-group">
					<label for="project-name">Name</label>
					<input type="text" id="project-name" 
							class="form-control" name="name"/>
					<form:errors path="name" />
				</div>
			
				<div class="form-group">
					<label for="project-type">Type</label>
					<form:select path="type" class="selectpicker" id="project-type" items="${types}" />
				</div>
				
				<div class="form-group">
					<label for="sponsor-name">Sponsor Name</label>
					<input id="sponsor-name" type="text" 
							class="form-control" name="sponsor.name"/>
				</div>
				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<input id="sponsor-phone" type="text" 
							class="form-control" name="sponsor.phone"/>
				</div>
				<div class="form-group">
					<label for="sponsor-email">Sponsor Email</label>
					<input id="sponsor-email" type="text" 
							class="form-control" name="sponsor.email"/>
				</div>
				
				<div class="form-group">
					<label for="authorizedFunds">Authorized Funds</label>
					<input id="authorizedFunds" type="text"
						class="form-control" name="authorizedFunds"/>
				</div>
			
				<div class="form-group">
					<label for="authorizedHours">Authorized Hours</label>
					<input id="authorizedHours" type="text"
						class="form-control" name="authorizedHours"/>
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<textarea class="form-control" rows="3" id="description" name="description"></textarea>
					<form:errors path="description" />
				</div>
	
				<div>
					<label for="project-special">Special</label>
					<input type="checkbox" name="special" id="special">
				</div>
				
				<div class="form-group">
					<label for="poc">POC</label>
					<form:input id="poc" cssClass="form-control" path="pointsOfContact[0]"/>
				</div>
				<div class="form-group">
					<label for="poc2">POC2</label>
					<form:input id="poc2" cssClass="form-control" path="pointsOfContact[1]"/>
				</div>
				<div class="form-group">
					<label for="poc3">POC3</label>
					<form:input id="poc3" cssClass="form-control" path="pointsOfContact[2]"/>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
				
		</div>
	</div>
</body>
</html>