<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
</head>
<body>
<div class="login-container">

      <form class="form-signin" action="<c:url value='/j_spring_security_check' />" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required  autofocus >
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password"  name="password" class="form-control" placeholder="Password" required >                           
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div> 
    <script>
    	
   	</script>

</body>
</html>