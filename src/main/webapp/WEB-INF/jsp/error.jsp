<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8">
    <title>Error Page</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
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
                <h1>Error page</h1>
            </div>
            
            <table>
            	<tbody>
            		<tr>
            			<td colspan="2">An error has been encountered! Looks like user has some devices mapped!!!</td>
            		</tr>
            		<tr>
            			<td>Error:</td>
            			<td>${errors}</td>
            		</tr>
            		<tr>
            			<td colspan="2"></td>
            		</tr>
            		
            	</tbody>
            </table>
            
            <form method=GET action="/people/">
            	<input type="submit" value="Back" class="btn"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
