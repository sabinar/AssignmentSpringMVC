<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC and Hibernate Template</title>

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
            <a href="/" class="brand">Spring MVC and Hibernate Template</a>
            <a href="/" class="brand" id="heroku">by <strong>heroku</strong></a>
        </div>
    </div>
</div-->

<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <div class="page-header">
                <h1>Simple CRUD Page</h1>
            </div>
            <form:form method="post" action="add" commandName="person" class="form-vertical">

                <form:label path="firstName">First Name</form:label>
                <form:input path="firstName" />
                <form:label path="lastName">Last Name</form:label>
                <form:input path="lastName" />
                <form:label path="email">Email</form:label>
                <form:input path="email" />
                <input type="submit" value="Add Person" class="btn"/>
            </form:form>


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
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${peopleList}" var="person">
                        <tr>
                        	<td>${person.id} </td>
                            <td>${person.lastName}, ${person.firstName}</td>
                            <td>${person.email}</td>
                            <td><form action="delete/${person.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
                            <td><form action="getDevices/${person.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Display Devices"/></form></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            
            
            <c:if  test="${!empty deviceList}">
                <h3>Device List</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                    	<th>Phone Number</th>
                        <th>Operating System</th>
                        <th>User</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${deviceList}" var="device">
                        <tr>
                        	<td>${device.phoneNumber} </td>
                            <td>${device.operatingSystem}</td>
                            <td>${device.person.firstName}</td>
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
