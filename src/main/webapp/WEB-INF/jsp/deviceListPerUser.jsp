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

<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1>Device List page</h1>
            </div>
            
			<form method="get" action="/people/">

				<table>
					<tbody>
					
						<tr>
							<td><form:label path="personId">User Id</form:label></td>
							<td><form:input path="personId" value="${personDetails.userId}"/></td>
						</tr>
						<tr>
							<td><form:label path="firstName">First Name</form:label></td>
							<td><form:input path="firstName" value="${personDetails.firstName}"/></td>
						</tr>

						<tr>
							<td><form:label path="email">Email</form:label></td>
							<td><form:input path="email" value="${personDetails.email}" /></td>
						</tr>

					</tbody>
				</table>

	            <c:if  test="${!empty deviceList}">
	                <h3>Devices</h3>
	                <table class="table table-bordered table-striped">
	                    <thead>
	                    <tr>
	                        <th>Phone</th>
	                        <th>Operating System</th>
	                        <th>User Id</th>
	                    </tr>
	                    </thead>
	                    <tbody>
	                    <c:forEach items="${deviceList}" var="device">
	                        <tr>
	                            <td>${device.phoneNumber}</td>
	                            <td>${device.operatingSystem}</td>
	                            <td>${device.person.userId} ${device.person.firstName} ${device.person.lastName}</td>	                            
	                        </tr>
	                    </c:forEach>
	                    </tbody>
	                </table>
	            </c:if>
	            
	            <input type="submit" value="Back" class="btn"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>
