<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/WEB-INF/common/ctx.jsp"%>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" href="images\favicon.png">

	<title>Clean Zone</title>

	<!-- Bootstrap core CSS -->
    <link href="${ctx}/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/fonts/font-awesome-4/css/font-awesome.min.css">
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="http\foxythemes.net\assets\js\MS_6.js"></script>
	  <script src="http\foxythemes.net\assets\js\MS_7.js"></script>
	<![endif]-->

	<!-- Custom styles for this template -->
    <link href="${ctx}/css/style.css" rel="stylesheet" />
    </head>

<body class="texture">

<div id="cl-wrapper" class="error-container">
	<div class="page-error">
		<h1 class="number text-center">500</h1>
		<h2 class="description text-center">Don't worry, there is a little turbulence!</h2>
		<h3 class="text-center"> We're trying to fix it, please try again later.</h3>
        <h3 class="text-center">Would you like to go <a href="${ctx}">home</a>?</h3>
	</div>
	<div class="text-center copy">&copy; 2016 <a href="#">SCOT</a></div>

	
</div>

    <script src="${ctx}/js/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/js/behaviour/general.js"></script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${ctx}/js/behaviour/voice-commands.js"></script>
<script src="${ctx}/js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.resize.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.flot/jquery.flot.labels.js"></script>
</body>
</html>
