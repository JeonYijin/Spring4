<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./temp/boot_head.jsp"></c:import>
	<script type="text/javascript">
		alert('Hello World');
	</script>
	<link href="./resources/css/home.css" rel="stylesheet">

</head>
<body>
<c:import url="./temp/boot_nav.jsp"></c:import>
<h1 class= "c1">
	HOME
</h1>
<h1 id ="d1">
	other h1
</h1>

<div id="d2">
	<h3>In DIV</h3>
</div>
<img class="c1" id="d3" alt="" src="./resources/images/kim2.jpg">
<div>
	<button onclick="fn1()">CLICK</button>
</div>

<script type="text/javascript">
	console.log('body script');
</script>
<!-- <script type="text/javascript" src="./resources/js/home.js"></script> -->
<script type="text/javascript" src="./resources/js/function_1.js"></script>
</body>
</html>
