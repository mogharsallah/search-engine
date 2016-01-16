<%@ include file="partials/header.jsp"%>
<div class="row">
	<div class="col-lg-6">
		<div class="well bs-component">
		<c:url var="addAction" value="/search/add" ></c:url>
			<form:form cssClass="form-horizontal" action="${addAction}"
				commandName="searchPattern">
				<fieldset>
					<legend>
						<span>${message}</span>
					</legend>
					<div class="form-group">
						<c:if test="${!empty searchPattern.name}">
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
						<form:label class="col-lg-2 control-label" path="keyword">
							<spring:message text="Keyword" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="keyword"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="page">
							<spring:message text="Page" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="page" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="paged">
							<spring:message text="Paged" />
						</form:label>
						<div class="">
							<form:checkbox class="" path="paged"/>
						</div>
					</div>
					<div class="form-group">
						<c:if test="${!empty searchPattern.name}">
							<input class="btn btn-primary col-lg-3" type="submit"
								value="<spring:message text="Edit Search Pattern"/>" />
						</c:if>
						<c:if test="${empty searchPattern.name}">
							<input class="btn btn-primary col-lg-3" type="submit"
								value="<spring:message text="Add Search Pattern"/>" />
						</c:if>
					</div>
				</fieldset>


			</form:form>
		</div>
	</div>
</div>

<c:if test="${!empty searchPatterns}">
	<div class="row">
		<div class="col-lg-12">
			<div class="search-header">
				<h1 id="tables">Search Patterns</h1>
			</div>

			<div class="bs-component">
				<table class="table table-striped table-hover ">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Keyword</th>
							<th>Page</th>
							<th>Paged</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${searchPatterns}" var="search">
							<tr>
								<td>${search.id}</td>
								<td>${search.name}</td>
								<td>${search.keyword}</td>
								<td>${search.page}</td>
								<td>${search.paged}</td>
								<td><a href="<c:url value='/search/edit/${search.id}' />">Edit</a></td>
								<td><a href="<c:url value='/search/remove/${search.id}' />">Delete</a></td>
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