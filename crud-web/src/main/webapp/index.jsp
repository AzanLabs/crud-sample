<!DOCTYPE html>
<html>
<head>
<!--<script type="text/javascript">
	location.href = "app/index.html"
</script>-->
</head>
<body>
	<form name="saveimage" action="./rest/image/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" id="file">
		<input type="text" name="id" id="id">
		<input type="submit" value="submit">
	</form>
</body>
</html>
