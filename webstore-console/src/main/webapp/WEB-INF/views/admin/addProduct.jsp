<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;	charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>Add products</p>
			</div>
		</div>
	</section>


	<section class="container">
		<button type="button" class="btn btn-primary pull-right"
			data-toggle="modal" data-target=".addEditModal">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> New
		</button>
		<table class="table table-condensed table-hover table-border">
			<thead>
				<tr>
					<th>#</th>
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Unit Price</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${product.code }</td>
						<td>${product.name }</td>
						<td>${product.unitPrice }</td>
						<td>${product.description }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</section>
	
	<!-- start AddEditModal -->
	<div class="modal fade addEditModal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="addEditModalForm">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Add</h4>

				</div>
				<form:form modelAttribute="newProduct" class="form-horizontal">
					<div class="modal-body">
						<!-- Product Code -->
						<div class="form-group">
							<label class="control-label col-lg-2 col-md-3 col-sm-3 "
								for="code"> Product Code </label>
							<div class="col-lg-10 col-md-9 col-sm-9 ">
								<form:input id="code" path="code" type="text"
									class="form-control" />
							</div>
						</div>
						<!-- Product Name -->
						<div class="form-group">
							<label class="control-label col-lg-2 col-md-3 col-sm-3 "
								for="name"> Product Name </label>
							<div class="col-lg-10 col-md-9 col-sm-9 ">
								<form:input id="name" path="name" type="text"
									class="form-control" />
							</div>
						</div>
						<!-- Unit Price -->
						<div class="form-group">
							<label class="control-label col-lg-2 col-md-3 col-sm-3 "
								for="unitPrice"> Unit Price </label>
							<div class="col-lg-10 col-md-9 col-sm-9 ">
								<form:input id="unitPrice" path="unitPrice" type="text"
									class="form-control" />
							</div>
						</div>
						<!-- Description -->
						<div class="form-group">
							<label class="control-label col-lg-2 col-md-3 col-sm-3 "
								for="description"> Description </label>
							<div class="col-lg-10 col-md-9 col-sm-9 ">
								<form:textarea id="description" path="description" rows="2"
									class="form-control" />
							</div>
						</div>
						<!-- Condition -->
						<div class="form-group">
							<label class="control-label col-lg-2 col-md-3 col-sm-3 ">
								Status </label>
							<div class="col-lg-10 col-md-9 col-sm-9 ">
								<label class="radio-inline"> <form:radiobutton
										path="status" value="New" />New
								</label> <label class="radio-inline"> <form:radiobutton
										path="status" value="Old" />Old
								</label> <label class="radio-inline"> <form:radiobutton
										path="status" value="Refurbished" />Refurbished
								</label>
							</div>
						</div>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add">
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- end AddEditModal -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</body>

</html>