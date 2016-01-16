<%@ include file="partials/header.jsp"%>
<div class="row">
	<div class="col-lg-6">
		<div class="well bs-component">
			<c:url var="addAction" value="/website/add"></c:url>
			<form:form cssClass="form-horizontal" action="${addAction}"
				commandName="website">
				<fieldset>
					<legend>
						<span>${message}</span>
					</legend>
					<div class="form-group">
						<c:if test="${!empty website.name}">
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
						<form:label class="col-lg-2 control-label" path="url">
							<spring:message text="Link" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="url" required="required" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="search_url">
							<spring:message text="Search Link" />
						</form:label>
						<div class="col-lg-10">
							<form:input class="form-control" path="search_url" />
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="page">
							<spring:message text="Page Pattern" />
						</form:label>
						<div class="col-lg-10">
							<select name="pId" >
								<c:forEach items="${pages}" var="p">
									<option value="${p.id}">${p.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="search">
							<spring:message text="Search Pattern" />
						</form:label>
						<div class="col-lg-10">
							<select name="sId">
								<c:forEach items="${searchs}" var="s">
									<option value="${s.id}">${s.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<form:label class="col-lg-2 control-label" path="actif">
							<spring:message text="Actif" />
						</form:label>
						<div class="">
							<form:checkbox class="" path="actif" />
						</div>
					</div>
					<div class="form-group">
						<c:if test="${!empty website.name}">
							<input class="btn btn-primary col-lg-3" type="submit"
								value="<spring:message text="Edit website "/>" />
						</c:if>
						<c:if test="${empty website.name}">
							<input class="btn btn-primary col-lg-3" type="submit"
								value="<spring:message text="Add website "/>" />
						</c:if>
					</div>
				</fieldset>


			</form:form>
		</div>
	</div>
</div>

<c:if test="${!empty websites}">
	<div class="row">
		<div class="col-lg-12">
			<div class="website-header">
				<h1 id="tables">website s</h1>
			</div>

			<div class="bs-component">
				<table class="table table-striped table-hover ">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Link</th>
							<th>Search Link</th>
							<th>Page Pattern</th>
							<th>Search Pattern</th>
							<th>Actif</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${websites}" var="website">
							<tr>
								<td>${website.id}</td>
								<td>${website.name}</td>
								<td><a href="${website.url}">Website</a></td>
								<td><a href="${website.search_url}">Search Page</a></td>
								<td>${website.page.name}</td>
								<td>${website.search.name}</td>
								<td>${website.actif}</td>
								<td><a href="<c:url value='/website/edit/${website.id}' />">Edit</a></td>
								<td><a
									href="<c:url value='/website/remove/${website.id}' />">Delete</a></td>
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