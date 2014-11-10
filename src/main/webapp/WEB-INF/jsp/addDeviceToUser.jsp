<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Add Device Page</title>

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
                <h1>Add Device To User</h1>
            </div>
            <form:form method="get" action="" commandName="personDetails" class="form-vertical">
				<table>
					<tbody>
						<tr>
							<td><form:label path="userId">User ID</form:label></td>
							<td><form:input path="userId" value="${userId}" readOnly="true" /></td>
						</tr>
						<tr>
							<td><form:label path="name">User Name</form:label></td>
							<td><form:input path="name" value="${name}" readOnly="true" /></td>
						</tr>
						<tr>
							<td><form:label path="email">Email</form:label></td>
							<td><form:input path="email" value="${email}" readOnly="true" /></td>
						</tr>
								
					</tbody>
				</table>
            </form:form>
            
             <form:form method="post" action="addDeviceToUser/${personDetails.userId}" commandName="deviceDetails" class="form-vertical">
				<table>
					<tbody>
						<tr>
							<td><form:label path="phoneNumber">Phone number</form:label></td>
							<td><form:input path="phoneNumber" /></td>
							<td><form:errors path="phoneNumber" cssClass="error" /></td>
						</tr>
							
						<tr>
							<td><form:label path="operatingSystem">Operating System</form:label></td>
							<td><form:input path="operatingSystem" /></td>
							<td><form:errors path="operatingSystem" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><input type="submit" value="Add Device" class="btn"/></td>
							<td><a href="<c:url value='backToUserListing' />">Back to User Listing</a></td>
						</tr>
					</tbody>
				</table>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
