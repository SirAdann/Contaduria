<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>UABC | Contaduría</title>
    
    <spring:url value="/resources" var="urlResources"></spring:url>
	<spring:url value="/" var="urlRoot"></spring:url>
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--  Línea para agregar los íconos de las acciones-->
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/glyphicons.css" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<spring:url value="/usuarios/editar" var="urlEditar" />
    <spring:url value="/usuarios/eliminar" var="urlEliminar" />
    
  </head>

  <body>

<jsp:include page="../includes/header.jsp"></jsp:include>

    <jsp:include page="../includes/menu.jsp"></jsp:include>
        
<br>
    <div class="container theme-showcase" role="main">

      <h3 class="text-center font-weight-bold">Listado de Usuarios</h3>
      
      <a href="${ urlRoot }usuarios/nuevo" class="btn btn-success" role="button" title="Nuevo Usuario" >Nuevo</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Correo</th>
                <th>Dependencia</th>
                <th>Rol</th>
                <th>Estatus</th>
                <th>Acciones</th>
            </tr>
            <c:forEach items="${ usuarios }" var="usuario">
            <tr>
                <td>${ usuario.idusuario }</td>
                <td>${ usuario.nombre}</td>
                <td>${ usuario.apellidos }</td>
                <td>${ usuario.correo }</td>
                <td>${ usuario.iddependencia }</td>
                <c:choose>
                  <c:when test="${ usuario.idtipousuario eq '1' }">
                <td>Normal</td>
                </c:when>
                <c:otherwise>
                <td>Administrador</td>
                </c:otherwise>
                </c:choose>
                
                
                <c:choose>
                <c:when test="${ usuario.idestatus eq '1' }">
                <td><span class="badge badge-success">Activo</span></td>
                </c:when>
                <c:otherwise>
                <td><span class="badge badge-danger">Inactivo</span></td>
                </c:otherwise>
                </c:choose>
                <td>
                    <a href="${urlEditar}/${usuario.idusuario}" class="btn btn-success btn-sm" role="button" title="Editar" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlEliminar}/${usuario.idusuario}" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
           </c:forEach>
        </table>
      </div>
          
      <hr class="featurette-divider">

    </div> <!-- /container -->
    
    <jsp:include page="../includes/footer.jsp"></jsp:include>

    <!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>    
  </body>
</html>