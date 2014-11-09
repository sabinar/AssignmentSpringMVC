<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Application Page</title>

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
                <h1>Application page</h1>
            </div>
            <form:form method="post" action="add" commandName="application" class="form-vertical">
            	
            	
            
				<table>
					<tbody>
						<tr>
							<td><form:label path="appName">Application Name</form:label></td>
							<td><form:input path="appName" /></td>
							<td><form:errors path="appName" cssClass="error" /></td>
						</tr>
						<tr>
							<td><form:label path="appDesc">Application Description</form:label></td>
							<td><form:input path="appDesc" /></td>
							<td></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Application" class="btn"/></td>
							<td><a href="<c:url value='backToDevice' />">Back to Device Page</a></td>
						</tr>		
					</tbody>
				</table>
                
                                
                
            </form:form>


            <c:if  test="${!empty applicationList}">
                <h3>Applications</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${applicationList}" var="application">
                        <tr>
                            <td>${application.appId}</td>
                            <td>${application.appName}</td>
                            <td>${application.appDesc}</td>
                            <td><form action="delete/${application.appId}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
                            <td><a href="<c:url value='addDevice/${application.appId}'/>">Add Device</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
