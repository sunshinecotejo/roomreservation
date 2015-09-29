<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Building </title>
    <link  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="row">
		<div class="col-lg-6">
			<div class="input-group" align="right">
				<form class="navbar-form navbar-left" role="search" method="get" action="/read/1">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="id">
					</div>
					<button type="submit" class="btn btn-default">Search</button>
				</form>
			</div>
		</div>
	</div>
	
	<div class="panel panel-default" align="center">
  	<div class="panel-heading">Building</div>
	<c:if test="${!empty buildingList}"> 
		<a href="create">New Building</a>
		<table class="table" >
			<tr>
				<th>Building Id</th>
				<th>Building Name</th>
				<th>Building Address</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${buildingList}" var="building">
				<tr>
					<td>${building.buildingId}</td>
					<td>${building.buildingName}</td>
					<td>${building.buildingAddress}</td>
					<td>
						<a href="update/${building.buildingId}">edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete/${building.buildingId}">delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>