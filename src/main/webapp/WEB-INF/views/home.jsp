<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./temp/boot_head.jsp"></c:import>
	<script type="text/javascript">
		alert('Hello World');
	</script>
</head>
<body>
<c:import url="./temp/boot_nav.jsp"></c:import>
<h1>
	HOME
</h1>
<script type="text/javascript">
	console.log('body script');
</script>
</body>
</html>
