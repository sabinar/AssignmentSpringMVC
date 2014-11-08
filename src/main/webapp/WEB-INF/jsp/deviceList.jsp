<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Device List Page</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">

    <!--
      IMPORTANT:
      This is Heroku specific styling. Remove to customize.
    -->
    <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">
    <!-- /// -->

</head>

<body>
<!--  div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a href="/" class="brand">Device</a>
            <a href="/" class="brand" id="heroku">by <strong>heroku</strong></a>
        </div>
    </div>
</div-->

<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1>Device List page</h1>
            </div>
            
			
			
			<form:form method="get" action="people" commandName="personDetails">
				<table>
					<tbody>
						<tr>
							<td><form:label path="userId"></form:label>User Id</td>
							<td><form:input path="userId" value="${userId}" readonly="true"/>
						</tr>
						
						<tr>
							<td><form:label path="firstName"></form:label>First Name</td>
							<td><form:input path="firstName" value="${firstName}" readonly="true"/>
						</tr>
						
						<tr>
							<td><form:label path="lastName"></form:label>Last Name</td>
							<td><form:input path="lastName" value="${lastName}" readonly="true"/>
						</tr>
						
						<tr>
							<td><form:label path="email"></form:label>Email</td>
							<td><form:input path="email" value="${email}" readonly="true"/>
						</tr>
					</tbody>
				</table>

	            <c:if  test="${!empty deviceList}">
	                <h3>Devices</h3>
	                <table class="table table-bordered table-striped">
	                    <thead>
	                    <tr>
	                    	<th>Phone ID</th>
	                        <th>Phone</th>
	                        <th>Operating System</th>
	                    </tr>
	                    </thead>
	                    <tbody>
	                    <c:forEach items="${deviceList}" var="device">
	                        <tr>
	                        	<td>${device.deviceId}</td>
	                            <td>${device.phoneNumber}</td>
	                            <td>${device.operatingSystem}</td>                            
	                        </tr>
	                    </c:forEach>
	                    </tbody>
	                </table>
	            </c:if>
	            
	            
            </form:form>
            
            <form method=GET action="/people/">
            	<input type="submit" value="Back" class="btn"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>
