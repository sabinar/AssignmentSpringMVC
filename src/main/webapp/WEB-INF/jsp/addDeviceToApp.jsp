<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Add App to Device Page</title>

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
                <h1>Add App to Device Page</h1>
            </div>
            <form:form method="post" action="add" commandName="application" class="form-vertical">
				<table>
					<tbody>
						<tr>
						
							<td><form:label path="appName">Application Name</form:label></td>
							<td><form:input path="appName" value="${appDetails.appName}"/></td>
						</tr>
						<tr>
							<td><form:label path="appDesc">Application Description</form:label></td>
							<td><form:input path="appDesc" value="${appDetails.appDesc}"/></td>
						</tr>
						<tr>
							<td><form:label path="deviceId">Device Id</form:label></td>
							<td><form:input path="deviceId" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Application" class="btn"/></td>
							<td><a href="<c:url value='people' />">Back to User Page</a></td>
						</tr>		
					</tbody>
				</table>
                
                                
                
            </form:form>


           
        </div>
    </div>
</div>

</body>
</html>