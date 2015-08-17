<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript"
	src="<c:url value="/resources/jquery-2.1.1.js" />"></script>

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

	<div class="container" style="width: 600px;">

		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<td>Departments</td>
						<td>AVG Salary</td>
					</tr>
				</thead>
				<tbody class="tableBody">
				</tbody>
			</table>
		</div>
	</div>

	<script>
		function resetTable() {
			var tableBody = $(".tableBody");
			tableBody.empty();
			$.ajax({
				url : "<c:url value="/avgSalaries" />",
			}).done(
					function(data) {
						for (var i = 0; i < data.length; ++i) {
							var row = "<tr><td>" + data[i].name + "</td><td>"
									+ data[i].salary + "</td></tr>";
							tableBody.append(row);
						}
					});
		}
		resetTable();
	</script>

</body>

</html>
