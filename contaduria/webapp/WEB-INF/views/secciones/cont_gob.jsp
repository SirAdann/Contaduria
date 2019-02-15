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
<link rel="stylesheet"
	href="${ urlResources }/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--  Línea para agregar los íconos de las acciones-->
<link rel="stylesheet"
	href="${ urlResources }/bootstrap/css/glyphicons.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<jsp:include page="../includes/header.jsp"></jsp:include>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<br>
	<div class="container theme-showcase" role="main">

		<div class="page-header">
	<h3 class="blog-title text-center"><span class="label label-success">Contabilidad Gubernamental</span></h3>
      </div>
      <br>
      <p>
        <h5><div >La Contabilidad Gubernamental es de aplicación obligatoria a todas aquellas entidades que reciban ingresos públicos, entre ellas los órganos autónomos como lo es la UABC, es por ello que a partir del ejercicio 2012 las operaciones contables y presupuestales de esta institución se registran en base a lo establecido en la Ley General de Contabilidad Gubernamental y los diferentes documentos emitidos por CONAC. De acuerdo con lo anterior, el propósito de esta sección es poner a disposición de los Administradores de unidades académicas y administrativas, así como de todas aquellas personas que producen pólizas contables, los documentos que sirvan de apoyo para el correcto y oportuno registro de las operaciones. </div></h5>
   </p>
		<br>

		<div class="table-responsive">
			<table class="table table-striped ">
			
			<td>
			<table class=" table table-hover table-striped ">

				<div>
					<h3>Documentos</h3>
				</div> <c:forEach var="documento" items="${documentos}">
					<a href="${ urlResources }/${documento.liga}" target="document"><p>${documento.orden} - ${documento.nombre}</p></a>
		
		</c:forEach>
		</table>
		</td>
		
		<td>
		<div role="main" align="right">
			<iframe style="float: right;"
				src="${ urlResources }/ViewerJS/#../${documento.liga}" width='600'
				height='600' allowfullscreen webkitallowfullscreen name="document"></iframe>
		</div>
		</td>
</table>
	</div>


	</div>



	<!-- /container -->

	<jsp:include page="../includes/footer.jsp"></jsp:include>

			<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	
</body>
</html>
