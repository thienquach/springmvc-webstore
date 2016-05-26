<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<section class="container">
	<div class="row">
		<c:forEach items="${products }" var="product">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px;">
				<div class="thumbnail">
					<div class="caption">
						<h3>${product.name }</h3>
						<p>${product.category.name }</p>
						<p>${product.unitPrice }USD</p>
						<p>Available ${product.unitsInStock } units in stock</p>
						<p>
							<a
								href="<spring:url value="/products/product?code=${product.code }"/>"
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> Details
							</a>
						</p>
					</div>
				</div>

			</div>
		</c:forEach>


	</div>
</section>
