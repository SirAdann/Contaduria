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

</head>

<body>
	
	<jsp:include page="includes/header.jsp"></jsp:include>
	<br>
	<div class="container marketing">
	<div style="text-align:right; "><p>Bienvenido(a) <sec:authentication	property="principal.username"/></p></div></div>

	<jsp:include page="includes/menu.jsp"></jsp:include>
	<div class="container">
		<br>
		<h3 class="text-center font-weight-bold">CRITERIOS CONTABLES,
			FISCALES Y LINEAMIENTOS OPERATIVOS</h3>
		<br>

		<div class="container">


			<p class="text-justify">Este sitio web ha sido dise�ado con la
				intenci�n de aportar a los administradores de unidades acad�micas y
				administrativas de la UABC, informaci�n �til para el desempe�o de su
				actividad, como una herramienta que les apoye en el cumplimiento de
				sus responsabilidades, por lo que contiene criterios y lineamientos
				que permiten llevar a cabo procesos observando la normatividad y
				requisitos que est�n definidos para la Instituci�n.</p>

			<p class="text-justify">Las disposiciones establecidas en estos
				documentos son de observancia obligatoria, por lo que se recomienda
				su an�lisis para su correcta aplicaci�n.</p>

			<p class="text-justify">Estos criterios y lineamiento se
				fundamentan en la normatividad interna y externa aplicable a la
				UABC, por lo que se encuentran en continuo cambio debido a las
				modificaciones que tiene la propia normatividad, pero tambi�n debido
				al proceso de mejora en nuestros procesos, por lo que las
				sugerencias de cambio que nos hagan llegar ser�n bien recibidas y
				adecuadamente analizadas, con la intenci�n de hacer cada vez m�s
				�tiles estos documentos.</p>

			<p class="text-justify">Sus comentarios y sugerencias ser�n
				atendidos en la cuenta de correo manuel.monjardin@uabc.edu.mx a la
				atenci�n del C.P. Manuel Monjard�n Acosta, Jefe del Departamento de
				Contabilidad.</p>

			<br>
			<h3 class="text-center">Atentamente</h3>
			<h3 class="text-center">C.P.C BERNARDO HERN�NDEZ CORTEZ</h3>
			<h3 class="text-center">CONTADOR DE LA UABC</h3>
			<br>
		</div>
	</div>
	
	<jsp:include page="includes/footer.jsp"></jsp:include>
	
		
		<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="${ urlResources }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ urlResources }/bootstrap/js/bootstrap-4-navbar.js"></script>



</body>
</html>