<html>
<head>
	<meta charset="utf-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<style>
	.ajax{
		width : 300px;
		height : 300px;
		border : lightgrey 1px solid;
		padding : 5px;
	}
	</style>
</head>
<body>
<h2>Hello World!</h2>
<form id="todo" name="todo" method="PUT" action="http://localhost:8080/todo/rest/todo/95a9d8e9-2ec2-419e-a5b4-b288c279efaf" >
	<input id="title" name="title" type="text">
	<input id="content" name="content" type="text">
	<button type = "submit">Submit</submit>
</form>
<div class="ajax">
	$.ajax({
            type: "POST",
            dataType: "json",
            url: "http://localhost:8080/todo/rest/todo/95a9d8e9-2ec2-419e-a5b4-b288c279efaf",
            data: {"myData":"dataString"},
            contentType: "application/json",
            success: function(data){
                alert('Items added');
            },
            error: function(e){
                console.log(e.message);
            }
</div>
</body>
</html>
