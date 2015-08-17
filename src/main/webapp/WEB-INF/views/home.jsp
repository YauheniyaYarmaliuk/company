<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
 	<meta charset="utf-8">
 	
	
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
	<script type="text/javascript" src="<c:url value="/resources/jquery-2.1.1.js" />"></script>
	 
	<title>Home</title>

</head>

<body>
	<header class="main-header" role="banner">
		<nav class="main-menu">
				<ul>
					<li><a href="http://localhost:8080/test/">Departments</a></li>
					<li><a href="http://localhost:8080/test/page">Employees</a></li>
					<li><a href="http://localhost:8080/test/avg">Avg Salary</a></li>
				</ul>
			</nav>
	</header>
	<div class="container" style="width: 500px;" >

	<div class="table-responsive">
		<table class="table table-condensed table-striped table-bordered">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody class="tableBody">
			</tbody>
		</table>	
	</div>
	
	<div>
		<span>New department</span>
		<form action="#" id="createDeptForm">
			<div class="form-group">
				<label for="name"></label>
				<input type="text" name="deptName" placeholder="Имя" class="form-control"/>
			</div>
			<input type="submit" value="Save" class="btn btn-success btn-sm"/>
		</form>
		
	
	</div>

</div>

	<script>
		function resetTable() {
			var tableBody = $(".tableBody");
			tableBody.empty();
			$.ajax({
			  url: "<c:url value="/departments/getAll" />",
			}).done(function(data) {
				for (var i = 0; i < data.length; ++i) {
					var row = '<tr id="row_' + data[i].id + '"><td>' + data[i].id + "</td><td>" + data[i].name + "</td><td>" +
					'<button type="button" class="btn btn-danger btn-sm" onclick="delDepart(' + data[i].id +');">Delete</button>'
					
					"</td></tr>";
					tableBody.append(row);
				}
			});
		}
		
		resetTable();
		
		$("#createDeptForm").submit(function(event) {
		  	event.preventDefault();
		  	var deptName = $("input[name=deptName]", this)[0].value;
		  	$.ajax({
		  		url: '<c:url value="/departments/insert/"/>' + deptName,
		  	}).done(function(data) {
		  		resetTable();
		  	});
		});
		
		function delDepart(deptId) {
			$.ajax({
		  		url: '<c:url value="/departments/delete/"/>' + deptId,
		  	}).done(function(data) {
		  		$("#row_" + deptId).remove();
		  		
		  	}); 
			
		}
	
	</script>

</body>

</html>
