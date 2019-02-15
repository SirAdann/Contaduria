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
    <title>UABC | Contadur�a</title>

    <spring:url value="/resources" var="urlResources"></spring:url>
	<spring:url value="/" var="urlRoot"></spring:url>
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--  L�nea para agregar los �conos de las acciones-->
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/glyphicons.css" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<spring:url value="/dependencias/editar" var="urlEditar" />
    <spring:url value="/dependencias/eliminar" var="urlEliminar" />

  </head>

  <body>

<!-- Encabezado -->
	<jsp:include page="../includes/header.jsp"></jsp:include>

    <!-- Barra de navegaci�n -->
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
<br>
    <div class="container theme-showcase" role="main">

      <h3 class="text-center font-weight-bold">Listado de Dependencias</h3>
      
      <a href="${ urlRoot }dependencias/nuevo" class="btn btn-success" role="button" title="Nueva Dependencia" >Nueva Dependencia</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Dependencia</th>
                <th>Campus</th>
                <th>Acciones</th>
               
            </tr>
            <c:forEach items="${ dependencias }" var="dependencia">
            <tr>
                <td>${ dependencia.iddependencia }</td>
                <td>${dependencia.dependencia}</td>
                <td>${ dependencia.campus }</td>
               
              
                <td>
                    <a href="${urlEditar}/${dependencia.iddependencia}" class="btn btn-success btn-sm" role="button" title="Editar" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlEliminar}/${dependencia.iddependencia}" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
           </c:forEach>
        </table>
      </div>
          
      <hr class="featurette-divider">

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="../bootstrap/js/bootstrap.min.js"></script> 
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
      $(function () {
          $("#fechaEstreno").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
  </body>
</html>
