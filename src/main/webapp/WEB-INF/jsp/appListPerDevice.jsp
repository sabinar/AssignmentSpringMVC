<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Application List Per Device Page</title>

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
                <h1>Application List Per Device page</h1>
            </div>
            
			<form method="get" action="/device/">
				
				<table>
					<tbody>
						<tr>
							<td>Device Id</td>
							<td></td>
						</tr>
						<tr>
							<td>Phone Number</td>
							<td></td>
						</tr>
						<tr>
							<td>Operating System</td>
							<td></td>
						</tr>
					</tbody>
				</table>

	            <c:if  test="${!empty applicationList}">
	                <h3>Applications</h3>
	                <table class="table table-bordered table-striped">
	                    <thead>
	                    <tr>
	                        <th>App Id</th>
	                        <th>Name</th>
	                        <th>Description</th>
	                    </tr>
	                    </thead>
	                    <tbody>
	                    <c:forEach items="${applicationList}" var="application">
	                        <tr>
	                            <td>${application.appId}</td>
	                            <td>${application.appName}</td>
	                            <td>${application.appDesc}</td>	                            
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
