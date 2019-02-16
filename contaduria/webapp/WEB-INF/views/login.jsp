<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Contaduria UABC">
    <meta name="author" content="Departamento de Apoyo Inform�tico">

    <title>UABC | Contaduria UABC</title>
	<spring:url value="/resources" var="urlResources"></spring:url>
	<spring:url value="/" var="urlRoot"></spring:url>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="${ urlResources }/bootstrap/css/signin.css">
  </head>

  <body>
  
  <!-- Encabezado -->
	<div class="container">
		<div class="row">
		<img src="${ urlResources }/images/Banner.png" class="rounded mx-auto d-block" alt="Inicio" width="720" height="123">
		</div>
	</div>
	
	<div class="text-center">  
	    <form class="form-signin" action="${ urlRoot }login" method="post">
	      <img class="mb-4" src="${ urlResources }/images/person-green.png" alt="" width="200" height="200">
	      
	      <c:if test="${ param.error!=null }">
	        <h4 class="form-signin-heading" style="color:red">Acceso Denegado</h4>
	      	<img src="${ urlResources }/images/error.png" width="48" height="48" class="center">
	      </c:if>
	      
    	  <h1 class="h3 mb-3 font-weight-normal">Acceso</h1>
	      <label for="inputEmail" class="sr-only">Direcci�n de correo</label>
    	  <input type="text" id="username" name="username" class="form-control" placeholder="Direcci�n de correo" required autofocus>
	      <label for="inputPassword" class="sr-only">Contrase�a</label>
    	  <input type="password" id="password" name="password" class="form-control" placeholder="Contrase�a" required>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	      <button class="btn btn-lg btn-success btn-block" type="submit">Enviar</button>
    	  <p class="mt-5 mb-3 text-muted">&copy; Patronato Universitario UABC - 2018</p>
    	</form>
    </div>
	
  </body>
</html>