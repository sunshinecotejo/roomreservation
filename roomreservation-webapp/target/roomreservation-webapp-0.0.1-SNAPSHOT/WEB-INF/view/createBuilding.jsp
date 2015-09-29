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
<div>
    <form>
        <div class="form-group">
            <label for="lblBuildingName">Building Name</label>
            <input type="text" class="form-control" id="lblBuildingName" >
        </div>
        <div class="form-group">
            <label for="lblBuildingAddress">Building Addres</label>
            <input type="text" class="form-control" id="lblBuildingAddress" >
        </div>
        
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>