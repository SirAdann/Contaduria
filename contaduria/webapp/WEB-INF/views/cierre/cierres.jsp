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
<link rel="stylesheet"
	href="${ urlResources }/bootstrap/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet"
	href="${ urlResources }/bootstrap/css/glyphicons.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<%-- Obteniendo el año --%>


<script type="]text/javascript">
 function mostrarAñoActual() {
var d = new Date();

document.write(d.getFullYear());
}

</script>









</head>

<body>

	<jsp:include page="../includes/header.jsp"></jsp:include>

	<jsp:include page="../includes/menu.jsp"></jsp:include>


	<br>

	<div class="container marketing" align="right">
		<div class="dropdown mr-1">


			<form action="${urlRoot}cierre/anio" method="get">

				<select name="anio">
					<option value="" selected disabled hidden>Selecciona un
						Año</option>
					<option value="2018">2018</option>
					<option value="2017">2017</option>
					<option value="2016">2016</option>
					<option value="2015">2015</option>
					<option value="2014">2014</option>
					<option value="2013">2013</option>
					<option value="2012">2012</option>
					<option value="2011">2011</option>
					<option value="2010">2010</option>
					<option value="2009">2009</option>
					<option value="2008">2008</option>

				</select> <input type="submit" value="Buscar">

			</form>
		</div>


		<div align="center">

			<p>
			<h1>${anio}</h1>
			</p>
		</div>


		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Nombre</th>
					<th>Categoria</th>
					<th>Mes</th>
					<th>Tipo</th>
					
				</tr>
				<c:forEach items="${ documentos }" var="documentos">
				
				
					<tr>
						<td><a href="${urlResources}/${documentos.liga}" >${ documentos.nombre}
						</a></td>
						<td>${documentos.categoria}</td>



						<c:choose>
							<c:when test="${documentos.mes eq '1'}">
								<td>Enero</td>
							</c:when>
							<c:when test="${documentos.mes eq '2'}">
								<td>Febrero</td>
							</c:when>
							<c:when test="${documentos.mes eq '3'}">
								<td>Marzo</td>
							</c:when>
							<c:when test="${documentos.mes eq '4'}">
								<td>Abril</td>
							</c:when>
							<c:when test="${documentos.mes eq '5'}">
								<td>Mayo</td>
							</c:when>
							<c:when test="${documentos.mes eq '6'}">
								<td>Junio</td>
							</c:when>
							<c:when test="${documentos.mes eq '7'}">
								<td>Julio</td>
							</c:when>
							<c:when test="${documentos.mes eq '8'}">
								<td>Agosto</td>
							</c:when>
							<c:when test="${documentos.mes eq '9'}">
								<td>Septiembre</td>
							</c:when>
							<c:when test="${documentos.mes eq '10'}">
								<td>Octubre</td>
							</c:when>
							<c:when test="${documentos.mes eq '11'}">
								<td>Noviembre</td>
							</c:when>
							<c:when test="${documentos.mes eq '12'}">
								<td>Diciembre</td>
							</c:when>
						</c:choose>



					



						<c:choose>
							<c:when test="${ documentos.idtipodocumento eq '1' }">
								<td><span class="fa fa-file-word-o" style="color: blue"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '2' }">
								<td><span class="fa fa-file-excel-o" style="color: green"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '3' }">
								<td><span class="fa fa-file-pdf-o" style="color: red"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '4' }">
								<td><span class="fa fa-file-word-o" style="color: blue"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '5' }">
								<td><span class="fa fa-file-excel-o" style="color: green"></span></td>
							</c:when>
						</c:choose>


						

					</tr>
					
				
					
				</c:forEach>
			</table>
		</div>
	</div>



	<!-- /container -->

	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->


	<script src="${urlResources}/bootstrap/js/popper.min.js"></script>
	<script src="${urlResources}/bootstrap/js/popper.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>







</body>
</html>
