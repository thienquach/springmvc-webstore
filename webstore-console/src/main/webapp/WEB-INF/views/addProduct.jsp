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
		<form:form modelAttribute="newProduct" class="form-horizontal">
			<fieldset>
				<legend>Add new product</legend>
				<!-- Product Code -->
				<div class="form-group">
					<label class="control-label col-lg-2 col-md-2 col-sm-12"
						for="code"> Product Code </label>
					<div class="col-lg-10 col-md-10 col-sm-12">
						<form:input id="code" path="code" type="text"
							class="form-control" />
					</div>
				</div>
				<!-- Product Name -->
				<div class="form-group">
					<label class="control-label col-lg-2 col-md-2 col-sm-12"
						for="name"> Product Name </label>
					<div class="col-lg-10 col-md-10 col-sm-12">
						<form:input id="name" path="name" type="text"
							class="form-control" />
					</div>
				</div>
				<!-- Unit Price -->
				<div class="form-group">
					<label class="control-label col-lg-2 col-md-2 col-sm-12"
						for="unitPrice"> Unit Price </label>
					<div class="col-lg-10 col-md-10 col-sm-12">
						<form:input id="unitPrice" path="unitPrice" type="text"
							class="form-control" />
					</div>
				</div>
				<!-- Description -->
				<div class="form-group">
					<label class="control-label col-lg-2 col-md-2 col-sm-12"
						for="décription"> Description </label>
					<div class="col-lg-10 col-md-10 col-sm-12">
						<form:textarea id="description" path="description" rows="2"
							class="form-control" />
					</div>
				</div>
				<!-- Discontinued -->
				<div class="form-group">
					<label class="control-label col-lg-2 col-md-2 col-sm-12"
						for="discontinued"> Discontinued </label>
					<div class="col-lg-10 col-md-10 col-sm-12">
						<form:checkbox id="discontinued" path="discontinued"
							class="form-control" />
					</div>
				</div>
				<!-- Condition -->
				<div class="form-group">
					<label class="control-label col-lg-2 col-md-2 col-sm-12"> Condition </label>
					<div class="col-lg-10 col-md-10 col-sm-12">
						<form:radiobutton path="condition" value="New" class="form-control"/>New
						<form:radiobutton path="condition" value="Old" class="form-control"/>Old
						<form:radiobutton path="condition" value="Refurbished" class="form-control"/>Refurbished
					</div>
				</div>
				<!-- Action button groups -->
				<div class="form-group">
					<div class="col-lg-offset-2 col-md-10 col-sm-12">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Add">
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>

</html>