<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>User Listing Page</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">

    <!--
      IMPORTANT:
      This is Heroku specific styling. Remove to customize.
    -->
    <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">
    <!-- /// -->
    <style>
		.error {
			color: #ff0000;
		}    
    </style>
</head>

<body>


<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1>User Listing page</h1>
            </div>
            <form:form method="post" action="add" commandName="person" class="form-vertical">

				<table>
					<tbody>
						<tr>
							<td><form:label path="name">Name</form:label></td>
							<td><form:input path="name" /></td>
							<td><form:errors path="name" cssClass="error" /></td>
						</tr>
						<tr>
							<td><form:label path="email">Email</form:label></td>
							<td><form:input path="email" /></td>
							<td><form:errors path="email" cssClass="error" /></td>
						</tr>
						<tr>
							<td colspan="3"><input type="submit" value="Add Person" class="btn"/></td>
						</tr>
						<tr>
							<td><a href="<c:url value='deviceListPage' />">Device List</a></td>
							<td><a href="<c:url value='appListPage' />">Application List</a></td>
						</tr>
					</tbody>
				</table>
                
                
            </form:form>

			<form:errors path="*" cssClass="error" element="div">
                    
                  </form:errors>
			
            <c:if  test="${!empty peopleList}">
                <h3>People</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                    	<th>UserId</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${peopleList}" var="person">
                        <tr>
                        	<td>${person.userId} </td>
                            <td>${person.name}</td>
                            <td>${person.email}</td>
                            <td><form action="delete/${person.userId}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
                            <td><a href="<c:url value='getDevices/${person.userId}'/>">Display</a></td>
                            <td><a href="<c:url value='addDevices/${person.userId}'/>">Add Devices</a></td>
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
