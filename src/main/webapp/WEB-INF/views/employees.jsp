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

	<div class="container" style="width: 800px;">

		<div class="table-responsive">
			<table class="table table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<td>Id</td>
						<td>deptId</td>
						<td>Name</td>
						<td>Surname</td>
						<td>Patronymic</td>
						<td>Birth</td>
						<td>Salary</td>
						<td>Delete</td>
					</tr>
				</thead>
				<tbody class="tableBody">
				</tbody>
			</table>	
		</div>
	
		<div>
			<span>New employee</span>
			<form action="#" id="createDeptForm">
				<div class="form-group">
					<label for="deptId"></label>
					<input type="text" name="deptId" placeholder="Id Department" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="name"></label>
					<input type="text" name="name" placeholder="Name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="surname"></label>
					<input type="text" name="surname" placeholder="Surname" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="patronymic"></label>
					<input type="text" name="patronymic" placeholder="Patronymic" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="birth"></label>
					<input type="text" name="birth" placeholder="Birth" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="salary"></label>
					<input type="text" name="salary" placeholder="Salary" class="form-control"/>
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
			  url: "<c:url value="/employees/getAll" />",
			}).done(function(data) {
				for (var i = 0; i < data.length; ++i) {
					var dob = new Date(data[i].birth);
					
					var row = '<tr id="row_' + data[i].id + '"><td>' + data[i].id + "</td><td>" + 
					data[i].deptId + "</td><td>" + 
					data[i].name + "</td><td>" + data[i].surname + "</td><td>" + data[i].patronymic + 
					"</td><td>" + 
					dob.toISOString().substring(0, 10) +  
					//dob.getYear() + "-" + dob.getMonth() + "-" + dob.getDay() + 
					"</td><td>" + data[i].salary + "</td><td>" +
					'<button value="btn" class="btn btn-danger btn-sm" onclick="delEmployee(' + data[i].id +');">Delete</button>'
					
					"</td></tr>";
					tableBody.append(row);
				}
			});
		}
		
		resetTable();
		
		$("#createDeptForm").submit(function(event) {
		  	event.preventDefault();
		  	var deptId = $("input[name=deptId]", this)[0].value;
		  	var name = $("input[name=name]", this)[0].value;
		  	var surname = $("input[name=surname]", this)[0].value;
		  	var patronymic = $("input[name=patronymic]", this)[0].value;
		  	var birth = $("input[name=birth]", this)[0].value;
		  	var salary = $("input[name=salary]", this)[0].value;
		  	
		  	$.ajax({
		  		url: '<c:url value="/employees/insert/"/>' + deptId + 
		  					"/" + name + "/" + surname + "/" + patronymic + 
		  					"/" + birth + "/" + salary,
		  	}).done(function(data) {
		  		resetTable();
		  	});
		});
		
		function delEmployee(empId) {
			$.ajax({
		  		url: '<c:url value="/employees/delete/"/>' + empId,
		  	}).done(function(data) {
		  		$("#row_" + empId).remove();
		  		
		  	}); 
			
		}
	
		
	</script>

</body>

</html>
