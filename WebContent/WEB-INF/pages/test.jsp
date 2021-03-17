<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script>
	function launchJnlp(){
	    document.getElementById('jnlpId').click();
	}
	 window.onload = launchJnlp;
	</script>
</head>
<body>
    <a id='jnlpId' href="jnlp:http://localhost:8080/JnlpDemo/test.jnlp">Launched</a>
</body>
</html>