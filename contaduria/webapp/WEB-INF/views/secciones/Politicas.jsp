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
<link rel="stylesheet"
	href="${ urlResources }/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--  L�nea para agregar los �conos de las acciones-->
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
	<h3 class="blog-title text-center"><span class="label label-success">POL�TICAS PARA LA COMPROBACI�N FINANCIERA PROFOCIE-2014</span></h3>
      </div>
      <br>
      <p>
        <h5><div >Con el prop�sito de normar los criterios aplicables a la comprobaci�n financiera de los
			   recursos del Programa de Fortalecimiento de la Calidad en Instituciones Educativas 
			   (PROFOCIE) 2014, la Secretar�a de Educaci�n P�blica, ha emitido las pol�ticas de 
			   comprobaci�n a las cuales debemos dar cumplimiento de la siguiente manera. </div></h5>
   </p>
		<br>
		
		

		<div class="table-responsive">
			<table class="table table-striped ">
			
			<td>
			<table class=" table table-hover table-striped ">

				<div>
					<h3>Documentos</h3>
				</div> <c:forEach var="documento" items="${documentos}">
					<a href="${ urlResources }/${documento.liga}" target="document"><p>${documento.orden} - ${documento.nombre} </p></a>
		
		</c:forEach>
		</table>
		</td>
		
		<td>
		<div role="main" align="right">
		
		<iframe style="float: right;"
				src="${ urlResources }/ViewerJS/#../${documento.liga}" width='600'
				height='600' allowfullscreen webkitallowfullscreen name="document"></iframe>
		
		</iframe>
			<!-- <iframe style="float: right;"
				src="${ urlResources }/ViewerJS/#../${documento.liga}" width='600'
				height='600' allowfullscreen webkitallowfullscreen></iframe> -->
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
	</script>
</body>
</html>
