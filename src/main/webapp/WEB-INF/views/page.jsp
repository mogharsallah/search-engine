<%@ include file="partials/header.jsp"%>
<div class="row">
	<div class="col-lg-6">
		<div class="well bs-component">
		<c:url var="addAction" value="/page/add" ></c:url>
			<form:form cssClass="form-horizontal" action="${addAction}"
				commandName="pagePattern">
				<fieldset>
					<legend>
						<span>${message}</span>
					</legend>
					<div class="form-group">
						<c:if test="${!empty pagePattern.name}">
							<form:label class="col-lg-2 control-label" path="id">
								<spring:message text="ID" />
							</form:label>
							<div class="col-lg-10">
								<form:input class="form-control" path="id" readonly="true"
									size="8" disabled="true" />
							</div>
							<form:hidden path="id" />
						</c:if>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="name">
							<spring:message text="Name" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="name" required="required" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="product">
							<spring:message text="Product" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="product"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="title">
							<spring:message text="Title" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="title" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="image">
							<spring:message text="Image" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="image" required="required" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="price">
							<spring:message text="Price" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="price" required="required" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="description">
							<spring:message text="Description" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="description" />
						</div>
					</div>
					<div class="form-group">
						<c:if test="${!empty pagePattern.name}">
							<input class="btn btn-primary col-lg-3" type="submit"
								value="<spring:message text="Edit Page Pattern"/>" />
						</c:if>
						<c:if test="${empty pagePattern.name}">
							<input class="btn btn-primary col-lg-3" type="submit"
								value="<spring:message text="Add Page Pattern"/>" />
						</c:if>
					</div>
				</fieldset>


			</form:form>
		</div>
	</div>
</div>

<c:if test="${!empty pagePatterns}">
	<div class="row">
		<div class="col-lg-12">
			<div class="page-header">
				<h1 id="tables">Page Patterns</h1>
			</div>

			<div class="bs-component">
				<table class="table table-striped table-hover ">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Product</th>
							<th>Title</th>
							<th>Image</th>
							<th>Price</th>
							<th>Description</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagePatterns}" var="page">
							<tr>
								<td>${page.id}</td>
								<td>${page.name}</td>
								<td>${page.product}</td>
								<td>${page.title}</td>
								<td>${page.image}</td>
								<td>${page.price}</td>
								<td>${page.description}</td>
								<td><a href="<c:url value='/page/edit/${page.id}' />">Edit</a></td>
								<td><a href="<c:url value='/page/remove/${page.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
						<tr>
					</tbody>
				</table>
				</div>
		</div>
	</div>
</c:if>
<%@ include file="partials/footer.jsp"%>