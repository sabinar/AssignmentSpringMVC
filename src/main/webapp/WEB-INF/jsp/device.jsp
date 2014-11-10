<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Device Page</title>

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
                <h1>Device page</h1>
            </div>
            
            <table>
            	<tbody>
            		<tr>
            			<td colspan="2">To add device, please visit user listing page</td>
            		</tr>
            		<tr>
            			<td><a href="<c:url value='people' />">User List</a></td>
            			<td><a href="<c:url value='appListPage' />">Application List</a></td>
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
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${deviceList}" var="device">
                        <tr>
                            <td>${device.phoneNumber}</td>
                            <td>${device.operatingSystem}</td>
                            <td>${device.person.userId} ${device.person.name}</td>
                            <td><form action="delete/${device.deviceId}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
                            <td><a href="<c:url value='getApplications/${device.deviceId}'/>">Display Apps</a></td>
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
